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
<style>
#whole_table{
			/* margin:0 auto; */
			border-spacing:0px;
		}
		#whole_table th{
			border:1px solid black;
			text-align:center;
			padding:10px;
		}
		#whole_table td{
			border:1px solid black;
			text-align:center;
			padding:10px;
		}
		#whole_table input{
			background-color:#F2F1EF;
		}
		#title{
			align:center;
			/* font-size:25px;
			color:red; */
		}
		.delete{
			cursor:pointer;
			color:red;
			margin-top:-15px;
		}
		/* a{
			text-decoration:none;
			color:red;
			font-size:25px;
		} */
		.middle_info input{
			border: 0px;
			/* outline:none; */
			text-align:center;
		}
		.b_1,.b_2,.b_3,.b_4,.edit,.submit{
			margin-top:8px;
		}
		.submit{
			color:#F2F1EF;
		}
		.edit{
			color:#4951B3;
		}
		.middle_info_td_phone{
			width:200px;
		}
		.box{
			position:relative;
			top:-5px;
		}
		#head_search{
			height:35px;
			width:1059px;
			background-color:#4951B3;
			padding-left:10px;
			margin-bottom:10px;
			margin-top:-12px;
			color:white;
			line-height:35px;
		}
		thead{
			height:20px;
			width:1059px;
			background-color:#4951B3;
			color:white;
			line-height:20px;
		}
		.foot_div div{
			float:left;
		}
		#manyDelete{
			margin-right:205px;
			margin-left:30px;
		}
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
		<!-- <a href="jsp/companyBack.jsp">返回后台主界面</a><br/><br/>
  	 <a href="jsp/companyAdd.jsp">前往企业添加模块</a><br/><br/> -->
  	 <span style="font-size:25px;">***模糊查询***</span> <br/><br/>
  	 <!-- <form action="jsp/companyFuzzyQueryList.jsp" method="post"> -->
  	 
  	 <%-- <table>
  	 	<tbody>
	 		<tr>
		 		<td><lable>企业名称：</lable><input id="name" type="text" name="name" value="${companyBean.name}"/></td>
		 		<td><lable>&nbsp&nbsp&nbsp&nbsp楼层位置：</lable><input id="addr" type="text" name="addr" value="${companyBean.addr}"/></td>
		 		<td><lable>&nbsp&nbsp&nbsp&nbsp联系姓名：</lable><input id="contacts" type="text" name="contacts" value="${companyBean.contacts}"/></td>
		 		<td><lable>&nbsp&nbsp&nbsp&nbsp联系电话：</lable><input id="phone" type="text" name="phone" value="${companyBean.phone}"/></td>
	 		</tr>
 		</tbody>
 		<tfoot>
 			<td><button type="submit" onclick="companyFuzzyQuery(1)">Search</button></td>
 		</tfoot>
 	</table> --%>
 	
 			<div>
				<div>
					<div>
						<div id="head_search">搜索</div>
						<div>
							企业名称：
							<input placeholder="请输入" id="name" type="text" name="name"/> 
							楼层位置：
							<input placeholder="请输入" id="addr" type="text" name="addr"/>
							联系姓名：
							<input placeholder="请输入" id="contacts" type="text" name="contacts"/>
							联系电话：
							<input placeholder="请输入" id="phone" type="text" name="phone"/>
                            <input type="button" value="查询" onclick="companyFuzzyQuery(1)" />
						</div>
					</div>
				</div>
			</div>
 	
 	 <!-- </form> --> <br/><br/>
 	 
     <span id="title">您的模糊查询结果如下(默认全部查出)：</span>
     <table id="whole_table">
     	<thead>
     		<th><input id="select" type="checkbox"/></th>
     		<th>企业名称</th>
     		<th>企业楼层位置</th>
     		<th>企业联系人</th>
     		<th>企业联系电话</th>
     		<th>删除企业</th>
     		<th>修改企业信息</th>
     	</thead>
     	<tbody class="middle_info">
     	<!-- 此处放置从ajax传回来的数据 -->
     	 <%-- <c:forEach items="${list3}" var="CompanyBean">
     		<tr>
     			<td>${CompanyBean.name}</td>
     			<td>${CompanyBean.addr}</td>
     			<td>${CompanyBean.contacts}</td>
     			<td>${CompanyBean.phone}</td>
     			<td class="delete">
	     			<form action="companyDelete.do" method="post">
	     				<input style="font-size:35px;color:red" type="hidden" name="id" value="${CompanyBean.id}"/>
	     				<button type="submit" style="font-size:35px;color:red">×</button>
	     			</form>
     			</td>
     		</tr>
     	</c:forEach> --%>
     	</tbody>
     	<input id="isSubmit" type="hidden" value="''"/>
     	<input id="update_id" type="hidden" value="0"/>
     	<input id="update_name" type="hidden" value="''"/>
     	<input id="update_addr" type="hidden" value="''"/>
     	<input id="update_contacts" type="hidden" value="''"/>
     	<input id="update_phone" type="hidden" value="''"/>
     	
     	<input id="checkID" type="hidden" value=""/>
     	
     	<input id="hiddenForGetDeleteId" type="hidden"/>
     </table>
     <script>
     	 var checkID = [];//定义一个空数组
         function companyFuzzyQuery(ppage){
             /* var jsonobj = {"name":"${sessionScope.name}"}; */
             $.ajax({
                url:"/CBDParkingManagementSystem/companyFuzzyQuery.do",
				type:"post",
				data:{
					page:ppage,
					name:$("#name").val(),
					addr:$("#addr").val(),
					contacts:$("#contacts").val(),
					phone:$("#phone").val(),
					deleteId:$("#hiddenForGetDeleteId").val(),
					isSubmit:$("#isSubmit").val(),
					update_id:$("#update_id").val(),
					update_name:$("#update_name").val(),
					update_addr:$("#update_addr").val(),
					update_contacts:$("#update_contacts").val(),
					update_phone:$("#update_phone").val(),
					checkID:$("#checkID").val(),
				},
				dataType:"json",
			    success:function(data){
			    	/* alert(); */
			    	/* alert(data.contacts1+";"+data.phone1); */
					var companyBean = data.list;
					var totalPage = data.totalPage;
					var num = data.num;
					var name1 = data.name1;
					var name2 = data.name2;
					var addr1 = data.addr1;
					var contacts1 = data.contacts1;
					var phone1 = data.phone1;
					var deleteSuccess1 = data.deleteSuccess1;
					var modifySuccess1 = data.modifySuccess1;
					var content = "";
					for(var i=0;i<companyBean.length;i++){
					var company = companyBean[i];
					 	content += "<tr class='c_"+company.id+"'>"
					     			+"<td><input name='vehicle' class='box' type='checkbox' value='"+company.id+"'/>"
					     			+"<td><input oninput='checkname()' class='b_1' type='text' readonly='readonly' value='"+company.name+"'/>"
					     				+"<br/><input class='e_1' type='text' readonly='readonly' value=''/></td>"
					     			+"<td><input oninput='checkaddr()' class='b_2' type='text' readonly='readonly' value='"+company.addr+"'/>"
					     				+"<br/><input class='e_2' type='text' readonly='readonly' value=''/></td>"
					     			+"<td><input oninput='checkcontacts()' class='b_3' type='text' readonly='readonly' value='"+company.contacts+"'/>"
					     				+"<br/><input class='e_3' type='text' readonly='readonly' value=''/></td>"
					     			+"<td class='middle_info_td_phone'><input oninput='checkphone()' class='b_4' type='text' readonly='readonly' value='"+company.phone+"'/>"
					     				+"<br/><input class='e_4' type='text' readonly='readonly' value=''/></td>"
					     			+"<td><button class='delete' onclick='getDeleteID("+company.id+")'>删除</button>"
					     				/* +"<br/><input class='e_5' type='text' readonly='readonly' value=''/>" */
					     			+"<td><button class='edit' onclick='isEdit("+company.id+")'>编辑</button>&nbsp&nbsp"
					     				+"<button class='submit' disabled='disabled' onclick='forbidEdit("+company.id+")'>提交</button>"
					     				+"<br/><input class='e_6' type='text' readonly='readonly' value=''/></td>"
					     			+"</td>"
					     		+"</tr>"
							 }
								$(".middle_info").html(content);
								$("#num").html(num);
								$("#currentpage").html(ppage);
								//因为使用多删除时，删除最后一页的时候，会出现当前页大于总页数的情况
								if(ppage > totalPage){
									
									$("#totalpage").html(totalPage+1);
								}else{
									$("#totalpage").html(totalPage);
								}
								$("#isSubmit").val("");
								$("#select").attr("checked",false);
								checkID = [];
								
						     	//先获取之前点击更新按钮后保存在input中的id
						     	var id = $("#update_id").val();
						     	//设置修改企业格式错误信息到页面
						     	$(".c_"+id+" .e_1").val(name1+name2);
						     	$(".c_"+id+" .e_2").val(addr1);
						     	$(".c_"+id+" .e_3").val(contacts1);
						     	$(".c_"+id+" .e_4").val(phone1);
						     	/* $(".d_"+id+" .e_5").val(deleteSuccess1); */
						     	$(".c_"+id+" .e_6").val(modifySuccess1);
						     	//设置错误信息的颜色和字体
						     	/* $(".c_"+id+" input").css("color","red"); */
						     	$(".c_"+id+"  .e_1").css("color","red");
						     	$(".c_"+id+"  .e_1").css("font-size","15");
						     	$(".c_"+id+"  .e_2").css("color","red");
						     	$(".c_"+id+"  .e_2").css("font-size","15");
						     	$(".c_"+id+"  .e_3").css("color","red");
						     	$(".c_"+id+"  .e_3").css("font-size","15");
						     	$(".c_"+id+"  .e_4").css("color","red");
						     	$(".c_"+id+"  .e_4").css("font-size","15");
						     	$(".c_"+id+"  .e_6").css("color","blue");
						     	$(".c_"+id+"  .e_6").css("font-size","15");
			                 }
			             });
			         }
		         <!-- 进行方法调用 -->
		         /* companyFuzzyQuery(1); */
		         companyFuzzyQuery(1);
		         //前端校验
		         	var d = 1;
			        var e = 1;
			        var f = 1;
		      	  	var g = 1;
		          //及时验证企业名称
				    function checkname(){
				    	//先获取之前点击更新按钮后保存在input中的id
				     	var id = $("#update_id").val();
				         //在每个函数中定义check变量是为了在表单提交后，逐个验证每个函数是否通过
				         var check;  
				         var name = $(".c_"+id+" .b_1").val();  
				         if (name.trim().length < 1 || name==null || name=="") {   
					         $(".c_"+id+" .e_1").css("color","red");
					         $(".c_"+id+" .b_1").css("color","red");
					         $(".c_"+id+" .e_1").val("名称不能为空");
					         d = 0;  
				           } else {  
				              /* document.getElementById("name_info").innerHTML = "* 企业名称不为空值  √"; */
				               $(".c_"+id+" .e_1").val("");    
				               $(".c_"+id+" .b_1").css("color","#86837D");    
				              d = 1;  
				           }  
				            return check;  
			        }
			           //及时验证企业楼层
				    function checkaddr(){
				    //先获取之前点击更新按钮后保存在input中的id
				     	var id = $("#update_id").val();
				         //在每个函数中定义check变量是为了在表单提交后，逐个验证每个函数是否通过
				         var check;  
				         var addr =  $(".c_"+id+" .b_2").val();  
				         if (addr.trim().length < 1 || addr==null || addr=="") {  
				         $(".c_"+id+" .e_2").css("color","red");
				         $(".c_"+id+" .b_2").css("color","red");
				         $(".c_"+id+" .e_2").val("地址不能为空");
				         e=0;
				           } else {  
				              /* document.getElementById("addr_info").innerHTML = "* 企业楼层不为空值  √"; */
				               $(".c_"+id+" .e_2").val("");    
				               $(".c_"+id+" .b_2").css("color","#86837D");   
				              e = 1;  
				           }  
				            return check;  
			        }
			        //及时验证企业联系人
			    function checkcontacts(){
			    //先获取之前点击更新按钮后保存在input中的id
				     	var id = $("#update_id").val();
			         //在每个函数中定义check变量是为了在表单提交后，逐个验证每个函数是否通过
			         var check;  
			         var contacts = $(".c_"+id+" .b_3").val();   
			         var reg = /^[\u4E00-\u9FA5]{2,4}$/;
			         if (!reg.test(contacts) || contacts==null|| contacts=="") {  
			         $(".c_"+id+" .e_3").css("color","red");
			         $(".c_"+id+" .b_3").css("color","red");
			         $(".c_"+id+" .e_3").val("姓名2~4位中文");
			         f=0;
			           } else {  
			              /* document.getElementById("contacts_info").innerHTML = "* 企业联系人为2~4个汉字  √"; */
			               $(".c_"+id+" .e_3").val("");    
			               $(".c_"+id+" .b_3").css("color","#86837D");    
			              f = 1;  
			           }  
			            return check;  
			        }
	        	//及时验证企业联系电话
			    function checkphone(){
			    //先获取之前点击更新按钮后保存在input中的id
				     	var id = $("#update_id").val();
			         //在每个函数中定义check变量是为了在表单提交后，逐个验证每个函数是否通过
			         var check;  
			         var phone =  $(".c_"+id+" .b_4").val();  
			         var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
			         if (!reg.test(phone)) { 
			         $(".c_"+id+" .e_4").css("color","red"); 
			         $(".c_"+id+" .b_4").css("color","red"); 
			         $(".c_"+id+" .e_4").val("电话格式11位");
			         g = 0;  
			           } else {  
			             /*  document.getElementById("phone_info").innerHTML = "* 企业联系手机号格式正确  √"; */
			               $(".c_"+id+" .e_4").val("");    
			               $(".c_"+id+" .b_4").css("color","#86837D");     
			              g = 1;  
			           }  
			            return check;  
		        }
		         function isEdit(id){
		         	$("#update_id").val(id);
		         	/* $("input[readonly='readonly']").removeProp("readonly"); */
		         	$(".c_"+id+" .b_1").removeProp("readonly");
		         	$(".c_"+id+" .b_1").css("border-style","solid");
		         	$(".c_"+id+" .b_1").css("border-bottom-width","2px");
		         	/* $(".c_"+id+" .b_1").css("color","#333333"); */
		         	$(".c_"+id+" .b_2").removeProp("readonly");
		         	$(".c_"+id+" .b_2").css("border-style","solid");
		         	$(".c_"+id+" .b_2").css("border-bottom-width","2px");
		         	/* $(".c_"+id+" .b_2").css("color","#333333"); */
		         	$(".c_"+id+" .b_3").removeProp("readonly");
		         	$(".c_"+id+" .b_3").css("border-style","solid");
		         	$(".c_"+id+" .b_3").css("border-bottom-width","2px");
		         	/* $(".c_"+id+" .b_3").css("color","#333333"); */
		         	$(".c_"+id+" .b_4").removeProp("readonly");
		         	$(".c_"+id+" .b_4").css("border-style","solid");
		         	$(".c_"+id+" .b_4").css("border-bottom-width","2px");
		         	/* $(".c_"+id+" .b_4").css("color","#333333"); */
		         	//变换按钮是否可点击
		         	$(".c_"+id+" .edit").css("disabled","disabled");
		         	$(".c_"+id+" .submit").removeProp("disabled");
		         	$(".c_"+id+" .submit").css("color","#4951B3");
		         }
		         function forbidEdit(id){
		         if(d==1 && e==1 && f==1 && g==1){
		         	var msg2 = "您真的要提交修改吗？ \n\n请确认!"
		         	if(confirm(msg2)==true){
		         		//获取这一行的各个数据,然后将数据暂存到另一组input中
			         	$("#isSubmit").val("submit");
			         	$("#update_id").val(id);
			         	$("#update_name").val($(".c_"+id+" .b_1").val());
			         	$("#update_addr").val($(".c_"+id+" .b_2").val());
			         	$("#update_contacts").val($(".c_"+id+" .b_3").val());
			         	$("#update_phone").val($(".c_"+id+" .b_4").val());
			         	
			         	$(".c_"+id+" input").attr('readonly','readonly');
			         	$(".c_"+id+" input").css("border-bottom-width","0px");
			         	$(".c_"+id+" input").css("color","black");
			         	//变换按钮是否可点击
			         	$(".c_"+id+" .submit").css("disabled","disabled");
			         	$(".c_"+id+" .submit").css("color","#F2F1EF");
			         	$(".c_"+id+" .edit").removeProp("disabled");
			         	
			         	companyFuzzyQuery($("#currentpage").html());
		         	}
		         }else{
		         	alert("格式填写正确后，才可提交");
		         }
		         }
		        function getDeleteID(id){
		        	var msg = "您真的确定要删除吗？\n\n请确认！";
						if (confirm(msg)==true){
						$("#hiddenForGetDeleteId").val(id);
		        		companyFuzzyQuery($("#currentpage").html());
					}
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
				   	/* checkID = [];//定义一个空数组  */
				        $("input[name='vehicle']:checked").each(function(i){//把所有被选中的复选框的值存入数组
				            checkID[i] =$(this).val();
				        }); 
				        /* alert(checkID); */
						$("#checkID").val(checkID);
					    companyFuzzyQuery($("#currentpage").html());
				  		
				    })
				});
				function prePage(){
				//    alert("pre");
					var current=$("#currentpage").html();
					var currentPage=parseInt(current);
					if(currentPage > 1){
						$("#select").attr("checked",false);
						companyFuzzyQuery(currentPage - 1);
					}
				}
				function nextPage(){
				//    alert("next");
					var current=$("#currentpage").html();
					var currentPage=parseInt(current);
					var total=$("#totalpage").html();
					var totalPage=parseInt(total);
					if(currentPage < totalPage){
						$("#select").attr("checked",false);
						companyFuzzyQuery(currentPage + 1);
					}
				}
				function endPage(){
				//    alert("end");
					var total=$("#totalpage").html();
					var totalPage=parseInt(total);
					$("#select").attr("checked",false);
					companyFuzzyQuery(totalPage);
				}
				function jump(){
					//先获取input框用户输入的值
					var jumpValue = parseInt($("#jumpNumTxt").val());
					var total = parseInt($("#totalpage").html());
					/* alert(jumpValue);
					alert(total); */
					if(jumpValue >= 1 && jumpValue <= total){
						companyFuzzyQuery(jumpValue);
					}
				}
			     </script>
			     <br/>
			     <!-- 设置翻页按钮 -->
			     <!-- <div class="bottom_buttons">
			            <button name="first" onclick="companyFuzzyQuery(1)">首页</button>
			            <button name="top" onclick="prePage()">上一页</button>
			                <button>
			                    <span id="currentpage">1</span>/
			                    <span id="totalpage">0</span>
			                </button>
			            <button name="down" onclick="nextPage()">下一页</a></button>
			            <button name="last" onclick="endPage()">末页</button>
			            <button id="manyDelete">批量删除</button>
				 </div> -->
				 
			<div class="foot_div">
				 <div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						共有
						<span id="num" class="ui_txt_bold04"></span>
						条记录，当前第
						<span id="currentpage" class="ui_txt_bold04"></span>
						/
						<span id="totalpage"></span>
						页
					</div>
					<div class="ui_frt">
						<!--    如果是第一页，则只显示下一页、尾页 -->
							<button id="manyDelete" onclick="return confirm('批量删除吗？\n\n请确认！')">批量删除</button>
							<input onclick="companyFuzzyQuery(1)" type="button" value="首页" class="ui_input_btn01" />
							<input onclick="prePage()" type="button" value="上一页" class="ui_input_btn01" />
							<input onclick="nextPage()" type="button" value="下一页" class="ui_input_btn01"/>
							<input onclick="endPage()" type="button" value="尾页" class="ui_input_btn01"/>
						
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" />页
							 <input type="button" class="ui_input_btn01" value="跳转" onclick="jump()" />
					</div>
				</div>








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