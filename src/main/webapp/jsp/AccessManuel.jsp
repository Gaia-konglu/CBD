<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AccessManuel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    后台管理员菜单页面<br>
    <shiro:hasPermission name="userMP">
   <div>用户管理</div>
   </shiro:hasPermission>
   <shiro:hasPermission name="carportMP">
   <div>车位管理</div>
   </shiro:hasPermission>
   <shiro:hasPermission name="contractMP">
    <div>合同管理</div>
    </shiro:hasPermission>
    <shiro:hasPermission name="complainMP">
     <div>投诉管理</div>
   </shiro:hasPermission>
   <shiro:hasPermission name="adminMP">
     <div>管理员权限管理</div>
   </shiro:hasPermission>
   <a href="/CBDParkingManagementSystem/tset4.do">111</a>
   
  </body>
</html>
