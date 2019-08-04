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
    
    <title>My JSP 'showMyRentInfor.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	
.table {
	padding: 0;
	margin: 0;
	position: relative;
	margin: 10px auto;
}

.table thead th {
	background: #044599 no-repeat;
	text-align: center;
	border-left: 1px solid #02397F;
	border-right: 1px solid #02397F;
	border-bottom: 1px solid #02397F;
	border-top: 1px solid #02397F;
	letter-spacing: 2px;
	text-transform: uppercase;
	font-size: 14px;
	color: #fff;
	height: 37px;
}

.table tbody tr td {
	text-align: center;
	border-left: 1px solid #ECECEC;
	border-right: 1px solid #ECECEC;
	border-bottom: 1px solid #ECECEC;
	font-size: 15px;
	color: #909090;
	height: 37px;
}
.point{
cursor:pointer;

}
	</style>
  </head>
  <script src="/CBDParkingManagementSystem/js/jquery.1.9.1.js"></script>
  <body>
    <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
    	<thead>
    		<th>车位小区地址</th>
    		<th>车位编号</th>
    		<th>租借开始时间</th>
    		<th>租借结束时间</th>
    		<th>出租价格</th>
    		<th>ID</th>
    		<th>状态</th>
    		<th>操作</th>
    	</thead>
    	<tbody>
    		<c:forEach items="${list}" var="obj">
  
   				<tr>
   					<td>${obj.personCarSpaceInfor.addr}</td>
    				<td>${obj.personCarSpaceInfor.carNum}</td>
   					<td>${obj.startTime}</td>
   					<td>${obj.endTime}</td>
   					<td>${obj.price}</td>
   					<td>${obj.id}</td>
   					<td>
   						<c:choose>
    						<c:when test="${obj.flag eq 1}">车位未预定</c:when>
    						<c:when test="${obj.flag eq 2}">车位已预定</c:when>
    						<%-- <c:when test="${obj.flag eq 2 and obj.bookOrder ne 0}">订单已生成</c:when> --%>
    					</c:choose>
   					</td>
   					<td><span class="point" onclick="sendRid(${obj.id})">删除</span></td>
   					
   				</tr>
   				
    		</c:forEach>
    	</tbody>
    </table>
    
    <script type="text/javascript">
    	function sendRid(index){
    		$.ajax({
    			url:"deleteRentInfor.do",
    			type:"post",
    			data:{"id":index},
    			success:function(message){
    			window.location.reload();
    			}
    		});
    	}
    
    
    </script>
  </body>
</html>
