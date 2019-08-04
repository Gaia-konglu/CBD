<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyInfor.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.title {
    background: #fafafa;
    height: 50px;
    padding: 0 20px;
    font-size: 24px;
    font-size: 16px;
    border-bottom: solid 1px #eee;
    line-height: 50px;
}
input{
    border: solid 1px #ccc;
    width: 300px;
    padding: 0 10px;
    height: 40px;
    border-radius: 5px;
    color: #999;
}
body{
height:500px;
width:900px;
border:solid 1px #EDEDED;
overflow-y:hidden; 
margin-left:23px;
}
#save_button{
background:#ffa000;
padding: 0 30px;
font-size: 14px;
color: #fff;
border-radius: 3px;
height: 40px;
cursor:pointer;
}

}

</style>
  </head>
  <script src="/CBDParkingManagementSystem/js/jquery.1.9.1.js"></script>
  <body>
    		<table>
		<tr>
			<td>真实姓名</td>
			<td>身份证号</td>
			<td>信誉度</td>
		</tr>
		<tr>
			<c:if test="${sessionScope.person==null}">
			
			<td>${sessionScope.tenant.realName}</td>
			<td>${sessionScope.tenant.idCard}</td>
			<td>${sessionScope.tenant.credit}</td>
			
			</c:if>
			
			<c:if test="${sessionScope.tenant==null}">
			
			<td>${sessionScope.person.realName}</td>
			<td>${sessionScope.person.idCard}</td>
			<td>${sessionScope.person.credit}</td>
			
			</c:if>
			
		</tr>
	</table>
     <div class="title">个人信息修改</div>
      <table>
      <form action="/CBDParkingManagementSystem/updatePerson.do" method="post">
        <tbody>
        <tr>
          <td style="padding-top:20px;">密码</td>
          <td colspan="2" style="padding-top:20px;"><input type="text" id="pass" name="password" oninput="checkpass()"/></td> 
        </tr>
     
        
        <tr>
            <td style="padding-top:20px;">地址</td>
            <td colspan="2" style="padding-top:20px;">
              <input type="text" id="addr" name="addr" >
            </td>
        </tr>
        <tr >
          <td style="padding-top:20px;">职业</td>
          <td colspan="2" style="padding-top:20px;">
            <input type="text" id="job" name="job" oninput="checkjob()" >
          </td>
        </tr>
        <tr>
          <td style="padding-top:20px;">手机号码</td>
          	<td colspan="2" style="padding-top:20px;">
            	<input type="text" id="phone" name="phone" oninput="checkphone()" >
        	</td>
        </tr>
        <tr>
          <td style="padding-top:20px;">电子邮箱</td>
          <td colspan="2" style="padding-top:20px;">
            <input type="text" name="eMail" id="mail" oninput="checkEmail()" >
          </td>  
        </tr>
       
        <tr>
          <td></td>
          <td colspan="3" style="padding-top:20px;">
            <input id="save_button" type="submit" value="确认修改">
          </td>
        </tr>
        </format>
        <%-- <td>
        ${requestScope.result}<br>
        <span id="check"></span>
        </td> --%>
      </tbody>
   </table>
     <div style="font-size:14px;color:red;">
		${requestScope.result}<br>
		<span id="check"></span>
	</div>

  </body>

  <script type="text/javascript">
    function checkphone(){
    	var zz=/^1[34578]\d{9}$/;
    	var content=$("#phone").val();
      if(!zz.test(content)&&!content==""){
      	$("#check").html("电话格式不对");
      }else{
      	$("#check").html("");
      }
    }
    
    function checkpass(){
    	var zz=/^[a-zA-Z0-9]{6,15}$/;
    	var content=$("#pass").val();
      if(!zz.test(content)&&!content==""){
      	$("#check").html("密码请输入6-15位字母和数字");
      }else{
      	$("#check").html("");
      }
    }
    
    function checkjob(){
    	var zz=/^[\u2E80-\u9FFF]+$/;
    	var content=$("#job").val();
      if(!zz.test(content)&&!content==""){
      	$("#check").html("工作请输入中文");
      }else{
      	$("#check").html("");
      }
    }
    
    function checkEmail(){
    	var zz=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    	var content=$("#mail").val();
      if(!zz.test(content)&&!content==""){
      	$("#check").html("邮箱格式错误");
      }else{
      	$("#check").html("");
      }
    }
    
  </script>
</html>
