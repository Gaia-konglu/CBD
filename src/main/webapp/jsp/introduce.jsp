﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>车位租赁系统前台</title>
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<style>
	#introduce_div{
		background-image:url("../images/common/ziru.jpg");
		background-repeat: no-repeat;
		background-size:100% 100%;
		width:1319px;
		height:400px;
		margin-top:7px;
		margin-left:-50px;
	}
	#title{
	background-image:url("../images/common/title.png");
		background-repeat: no-repeat;
		background-size:100% 100%;
		width:619px;
		height:129px;
		margin-top:3px;
		margin-left:350px;
	}
</style>
</head>
<body>
		<div id="title"></div>
		<div id="introduce_div"></div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
