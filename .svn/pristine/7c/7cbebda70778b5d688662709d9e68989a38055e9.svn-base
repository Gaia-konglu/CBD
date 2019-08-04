<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="../scripts/jquery/jquery-1.7.1.js"></script>
<link href="../style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="../style/authority/common_style.css" rel="stylesheet" type="text/css">
<link href="../style/authority/main_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="../scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="../scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="../style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="../scripts/artDialog/artDialog.js?skin=default"></script>
<title>信息管理系统</title>

<style>
	.alt td{ background:black !important;}
	
	.point{
cursor:pointer;
}
.point:hover{
text-decoration:underline;
color:#ffa000;
}
#text1{
margin-left:30px;
}
}
</style>
</head>
<body>
	
	<div id="container">
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
							</th>
							<th>交易单号</th>
							<th>交易时间</th>
    						<th>车位地址</th>
    						<th>车位编号</th>
    						<th>租借开始时间</th>
    						<th>租借结束时间</th>
    						<th>出租价格</th>
    						<th>包租婆用户名</th>
    						<th>操作</th>
    						<th>查看</th>
						</tr>
						<tbody class="middle_info">
     	 				<!-- ajax传回来的值 -->
							
						</tbody>
					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 25px; line-height: 25px;">
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
						
							<input onclick="companyAreadyRentedList(1)" type="button" value="首页" class="ui_input_btn01" />
							<input onclick="prePage()" type="button" value="上一页" class="ui_input_btn01" />
							<input onclick="nextPage()" type="button" value="下一页" class="ui_input_btn01"/>
							<input onclick="endPage()" type="button" value="尾页" class="ui_input_btn01"/>
						
						
						
						<!--     如果是最后一页，则只显示首页、上一页 -->
						
						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" />页
							 <input type="button" class="ui_input_btn01" value="跳转" onclick="jump()" />
					</div>
				</div>
			</div>
		</div>
				
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>

    
     <script>
     	function send(ppage){
     		$.ajax({
     			url:"/CBDParkingManagementSystem/checkTenantTradeInfor.do",
				type:"post",
				data:{
					"page":ppage
				},
				dataType:"json",
     			success:function(data){
     				/* alert(data); */
					var trades = data.list;
					var totalPage = data.totalPage;
					var num = data.num;
					var content = "";
					
					for(var i=0;i<trades.length;i++){
						var trade = trades[i];
						/* alert(trade.cStatus); */
						content += "<tr>"
								+"<td><input type='checkbox' name='IDCheck' value='14458579642011' class='acb' /></td>"
				     			+"<td>"+trade.tradeOrder+"</td>"
				     			+"<td>"+trade.tradeTime+"</td>"
				     			+"<td>"+trade.partingSpace.addr+"</td>"
				     			+"<td>"+trade.partingSpace.carNum+"</td>"
				     			+"<td>"+trade.rentInfor.startTime+"</td>"
				     			+"<td>"+trade.rentInfor.endTime+"</td>"
				     			+"<td>"+trade.rentInfor.price+"</td>"
				     			+"<td>"+trade.landLady.name+"</td>"
				     			+"<td><span class='point' onclick='orderAndBfer("+trade.id+","+trade.landLady.id+")'>我要投诉</span></td>"
				    			+"<td><span class='point' onclick='seeComplain("+trade.id+","+trade.landLady.id+")'>查看</span></td>"
		     					+"</tr>";
					}
					$(".middle_info").html(content);
					$("#currentpage").html(ppage);
					$("#totalpage").html(totalPage);
					$("#num").html(num);
     			}
     		});
     	}
     	<!-- 进行方法调用 -->
     	send(1);
     	function orderAndBfer(trade_id1,rent_id1){
     	$.ajax({
     	url:"/CBDParkingManagementSystem/orderAndBfer.do",
    			type:"post",
    			data:{
    			  trade_id:trade_id1,
    			  rent_id:rent_id1,
    			 
    			},
    			success:function(message){
    			   if(message=="success"){
                    window.location.href='/CBDParkingManagementSystem/jsp/AddComplain.jsp';
                  }
    			}
    			});
     	}
     	function seeComplain(oor_id,rren_id){
     	$.ajax({
     	url:"/CBDParkingManagementSystem/seeComplain.do",
    			type:"post",
    			data:{
    			  or_id:oor_id,
    			  ren_id:rren_id
    			},
    			success:function(message){
    			   if(message=="success"){
                    window.location.href='/CBDParkingManagementSystem/jsp/SeeComplain.jsp';
                  }
    			}
     	});
     	}
		function prePage(){
		//	alert("pre");
			var current=$("#currentpage").html();
			var currentPage=parseInt(current);
			if(currentPage > 1){
				send(currentPage - 1);
			}
		}
		function nextPage(){
		//	alert("next");
			var current=$("#currentpage").html();
			var currentPage=parseInt(current);
			var total=$("#totalpage").html();
			var totalPage=parseInt(total);
			if(currentPage < totalPage){
				send(currentPage + 1);
			}
		}
		function endPage(){
		//	alert("end");
			var total=$("#totalpage").html();
			var totalPage=parseInt(total);
			send(totalPage);
		}
		function jump(){
			//先获取input框用户输入的值
			var jumpValue = parseInt($("#jumpNumTxt").val());
			var total = parseInt($("#totalpage").html());
			/* alert(jumpValue);
			alert(total); */
			if(jumpValue >= 1 && jumpValue <= total){
				send(jumpValue);
			}
		}
	
     </script>
 
</body>
</html>