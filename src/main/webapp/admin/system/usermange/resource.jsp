<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>资源管理</title>
<jsp:include page="../../../inc.jsp"></jsp:include>

	<script type="text/javascript">
		$.canEdit = true;
	</script>


	<script type="text/javascript">
		$.canDelete = true;
	</script>

<script type="text/javascript">
	var treegrid;
	$(function(){
		treegrid = $('#treegrid').treegrid({
			url:'${pageContext.request.contextPath}/resource_treegrid',
			idField:'id',
			treeField:'name',
			parentField:'pid',
			fit:true,
			fitColumns:false,
			border:false,
			forzenColumns:[[{
				title:'编号',
				field:'id',
				width:150,
				hidden:true
			}]],
			columns:[[{
				title:'资源名称',
				field:'name',
				width:200,
			},{
				title:'资源路径',
				field:'url',
				width:200,
			},{
				title:'资源类型ID',
				field:'typeId',
				width:200,
				hidden:true
			},{
				title:'资源类型',
				field:'typeName',
				width:200,
			},{
				title:'排序',
				field:'seq',
				width:40,
			},{
				title:'上级资源ID',
				field:'pid',
				width:200,
				hidden:true
			},{
				title:'上级资源',
				field:'pname',
				width:200,
			},{
				title:'操作',
				field:'action',
				width:80,
				formatter:function(value,row,index){
					var str = '';
					if($.canEdit){
						str+=$.formatString('<img onclick="editFun(\'{0}\')" src="{1}" title="编辑">',row.id,'${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					str += "&nbsp;";
					if($.canDelete){
						str+=$.formatString('<img onclick="delFun(\'{0}\')" src="{1}" title="删除">',row.id,'${pageContext.request.contextPath}/style/images/extjs_icons/pencil_delete.png');
					}
					return str;
				}
			},{
				title:'备注',
				field:'remark',
				width:150
			}]],
			toolbar:'#toolbar'
		});
	});
	
	function addFun(){
		parent.$.modalDialog({
			title : '添加资源',
			width : 500,
			height : 300,
			href : '${pageContext.request.contextPath}/resource_goResAdd',
			iconCls : 'disk',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_treeGrid = treegrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	
	function editFun(id){
		if(id != undefined){
			treegrid.treegrid('select',id);
		}
		var node = treegrid.treegrid('getSelected');
		if(node){
			parent.$.modalDialog({
			title : '编辑资源',
			width : 500,
			height : 300,
			href : '${pageContext.request.contextPath}/resource_goResEdit?id='+node.id,
			iconCls : 'disk',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_treeGrid = treegrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
		}
	}
	
	/**
	   删除
	**/
	function delFun(id){
		if(id != undefined){
			treegrid.treegrid('select',id);
		}
		var node = treegrid.treegrid('getSelected');
		if(node){
			parent.$.messager.confirm('提示','您是否确定要删除该资源?',function(confirm){
				if(confirm){
					$.post('${pageContext.request.contextPath}/resource_del',{
						id : node.id
					},function(result){
						if(result.success){
							parent.$.messager.alert('提示',result.msg,'info');
							treegrid.treegrid('reload');
							parent.layout_west_tree.tree('reload');
						}
					});
				}
			});
		}
	}
	
	function expandNode(){
		var node = treegrid.treegrid('getSelected');
		if(node){
			treegrid.treegrid('expandAll',node.id);
		}else{
			treegrid.treegrid('expandAll');
		}
	}
	
	function collapseNode(){
		var node = treegrid.treegrid('getSelected');
		if(node){
			treegrid.treegrid('collapseAll',node.id);
		}else{
			treegrid.treegrid('collapseAll');
		}
	}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'north',border:false" style="height:80px;overflow:hidden;padding:5px">
			<div class="well well-small">
				<span class="badge badge-important">友情提示</span>
				<p>
					新增资源不隶属于当前用户角色，请在<span class="label label-info"><strong>角色管理</strong></span>中重新分配
				</p>
			</div>
		</div>
		<div data-options="region:'center',border:false" style="overflow:hidden ">
			<table id="treegrid"></table>
		</div>
		<div id="toolbar" style="display:none">
			<a onclick="addFun()" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
			<a onclick="expandNode()" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'resultset_next'">展开</a>
			<a onclick="collapseNode()" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'resultset_previous'">闭合</a>
			<a onclick="treegrid.treegrid('reload')" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'transmit'">刷新</a>
		</div>
	</div>
</body>
</html>