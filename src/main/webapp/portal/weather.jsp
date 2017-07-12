<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>天气预报</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <div  title="天气预报"  cc="aaa" closable="true" collapsible="true" style="height:260px;padding:5px; position:relative; overflow:scroll;scrollbar-face-color: #EAEAEA;scrollbar-shadow-color: #EAEAEA;scrollbar-highlight-color: #EAEAEA;scrollbar-3dlight-color: #EAEAEA;scrollbar-darkshadow-color: #697074;
scrollbar-track-color: #F7F7F7;scrollbar-arrow-color: #666666; " pageIdex="0">
   <iframe width="800" scrolling="no" height="120" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=19&icon=1&py=hangzhou&temp=1&num=5"></iframe>
  </div>
  </body>
</html>
