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
<script src="/CBDParkingManagementSystem/js/jquery.1.9.1.js"></script>
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
#selects{
height:27px;
}
#text1{
margin-left:-50px;

}
</style>
</head>
<body>
	
		<div id="container">

		<div class="ui_content">
			
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top" style="background:#f3f2f0;font-weight: bold;color:#757370;">搜索</div>
						<div id="box_center">
							区域:
							<select id="selects" name="region">
  									<option value="">--请选择--</option>
                                	<option value="成都市武侯区">成都市武侯区</option>
                                	<option value="成都市青羊区">成都市青羊区</option>
                                    <option value="成都市高新区">成都市高新区</option>
                                	<option value="成都市成华区">成都市成华区</option>
  									<option value="成都市锦江区">成都市锦江区</option>
  									<option value="成都市金牛区">成都市金牛区</option>
  									<option value="成都市龙泉驿区">成都市龙泉驿区</option>
  									<option value="成都市青白江区">成都市青白江区</option>
  									<option value="成都市新都区">成都市新都区</option>
  									<option value="成都市温江区">成都市温江区</option>
  									<option value="成都市双流区">成都市双流区</option>
  									<option value="成都市郫都区">成都市郫都区</option>
  								</select>&nbsp&nbsp&nbsp
							开始时间:
							<input id="startTime" type="date" name="startTime">&nbsp&nbsp&nbsp
							结束时间:
							<input id="endTime" type="date" name="endTime">&nbsp&nbsp&nbsp
							<input type="button" value="查询" class="ui_input_btn01" onclick="send(1);" /> 
							<input type="button" value="删除" class="ui_input_btn01" onclick="batchDel();" /> 
						</div>
						
					</div>
				</div>
			</div>
			
		
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
							</th>
							<th>小区地址</th>
    						<th>车位编号</th>
    						<th>租借开始时间</th>
    						<th>租借结束时间</th>
    						<th>抢租客用户名</th>
    						<th>抢租客职业</th>
    						<th>抢租客电话</th>
    						<th>抢租客信誉度</th>
    						<th>抢租客留言</th>
    						<th>操作</th>
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
						
							<input onclick="send(1)" type="button" value="首页" class="ui_input_btn01" />
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
				<!--弹框  -->
				<div class='demo-bg'></div>
    			<div class='demo-txt'>
        			<div class="text" id="text1">预定成功，是否查看已预定车位信息？</div>
        			<button onclick="redirect()">是</button>
        			<button class="btn" onclick="closeDialog()">否</button>
    			</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
<input id="companyName" type="hidden" value="${sessionScope.name}"/>
     <script>
     	function send(ppage){
     		/* var jsonobj = {"name":"${sessionScope.name}"}; */
     		$.ajax({
     			url:"/CBDParkingManagementSystem/showAllRentInfor.do",
				type:"post",
				data:{
					"page":ppage,
					"startTime":$("#startTime").val(),
					"endTime":$("#endTime").val(),
					"region":$("#selects").val()
				},
				dataType:"json",
     			success:function(data){
     			
				var lists = data.list;
				var page = data.totalPage;
				var num = data.num;
				var content = "";
				for(var i = 0;i<lists.length;i++){
					var l = lists[i];
					content +="<tr>"
					             +"<td>"+"</td>"
								+"<td>"+l.personCarSpaceInfor.addr+"</td>"
    							+"<td>"+l.personCarSpaceInfor.carNum+"</td>"
    							+"<td>"+l.startTime+"</td>"
    							+"<td>"+l.endTime+"</td>"
    							+"<td>"+l.price+"</td>"
    							+"<td>"+l.landLady.name+"</td>"
    							+"<td>"+l.landLady.job+"</td>"
    							+"<td>"+l.landLady.credit+"</td>"
    							+"<td>"+"<input id='message"+l.id+"' type='text' name='message'/>"+"</td>"
    							+"<td>"
    							+"<span class='point' onclick='sendRent("+l.id +")'>预定</span>"
    							+"</td>"
    						+"</tr>"
				}
					$(".middle_info").html(content);
					$("#currentpage").html(ppage);
					$("#totalpage").html(page);
					$("#num").html(num);
     			}
     		});
     	}
     	<!-- 进行方法调用 -->
     	send(1);
     function sendRent(index){
		$.ajax({
			url:"/CBDParkingManagementSystem/addBookInfor.do",
			type:"post",
			data:{
			"rid":index,
			"page":$("#currentpage").html(),
			"message":$("#message"+index).val()
			},
			success:function(message){
			if(message=="success"){
					openDialog();
					current=$("#currentpage").html();
    			 	send(current);    			
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
		var demobg = document.querySelector(".demo-bg");
    var demotxt = document.querySelector(".demo-txt");
    function openDialog() {
    	demobg.style.display="block";
        demotxt.style.display="block";
 		
    }
    function closeDialog() {
        demotxt.style.display = "none";
        demobg.style.display = "none";
    }
    function redirect(){
    window.location.href="/CBDParkingManagementSystem/checkPayBook.do";
    }
     </script>
 
</body>
</html>