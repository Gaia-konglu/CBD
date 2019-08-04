<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddComplain.jsp' starting page</title>
    
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
							<td>${order_dfer.partingSpace.addr}</td>
							<td>${order_dfer.partingSpace.carNum}</td>
							<td>${order_dfer.rentInfor.startTime}</td>
							<td>${order_dfer.rentInfor.endTime}</td>
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
							<td>${order_dfer.tenant.name}</td>
							<td>${order_dfer.tenant.realName}</td>
							<td>${order_dfer.tenant.idCard}</td>
							<td>${order_dfer.tenant.job}</td>
							<td>${order_dfer.tenant.phone}</td>
						</tr>

					</tbody>
				</table>
			</div>
  <form action="addCompl.do" method="post">
  <c:choose>
  <c:when test="${sessionScope.cont ==null}">
     <textarea id="comContent" cols="40" row="10" style="height:100px;" name="ComplainContent">${sessionScope.cont} </textarea>
    
     <input type="submit"  value="投诉">
     </c:when>
     <c:otherwise>
      <textarea id="comContent" cols="40" readonly="readonly" row="10" style="height:100px;" name="ComplainContent">${sessionScope.cont} </textarea>
    
     <input type="submit" disabled="disabled"  value="已投诉">
     </c:otherwise>
     </c:choose>
     </form>
        
  </body>
</html>
