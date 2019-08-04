<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

  
 
  <label>被投诉人：</label><input id="name2" type="text" name="name2"><input type="button" value="查询" onclick="findBycper(${sessionScope.pageNow})"></br>
     <c:choose>
      <c:when test="${sessionScope.uc !=0}">
    <%--  <table border=1>
       <thead>
          <tr>
             <th>投诉方</th>
             <th>被投诉方</th>
             <th>投诉时间</th>
             <th>操作</th>
          </tr>
       </thead>
       <tbody>
          <c:forEach items="${sessionScope.showComplain}" var="obj">
         <tr>
           <td>${obj.person.name }</td>
          <td>${obj.person2.name }</td> 
          <td>
          
          <fmt:formatDate value="${obj.complainTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
          </td>
           <td><input type="button" value="处理" onclick="handle(${obj.id})"></td> 
          </tr>
         </c:forEach>  
       </tbody>
    </table> --%>
    <div class="bs-example widget-shadow" data-example-id="hoverable-table"> 
			<h4>投诉信息</h4>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>投诉方</th>
									<th>被投诉方</th>
									<th>投诉时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${sessionScope.showComplain}" var="obj">
									<tr>
										<td>${obj.person.name }</td>
										<td>${obj.person2.name }</td>
										<td><fmt:formatDate value="${obj.complainTime}"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td><input type="button" value="处理"
											onclick="handle(${obj.id})"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
   
      <c:choose>
     <c:when test="${sessionScope.showStatus =='暂缓处理'}">
     <input type="button" value="首页" onclick="showComplain(1)">
     <input type="button" onclick="prePage1(${sessionScope.pageNow},${sessionScope.untreateCount})" value="上一页">
     <label>${sessionScope.pageNow}</label><label>/${sessionScope.untreateCount}</label>
    <input type="button" onclick="nextPage1(${sessionScope.pageNow},${sessionScope.untreateCount})" value="下一页">
    <input type="button" value="尾页" onclick="showComplain(${sessionScope.untreateCount})">
    <select id="good">
     <c:forEach var="i" begin="1" end="${sessionScope.untreateCount}" step="1">
      <option>${i}</option>
      </c:forEach>
     </select>
     <input type="button" value="跳转" onclick="skipWaitHandle()">
    </c:when>
    
     <c:when test="${sessionScope.showStatus =='投诉生效'}">
       <input type="button" value="首页" onclick="showComplain2(1,'${sessionScope.dfna11}')">
     <input type="button" onclick="prePage2(${sessionScope.pageNow},${sessionScope.untreateCount})" value="上一页">
     <label>${sessionScope.pageNow}</label><label>/${sessionScope.untreateCount}</label>
    <input type="button" onclick="nextPage2(${sessionScope.pageNow},${sessionScope.untreateCount})" value="下一页">
    <input type="button" value="尾页" onclick="showComplain2(${sessionScope.untreateCount},'${sessionScope.dfna11}')">
    <select id="good">
     <c:forEach var="i" begin="1" end="${sessionScope.untreateCount}" step="1">
      <option>${i}</option>
      </c:forEach>
     </select>
     <input type="button" value="跳转" onclick="skipHandle()">
    </c:when>
    
    
    <c:otherwise>
    <input type="button" value="首页" onclick="showComplain(1)">
    <input type="button" onclick="prePage(${sessionScope.pageNow},${sessionScope.untreateCount})" value="上一页">
     <label>${sessionScope.pageNow}</label><label>/${sessionScope.untreateCount}</label>
    <input type="button" onclick="nextPage(${sessionScope.pageNow},${sessionScope.untreateCount})" value="下一页">
     <input type="button" value="尾页" onclick="showComplain(${sessionScope.untreateCount})">
     <select id="good">
     <c:forEach var="i" begin="1" end="${sessionScope.untreateCount}" step="1">
      <option>${i}</option>
      </c:forEach>
     </select>
     <input type="button" value="跳转" onclick="skipNoHandle()">
   </c:otherwise>
   </c:choose>
    </c:when>
      <c:otherwise>
         <label style="color: red;font-size: 30px;">没有投诉数据</label></br>
      </c:otherwise>
    </c:choose>
     
    <!-- <form action="waitHandle.do" method="post">
    <input type="submit" value="暂缓处理部分">
    </form>
    <form action="showComplain.do" method="post">
    <input type="submit" value="未处理部分">
    </form> -->
    </br>
    <!-- <input type="button" value="暂缓处理部分" onclick="waitHandle(1)">
    <input type="button" value="未处理部分" onclick="noHandle(1)"></br> -->
     <label id="arr"  style="color: red;font-size: 30px;"></label>
     
   <script type="text/javascript">
   
   /* function noHandle(page){
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
          });
       
   } */
   
