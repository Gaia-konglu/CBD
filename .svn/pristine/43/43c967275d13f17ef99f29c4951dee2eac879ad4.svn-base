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
    *************</br>
            企业后台。 </br>
    *************</br>
 	<form action="jsp/companyFuzzyQueryList.jsp" method="post">
 		<input type="hidden" name="name" value="${requestScope.companyBean.name}"/>
 		<input type="hidden" name="addr" value="${requestScope.companyBean.addr}"/>
 		<input type="hidden" name="contacts" value="${requestScope.companyBean.contacts}"/>
 		<input type="hidden" name="phone" value="${requestScope.companyBean.phone}"/>
 		<button type="submit">进入模糊查询、删除模块</button>
 	</form><br/>
 	<form action="jsp/companyAdd.jsp" method="get">
 		<button type="submit">点击进入新增企业模块</button>
 	</form><br/>
  </body>
</html>
