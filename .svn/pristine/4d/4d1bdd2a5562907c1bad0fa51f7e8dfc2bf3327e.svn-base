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
					<a href="jsp/index.jsp">
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
            <div class="form-title">
<div class="form-title">
<h4>续约企业租赁合同:</h4>
</div>

<div class="form-body">

				<form action="updatepage.do" method="post" name="channelform"  onsubmit="return validate_channel_info(this);">
					<div class="form-group">

						<div class="form-group">
							<label for="number"> 原合同编号：</label> <input type="text"
								readonly="readonly" class="form-control" id="oldnumber"
								name="oldnumber" placeholder="oldnumber"
								value="<%=session.getAttribute("oldnum")%>">
						</div>

						<div class="form-group">
							<label for="number"> 新合同编号：</label> <input type="text"
								readonly="readonly" class="form-control" id="newnumber"
								name="newnumber" placeholder="newnumber"
								value="<%=session.getAttribute("num")%>">
						</div>


						<label for="contacts">修改企业联系人：</label> <input type="text"
							class="form-control" name="contacts" id="contacts" placeholder="如：张三" onfocus="contactsonfocu()" onblur="contactsonblus()">
							<font color=red><span id="contaerror"></font>
					</div>

					<div class="form-group">
						<label for="phone"> 修改联系人电话：</label> <input type="text"
							class="form-control" id="phone" name="phone" placeholder="如：13809978767" onfocus="phoneonfocu()" onblur="phoneonblus()">
							<font color=red><span id="phoneerror"></font>
					</div>
					
                    <div class="form-group">
					<label for="starttime"> 合约生效日期：</label> 
					<input readOnly="true" style="height:30px;width:200px" class="Wdate" type="text"
						id="startDate" name="startDate"
						onclick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}'});" onfocus="startDateonfocu()" onblur="startDateonblus()" />
						<font color=red><span id="startDateerror"></font>
					</div>
						
						<div class="form-group">
						<label
						for="endtime"> 合约截止日期：</label> <input readOnly="true"
						style="height:30px;width:200px" class="Wdate" type="text"
						id="endDate" name="endDate"
						onclick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}'});" onfocus="endDateonfocu()" onblur="endDateonblus()"/>
						<font color=red><span id="endDateerror"></font>
						</div>
					<br />
					<br /> 
					<br />

					<button type="submit" class="btn btn-default">提交</button>
				</form>
			</div>

 <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
 
 <script type="text/javascript">
 
 function validate_channel_info(channelform)
					{
						
						if(contacts.value=="" || contacts.value==null)
						{
							alert("联系人姓名不能为空");
							return false;
						}
						if(phone.value=="" || phone.value==null)
						{
							alert("联系电话不能为空");
							return false;
						}
						
						if(startDate.value=="" || startDate.value==null)
						{
							alert("合同生效日期不能为空");
							return false;
						}
						if(endDate.value=="" || endDate.value==null)
						{
							alert("合同截止日期不能为空");
							return false;
						}
						
					
						return true;
					} 
					
					//验证联系人姓名
	function contactsonblus(){ 
      var contacts=document.getElementById("contacts"); 
      var re = /^[a-zA-Z_]{6,18}$/; 
      if(contacts.value==""){ 
           document.getElementById('contaerror').innerText="请输入联系人名称"; 
       } 
      else if(contacts.value.length<1 ||contacts.value.length>18){ 
                 console.log(contacts.value); 
                 document.getElementById('contaerror').innerText="格式错误,长度应为1-18个字符"; 
       } 
      else { 
            document.getElementById('contaerror').innerText =""; 
           } 
      } 

function contactsonfocu(){ 
document.getElementById('contaerror').innerText =""; 
}

//验证联系电话
	function phoneonblus(){ 
      var phone=document.getElementById("phone"); 
     var re = /^\d{4,20}$/;
      if(phone.value==""){ 
           document.getElementById('phoneerror').innerText="请输入联系电话"; 
       } 
      else if(!re.test($("#phone").val())){
				document.getElementById('phoneerror').innerText="电话格式输入错误,位4到20位数字";
				}
      else { 
            document.getElementById('phoneerror').innerText =""; 
           } 
      } 

function phoneonfocu(){ 
document.getElementById('phoneerror').innerText =""; 
}



//验证合同生效时间
	function startDateonblus(){ 
      var startDate=document.getElementById("startDate"); 
      if(startDate.value==""){ 
           document.getElementById('startDateerror').innerText="请选择合同生效日期"; 
       } 
     
      else { 
            document.getElementById('startDateerror').innerText =""; 
           } 
      } 

function startDateonfocu(){ 
document.getElementById('startDateerror').innerText =""; 
}

//验证合同截止时间
	function endDateonblus(){ 
      var endDate=document.getElementById("endDate"); 
      if(endDate.value==""){ 
           document.getElementById('endDateerror').innerText="请选择合同截止日期"; 
       } 
     
      else { 
            document.getElementById('endDateerror').innerText =""; 
           } 
      } 

function startDateonfocu(){ 
document.getElementById('endDateerror').innerText =""; 
}
 
 
 
 </script>








		</div>
		<!--footer-->
		
        <!--//footer-->
	</div>
	<!-- Classie -->
		<script src="js/classie.js"></script>
		<script>
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
		</script>
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.js"> </script>
</body>
</html>