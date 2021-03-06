<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
$(function(){
	$("#form").form({
		url:'${pageContext.request.contextPath}/remind_open',
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
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr>
					<th>提醒日期</th>
					<td><input class="span2" name="rdate" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" /></td>
					<th>备忘内容</th>
					<td><input name="content" type="text" placeholder="请输入备忘内容" class="easyui-validatebox span2" data-options="required:true" value=""></td>
				</tr>
			</table>
		</form>
	</div>
</div>