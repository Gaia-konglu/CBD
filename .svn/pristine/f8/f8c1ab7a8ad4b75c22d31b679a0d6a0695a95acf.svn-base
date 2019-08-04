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
<!-- <link href='http://fonts.useso.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
 --><!--//webfonts--> 
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
<script type="text/javascript" src="js/jsAddress.js"></script>
<style type="text/css">
.selects {
	width: 200px;
	height: 35px;
	border-radius: 5px; 
	box-shadow : 0 0 5px #ccc;
	position: relative;
	float:left;
}
</style>
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
			 <div>
			<input id="condition" type="text" class="form-control"  placeholder="地址信息" style="width:500px;float:left;"> 
             <div class="selects"> 
             <select  id="status"  class="form-control" >
             <option value="已出租">已出租</option>
             <option value="未出租">未出租</option>
             </select></div>
			<button type="submit" class="btn btn-default" onclick="selectByCondition(1)">查询</button>
			</div>
			
			<div class="bs-example widget-shadow"  style="clear:both;"
				data-example-id="bordered-table">
				<h4 style="font-size: 30px;">车位信息:</h4>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th><input type="checkbox" id="select"/></th>
							<th>地址</th>
							<th>编号</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="carports">
						<tr>
							<th scope="row">1</th>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
						</tr>
						
					</tbody>
				</table>
				<button id="manyDelete"  style="margin-top:0px;">删除选中车位</button>
			</div>

    <br>
    <span>当前第<span id="nowpage"></span>页，共<span id="totalpage"></span>页。</span>
   <!-- 填充上一页和下一页 -->
    <span id="changepage"></span>
    <script type="text/javascript">
    
    function showAllCarport(page){
    
    var p=parseInt($("#totalpage").html());    
    if(page>p){
    
    page=p;
    
    }
 
    if(page<1){
    page=1;
    }    
    
    
    
    $.ajax({
       url:"/CBDParkingManagementSystem/showAllCarport.do",
		type:"post",
		data:{
		pageNow:page
		},
		dataType:"json",
		success:function(data){
		
		var cplist=data.cblist;
		var pb=data.pb;
		
		var content="";
		
		for(var i=0;i<cplist.length;i++){
		
		   var carport=cplist[i];
		   content+="<tr>"
		   +"<th scope='row'>"+"<input type='checkbox' name='vehicle' value='"+carport.id+"'/>"+"</th>"
		   +"<td>"+carport.adress+"</td>"
		   +"<td>"+carport.carNum+"</td>"
		    +"<td>"+carport.status+"</td>"
		     +"<td><button onclick=updateCarport('"+carport.adress+"','"+carport.id+"','"+carport.carNum+"')>修改</button></td>"
		   +"</tr>";
		}
		$("#carports").html(content);
		$("#totalpage").html(pb.totalPageCount);
		$("#nowpage").html(pb.pageNow)
	    var nowpage=parseInt(pb.pageNow);
	
	var content2="<a class='btn btn-default' href='javascript:showAllCarport(1)'>首页</a>"	
	+"<a class='btn btn-default' href='javascript:showAllCarport("+(nowpage-1)+")'>上一页</a><a class='btn btn-default' href='javascript:showAllCarport("+(nowpage+1)+")'>下一页</a>"
	+"<a class='btn btn-default' href='javascript:showAllCarport("+pb.totalPageCount+")'>尾页</a>";	
		$("#changepage").html(content2);
		
		}    
    });
    }
    
    
    showAllCarport(1);
    
    
    
    	function selectByCondition(page) {
    		var p = parseInt($("#totalpage").html());
    		if (page > p) {
    
    			page = p;
    
    		}
    
    		if (page < 1) {
    			page = 1;
    		}
    
  
	var a= $("#status").val();
	var b= $("#condition").val();
	
   
    
    		$.ajax({
    			url : "/CBDParkingManagementSystem/selectCarportByCondition.do",
    			type : "post",
    			data : {
    				pageNow : page,
    				adress:b,
    				status:a
    			},
    			dataType : "json",
    			success : function(data) {
    
    				var cplist = data.cblist;
    				var pb = data.pb;
    
    				var content = "";
    
    				for (var i = 0; i < cplist.length; i++) {
    
    					var carport = cplist[i];
    					content += "<tr>"
    						+ "<th scope='row'>" + "<input type='checkbox' name='vehicle' value='"+carport.id+"'/>" + "</th>"
    						+ "<td>" + carport.adress + "</td>"
    						+ "<td>" + carport.carNum + "</td>"
    						+ "<td>" + carport.status + "</td>"
    						  +"<td><button onclick=updateCarport('"+carport.adress+"','"+carport.id+"','"+carport.carNum+"')>修改</button></td>"
    						+ "</tr>";
    				}
    				$("#carports").html(content);
    				$("#totalpage").html(pb.totalPageCount);
    				$("#nowpage").html(pb.pageNow)
    				var nowpage = parseInt(pb.pageNow);
    
    				var content2 = "<a href='javascript:selectByCondition(" + (nowpage - 1) + ")'>上一页</a><a href='javascript:selectByCondition(" + (nowpage + 1) + ")'>下一页</a>";
    				$("#changepage").html(content2);
    
    			}
    		});
    
    	}
    	
    	
    	
    	function updateCarport(address,id,carnum){
    	
    	window.location.href="./jsp/updatecarport.jsp?address="+address+"&number="+carnum+"&id="+id;
    	
    	}
    	
    	
    	
    	 //复选框全选与不全选
		         $(function(){
                 $("#select").click(function(){
                    //当id为select的标签被点击的时候，获取tbody下面所有的复选框并将其选中状态设置跟编码的前端 复选框保持一致。
                    //attr方法与JQ的版本有关，在1.8.3及以下有效。
                    $("tbody input").prop("checked",this.checked);
                	});
            	});
            	
            	<!--获取选中复选框的值-->
				$(document).ready(function(){
				//当id为manyDelete的标签被点击的时候，属性name='vehicle'的复选框为选中状态，则将其值放入数组
				   $('#manyDelete').click(function(){
				   checkID = [];//定义一个空数组
				        $("input[name='vehicle']:checked").each(function(i){//把所有被选中的复选框的值存入数组
				            checkID[i] =$(this).val();
				        }); 
				       
                       if(checkID.length==0){
                       	alert('你还没有选择任何车位！'); 
                               return;
                      }
	
	                  deletecarport(checkID);
				    })
				});
				
				function deletecarport(checkID){
				
				$.ajax({
    			url : "/CBDParkingManagementSystem/deletecarport.do",
    			type : "post",
    			data : {
    				carportId:checkID
    			},
    			traditional: true,
    			
    			success : function(data) {
    			
    			alert("删除成功");
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