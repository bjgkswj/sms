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
			url:'${pageContext.request.contextPath}/stu_add',
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
        	<input type="hidden" name="schoolId" value="${slId }" />
        	<input type="hidden" name="lrr_id" value="">
            <table class="table table-hover table-condensed">
            	<tr>
					<th>学员ID</th>
					<td colspan="5"><input name="id" type="text" class="span2" readonly="readonly" value="系统自动产生"></td>
				</tr>
                <tr>
					<th>学员姓名</th>
					<td><input name="name" type="text" placeholder="请输入学员姓名" class="easyui-validatebox span2" data-options="required:true"></td>
					<th>FirstName</th>
					<td><input type="text" name="firstName" placeholder="请输入学员FirstName" class="easyui-validatebox span2" /></td>
					<th>LastName</th>
					<td><input name="lastName" type="text" placeholder="请输入学员LastName" class="easyui-validatebox span2" > </td>
				</tr>
				<tr>
					<th>性别</th>
					<td><input type="radio" name="sex" value="男" />男<input type="radio" name="sex" value="女" />女</td>
					<th>单位名称</th>
					<td><input name="company" type="text" placeholder="请输入单位名称" class="easyui-validatebox span2" value=""> </td>
					<th>固话</th>
					<td><input name="tel" type="text" placeholder="请输入固定电话" class="easyui-validatebox span2" value="" data-options="validType:'telephone'"></td>
				</tr>
				<tr>
					<th>手机1</th>
					<td><input name="phone1" type="text" placeholder="请输入手机号1" class="easyui-validatebox span2" value="" data-options="validType:'mobile'"></td>
					<th>手机2</th>
					<td><input name="phone2" type="text" placeholder="请输入手机号2" class="easyui-validatebox span2" value="" data-options="validType:'mobile'"></td>
					<th>QQ</th>
					<td><input name="QQ" type="text" placeholder="请输入QQ" class="easyui-validatebox span2" value="" data-options="validType:'qq'"></td>
				</tr>
				<tr>
					<th>邮件1</th>
					<td><input name="email1" class="easyui-validatebox span2" placeholder="请输入常用邮箱1" data-options="validType:'email'"></td>
					<th>邮件2</th>
					<td><input name="email2" class="easyui-validatebox span2" placeholder="请输入常用邮箱2" data-options="validType:'email'" /></td>
					<th>身份证号</th>
					<td><input name="card" type="text" placeholder="请输入身份证号" class="easyui-validatebox span2" value="" data-options="validType:'idcard'"></td>
				</tr>
				<tr>
					<th>签约日期</th>
					<td><input name="signDate" class="easyui-datebox span2" ></td>
					<th>学员类型</th>
					<td>
					<select name="stuType" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
						<option value="0">==请选择==</option>
						<option value="1">正式学员</option>
						<option value="2">重读学员</option>
						<option value="3">试听学员</option>
					</select>
					</td>
					<th>学员顾问</th>
					<td>
					<select name="userId" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
							<option value="0">==请选择==</option>
							<c:forEach items="${users }" var="user">
								<option value="${user.id }">${user.name }</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<th>备注</th>
					<td colspan="5">
						<textarea name="remark" rows="5" cols="30" style="height:70px;width:700px"></textarea>
					</td>
				</tr>
            </table>
        </form>
    </div>
    </div>