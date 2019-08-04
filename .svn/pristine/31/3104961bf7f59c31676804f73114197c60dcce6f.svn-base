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
    
    <title>My JSP 'addManyCarport.jsp' starting page</title>
    
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
    <form action="addManyCarport.do" method="post">
  车位地址：  <input type="text" name="adress" value="${carportbean.adress }"><br>
    车位区域编号：<input type="text"  name="areaId" ><br>
  起始车位编号：  <input type="text" name="caportId">${err_caportId}<br>
  添加车位数量：<input type="text" name="carportNum">${err_caportNum}<br>
   <!-- 用于接收签订第三方协议后，获得第三方id -->
   <input type="hidden" name="tpc.id" value="1"> 
    <input type="submit" value="添加">
    
    </form>
    ${adressException}
    
  </body>
</html>
