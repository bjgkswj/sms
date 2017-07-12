<%@page import="org.sms.core.SessionInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>联系提醒</title>
  </head>
  <body>
  <c:if test="${sessionInfo != null}">
  <script type="text/javascript">
	/* var reqDataGrid;
	$(function() {
		reqDataGrid = $('#reqDataGrid').datagrid({
			url : '${pageContext.request.contextPath}/remind_dataGrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,  //是否分页
			idField : 'id',
			pageSize : 2,
			pageList : [ 4, 6, 8, 10, 12, 14, 16 ],
			sortName : 'contacttime',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			striped : true,
			rownumbers : true,
			singleSelect : true,
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			} ] ],
			columns : [ [ {
				field : 'recordId',
				title : '咨询编号',
				hidden : true
			}, {
				field : 'contacttime',
				title : '下次联系时间',
				width : 80,
				sortable : true,
				formatter : function(value,row,index){
					if(value != null){
			        	value = value.substr(0, value.length - 9);
			        }
			        return value;
				}
			}, {
				field : 'cusreq',
				title : '事件内容',
				width : 150,
				formatter:function(value,row,index){
					var str = $.formatString('<a style="color:black" href="javascript:void(0)" onclick="editFun(\'{0}\')">【咨询】'+value+'</a>',row.recordId);
					return str;
				}
			}, {
				field : 'action',
				title : '操作',
				width : 100,
				formatter : function(value, row, index) {
					var str = $.formatString('<img onclick="clsFun(\'{0}\');" src="{1}" title="关闭"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/delete.png');
					return str;
				}
			}] ]
		});
	});
	
	function clsFun(id) {
		if (id == undefined) {
			var rows = reqDataGrid.datagrid('getSelections');
			id = rows[0].id;
		}
		parent.$.messager.confirm('询问', '您确定要关闭当前提醒吗？', function(b) {
			if (b) {
				$.post('${pageContext.request.contextPath}/remind_close', {
					id : id
				}, function(result) {
					if (result.success) {
						parent.$.messager.alert('提示', result.msg, 'info');
						reqDataGrid.datagrid('reload');
					}
				}, 'JSON');
			}
		});
	}
	
	//设置为屏幕分辨率大小
	function fixWidth(percent)  {  
   		return window.screen.width * percent ; //这里你可以自己做调整  
	}
	
	function editFun(id) {
		parent.$.modalDialog({
			title : '查看咨询',
			width : fixWidth(1),
			height : 540,
			iconCls: 'disk',
			maximizable:true,
			href : '${pageContext.request.contextPath}/recordController/editPage?id=' + id
		});
	} */
</script>
</c:if>
    <div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border:false">
			<table id="reqDataGrid"></table>
		</div>
	</div>
  </body>
</html>
