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
							<th>车位产权证编号</th>
  							<th>车位所在小区地址</th>
  							<th>小区车位编号</th>
  							<th>提交时间</th>
  							<th>状态</th>
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
        			<div class="text">确定删除本条信息吗？</div>
        			<input type="hidden" id="partId" name="pid"/>
        			<button onclick="deletePart()">确定</button>
        			<button class="btn" onclick="closeDialog()">退出</button>
    			</div>
	
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>

    
     <script>
    
		
     	function send(ppage){
     		$.ajax({
     			url:"/CBDParkingManagementSystem/showMyPart.do",
				type:"post",
				data:{
					"page":ppage
				},
				dataType:"json",
     			success:function(data){
					var parts = data.list;
					var totalPage = data.totalPage;
					var num = data.num;
					var content = "";
					var status="";
					var text="";
					for(var i=0;i<parts.length;i++){
						var part = parts[i];
						content += "<tr>"
								+"<td><input type='checkbox' name='IDCheck' value='14458579642011' class='acb' /></td>"
				     			+"<td>"+part.propertyNum+"</td>"
				     			+"<td>"+part.addr+"</td>"
				     			+"<td>"+part.carNum+"</td>"
				     			+"<td>"+part.time+"</td>"
				     			+"<td>"
				     			if(part.status == 1){
				     			status = "车位已审核";
				     			content += status; 
				     			}
				     			else if (part.status == 0){
				     			status = "车位待审核";
				     			content += status; 
				     			}
		     			content+="</td>"
				    			+"<td><span class='point' onclick='openDialog("+part.id+")'>删除</span></td>"
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
     	function deletePart(){
    		$.ajax({
    			url:"/CBDParkingManagementSystem/deletePart.do",
    			type:"post",
    			data:{
    			"pid":$("#partId").val()
    			},
    			success:function(message){
    			if(message=="success"){
					closeDialog();
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
    function openDialog(pid) {
    	demobg.style.display="block";
        demotxt.style.display="block";
 		document.getElementById("partId").value=pid;
    }
    function closeDialog() {
        demotxt.style.display = "none";
        demobg.style.display = "none";
    }
     </script>
 
</body>
</html>