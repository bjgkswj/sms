<%@page import="org.sms.modules.basemanage.model.SmsSchool"%>
<%@page import="org.sms.system.BeanFactory"%>
<%@page import="org.sms.modules.basemanage.service.SchoolServiceI"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta name="renderer" content="webkit">
    <title>系统登录</title>
<!-- 引入jQuery -->
<script src="${pageContext.request.contextPath}/jslib/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
<!-- 引入EasyUI -->
<link id="easyuiTheme" rel="stylesheet" href="${pageContext.request.contextPath}/jslib/jquery-easyui-1.3.3/themes/<c:out value="${cookie.easyuiThemeName.value}" default="bootstrap"/>/easyui.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.3.3/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<style>
	html,body{width:100%;height:100%;margin:0px;padding:0px;overflow:hidden;font-family:'宋体';}
	.body_bg{width:100%;height:100%; position:absolute; z-index:-1;}
	p{margin:0px;padding:0px;}
	font{margin:0px; padding:0px;}
	input{margin:0px; padding:0px;}
	.login_body{width:100%;height:100%;overflow:auto;}
	form{width:670px;height:406px;margin:111px auto; position:relative;}
	.login_main{width:670px;height:406px;background:url("style/images/sms-login.png") no-repeat;
        _filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true', sizingMethod='scale', src="resources/images/bf-login.png");
        _background:none;}
	.login_main_c{height:160px; width:343px;padding-left:15px; padding-top:100px; position:absolute; top:0; left:0;}
	.login_main p{clear:both;margin-bottom:10px;color:#71BAFF;padding-left:10px;font-size:12px; font-weight:bold}
	.login_txt{width:115px;height:20px;border:1px #879B85 solid;vertical-align:middle; margin-left:5px;}
	.login_input_yz{width:50px;height:20px;border:1px #879B85 solid;margin-left:5px;vertical-align:middle;}
	.login_check{width:20px;vertical-align:middle; margin-left:53px;}
	.login_checktext{vertical-align:middle;margin-left:5px;}
	.login_main p img{vertical-align:middle;margin-left:15px;}
	.login_bt{width:65px;height:26px;border:0px;background:url("style/images/login_button.gif") no-repeat; margin-left:80px; cursor:pointer;}
	.login_main .login_admin{font-size:12px;font-weight:normal;padding-left:0px;margin-top: -25px;}
	.login_bottom{width:570px; padding-left:30px; padding-top:260px; font-size:12px; color:#71BAFF;}
</style>
		<script type="text/javascript" charset="utf-8">
	var loginDialog;
	var defaultUserInfoDialog;
	$(function() {
		$('#loginForm input').keyup(function(event) {
			if (event.keyCode == '13') {
				loginFun();
			}
		});

		var sessionInfo_userId = '${sessionInfo.id}';
		if (sessionInfo_userId) {/*目的是，如果已经登录过了，那么刷新页面后也不需要弹出登录窗体*/
			location.replace('${pageContext.request.contextPath}/index.jsp');
		}
	});
	function loginFun() {
			if ($('#loginForm').form('validate')) {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				$.post('${pageContext.request.contextPath}/user_login', $('#loginForm').serialize(), function(result) {
					if (result.success) {
						location.replace('${pageContext.request.contextPath}/index.jsp');
					} else {
						$.messager.alert('错误', result.msg, 'error');
					}
					parent.$.messager.progress('close');
				}, "JSON");
			}
	}
</script>
  </head>
  
  <body>
	<div class="login_body">
		<img src="<%=path%>/style/images/login_main.jpg" class="body_bg" />
		<form id="loginForm" method="post">
			<div class="login_main">
				<div class="login_main_c">
					<p>
						用户名：<input type="text" class="easyui-validatebox"
							id="username" name="username" required="true"
							missingMessage="请输入用户名" xtype="obj" value=""/>
					</p>
					<p>
						密&nbsp;&nbsp;码：<input type="password" style="margin-left:-1px;"
							class="easyui-validatebox" name="password" required="true" missingMessage="请输入密码" xtype="obj"
							id="password" />
					</p>
					<p>
						校&nbsp;&nbsp;区：<select name="schoolId" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto',required:true">
							<option value="0">==请选择校区==</option>
							<c:forEach items="${schoolList}" var="school">
								<option value="${school.id}" <c:if test="${school.id == schoolId}"> selected="selected" </c:if>>${school.schoolname}</option>
							</c:forEach>
						</select>
					</p>
					<input type="button" class="login_bt" id="loginBtu" onclick="loginFun();" />
				</div>
				<div class="login_bottom">版权归有限公司所有<b>(V1.0版)</b></div>
			</div>
		</form>
	</div>
</body>
</html>
