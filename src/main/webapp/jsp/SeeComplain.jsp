<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SeeComplain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
  </head>
  
  <body>
    <div class="bs-example widget-shadow" data-example-id="bordered-table"> 
						<h4>事件记录:</h4>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>车位小区地址</th>
							<th>车位编号</th>
							<th>租赁开始时间</th>
							<th>租赁结束时间</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>${seeCom.order.partingSpace.addr}</td>
							<td>${seeCom.order.partingSpace.carNum}</td>
							<td>${seeCom.order.rentInfor.startTime}</td>
							<td>${seeCom.order.rentInfor.endTime}</td>
						</tr>

					</tbody>
				</table>
			</div>
			
			<div class="bs-example widget-shadow" data-example-id="bordered-table"> 
						<h4>被投诉方:</h4>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>用户名</th>
							<th>真实姓名</th>
							<th>身份证号</th>
							<th>职业</th>
							<th>联系电话</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>${seeCom.person2.name}</td>
							<td>${seeCom.person2.realName}</td>
							<td>${seeCom.person2.idCard}</td>
							<td>${seeCom.person2.job}</td>
							<td>${seeCom.person2.phone}</td>
						</tr>
						<tr>
						     <td>投诉状态</td>
						     <td>${seeCom.status}</td>
						</tr>
						<tr>
						    <td>投诉原因</td>
						    <td><textarea cols="40" row="10" style="height:100px;" readonly="readonly">${seeCom.complainContent} </textarea></td>
						</tr>
						<tr>
						    <td>回复</td>
						    <td><textarea cols="40" row="10" style="height:100px;" readonly="readonly">${seeCom.returnContent} </textarea></td>
						</tr>

					</tbody>
				</table>
			</div>
  </body>
</html>
