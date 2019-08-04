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
					<a href="/CBDParkingManagementSystem/jsp/index.jsp">
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
			
		根据条件查询：
 
 工号： <input type="text" name="num" id="inum">
  姓名：<input type="text" name="name" id="iname">
  <input type="submit" value="查询" onclick="findBycondition(1)">
  
  
  <div class="bs-example widget-shadow" data-example-id="bordered-table"> 
						<h4>后台管理员表:</h4>
				<table class="table table-bordered">
					<thead>
						<tr>
							
							<th>工号</th>
							
							<th>姓名</th>
							<th>电话</th>
							<th>拥有权限</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="backStage">
						
					</tbody>
				</table>
			</div>
  
  
  
  
<!--   <table>
  <thead>
  <tr>
  <td>工号</td>
   <td>密码</td>
    <td>姓名</td>
     <td>电话</td>
     <td>拥有权限</td>
     <td>操作</td>
  </tr>
  </thead>
  <tbody id="backStage">

  </tbody>
  
  </table> -->
  <br>
    <span>当前第<span id="nowpage"></span>页，共<span id="totalpage"></span>页。</span>
   <!-- 填充上一页和下一页 -->
    <span id="changepage"></span>
  
  <script type="text/javascript">
  
  function showback(page){
   var p=parseInt($("#totalpage").html());    
    if(page>p){
    
    page=p;
    
    }
 
    if(page<1){
    page=1;
    }  
  $.ajax({
  url:"findAllback.do",
  type:"post",
  data:{
  pageNow:page
  },
  dataType:"json",
  success:function(data){
  
  var content="";
  var backs=data.bsblist;
  var pb=data.pb;
  for(var i=0;i<backs.length;i++){
   var back=backs[i];
  var userMP="";
  var complainMP="";
  var carMP="";
  var pactMP="";

if(back.user_authority!='0'){
userMP="用户管理权限<br>";
}

if(back.complain_authority!='0'){
complainMP="投诉管理权限<br>";
}
if(back.car_authority!='0'){
carMP="车位管理权限<br>";
}
if(back.pact_authority!='0'){
pactMP="合同管理权限";

}


    
     content+="<tr>"+"<td>"+back.num+"</td>"
     
     +"<td>"+back.name+"</td>"
     +"<td>"+back.phone+"</td>"
     +"<td>"+userMP+complainMP+carMP+pactMP+"</td>"
     +"<td>"+"<button onclick='gotoUpdatePage("+back.id+")'>修改权限</button>"+
     "<br><button onclick='deleteBack("+back.id+")'>删除管理员</button>"+"</td>"
     +"</tr>";
       
  
  }
  $("#backStage").html(content);
  $("#totalpage").html(pb.totalPageCount);
		$("#nowpage").html(pb.pageNow)
	    var nowpage=parseInt(pb.pageNow);
	
	var content2="<a class='btn btn-default' href='javascript:showback("+1+")'>首页</a>"
	+"<a class='btn btn-default' href='javascript:showback("+(nowpage-1)+")'>上一页</a><a class='btn btn-default' href='javascript:showback("+(nowpage+1)+")'>下一页</a>"
		+"<a class='btn btn-default' href='javascript:showback("+pb.totalPageCount+")'>尾页</a>";
		
		
		$("#changepage").html(content2);
  }
  
  
  });
  }
  showback(1);
function  gotoUpdatePage(id){

window.location.href="findBackByid.do?id="+id;
}

function findBycondition(page){
   var p=parseInt($("#totalpage").html());    
    if(page>p){
    
    page=p;
    
    }
 
    if(page<1){
    page=1;
    }  
  $.ajax({
  url:"findBycondition.do",
  type:"post",
  data:{
  pageNow:page,
  num:$("#inum").val(),
  name:$("#iname").val()
  },
  dataType:"json",
  success:function(data){
  
  var content="";
  var backs=data.bsblist;
  var pb=data.pb;
  for(var i=0;i<backs.length;i++){
   var back=backs[i];
  var userMP="";
  var complainMP="";
  var carMP="";
  var pactMP="";

if(back.user_authority!='0'){
userMP="用户管理权限<br>";
}

if(back.complain_authority!='0'){
complainMP="投诉管理权限<br>";
}
if(back.car_authority!='0'){
carMP="车位管理权限<br>";
}
if(back.pact_authority!='0'){
pactMP="合同管理权限";

}


    
     content+="<tr>"+"<td>"+back.num+"</td>"
    
     +"<td>"+back.name+"</td>"
     +"<td>"+back.phone+"</td>"
     +"<td>"+userMP+complainMP+carMP+pactMP+"</td>"
     +"<td>"+"<button onclick='gotoUpdatePage("+back.id+")'>修改权限</button>"
     +  "<br><button onclick='deleteBack("+back.id+")'>删除管理员</button>"+"</td>"
     +"</td>"
     +"</tr>";
       
  
  }
  $("#backStage").html(content);
  $("#totalpage").html(pb.totalPageCount);
		$("#nowpage").html(pb.pageNow)
	    var nowpage=parseInt(pb.pageNow);
	
	var content2="<a href='javascript:showback("+(nowpage-1)+")'>上一页</a><a href='javascript:showback("+(nowpage+1)+")'>下一页</a>";
		$("#changepage").html(content2);
  }
  
  
  
  });
  }
  
  
  function deleteBack(did){
   $.ajax({
  url:"deleteBack.do",
  type:"post",
  data:{
  id:did
  },
  success:function(data){
  
  window.location.reload();
  
  }
  
  });
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