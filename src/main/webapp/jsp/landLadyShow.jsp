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
    
    <title>My JSP 'landLadyShow.jsp' starting page</title>
    
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
  	<button onclick="apply()">车位申请</button>
  	<button onclick = "published()">招租信息管理</button>
  	<button onclick = "checkMyPart()">我的车位管理</button>
    <table border="1" cellspacing = "0" cellpadding = "10">
    	<thead>
    		<th>小区地址</th>
    		<th>车位编号</th>
    		<th>租借开始时间</th>
    		<th>租借结束时间</th>
    		<th>抢租客用户名</th>
    		<th>抢租客职业</th>
    		<th>抢租客电话</th>
    		<th>抢租客信誉度</th>
    		<th>抢租客留言</th>
    		<th>操作</th>
    	</thead>
    	<tbody>
    		<c:forEach items="${list}" var="obj">
    		<tr>
    			<td>${obj.part.addr}</td>
    			<td>${obj.part.carNum}</td>
    			<td>${obj.rent.startTime}</td>
    			<td>${obj.rent.endTime}</td>
    			<td>${obj.tenant.name}</td>
    			<td>${obj.tenant.job}</td>
    			<td>${obj.tenant.phone}</td>
    			<td>${obj.tenant.credit}</td>
    			<td>${obj.message}</td>
    			<td><button type="button" onclick="affirm(${obj.id},${obj.rent.id })">确认出租</button></td>
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
    
    <script type="text/javascript">
    	function affirm(b_id,r_id){
    	var jsonobj = {"bid":b_id,"rid":r_id};
    		$.ajax({
    			url:"updateStatus.do",
    			type:"post",
    			data:jsonobj,
    			success:function(message){
    			window.location.reload();
   				}
    		});
    	}
    	
    	function apply(){
    	window.location.href = "jsp/addPartingSpace.jsp";
    	}
    	
    	function published(){
    	window.location.href = "showMyRentInfor.do";
    	}
    	function checkMyPart(){
    	window.location.href = "showMyPart.do";
    	}
    	
    </script>
  </body>
</html>
