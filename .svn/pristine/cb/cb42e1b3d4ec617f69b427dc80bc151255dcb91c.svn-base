<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMyPart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	table{
	margin:100px auto;
	}
	th{
	height:50px;
	font-size:20px;
	}
	tr{
	height:50px;
	font-size:20px;
	text-align:center;
	}
	input{
	font-size:15px;
	}
	button{
	font-size:15px;
	}
	</style>
  </head>
  <script src="/CBDParkingManagementSystem/js/jquery.1.9.1.js"></script>
  <body>
   		<table border="1" cellspacing = "0" cellpadding = "10">
    	<thead>
    		<th>车位产权证编号</th>
  			<th>车位所在小区地址</th>
  			<th>小区车位编号</th>
  			<th>提交时间</th>
  			<th>状态</th>
  			<th>操作</th>
    	</thead>
    	<tbody>
    		<c:forEach items="${list}" var="obj">
    		<tr>
    			<td>${obj.propertyNum}</td>
    			<td>${obj.addr}</td>
    			<td>${obj.carNum}</td>
    			<td>${obj.time}</td>
    			<td>
    				<c:choose>
    					<c:when test="${obj.flag eq 1}">已通过审核</c:when>
    					<c:when test="${obj.flag eq 0}">待审核</c:when>
    				</c:choose>
    			</td>
    			<td><button onclick="publish(${obj.id})">发布招租</button></td>
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
   	<script type="text/javascript">
   		function publish(pid){
   		window.location.href="jsp/publishRentInfor.jsp?pid="+pid;
   		}
   	
   	
   	</script>
  </body>
</html>
