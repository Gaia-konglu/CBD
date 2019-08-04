<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SuperBack.jsp' starting page</title>
    
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
  <div>
  	<table border=1>
  		<thead>
  			<tr>
  				<th>id</th>
  				<th>姓名</th>
  			</tr>
  		</thead>
  		<tbody>
  			
  				<tr>
  					<td>${ubab.num}</td>
  					<td>${ubab.name}</td>
  				</tr>
  			
  		</tbody>
  	</table>
  </div>
  
  
  修改后台管理员权限
   <form action="/CBDParkingManagementSystem/updateBackau.do" method="post">
   		<input type="hidden" name="id" value="${ubab.id}">
   		用户管理权限：
		<label><input name="user_authority" type="radio" value="userMP" <c:if test="${ubab.user_authority!='0'}">checked</c:if> />有权 </label> 
		<label><input name="user_authority" type="radio" value="0" <c:if test="${ubab.user_authority=='0'}">checked</c:if>/>无权 </label> 
		车位管理权限：
		<label><input name="car_authority" type="radio" value="carportMP" <c:if test="${ubab.car_authority!='0'}">checked</c:if>/>有权 </label> 
		<label><input name="car_authority" type="radio" value="0" <c:if test="${ubab.car_authority=='0'}">checked</c:if>/>无权 </label>
		合同管理权限：
		<label><input name="pact_authority" type="radio" value="contractMP" <c:if test="${ubab.pact_authority!='0'}">checked</c:if>/>有权 </label> 
		<label><input name="pact_authority" type="radio" value="0" <c:if test="${ubab.pact_authority=='0'}">checked</c:if>/>无权 </label>
		投诉管理权限：
		<label><input name="complain_authority" type="radio" value="complainMP" <c:if test="${ubab.complain_authority!='0'}">checked</c:if>/>有权 </label> 
		<label><input name="complain_authority" type="radio" value="0" <c:if test="${ubab.complain_authority=='0'}">checked</c:if>/>无权 </label> 
		<button type="submit">确认修改</button>
	</form>
  添加后台管理员
     <form action="/CBDParkingManagementSystem/addBack.do" method="post">
		工号:<input type="text" name="num" value="${bsb.num }">${err_num}<br/><br/>
		姓名:<input type="text" name="name" value="${ bsb.name}">${err_name }<br/><br/>
		登录密码：<input type="text" name="pass" value="${bsb.pass }">${err_pass }<br/><br/>
		电话号码：<input type="text" name="phone" value="${bsb.phone }">${err_phone }<br/><br/>
		用户管理权限：
		<label><input name="user_authority" type="radio" value="userMP" checked/>有权 </label> 
		<label><input name="user_authority" type="radio" value="0" />无权 </label> 
		车位管理权限：
		<label><input name="car_authority" type="radio" value="carportMP" checked/>有权 </label> 
		<label><input name="car_authority" type="radio" value="0" />无权 </label>
		合同管理权限：
		<label><input name="pact_authority" type="radio" value="contractMP" checked/>有权 </label> 
		<label><input name="pact_authority" type="radio" value="0" />无权 </label>
		投诉管理权限：
		<label><input name="complain_authority" type="radio" value="complainMP" checked/>有权 </label> 
		<label><input name="complain_authority" type="radio" value="0" />无权 </label> 
		<button type="submit">添加管理员</button>
	</form>  
  </body>
</html>
