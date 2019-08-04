<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>Home</title>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
 <!-- js-->
 <script type="text/javascript" src="../scripts/jquery/jquery-1.7.1.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<!--webfonts-->
<!-- <link href='http://fonts.useso.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'> -->
<!--//webfonts--> 
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- chart -->
<script src="js/Chart.js"></script>
<!-- //chart -->
<!--Calender-->
<!--<link rel="stylesheet" href="css/clndr.css" type="text/css" />-->
<script src="js/underscore-min.js" type="text/javascript"></script>
<script src= "js/moment-2.2.1.js" type="text/javascript"></script>
<!--<script src="js/clndr.js" type="text/javascript"></script>-->
<script src="js/site.js" type="text/javascript"></script>
<!--End Calender-->
<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
<style>
		.big_div{
			/* border:1px solid red; */
			width:282px;
			height:500px;
		}
		.big_div div{
			/* border:1px solid black; */
			width:280px;
			height:25px;
			float:left;
		}
		.big_div input{
			height:22px;
		}
		.info{
			color:red;
			font-size:13px;
		}
		thead{
			height:20px;
			width:1059px;
			background-color:#4951B3;
			color:white;
			line-height:20px;
		}
		.table{
			width:1059px;
		}
		/* th{
			border:1px dashed black;
		}
		td{
			border:1px dashed black;
		} */
		/* a{
			text-decoration:none;
			color:red;
			font-size:25px;
		} */
	</style>
</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
						<li>
							<a href="./jsp/index.jsp" class="active"><i class="fa fa-home nav_icon"></i>首页</a>
						</li>
						 <shiro:hasPermission name="userMP">
						<li>
							<a href="#"><i class="fa fa-cogs nav_icon"></i>个人信息管理模块 <span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="/CBDParkingManagementSystem/jsp/BackgroundAlter.jsp">修改个人信息</a>
								</li>
							
							</ul>
							<!-- /nav-second-level -->
						</li>
						</shiro:hasPermission>
						<shiro:hasPermission name="adminMP">
						<li>
							<a href="#"><i class="fa fa-book nav_icon"></i>操作权限管理 <span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="jsp/addBackStage.jsp">添加后台管理员</a>
								</li>
								<li>
									<a href="jsp/showAllBackStage2.jsp">查看后台管理员</a>
								</li>
							</ul>
							<!-- /nav-second-level -->
						</li>
                         </shiro:hasPermission>
                         <shiro:hasPermission name="userMP">
						<li>
							<a href="#"><i class="fa fa-envelope nav_icon"></i>企业用户管理<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="jsp/companyFuzzyQueryList.jsp">企业查询、删除、信息修改</a>
								</li>
								<li>
									<a href="jsp/companyAdd.jsp">企业用户新增</a>
								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
 </shiro:hasPermission>
  <shiro:hasPermission name="userMP">
						<li>
							<a href="#"><i class="fa fa-check-square-o nav_icon"></i>包租婆管理<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="/CBDParkingManagementSystem/jsp/findAll.jsp">查看包租婆所有车位信息 </a>
								</li>
								<li>
									<a href="/CBDParkingManagementSystem/jsp/WaitApprove.jsp">包租婆车位审核</a>
								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
						 </shiro:hasPermission>
						 <shiro:hasPermission name="contractMP">
						<li>
							<a href="#"><i class="fa fa-file-text-o nav_icon"></i>外部合约管理<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="/CBDParkingManagementSystem/newthirdcontractnumber.do">新增外部合约</a>
								</li>
								<li>
									<a href="/CBDParkingManagementSystem/jsp/ThirdParkContarct.jsp">续约外部合约</a>
								</li>
								<li>
									<a href="/CBDParkingManagementSystem/jsp/terminatethirdcontract.jsp">解除外部合约</a>
								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
                          </shiro:hasPermission>
