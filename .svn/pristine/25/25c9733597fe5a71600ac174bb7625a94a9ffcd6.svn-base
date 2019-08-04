<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<base href="<%=basePath%>">    
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
	<title>修改信息</title>
	<style type="text/css">
	body,input{
		margin: 0;
		padding: 0;
		/* background: ; */
	}
	input{
		display: inline-block;
		background: #fff;
	}
	.xiao-container{
		width: 100%;
	}
	.xiao-register-box{
		position: relative;
		height: 800px;
		width: 800px;
		top: 50px;
		margin: 0 auto;
		z-index: 99999;
		background:#ffffff;
		border: 7px solid #d3d1db;
	}
	.xiao-title-box{
		position: absolute;
		width: 300px;
		height: 50px;
		margin-left: 250px;
		margin-top: 5px;
		font-size: 28px;
		font-weight: 800;
		color: black;
		line-height: 50px;
		border-bottom:solid 1px #eee;
		background:#fafafa;
	}
	.xiao-username-box{
		position: absolute;
		width: 420px;
		height: 40px;
		line-height: 40px;
		margin-top:100px;
		margin-left:80px;
		font-weight: 700;
	}
	.xiao-username-input{
		display: inline-block;
		margin-left: 45px;
		/*background: green;*/
	}
	#pass{
		height: 35px;
		width: 290px;
		border: 2px solid #ccc;
		border-radius: 5px;
	}
	.xiao-userPassword-box{
		position: absolute;
		width: 420px;
		height: 40px;
		line-height: 40px;
		margin-top:180px;
		margin-left:80px;
		font-weight: 700;
	}
	.xiao-userPassword-input{
		display: inline-block;
		margin-left: 61px;
	}
	#addr{
		height: 35px;
		width: 290px;
		border: 2px solid #ccc;
		border-radius: 5px;
	}
	.xiao-userRePassword-box{
		position: absolute;
		width: 420px;
		height: 40px;
		line-height: 40px;
		margin-top:260px;
		margin-left:80px;
		font-weight: 700;
	}
	.xiao-userRePassword-input{
		display: inline-block;
		margin-left: 28px;
	}
	#job{
		height: 35px;
		width: 290px;
		border: 2px solid #ccc;
		border-radius: 5px;
	}
	.xiao-userPhone-box{
		position: absolute;
		width: 420px;
		height: 40px;
		line-height: 40px;
		margin-top:340px;
		margin-left:80px;
		font-weight: 700;
	}
	.xiao-userPhone-input{
		display: inline-block;
		margin-left: 28px;
	}
	#phone{
		height: 35px;
		width: 290px;
		border: 2px solid #ccc;
		border-radius: 5px;
	}
	.xiao-userEmail-box{
		position: absolute;
		width: 420px;
		height: 40px;
		line-height: 40px;
		margin-top:420px;
		margin-left:80px;
		font-weight: 700;
	}
	.xiao-userEmail-input{
		display: inline-block;
		margin-left: 28px;
	}
	#mail{
		height: 35px;
		width: 290px;
		border: 2px solid #ccc;
		border-radius: 5px;
	}
 
	.xiao-userGender-box{
		position: absolute;
		width: 420px;
		height: 40px;
		line-height: 40px;
		margin-top:500px;
		margin-left:82px;
		font-weight: 700;
	}
	.xiao-userGender-input{
		display: inline-block;
		margin-left: 62px;
	}
	.xiao-require{
		color: red;
	}
	.xiao-submit-box{
		position:absolute;
		width: 80px;
		height: 40px;
		line-height: 40px;
		margin-top: 580px;
		margin-left:200px;
		border-radius: 5px;
		background: grey;
	}
	#xiao-submit-button{
		display: inline-block;
		width: 80px;
		height: 40px;
		border-radius: 5px;
		background: #ffe6b0;
	}
	.xiao-goLogin-box{
		position:absolute;
		width: 150px;
		height: 20px;
		margin-top: 600px;
		margin-left:320px;
 
	}
 
	</style>
</head>
<body>
	<div class="xiao-container">
		<div class="xiao-register-box">
			<div class="xiao-title-box" >
				<span>个人信息修改</span>
			</div>
			<form action="/CBDParkingManagementSystem/updatePerson.do" method="post">
				<div class="xiao-username-box">
					<span class="xiao-require">*</span>
					<label for="userPassword">密码</label>
					<div class="xiao-userPassword-input">
						<input type="text" id="pass" name="password" oninput="checkpass()"/>
					</div>
				</div>
 
				<div class="xiao-userPassword-box">
					<span class="xiao-require">*</span>
					<label for="userPassword">地址</label>
					<div class="xiao-userPassword-input">
						<input type="text" id="addr" name="addr" >
					</div>
				</div>
 
				<div class="xiao-userRePassword-box">
				<span class="xiao-require">*</span>
						<label for="userPassword">职业</label>
					<div class="xiao-userPassword-input">
						<input type="text" id="job" name="job" oninput="checkjob()" >
					</div>
				</div>
 
				<div class="xiao-userPhone-box">
					<span class="xiao-require">*</span>
					<label for="userPhone">手机号码</label>
					<div class="xiao-userPhone-input">
						<input type="text" id="phone" name="phone" oninput="checkphone()" >
					</div>
				</div>
				
				<div class="xiao-userEmail-box">
					<span class="xiao-require">*</span>
					<label for="userEmail">电子邮箱</label>
					<div class="xiao-userEmail-input">
						<input type="text" name="eMail" id="mail" oninput="checkEmail()" >
					</div>
				</div>
				
				
				<div class="xiao-submit-box">
					<input id = "xiao-submit-button" type="submit" value="确认修改">
				</div>
				
			</form>
			<div style="margin-top:650px;font-size:18px;color:red;">
				${requestScope.result}<br>
				<span id="check"></span>
			</div>
		</div>
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