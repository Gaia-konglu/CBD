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
    
    <title>My JSP 'tenantShow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	table{
	margin:100px auto;
	}
	th{
	height:50px;
	
	font-size:20px;
	}
	tr{
	height:50px;
	font-size:20px;
	text-align:center;
	}
	input{
	font-size:15px;
	}
	button{
	font-size:15px;
	}
	#page{
	width:900px;
	height:150px;
	position:absolute;
	top:400px;
	left:650px;
	}
	li{
	float:left;
	list-style:none;
	margin-left:10px;
	}
	</style>
  </head>
  <script src="/CBDParkingManagementSystem/js/jquery.1.9.1.js"></script>
  <body>
 
  		<label>开始时间</label><input id="startTime" type="date" name="startTime">
  		<label>结束时间</label><input id="endTime" type="date" name="endTime">
  		<button onclick="sendPage(1)">查询</button>
 		<button onclick="myBook()">我的预定</button>
    <table border="1" cellspacing = "0" cellpadding = "10">
    	<thead>
    		<th>小区地址</th>
    		<th>车位编号</th>
    		<th>租借开始时间</th>
    		<th>租借结束时间</th>
    		<th>出租价格</th>
    		<th>包租婆用户名</th>
    		<th>包租婆职业</th>
    		<th>信誉度</th>
    		<th>留言</th>
    		<th>操作</th>
    	</thead>
    	<tbody id="contents">
    		
    	</tbody>
    </table>
    <div id="page">
    	<ul class="pages">
			<li id="first" onclick="sendPage(1)">首页</li>
			<li id="top" onclick="prePage()">上一页</li>
			<li class="xifenye" id="xifenye"><span id="currentpage">1</span>/
			<span id="totalpage">0</span></li>
			<li id="down" onclick="nextPage()">下一页</li>
			<li id="last" onclick="endPage()">末页</li>
		</ul>	
    </div>
    <script type="text/javascript">
		function sendPage(pages){
			$.ajax({
			url:"showAllRentInfor.do",
			type:"post",
			data:{
				"page":pages,
				"startTime":$("#startTime").val(),
				"endTime":$("#endTime").val(),
			},
			success:function(data){
				var lists = data.list;
				var page = data.totalPage;
				var content = "";
				for(var i = 0;i<lists.length;i++){
					var l = lists[i];
					content +="<tr>"
								+"<td>"+l.personCarSpaceInfor.addr+"</td>"
    							+"<td>"+l.personCarSpaceInfor.carNum+"</td>"
    							+"<td>"+l.startTime+"</td>"
    							+"<td>"+l.endTime+"</td>"
    							+"<td>"+l.price+"</td>"
    							+"<td>"+l.landLady.name+"</td>"
    							+"<td>"+l.landLady.job+"</td>"
    							+"<td>"+l.landLady.credit+"</td>"
    							+"<td>"+"<input id='message' type='text' name='message'/>"+"</td>"
    							+"<td>"
    							+"<button onclick='sendRent("+l.id +")'>预定</button>"
    							+"</td>"
    						+"</tr>"
				}
				$("#contents").html(content);
				$("#totalpage").html(page);
				$("#currentpage").html(pages);
				}
			});
		}    
   sendPage(1);
    	function prePage(){
			var current = $("#currentpage").html();
			var currentPage = parseInt(current);
			if(currentPage > 1){
				sendPage(currentPage-1 );
			}
		}

		function nextPage(){
			var current = $("#currentpage").html();
			var currentPage = parseInt(current);
			var totalpage = $("#totalpage").html();
			var totalPage = parseInt(totalpage);
			if(currentPage < totalPage){
				sendPage(currentPage + 1 );
			}
		}
 		function endPage(){
			var totalpage = $("#totalpage").html();
			var totalPage = parseInt(totalpage);
	 		sendPage(totalPage);
 		}
		function sendRent(index){
		$.ajax({
			url:"addBookInfor.do",
			type:"post",
			data:{
			"rid":index,
			"message":$("#message").val()
			},
			success:function(message){
			window.location.reload();
			}
		});
	}
	
		function myBook(){
			window.location.href="checkPayBook.do";
		}
    </script>
  </body>
</html>
