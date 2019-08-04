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
    
    <title>My JSP 'UpdateCompany.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/modernizr.custom.js"></script>
  </head>
  
  <body>
  		<table>
		<tr>
			<td>用户名</td>
			<td>企业姓名</td>
			<td>地址</td>
		</tr>
		<tr>
			<td>${sessionScope.companyBean.admin}</td>
			<td>${sessionScope.companyBean.name}</td>
			<td>${sessionScope.companyBean.addr}</td>
		</tr>
		</table>
     <form action="/CBDParkingManagementSystem/updateCompany.do" method="post">
		登录密码：<input type="text" name="pass" id="pass" oninput="checkpass()">${requestScope.passError}<br/><br/>
		联系人：<input type="text" style="display:inline-block;margin-left:17px;" name="contacts" id="contacts" oninput="checkcontacts()">${requestScope.contactsError}<br/><br/>
		电话号码：<input type="text" name="phone" id="phone" oninput="checkphone()">${requestScope.phoneError}<br/><br/>
		<button type="submit">确认修改</button>
	</form>
	<div>
		${requestScope.success}<br>
		<span id="check"></span>
	</div>
  </body>
  <script type="text/javascript">
  	function checkpass(){
    	var zz=/^[a-zA-Z0-9]{6,15}$/;
    	var content=$("#pass").val();
      if(!zz.test(content)&&!content==""){
      	$("#check").html("密码请输入6-15位字母和数字");
      }else{
      	$("#check").html("");
      }
    }
    

    
    function checkcontacts(){
    	var zz=/^[a-zA-Z\u4e00-\u9fa5]+$/;
    	var content=$("#contacts").val();
      if(!zz.test(content)&&!content==""){
      	$("#check").html("联系人不能有数字、字符");
      }else{
      	$("#check").html("");
      }
    }
    
    function checkphone(){
    	var zz=/^1[34578]\d{9}$/;
    	var content=$("#phone").val();
      if(!zz.test(content)&&!content==""){
      	$("#check").html("电话格式不对");
      }else{
      	$("#check").html("");
      }
    }
    
  </script>
  
  
</html>
