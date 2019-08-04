<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'publishRentInfor.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="style/authority/main_css.css" rel="stylesheet" type="text/css">
<style type="text/css">

.table {
	padding: 0;
	margin: 0;
	position: relative;
	margin: 0 auto;
}

.table tbody tr th {
	background: #f3f2f0 no-repeat;
	text-align: center;
	border-left: 1px solid #ECECEC;
	border-right: 1px solid #ECECEC;
	border-bottom: 1px solid #ECECEC;
	border-top: 1px solid #ECECEC;
	letter-spacing: 2px;
	text-transform: uppercase;
	font-size: 14px;
	color: #757370;
	height: 37px;
}

.table tbody tr td {
	text-align: center;
	border-left: 1px solid #ECECEC;
	border-right: 1px solid #ECECEC;
	border-bottom: 1px solid #ECECEC;
	font-size: 15px;
	color: #909090;
	height: 37px;
}

.point{
cursor:pointer;
}
.point:hover{
text-decoration:underline;
color:#ffa000;
}
.undonepoint{
cursor:pointer;
}
.undonepoint:hover{
text-decoration:underline;
color:#ECECEC;
}
#pulish{
margin-left:-50px;
}

.demo-txt2{
position: absolute;
            z-index: 1;
            color: #000;
            background: white;
            width: 360px;
            height: 200px;
            margin:auto;
            padding: auto;
            left: 0;
            right: 0;
            bottom: 0;
            top: 0;
            display: none;
            padding: 10px;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
}

.demo-txt3{
position: absolute;
            z-index: 1;
            color: #000;
            background: white;
            width: 360px;
            height: 200px;
            margin:auto;
            padding: auto;
            left: 0;
            right: 0;
            bottom: 0;
            top: 0;
            display: none;
            padding: 10px;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
}

.demo-txt4{
position: absolute;
            z-index: 1;
            color: #000;
            background: white;
            width: 360px;
            height: 200px;
            margin:auto;
            padding: auto;
            left: 0;
            right: 0;
            bottom: 0;
            top: 0;
            display: none;
            padding: 10px;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
}

.btn1{
margin-top:50px;
margin-left:150px;
width:80px;
height:30px;
}
.text1{
margin-top:60px;
margin-left:120px;
font-size:20px;
}
</style>
  </head>
  <script src="/CBDParkingManagementSystem/js/jquery.1.9.1.js"></script>
  <body>
  <table  class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0" >
  		<tr>
  			<th>小区地址</th>
  			<th>小区车位编号</th>
  			<th>租借开始时间</th>
  			<th>租借结束时间</th>
  			<th>出租金额</th>
  			<th>状态</th>
  			<th>操作</th>
  		</tr>
  		<tbody>
  			 <c:forEach items="${list}" var="obj">
    		<tr>
    			
    			<td>${obj.addr}</td>
    			<td>${obj.carNum}</td>
    			<td><input id="startTime${obj.id}" type="date" name="startTime"></td>
    			<td><input id="endTime${obj.id}" type="date" name="endTime"></td>
    			<td><input id="price${obj.id}" type="text" name="price"></td>
    			<c:if test="${obj.status eq 1}">
    			<td>已通过审核</td>
    			<td><span class="point" onclick="publish(${obj.id})">发布招租</span></td>
    			</c:if>
    			<c:if test="${obj.status eq 0}">
    			<td>待审核</td>
    			<td><span class="undonepoint" >发布招租</span></td>
    			</c:if>
    			
    		</tr>
    		</c:forEach>
  		</tbody>
  		<span id="check"></span>
  	</table>
  				<!--弹框  -->
				<div class='demo-bg'></div>
    			<div class='demo-txt' id="txtpulish">
        			<div class="text" id="pulish" >车位已发布，是否查看已发布信息？</div>
        			<input type="hidden" id="partId" name="pid"/>
        			<button onclick="redirect()">是</button>
        			<button class="btn" onclick="closeDialog()">否</button>
    			</div>
    			<!-- 弹框2 -->
    			<div class='demo-txt2' id="txtpulish2">
        			<div class="text1"  >时间发布有误！</div>
        			<button class="btn1" onclick="closeDialog()">返回</button>
    			</div>
    			<!-- 弹框3 -->
    			<div class='demo-txt3' id="txtpulish3">
        			<div class="text1"  >金额超出范围！</div>
        			<button class="btn1" onclick="closeDialog()">返回</button>
    			</div>
    			<!-- 弹框4 -->
    			<div class='demo-txt4' id="txtpulish4">
        			<div class="text1" >金额格式有误！</div>
        			<button class="btn1" onclick="closeDialog()">返回</button>
    			</div>
  <script type="text/javascript">
   		function publish(pid){
   		$.ajax({
   		url:"addRentInfor.do",
   		type:"post",
   		data:{
   			"startTime":$("#startTime"+pid).val(),
   			"endTime":$("#endTime"+pid).val(),
   			"price":$("#price"+pid).val(),
   			"pid":pid
   		},
   		success:function(message){
   		if(message=="success"){
   		openDialog();
   		}
   		else if(message=="fail"){
   		openDialog2();
   		}
   		else if(message=="over"){
   		openDialog3();
   		}
   		else if(message=="priceError"){
   		openDialog4();
   		}
   		
   		}
   		});
   	}
   	function redirect(){
   	window.location.href="jsp/landLadyPulishedRentInfor.jsp";
   	}
   	
   	var demobg = document.querySelector(".demo-bg");
    var demotxt = document.querySelector(".demo-txt");
     var demotxt2 = document.querySelector(".demo-txt2");
      var demotxt3 = document.querySelector(".demo-txt3");
       var demotxt4 = document.querySelector(".demo-txt4");
    function openDialog() {
    	demobg.style.display="block";
        demotxt.style.display="block";
 		
    }
    function openDialog2() {
    	demobg.style.display="block";
        demotxt2.style.display="block";
 		
    }
      function openDialog3() {
    	demobg.style.display="block";
        demotxt3.style.display="block";
 		
    }
         function openDialog4() {
    	demobg.style.display="block";
        demotxt4.style.display="block";
 		
    }
    function closeDialog() {
        demotxt.style.display = "none";
        demobg.style.display = "none";
        window.location.reload();
    }
   	</script>
  </body>
</html>
