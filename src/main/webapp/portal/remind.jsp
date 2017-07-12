<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>每日提醒</title>
    
  </head>
  <body>
  <script type="text/javascript">
	var rDataGrid;
	var dg_url = '';
	var sessionInfo_userId = '${sessionInfo.id}';
	if (sessionInfo_userId) {
		dg_url = '${pageContext.request.contextPath}/remind_dataGrid';
	}
	$(function(){
		rDataGrid = $('#rdataGrid').datagrid({
			url : dg_url,
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'rdate',
			sortOrder : 'desc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			} ] ],
			columns : [ [ {
				field : 'rdate',
				title : '提醒时间',
				width : 80,
				sortable : true,
				formatter : function(value,row,index){
					if(value != null){
			        	//value = value.substr(0, value.length - 9);
			        }
			        return value;
				}
			}, {
				field : 'content',
				title : '备忘内容',
				width : 150
			}, {
				field : 'action',
				title : '操作',
				width : 100,
				formatter : function(value, row, index) {
					var str = $.formatString('<img onclick="closeFun(\'{0}\');" src="{1}" title="关闭"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/delete.png');
					return str;
				}
			}] ],
			toolbar : '#toolbar',
			onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$(this).datagrid('unselectAll');
				$(this).datagrid('selectRow', rowIndex);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
	});
	function closeFun(id) {
		if (id == undefined) {
			var rows = rDataGrid.datagrid('getSelections');
			id = rows[0].id;
		}
		parent.$.messager.confirm('询问', '您确定要关闭当前提醒吗？', function(b) {
			if (b) {
				$.post('${pageContext.request.contextPath}/remind_close', {
					id : id
				}, function(result) {
					if (result.success) {
						parent.$.messager.alert('提示', result.msg, 'info');
						rDataGrid.datagrid('reload');
					}
				}, 'JSON');
			}
		});
	}
	
	function addFun() {
		parent.$.modalDialog({
			title : '创建新提醒',
			width : 500,
			height : 200,
			href : '${pageContext.request.contextPath}/portal/remindAdd.jsp',
			iconCls : 'disk',
			buttons : [ {
				text : '发布',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = rDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
</script>
    <div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border:false">
			<table id="rdataGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
		<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
	</div>

	<div id="menu" class="easyui-menu" style="width: 120px; display: none;">
		<div onclick="addFun();" data-options="iconCls:'pencil_add'">增加</div>
		<div onclick="closeFun();" data-options="iconCls:'pencil_delete'">关闭</div>
	</div>
  </body>
</html>
