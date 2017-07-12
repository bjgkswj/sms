<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    <title>学员管理</title>
    <jsp:include page="../../../inc.jsp" />
    
	<script type="text/javascript">
		$.canEdit = true;
	</script>
	
    <script type="text/javascript">
    var dataGrid = null;
	$(function() {
		dataGrid = $("#stuDataGrid");
		dataGrid.datagrid({
			url : '${pageContext.request.contextPath}/stu_datagrid',
			fit : true,
			//fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'createDate',
			sortOrder : 'desc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			striped : true,
			rownumbers : true,
			singleSelect : true,
			frozenColumns : [ [ {
				field : 'id',
				title : '学号',
				width : 80,
				checkbox : true,
			}, {
				field : 'name',
				title : '姓名',
				width : 50,
				sortable : true,
			} ] ],
			columns : [ [ {
				field : 'firstName',
				title : 'FirstName',
				width : 65,
				sortable : true,
				hidden : true,
			}, {
				field : 'lastName',
				title : 'LastName',
				width : 65,
				sortable : true,
				hidden :true,

			}, {
				field : 'sex',
				title : '性别',
				width : 35,
				hidden : true,
			},{
				field : 'company',
				title : '单位',
				width : 200,
			}, {
				field : 'tel',
				title : '固话',
				width : 100,
				sortable : true,
			}, {
				field : 'phone1',
				title : '手机1',
				width : 100,
			}, {
				field : 'phone2',
				title : '手机2',
				width : 100,
			}, {
				field : 'email1',
				title : '邮件1',
				width : 150,				
			}, {
				field : 'email2',
				title : '邮件2',
				width : 80,
				hidden : true,
			}, {
				field : 'qQ',
				title : 'QQ',
				width : 80,
			}, {
				field : 'card',
				title : '身份证',
				width : 150,
				sortable : true,
			}, {
				field : 'bornDate',
				title : '出生日期',
				width : 80,
				sortable : true,
				formatter : function(val,row){
					return getBirthdayFromIdCard(row.card);
				}
			}, {
				field : 'signDate',
				title : '签约时间',
				width : 80,				
			},{
				field : 'stuType',
				title : '学生类型',
				width : 60,
				formatter : function(val){
					if(val == 1)
					 return "正式学员";
					else if(val == 2)
					 return "重听学员";
					 else 
					 return "试听学员";
				}
			}, {
				field : 'userId',
				title : '学员顾问',
				width : 60,
				formatter : function(val,row){
					return row.userName;
				}
			}, {
				field : 'action',
				title : '操作',
				width : 30,
				formatter : function(value, row, index) {
					var str = '';
					if(row.id==undefined){
						return;
					}
					if($.canEdit){
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑培训及考试信息"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					return str;
				}
			}] ],
			onDblClickRow : function(rowIndex,rowData){
				parent.$.modalDialog({
					title : '学员资料变更',
					width : fixWidth(0.8),
					height : 450,
					maximizable : true,
					href : '${pageContext.request.contextPath}/stu_goStuEdit?id='+rowData.id,
					iconCls : 'disk',
					buttons : [ {
						text : '保存',
						handler : function() {
							parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
							var f = parent.$.modalDialog.handler.find('#ff');
							f.submit();
						}
					} ]
				});
			},
			onLoadSuccess : function() {
				$('#searchForm table').show();
			},
			toolbar : '#toolbar'
		});
		
		var p = dataGrid.datagrid('getPager'); 
		$(p).pagination({ 
			 pageSize: 10,//每页显示的记录条数，默认为10
			 pageList:[5,10,15,20],//每页显示几条记录
			 beforePageText: '第',//页数文本框前显示的汉字
			 afterPageText: '页    共 {pages} 页',
			 displayMsg: '当前显示 {from} - {to} 条记录    共 {total} 条记录',
			 onBeforeRefresh:function(){ 
				 $(this).pagination('loading');//正在加载数据中...
				 alert('before refresh');
				 $(this).pagination('loaded'); //数据加载完毕
			 } 
		 }); 
		 
		function getBirthdayFromIdCard(idCard) {  
	        var birthday = "";  
	        if(idCard != null && idCard != ""){  
	            if(idCard.length == 15){  
	                birthday = "19"+idCard.substr(6,6);  
	            } else if(idCard.length == 18){  
	                birthday = idCard.substr(6,8);  //1995-05-29
	            }  
	          
	            birthday = birthday.replace(/(.{4})(.{2})/,"$1-$2-");  
	        }
	        return birthday;  
      }
      
      

		function endEdit(){
			var rows = dataGrid.datagrid('getRows');
			for ( var i = 0; i < rows.length; i++) {
				dataGrid.datagrid('endEdit', i);
            }
        }       
	});
	//学员注册
    function addFun(){
		parent.$.modalDialog({
			title : '注册学籍',
			width : fixWidth(0.8),
			height : 450,
			href : '${pageContext.request.contextPath}/stu_goStuAdd',
			iconCls : 'disk',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#ff');
					f.submit();
				}
			} ]
		});
	}
	
	//注销学员
	function deleteFun(){
		var rows = dataGrid.datagrid("getChecked");
		var ids = "";
		if(rows && rows.length != 0){
			for(var i = 0;i<rows.length;i++){
				ids = ids + rows[i].id;
				if(i < (rows.length-1)){
					ids = ids + ",";
				}
			}
		}else{
			$.messager.alert("提示","请选择删除项","info");
			return;
		}
		$.messager.confirm('提示', '您确定注销该学员吗？', function(b) {
			if (b) {
				$.post('${pageContext.request.contextPath}/stu_delete', {
					id : ids
				}, function(result) {
					if (result.success) {
						parent.$.messager.alert('提示', result.msg, 'info');
						dataGrid.datagrid('reload');
					}
				}, 'JSON');
			}
		});
	}
	
	//查询
	function searchFun(){
		dataGrid.datagrid('load',$.serializeObject($('#searchForm')));
	}
	
	//清空查询
	function cleanFun(){
		$("#searchForm input").val('');
		dataGrid.datagrid('load',{});
	}
	//设置为屏幕分辨率大小
	function fixWidth(percent)  {
   		return window.screen.width * percent ; //这里你可以自己做调整  
	}
  </script>
  
  </head>
  <body>
    <div class="easyui-layout" data-options="fit : true,border : false">
    	<div data-options="region:'north',title:'查询',border:false" style="height:85px;padding-left:10px; overflow: hidden;">
			<div style="float:left">
			<a id="addStu" onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
			
			<a id="delStu" onclick="deleteFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'cancel'">删除</a>
			
			<a id="impStu" onclick="excelImportStudent();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'sum'">导入学生</a>
			<a id="loadStu" onclick="toload();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'sum'">下载模板</a>
			</div>
			<div style="clear:both"></div>
			<div style="float:left">
			<form id="searchForm">
				关键字：<input id="key" name="name" placeholder="可以模糊查询" class="span2" />
				签约时间：<input class="span2" name="signDateStart" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />至<input class="span2" name="signDateEnd" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />
				学员类型：<select name="stuType" class="easyui-combobox" data-options="width:90,height:29,editable:false,panelHeight:'auto',required:true">
									<option value="0">==请选择==</option>
									<option value="1">正式学员</option>
									<option value="2">重读学员</option>
									<option value="3">试听学员</option>
				</select>
				学员顾问：<select name="userId" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
						<option value="0">==请选择==</option>
						<c:forEach items="${users }" var="user">
							<option value="${user.id }">${user.name }</option>
						</c:forEach>
				</select>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_delete',plain:true" onclick="cleanFun();">清空条件</a>
			</form>
			</div>
		</div>
		<div data-options="region:'center',border:false">
			<table id="stuDataGrid"></table>
		</div>
		<div id="toolbar" style="display: none;">
		
	</div>
	</div>
  </body>
</html>
