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
	<link href="style/authority/main_css.css" rel="stylesheet" type="text/css">
<style type="text/css">

.table {
	padding: 0;
	margin: 0;
	position: relative;
	margin: 0 auto;
}

.table thead  th {
	background: #f3f2f0 no-repeat;
	text-align: center;
	border-left: 1px solid #ECECEC;
	border-right: 1px solid #ECECEC;
	border-bottom: 1px solid #ECECEC;
	border-top: 1px solid #ECECEC;
	letter-spacing: 2px;
	text-transform: uppercase;
	font-size: 14px;
	color: #757370;
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
.point:hover{
text-decoration:underline;
color:#ffa000;
}
}


</style>
  </head>
    <script src="/CBDParkingManagementSystem/js/jquery.1.9.1.js"></script>
  <body>
     <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
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
    			<td><span class="point"  onclick="openDialog(${obj.id})">取消订单</span></td>
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
    			<!--弹框  -->
				<div class='demo-bg'></div>
    			<div class='demo-txt'>
        			<div class="text">确定删除本条信息吗？</div>
        			<input type="hidden" id="partId" name="bookId"/>
        			<button onclick="deletePay()">确定</button>
        			<button class="btn" onclick="closeDialog()">退出</button>
    			</div>
    <script type="text/javascript">
    function deletePay(){
    	$.ajax({
    	url:"deletePayBooKInfor.do",
    	type:"post",
    	data:{
    		"bookId":$("#partId").val()
    	},
    	success:function(message){
    	if(message=="success"){
			closeDialog();
			window.location.reload();	 			
    		}
    	}
    	});
    
    }
    	
    var demobg = document.querySelector(".demo-bg");
    var demotxt = document.querySelector(".demo-txt");
    function openDialog(pid) {
    	demobg.style.display="block";
        demotxt.style.display="block";
 		document.getElementById("partId").value=pid;
    }
    function closeDialog() {
        demotxt.style.display = "none";
        demobg.style.display = "none";
    }
    
    </script>
  </body>
</html>
