<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <script type="text/javascript"> 
    $(function(){
    	//表单提交
		$("#ff").form({
			url:'${pageContext.request.contextPath}/stu_edit',
			onSubmit:function(){
			parent.$.messager.progress({
				title:'提示',
				text:'数据处理中，请稍后...'
			});
			var isValid = $(this).form('validate');
			if(!isValid){
				parent.$.messager.progress('close');
			}
			return isValid;
		},
		success:function(result){
			parent.$.messager.progress('close');
			result = $.parseJSON(result);
			if(result.success){
				parent.$.modalDialog.openner_dataGrid.datagrid('reload');
				parent.$.modalDialog.handler.dialog('close');
			}else{
				parent.$.messager.alert('错误：',result.msg,'error');
			}
		}
		});
    });
  </script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
        <form id="ff" method="post">
        	<input name="createDate" type="hidden" value="${sstu.createDate }" >
        	<input type="hidden" name="schoolId" value="${sstu.school.id }" />
        	<input type="hidden" name="lrr_id" value="${sstu.lrr_id }">
            <table class="table table-hover table-condensed">
                <tr>
					<th>学员ID</th>
					<td colspan="5"><input name="id" type="text" placeholder="请输入学员编号" class="easyui-validatebox span2" data-options="required:true" readonly="readonly" value="${sstu.id }"></td>
				</tr>
                <tr>
					<th>学员姓名</th>
					<td><input name="name" type="text" placeholder="请输入学生姓名" class="easyui-validatebox span2" data-options="required:true" value="${sstu.name }"></td>
					<th>FirstName</th>
					<td><input type="text" name="firstName" placeholder="请输入学生FirstName" class="easyui-validatebox span2" value="${sstu.firstName }" /></td>
					<th>LastName</th>
					<td><input name="lastName" type="text" placeholder="请输入学生LastName" class="easyui-validatebox span2" value="${sstu.lastName }" > </td>
				</tr>
				<tr>
					<th>性别</th>
					<td><input type="radio" name="sex" value="男" <c:if test="${sstu.sex == '男' }">checked="checked"</c:if> />男<input type="radio" name="sex" value="女" <c:if test="${sstu.sex == '女' }">checked="checked"</c:if> />女</td>
					<th>单位名称</th>
					<td><input name="company" type="text" placeholder="请输入单位名称" class="easyui-validatebox span2" value="${sstu.company }"> </td>
					<th>固话</th>
					<td><input name="tel" placeholder="请输入固定电话" class="easyui-validatebox span2" data-options="validType:'telephone'" value="${sstu.tel }"></td>
				</tr>
				<tr>
					<th>手机1</th>
					<td><input name="phone1" placeholder="请输入手机号1" class="easyui-validatebox span2" data-options="validType:'mobile'" value="${sstu.phone1 }"></td>
					<th>手机2</th>
					<td><input name="phone2" placeholder="请输入手机号2" class="easyui-validatebox span2" data-options="validType:'mobile'" value="${sstu.phone2 }"></td>
					<th>QQ</th>
					<td><input name="QQ" placeholder="请输入QQ" class="easyui-validatebox span2" data-options="validType:'qq'" value="${sstu.QQ }"></td>
				</tr>
				<tr>
					<th>邮件1</th>
					<td><input name="email1" class="easyui-validatebox span2" placeholder="请输入常用邮箱1" data-options="validType:'email'" value="${sstu.email1 }"></td>
					<th>邮件2</th>
					<td><input name="email2" class="easyui-validatebox span2" placeholder="请输入常用邮箱2" data-options="validType:'email'" value="${sstu.email2 }" /></td>
					<th>身份证号</th>
					<td><input name="card" placeholder="请输入身份证号" class="easyui-validatebox span2" data-options="validType:'idcard'" value="${sstu.card }"></td>
				</tr>
				<tr>
					<th>签约日期</th>
					<td><input name="signDate" class="easyui-datebox span2" value="${sstu.signDate }" ></td>
					<th>学员类型</th>
					<td>
					<select name="stuType" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
						<option value="0">==请选择==</option>
						<option value="1" <c:if test="${sstu.stuType == 1 }">selected = "selected"</c:if>>正式学员</option>
						<option value="2" <c:if test="${sstu.stuType == 2 }">selected = "selected"</c:if>>重读学员</option>
						<option value="3" <c:if test="${sstu.stuType == 3 }">selected = "selected"</c:if>>试听学员</option>
					</select>
					</td>
					<th>学员顾问</th>
					<td>
					<select name="userId" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
							<option value="0">==请选择==</option>
							<c:forEach items="${users }" var="user">
								<option value="${user.id }"  <c:if test="${sstu.user.id == user.id }">selected = "selected"</c:if>>${user.name }</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<th>备注</th>
					<td colspan="5">
						<textarea name="remark" rows="5" cols="30" style="height:70px;width:700px">${sstu.remark }</textarea>
					</td>
				</tr>
            </table>
        </form>
    </div>
    </div>