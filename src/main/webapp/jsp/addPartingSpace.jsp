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
    
    <title>My JSP 'addPartingSpace.jsp' starting page</title>
    
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
	margin: 50px auto;
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
	height: 47px;
}
.table tbody tr td {
	text-align: center;
	border-left: 1px solid #ECECEC;
	border-right: 1px solid #ECECEC;
	border-bottom: 1px solid #ECECEC;
	font-size: 15px;
	color: #909090;
	height: 47px;
}
input{
width:250px;
height:25px;

}
</style>
  </head>
  
  <body>
  		
    <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
  		<thead>
  			<th>车位产权证编号</th>
  			<th>车位所在小区地址</th>
  			<th>小区车位编号</th>
  			<th>车位产权复印件</th>
  			<th>操作</th>
  	
  		</thead>
  		<tbody>
  			<tr>
  			 <form action="addPartingSpace.do" method="post" enctype = "multipart/form-data">
  			 
  				<td ><input  type="text" name="propertyNum" /></td>
  				<td><input  type="text" name="addr" /></td>
  				<td><input  type="text" name="carNum" "/></td>
  				<td><input  type="file" name="imgFile"/></td>
  				<td><button type="submit">提交申请</button></td>
  			</form>
  			</tr>
  		</tbody>
  	</table>
  	
  </body>
</html>