/*    function waitHandle(page){
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
       
   } */
   function skipNoHandle(){
    showComplain($('#good option:selected').val());
   }
   
    function skipHandle(){
    showComplain2($('#good option:selected').val(),'<%=session.getAttribute("dfna11")%>');
   }
    function skipWaitHandle(){
    showComplain1($('#good option:selected').val());
   }
       function handle(id){
          $.ajax({
           url:"/CBDParkingManagementSystem/showCom.do",
           type:"post",
           data:{
              id:id,
           },
              
              success:function(data){
                  if(data=="success"){
                    window.location.href='/CBDParkingManagementSystem/jsp/HandleComplain.jsp';
                  }
              }
          });
       }
       
        function findBycper(page){
          $.ajax({
           url:"/CBDParkingManagementSystem/findcperComplain.do",
           type:"post",
           data:{
              pageNow:page,
               name2:$("#name2").val(),
           },
              
              success:function(data){
                  if(data=="success"){
                     window.location.href='/CBDParkingManagementSystem/jsp/ShowAllComplain.jsp';
                  }else if(data=="loser"){
                     $("#arr").html("数据不存在");
                     
                  }
              }
          });
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
       
       function nextPage(oldPageNow,untreateCount){
       
          if(oldPageNow<untreateCount){
             var pageNow=oldPageNow+1;
             showComplain(pageNow);
          }else{
              showComplain(untreateCount);
          }
       }
       
        function prePage(oldPageNow,untreateCount){
          if(oldPageNow>1){
             var pageNow=oldPageNow-1;
             showComplain(pageNow);
          }else{
              showComplain(1);
          }
       }
        function nextPage1(oldPageNow,untreateCount){
        
          if(oldPageNow<untreateCount){
             var pageNow=oldPageNow+1;
             showComplain1(pageNow);
          }else{
              showComplain1(untreateCount);
          }
       }
       
        function prePage1(oldPageNow,untreateCount){
        
          if(oldPageNow>1){
             var pageNow=oldPageNow-1;
             showComplain1(pageNow);
          }else{
              showComplain1(1);
          }
       }
       function nextPage2(oldPageNow,untreateCount){
        
          if(oldPageNow<untreateCount){
             var pageNow=oldPageNow+1;
             showComplain2(pageNow,'<%=session.getAttribute("dfna11")%>');
          }else{
              showComplain2(untreateCount,'<%=session.getAttribute("dfna11")%>');
          }
       }
       function prePage2(oldPageNow,untreateCount){
        
          if(oldPageNow>1){
             var pageNow=oldPageNow-1;
             showComplain2(pageNow,'<%=session.getAttribute("dfna11")%>');
          }else{
              showComplain2(1,'<%=session.getAttribute("dfna11")%>');
          }
       }
       
        function showComplain1(page){
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
     })
   }
    function showComplain2(page,name2){
     $.ajax({
         url:"/CBDParkingManagementSystem/findcperComplain.do",
           type:"post",
           data:{
           pageNow:page,
           name2:name2
           },
           success:function(data){
               if(data=="success"){
                    window.location.href='/CBDParkingManagementSystem/jsp/ShowAllComplain.jsp';
                  }
           }
     })
   }
        
    </script> 
  </body>
</html>











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










<%-- <%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 --%>