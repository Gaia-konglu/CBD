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
    
    <title>My JSP 'CompanyFront.jsp' starting page</title>
    
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
            企业前台。 </br>
 	企业名称：${sessionScope.name}<br/><br/>
 	<form action="jsp/companyAreadyRentedList.jsp">
 		<button type="submit">查看企业已租赁车位</button>
 	</form><br/>
 	<form action="jsp/companyNotRentedList.jsp">
 		<button type="submit">CDB车位管理平台系统的未租赁的空闲车位</button>
 	</form>
  </body>
</html>
