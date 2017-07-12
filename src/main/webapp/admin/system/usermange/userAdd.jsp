<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/user_add',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
		<input type="hidden" name="id" value="" />
			<table class="table table-hover table-condensed">
				<tr>
					<th>登录名称</th>
					<td><input name="username" type="text" placeholder="请输入登录名称" class="easyui-validatebox span2" data-options="required:true" value=""></td>
					<th>密码</th>
					<td><input name="password" type="password" placeholder="请输入密码" class="easyui-validatebox span2" data-options="required:true"></td>
				</tr>
				<tr>
					<th>姓名</th>
					<td><input name="name" type="text" placeholder="请输入姓名" class="easyui-validatebox span2" data-options="required:true"></td>
					<th>性别</th>
					<td><input name="sex" type="radio" value="男" />男&nbsp;<input name="sex" type="radio" value="女" />女</td>
				</tr>
				<tr>
					<th>办公手机号</th>
					<td><input name="phone" type="text" placeholder="请输入办公手机号" class="easyui-validatebox span2" data-options="required:true,validType:'mobile'"></td>
					<th>个人手机号</th>
					<td><input name="sphone" type="text" placeholder="请输入个人手机号" class="easyui-validatebox span2" data-options="validType:'mobile'"></td>
				</tr>
				<tr>
					<th>电子邮箱</th>
					<td><input name="email" type="text" placeholder="请输入邮箱" class="easyui-validatebox span2" data-options="required:true,validType:'email'"></td>
					<th>QQ</th>
					<td><input name="qq" type="text" placeholder="请输入QQ号" class="easyui-validatebox span2" data-options="validType:'qq'" ></td>
				</tr>
				<tr>
					<th>固定电话</th>
					<td><input name="tel" type="text" placeholder="请输入固定电话" class="easyui-validatebox span2" data-options="validType:'telephone'" ></td>
					<th>所属分校</th>
					<td><select name="schoolId" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
							<c:forEach items="${schoolList }" var="school">
								<option value="${school.id }">${school.schoolname }</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
		</form>
	</div>
</div>