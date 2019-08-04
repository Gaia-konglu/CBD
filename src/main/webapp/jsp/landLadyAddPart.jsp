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
    
    <title>信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style>
.table {
	padding: 0;
	margin: 0;
	position: relative;
	margin: 0 auto;
}

.table tbody tr th {
	background: #FFF9C1 no-repeat;
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

	input{
width:170px;
height:25px;
}
.selects{
width:170px;
height:30px;
}
</style>
</head>
<body>
	
	<div id="container">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0" >
						<tr>
							<th>车位产权证编号</th>
							<th>区域</th>
  							<th>小区地址</th>
  							<th>小区车位编号</th>
  							<th>车位产权复印件</th>
  							<th>操作</th>
						</tr>
						<tbody >
     	 				<form action="/CBDParkingManagementSystem/addPartingSpace.do" method="post" enctype = "multipart/form-data">
  							<td ><input  type="text" name="propertyNum" /></td>
  							<td>
  								<select class="selects" name="region">
  									<option value="">--请选择--</option>
                                	<option value="成都市武侯区">成都市武侯区</option>
                                	<option value="成都市青羊区">成都市青羊区</option>
                                	<option value="成都市高新区">成都市高新区</option>
                                	<option value="成都市成华区">成都市成华区</option>
  									<option value="成都市锦江区">成都市锦江区</option>
  									<option value="成都市金牛区">成都市金牛区</option>
  									<option value="成都市龙泉驿区">成都市龙泉驿区</option>
  									<option value="成都市青白江区">成都市青白江区</option>
  									<option value="成都市新都区">成都市新都区</option>
  									<option value="成都市温江区">成都市温江区</option>
  									<option value="成都市双流区">成都市双流区</option>
  									<option value="成都市郫都区">成都市郫都区</option>
  								</select>
  							
  							</td>
  							<td><input  type="text" name="addr" /></td>
  							<td><input  type="text" name="carNum" "/></td>
  							<td><input  type="file" name="imgFile"/></td>
  							<td><button type="submit">提交申请</button></td>
  						</form>
						</tbody>
					</table>
		</div>
</body>
</html>