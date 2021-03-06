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
    
    <title>My JSP 'myPayBookInfor.jsp' starting page</title>
    
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
    		<th>小区地址</th>
    		<th>车位编号</th>
    		<th>租借开始时间</th>
    		<th>租借结束时间</th>
    		<th>出租价格</th>
    		<th>包租婆用户名</th>
    		<th>包租婆电话</th>
    		<th>包租婆信誉度</th>
    		<th>留言</th>
    		<th>操作</th>
    		<th>取消订单</th>
    	</thead>
    	<tbody>
    		<c:forEach items="${list}" var="obj">
    		<tr>
    			<td>${obj.part.addr}</td>
    			<td>${obj.part.carNum}</td>
    			<td>${obj.rent.startTime}</td>
    			<td>${obj.rent.endTime}</td>
    			<td>${obj.rent.price}</td>
    			<td>${obj.landLady.name}</td>
    			<td>${obj.landLady.phone}</td>
    			<td>${obj.landLady.credit}</td>
    			<td>${obj.message}</td>
    			<form action="aliPay.do" method="post">
    			<input type="hidden" name="order" value="${obj.order}">
    			<input type="hidden" name="price" value="${obj.rent.price}">
    			<input type="hidden" name="carNum" value="${obj.part.carNum}">
    			<input type="hidden" name="addr" value="${obj.part.addr}">
    			<td><button type="submit" >确认支付</button></td>
    			</form>
    			<td><button type="button" onclick="">取消订单</button></td>
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
  </body>
</html>
