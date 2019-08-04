<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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


		<input type="hidden" id="i" name="i" value="${param.i}" />
		<div class="form-title">
			<h4>添加企业租赁合同:</h4>
		</div>



		<form action="addnewcarport.do" method="post" name="channelform"  onsubmit="return validate_channel_info(this);">
			<div class="form-group" style="clear:both">
				<label for="focusedinput" class="col-sm-2 control-label">合同编号:</label>
				<div class="col-sm-8">
					<input readonly="readonly" type="text" class="form-control1"
						id="newcontractnumbers" name="newcontractnumbers"
						value="<%=session.getAttribute("contractnum")%>">
				</div>
			</div>


			<div class="form-group" style="clear:both">
				<label for="focusedinput" class="col-sm-2 control-label">企业名称:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control1" id="company"
						name="company" placeholder="如：成都蜗牛学院" onfocus="YHMonfocu()" onblur="YHMonblus()">
						<font color=red><span id="YHMerror"></font>
				</div>
			</div>

			<div class="form-group" style="clear:both">
				<label for="focusedinput" class="col-sm-2 control-label">联系人姓名:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control1" id="contacts"
						name="contacts" placeholder="如：张三" onfocus="contactsonfocu()" onblur="contactsonblus()">
						<font color=red><span id="contaerror"></font>
				</div>
			</div>


			<div class="form-group" style="clear:both">
				<label for="smallinput"
					class="col-sm-2 control-label label-input-sm">联系电话:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control1 input-sm" id="phone"
						name="phone" placeholder="如：13909987898" onfocus="phoneonfocu()" onblur="phoneonblus()">
						<font color=red><span id="phoneerror"></font>
				</div>
			</div>





			<div class="form-group" style="clear:both">
				<label for="selector1" class="col-sm-2 control-label">请选择车位地址信息:</label>
				<div class="col-sm-8">
					<select id="FirstCate" name="FirstCate" class="form-control1"
						onchange="changeCategory()">
						<option>----请--选--择----</option>
					</select>
				</div>
			</div>
			<br />
			<div class="form-group" style="clear:both">
				<label for="selector1" class="col-sm-2 control-label">请选择车位编号信息:</label>
				<div class="col-sm-8">
					<select id="secondTypeId" name="secondTypeId" class="form-control1"
						onchange="addCarport()">
						<option id="typ" name="typ" value="">----请--选--择----</option>
					</select>
				</div>
			</div>
			<br>

			<div class="form-group" style="clear:both">
				<label class="col-sm-2 control-label">已选择车位编号信息:</label>

				<div class="col-sm-8"
					style="overflow-y:scroll;margin-left:15px;width:790px;height:150px;background-color:white">
					<table style="width:760px" id="bottom" name="bottom" border=1
						class="form-control1" style="text-align:center" onfocus="bottomonfocu()" onblur="bottomonblus()">
				    </table>
					<font color=red><span id="carporterror"></font>
				</div>
			</div>
			
			<div class="form-group" style="clear:both">
			      <input type="hidden" id="selectcarport" name="selectcarport" style="background:transparent;border:0" value=""> 
            </div> 


			<div class="form-group" style="clear:both">
				<label for="focusedinput" class="col-sm-2 control-label">合同生效日期:</label>
				<div class="col-sm-8">
					<input readOnly="true" style="height:25px;width:300px" class="Wdate" type="text"
						id="startDate" name="startDate"
						onclick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}'});" onfocus="startDateonfocu()" onblur="startDateonblus()"/>
						<font color=red><span id="startDateerror"></font>
				</div>
			</div>


			<div class="form-group" style="clear:both">
				<label for="focusedinput" class="col-sm-2 control-label">合同截止日期:</label>
				<div class="col-sm-8">
					<input readOnly="true" style="height:25px;width:300px" class="Wdate" type="text"
						id="endDate" name="endDate" value="${Contract.endTime}"
						onclick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}'});"
						 onfocus="endDateonfocu()" onblur="endDateonblus()"/>
						 <font color=red><span id="endDateerror"></font>
				</div>
			</div>

			<button id="button2" type="submit" class="btn btn-default">提交</button>


		</form>



		<script type="text/javascript">
		
			function validate_channel_info(channelform) {

				if (company.value == "" || company.value == null) {
					alert("企业名称不能为空");
					return false;
				}
				if (contacts.value == "" || contacts.value == null) {
					alert("联系人姓名不能为空");
					return false;
				}
				if (phone.value == "" || phone.value == null) {
					alert("联系电话不能为空");
					return false;
				}
				if (selectcarport.value =="[]" || selectcarport.value =="") {
					alert("车位编号不能为空");
					return false;
				}

				if (startDate.value =="" || startDate.value == null) {
					alert("合同生效日期不能为空");
					return false;
				}
				if (endDate.value == "" || endDate.value == null) {
					alert("合同截止日期不能为空");
					return false;
				}

				return true;
			}
			//验证企业名称 		
			function YHMonblus() {
				var company = document.getElementById("company");
				var re = /^[a-zA-Z_]{6,18}$/;
				if (company.value == "") {
					document.getElementById('YHMerror').innerText = "请输入企业名称";
				} else if (company.value.length<2 ||company.value.length>18) {
					console.log(company.value);
					document.getElementById('YHMerror').innerText = "格式错误,长度应为2-18个字符";
				} else {
					document.getElementById('YHMerror').innerText = "";
				}
			}

			function YHMonfocu() {
				document.getElementById('YHMerror').innerText = "";
			}
			//验证联系人姓名
			function contactsonblus() {
				var contacts = document.getElementById("contacts");
				var re = /^[a-zA-Z_]{6,18}$/;
				if (contacts.value == "") {
					document.getElementById('contaerror').innerText = "请输入联系人名称";
				} else if (contacts.value.length<1 ||contacts.value.length>18) {
					console.log(contacts.value);
					document.getElementById('contaerror').innerText = "格式错误,长度应为1-18个字符";
				} else {
					document.getElementById('contaerror').innerText = "";
				}
			}

			function contactsonfocu() {
				document.getElementById('contaerror').innerText = "";
			}

			//验证联系电话
			function phoneonblus() {
				var phone = document.getElementById("phone");
				var re = /^\d{4,20}$/;
				if (phone.value == "") {
					document.getElementById('phoneerror').innerText = "请输入联系电话";
				}
				else if(!re.test($("#phone").val())){
				document.getElementById('phoneerror').innerText="电话格式输入错误,位4到20位数字";
				}
				else {
					document.getElementById('phoneerror').innerText = "";
				}
			}

			function phoneonfocu() {
				document.getElementById('phoneerror').innerText = "";
			}

			//验证车位信息

			//验证合同生效时间
			function startDateonblus() {
				var startDate = document.getElementById("startDate");
				if (startDate.value == "") {
					document.getElementById('startDateerror').innerText = "请选择合同生效日期";
				}

				else {
					document.getElementById('startDateerror').innerText = "";
				}
			}

			function startDateonfocu() {
				document.getElementById('startDateerror').innerText = "";
			}

			//验证合同截止时间
			function endDateonblus() {
				var endDate = document.getElementById("endDate");
				if (endDate.value == "") {
					document.getElementById('endDateerror').innerText = "请选择合同截止日期";
				}

				else {
					document.getElementById('endDateerror').innerText = "";
				}
			}

			function startDateonfocu() {
				document.getElementById('endDateerror').innerText = "";
			}

			function changeCategory() {

				var adress = {
					"adress" : $("#FirstCate").val()
				};
				$.ajax({
							url : "/CBDParkingManagementSystem/addcompanycontractcarport.do",
							type : "post",
							contentType : "application/json;charset=utf-8",
							data : JSON.stringify(adress),
							dataType : "json",
							//返回的多个内容（map）中，取单个元素.键
							success : function(data) {

								var content = "<option>----请--选--择----</option>";
								var carnum = data.carnum;

								for (var i = 0; i < carnum.length; i++) {
									var g = carnum[i];
									content += "<option>" + g.carNum
											+ "</option>";

								}

								$("#secondTypeId").html(content);

							}

						});

			}

			function addCarport() {
				var number = {
					"adress" : $("#FirstCate").val(),
					"carNum" : $("#secondTypeId").val()
				}

				$.ajax({
							url : "/CBDParkingManagementSystem/selectnewcarport.do",
							type : "post",
							contentType : "application/json;charset=utf-8",
							data : JSON.stringify(number),

							dataType : "json",
							//返回的多个内容（map）中，取单个元素.键
							success : function(data) {
								var content = "<tr>" + "<td>序号</td>"
										+ "<td>车位地址</td>" + "<td>车位编号</td>"
										+ "<td>操作</td>" + "</tr>";
								var car = data.newcarport;
								var result=data.backerror;
								for (var i = 0; i < car.length; i++) {
									var g = car[i];
									content += "<tr><td>"
											+ (i + 1)
											+ "</td><td>"
											+ g.adress
											+ "</td><td>"
											+ g.carNum
											+ "</td><td><input type='button' onclick='deletecarportselect("
											+ i + ")' value='删除'></td></tr>"
								}
								$("#bottom").html(content);
								$("#selectcarport").val(result);

							}

						});

			}
			function deletecarportselect(index) {
				$.ajax({

							url : "/CBDParkingManagementSystem/deletenewcarport.do",
							type : "post",
							contentType : "application/json;charset=utf-8",
							data : JSON.stringify(index),
							dataType : "json",
							//返回的多个内容（map）中，取单个元素.键
							success : function(data) {
								var content = "<tr>" + "<td>序号</td>"
										+ "<td>车位地址</td>" + "<td>车位编号</td>"
										+ "<td>操作</td>" + "</tr>";
								var carnum = data.newcarportnum;
								var result=data.backerror;
								for (var i = 0; i < carnum.length; i++) {
									var g = carnum[i];
									content += "<tr><td>"
											+ (i + 1)
											+ "</td><td>"
											+ g.adress
											+ "</td><td>"
											+ g.carNum
											+ "</td><td><input type='button' onclick='deletecarportselect("
											+ i + ")' value='删除'></td></tr>"
								}
								$("#bottom").html(content);
								$("#selectcarport").val(result);

							}
						});

			}

			function changeadress() {
				$.ajax({

					url : "/CBDParkingManagementSystem/newcarport.do",
					type : "post",
					contentType : "application/json;charset=utf-8",
					data : JSON.stringify(),
					dataType : "json",
					//返回的多个内容（map）中，取单个元素.键
					success : function(data) {
						var content = "<option>----请--选--择----</option>";
						var carnum = data.newcarports;
						for (var i = 0; i < carnum.length; i++) {
							var g = carnum[i];
							content += "<option>" + g.adress + "</option>";
						}
						$("#FirstCate").html(content);

					}
				});
			}

			changeadress();

			function newnums() {
				$.ajax({
					url : "/CBDParkingManagementSystem/newcontractnumber.do",
					type : "post",
					contentType : "application/json;charset=utf-8",
					data : JSON.stringify(),
					dataType : "json",
					//返回的多个内容（map）中，取单个元素.键
					success : function(data) {

					}

				});

			}

			function showComplain(page) {
				$.ajax({
							url : "/CBDParkingManagementSystem/showComplain.do",
							type : "post",
							data : {
								pageNow : page,
							},
							success : function(data) {
								if (data == "success") {
									window.location.href = '/CBDParkingManagementSystem/jsp/ShowAllComplain.jsp';
								}
							}
						})
			}

			function waitHandle(page) {
				$.ajax({
							url : "/CBDParkingManagementSystem/waitHandle.do",
							type : "post",
							data : {
								pageNow : page,
							},

							success : function(data) {
								if (data == "success") {
									window.location.href = '/CBDParkingManagementSystem/jsp/ShowAllComplain.jsp';
								}
							}
						});

			}
		</script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>











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