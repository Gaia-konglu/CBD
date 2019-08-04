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
    
    <title>My JSP 'UpdateBack.jsp' starting page</title>
    
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
    This is my JSP page. <br>
            修改后台管理员登录密码、电话号码
    
    <form action="/CBDParkingManagementSystem/updateBack.do" method="post">
	
		登录密码：<input type="text" name="pass"><br/><br/>
		电话号码：<input type="text" name="phone" ><br/><br/>
		<button type="submit">添加</button>
	</form>
    

    <a href="/CBDParkingManagementSystem/findAll.do">> 查看全部私人招租车位信息 </a>
    <br/>
    <br/>
    
    <a href="/CBDParkingManagementSystem/WaitApprove.do">> 查询需要审批的包租婆添加的所有私人招租车位信息+包租婆的个人信息 </a>
    <br/>
    <br/>
    
     <a href="/CBDParkingManagementSystem/jsp/RegisterLog.jsp">> 查看后台 登录日志 </a>
    <br/>
    <br/>
    
    <a href="/CBDParkingManagementSystem/jsp/OperationLog.jsp">> 查看后台操作日志 </a>
    <br/>
    <br/>
    
  </body>
</html>