<shiro:hasPermission name="contractMP">
						<li>
							<a href="#"><i class="fa fa-file-text-o nav_icon"></i>租户合约管理<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="/CBDParkingManagementSystem/newcontractnumber.do">租户签约</a>
								</li>
								<li>
									<a href="/CBDParkingManagementSystem/jsp/Contract.jsp">租户续约</a>
								</li>
								<li>
									<a href="/CBDParkingManagementSystem/jsp/terminatecompanyContract.jsp">租户解约</a>
								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
  </shiro:hasPermission>

 <shiro:hasPermission name="complainMP">
						<li>
							<a href="#"><i class="fa fa-file-text-o nav_icon"></i>投诉管理<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>
									<a href="javascript:showComplain(1)">查看未受理投诉</a>
								</li>
								<li>
									<a href="javascript:waitHandle(1)">查看暂缓处理投诉</a>
								</li>

							</ul>
							<!-- //nav-second-level -->
						</li>
						</shiro:hasPermission>
 <shiro:hasPermission name="carportMP">
						<li>
							<a href="#"><i class="fa fa-file-text-o nav_icon"></i>车位管理<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								
								<li>
									<a href="jsp/showcarport2.jsp">查看车位信息</a>
								</li>
							  
								<li>
									<a href="jsp/addcarport2.jsp">添加车位信息</a>
								</li>
								<li>
									<a href="jsp/addManyCarport2.jsp">批量添加车位信息</a>
								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
 </shiro:hasPermission>
                        <li>
							<a href="#"><i class="fa fa-file-text-o nav_icon"></i>查看日志<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level collapse">
								<li>   
									<a href="/CBDParkingManagementSystem/jsp/OperationLog.jsp">查看后台操作日志</a>
								</li>   
								<li>
									<a href="jsp/RegisterLog.jsp">查看后台登陆日志</a>
								</li>
								<li>
									<a href="111.do">查看性能统计</a>
								</li>
							</ul>
							<!-- //nav-second-level -->
						</li>
						
					</ul>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<!--logo -->
				<div class="logo">
					<a href="index.html">
						<h1>CBD停车管理平台</h1>
						<span>后台管理系统</span>
					</a>
				</div>
				<!--//logo-->
				<!--search-box-->
				
			</div>
				<!--notification menu end -->
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
									<div class="user-name">
										工号:
										<span>${sessionScope.backStageBean.num}</span>
									</div>
									<i class="fa fa-angle-down lnr"></i>
									<i class="fa fa-angle-up lnr"></i>
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu">
								<li> <a href="/CBDParkingManagementSystem/backclose.do"><i class="fa fa-sign-out"></i>注销</a> </li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>				
			</div>
			<div class="clearfix"> </div>	
		</div>
		
		
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<!-- 内容填充 -->
		
	<h4  style="font-size:25px;margin-bottom:15px">***新增企业***</h4>
						<table class="table table-hover"> 
						<thead> 
							<tr> 
								<th>No.</th> 
								<th>新增企业的基本项目</th> 
								<th>录入新增的企业信息</th> 
								<th>系统提示</th> 
							</tr> 
						</thead> 
						<!-- <form action="companyAdd.do" method="post"> -->
							<tbody> 
								<tr> 
									<th scope="row">1</th> 
									<td>企业登录账号：</td> 
									<td><input type="text" id="admin" oninput="checkuse()"/></td> 
									<td><div id="admin_info" class="info">* 登录账号为11位手机号同时要符合规范</div></td> 
								</tr> 
								<tr> 
									<th scope="row">2</th> 
									<td>企业登录密码：</td> 
									<td><input type="password" id="pass" oninput="checkpwd()"/></td> 
									<td><div id="pass_info" class="info">* 密码6-18位（且至少一个字母和一个数字）</div></td> 
								</tr> 
								<tr> 
									<th scope="row">3</th> 
									<td>确认登录密码：</td> 
									<td><input type="password" id="rePass" oninput="checkpwdc()"/></td> 
									<td><div id="rePass_info" class="info">* 2次输入的密码必须一致</div></td> 
								</tr> 
								<tr> 
									<th scope="row">4</th> 
									<td>填写企业名称：</td> 
									<td><input type="text" id="name" oninput="checkname()"/></td> 
									<td><div id="name_info" class="info">* 企业名称不为空值</div></td> 
								</tr> 
								<tr> 
									<th scope="row">5</th> 
									<td>企业楼层位置：</td> 
									<td><input type="text" id="addr" oninput="checkaddr()"/></td> 
									<td><div id="addr_info" class="info">* 企业楼层不为空值</div></td> 
								</tr> 
								<tr> 
									<th scope="row">6</th> 
									<td>企业联系姓名：</td> 
									<td><input type="text" id="contacts" oninput="checkcontacts()"/></td> 
									<td><div id="contacts_info" class="info">* 企业联系人为2~4个汉字</div></td> 
								</tr> 
								<tr> 
									<th scope="row">7</th> 
									<td>企业联系电话：</td> 
									<td><input type="text" id="phone" oninput="checkphone()"/></td> 
									<td><div id="phone_info" class="info">* 手机号必须11位同时要符合规范</div></td> 
								</tr> 
								<tr> 
									<th scope="row"></th> 
									<td></td> 
									<td><button id="addCompanyButton" style="color:#4450AC;" type="submit" onclick="isAdd()">点击新增</button></td> 
									<td><div id="ifSuccessShowConfirm" class="info" style="color:#1003F9">${requestScope.map.success1}</div></td> 
								</tr> 
							</tbody>
						<!-- </form> -->
						</table>
					</div>
					<div class="bs-example widget-shadow" data-example-id="contextual-table">

		</div>
		<!--footer-->
		
        <!--//footer-->
	</div>
	<!-- Classie -->
		<script src="js/classie.js"></script>
		<script>
			function companyAdd(){
				$.ajax({
					url:"/CBDParkingManagementSystem/companyAdd.do",
					type:"post",
					data:{
						admin:$("#admin").val(),
						pass:$("#pass").val(),
						rePass:$("#rePass").val(),
						name:$("#name").val(),
						addr:$("#addr").val(),
						contacts:$("#contacts").val(),
						phone:$("#phone").val(),
					},
					dataType:"json",
					success:function(data){
						/* alert(data.admin1); */
						$("#admin").val(data.companyBean.admin);
						$("#pass").val(data.companyBean.pass);
						$("#rePass").val(data.companyBean.rePass);
						$("#name").val(data.companyBean.name);
						$("#addr").val(data.companyBean.addr);
						$("#contacts").val(data.companyBean.contacts);
						$("#phone").val(data.companyBean.phone);
						
						//if((data.admin1+data.admin2)!=''){
							$("#admin_info").html(data.admin1+data.admin2);
							$("#admin_info").css("color","red");
						//}
						//if(data.pass1!=''){
							$("#pass_info").html(data.pass1);
							$("#pass_info").css("color","red");
						//}
						//if(data.rePass1!=''){
						$("#rePass_info").html(data.rePass1);
						$("#rePass_info").css("color","red");
						//}
						//if(data.name1+data.name2!=''){
						$("#name_info").html(data.name1+data.name2);
						$("#name_info").css("color","red");
						//}
						//if(data.addr1!=''){
						$("#addr_info").html(data.addr1);
						$("#addr_info").css("color","red");
						//}
						//if(data.contacts1!=''){
						$("#contacts_info").html(data.contacts1);
						$("#contacts_info").css("color","red");
						//}
						//if(data.phone1!=''){
						$("#phone_info").html(data.phone1);
						$("#phone_info").css("color","red");
						//}
						
						if(data.success1=='新增企业成功,您可以前往查询模块进行查询'){
							alert(data.success1);
							window.location.reload();
						}
						
					}
				});
			}
			function isAdd(){
			if(a==1 && b==1 && c==1 && d==1 && e==1 && f==1 && g==1){
				var msg = '进行企业新增？ \n\n 请确认！';
					 if(confirm(msg)==true){
					 	companyAdd();
					 }
				}else{
					alert("上述格式全部正确后，才可新增！");
				}
			}
			
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			

			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
			
			//前端校验
			//及时验证用户名
			var check; 
	        var a = 0;
	        var b = 0;
	        var c = 0;
	        var d = 0;
	        var e = 0;
	        var f = 0;
	        var g = 0;
		    function checkuse(){
		         //在每个函数中定义check变量是为了在表单提交后，逐个验证每个函数是否通过
		         var check;  
		         var username = document.getElementById("admin").value;  
		         var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
		         if (!reg.test(username)) { 
		         	$("#admin_info").css("color","red");
		         	$("#admin_info").html("* 登录账号为11位手机号同时要符合规范");
		         	a = 0;
		           } else {  
		             /*  document.getElementById("admin_info").innerHTML = "* 用户名6~18  √"; */
		               $("#admin_info").css("color","green");    
		              a = 1;  
		           }  
		            return check;  
		        }
		        
		    //利用正则表达式判断密码符合否
    function checkpwd() {  
       
        var regs = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,18}$/;
        var pass = document.getElementById("pass").value;  
        if (!regs.test(pass) || pass==null || pass=="" ) {  
        $("#pass_info").css("color","red");
        $("#pass_info").html("* 密码6-18位（且至少一个字母和一个数字）");
        b = 0; 
        } else {  
            /* document.getElementById("pass_info").innerHTML = "* 密码6~18（且至少一个字母和一个数字）  √";   */
            $("#pass_info").css("color","green");  
            b = 1;  
        }  
        return check;  
    }  
    //验证密码是否不一致！
    function checkpwdc() {  
        var check;  
        var pass = document.getElementById("pass").value;  
        var rePass = document.getElementById("rePass").value;  
        if (pass != rePass  || rePass==null || rePass=="") {  
        $("#rePass_info").css("color","red");
        $("#rePass_info").html("* 2次输入的密码必须一致");
        c = 0;
        } else {  
            /* document.getElementById("rePass_info").innerHTML = "* 2次输入的密码一致  √";  */
            $("#rePass_info").css("color","green");  
            c = 1;  
        }  
        return check;  
    }  
    
       
    
    
    //及时验证企业名称
	    function checkname(){
	         //在每个函数中定义check变量是为了在表单提交后，逐个验证每个函数是否通过
	         var check;  
	         var name = document.getElementById("name").value;  
	         if (name.trim().length < 1 || name==null || name=="") {   
	         $("#name_info").css("color","red");
	         $("#name_info").html("* 企业名称不为空值");
	         d = 0;  
	           } else {  
	              /* document.getElementById("name_info").innerHTML = "* 企业名称不为空值  √"; */
	               $("#name_info").css("color","green");    
	              d = 1;  
	           }  
	            return check;  
	        }
	        //及时验证企业楼层
	    function checkaddr(){
	         //在每个函数中定义check变量是为了在表单提交后，逐个验证每个函数是否通过
	         var check;  
	         var addr = document.getElementById("addr").value;  
	         if (addr.trim().length < 1 || addr==null || addr=="") {  
	         $("#addr_info").css("color","red");
	         $("#addr_info").html("* 企业楼层不为空值");
	           } else {  
	              /* document.getElementById("addr_info").innerHTML = "* 企业楼层不为空值  √"; */
	               $("#addr_info").css("color","green");    
	              e = 1;  
	           }  
	            return check;  
	        }
	    //及时验证企业联系人
	    function checkcontacts(){
	         //在每个函数中定义check变量是为了在表单提交后，逐个验证每个函数是否通过
	         var check;  
	         var contacts = document.getElementById("contacts").value;  
	         var reg = /^[\u4E00-\u9FA5]{2,4}$/;
	         if (!reg.test(contacts) || contacts==null|| contacts=="") {  
	         $("#contacts_info").css("color","red");
	         $("#contacts_info").html("* 企业联系人为2~4个汉字");
	           } else {  
	              /* document.getElementById("contacts_info").innerHTML = "* 企业联系人为2~4个汉字  √"; */
	               $("#contacts_info").css("color","green");    
	              f = 1;  
	           }  
	            return check;  
	        }
	        //及时验证企业联系电话
	    function checkphone(){
	         //在每个函数中定义check变量是为了在表单提交后，逐个验证每个函数是否通过
	         var check;  
	         var phone = document.getElementById("phone").value;  
	         var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
	         if (!reg.test(phone)) { 
	         $("#phone_info").css("color","red"); 
	         $("#phone_info").html("* 手机号必须11位同时要符合规范"); 
	         g = 0;  
	           } else {  
	             /*  document.getElementById("phone_info").innerHTML = "* 企业联系手机号格式正确  √"; */
	               $("#phone_info").css("color","green");    
	              g = 1;  
	           }  
	            return check;  
	        }
	        
	         function showComplain(page){
     $.ajax({
         url:"/CBDParkingManagementSystem/showComplain.do",
           type:"post",
           data:{
           pageNow:page,
           },
           success:function(data){
               if(data=="success"){
                    window.location.href='/CBDParkingManagementSystem/jsp/ShowAllComplain.jsp';
                  }
           }
     })
   }
   
   function waitHandle(page){
      $.ajax({
           url:"/CBDParkingManagementSystem/waitHandle.do",
           type:"post",
           data:{
              pageNow:page,
           },
              
              success:function(data){
                  if(data=="success"){
                    window.location.href='/CBDParkingManagementSystem/jsp/ShowAllComplain.jsp';
                  }
              }
          });
       
   }
		</script>
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.js"> </script>
</body>
</html>