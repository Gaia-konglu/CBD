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
<script type="text/javascript">
	$(document).ready(function(){
		/** 新增   **/
	    $("#addBtn").fancybox({
	    	'href'  : 'house_edit.html',
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : false,
	        'onClosed' : function() { 
	        	window.location.href = 'house_list.html';
	        }
	    });
		
	    /** 导入  **/
	    $("#importBtn").fancybox({
	    	'href'  : '/xngzf/archives/importFangyuan.action',
	    	'width' : 633,
	        'height' : 260,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : false,
	        'onClosed' : function() { 
	        	window.location.href = 'house_list.html';
	        }
	    });
		
	    /**编辑   **/
	    $("a.edit").fancybox({
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : false,
	        'onClosed' : function() { 
	        	window.location.href = 'house_list.html';
	        }
	    });
	});
	/** 用户角色   **/
	var userRole = '';

	/** 模糊查询来电用户  **/
	function search(){
		$("#submitForm").attr("action", "house_list.html?page=" + 1).submit();
	}

	/** 新增   **/
	function add(){
		$("#submitForm").attr("action", "/xngzf/archives/luruFangyuan.action").submit();	
	}
	 
	/** Excel导出  **/
	function exportExcel(){
		if( confirm('您确定要导出吗？') ){
			var fyXqCode = $("#fyXq").val();
			var fyXqName = $('#fyXq option:selected').text();
//	 		alert(fyXqCode);
			if(fyXqCode=="" || fyXqCode==null){
				$("#fyXqName").val("");
			}else{
//	 			alert(fyXqCode);
				$("#fyXqName").val(fyXqName);
			}
			$("#submitForm").attr("action", "/xngzf/archives/exportExcelFangyuan.action").submit();	
		}
	}
	
	/** 删除 **/
	function del(fyID){
		// 非空判断
		if(fyID == '') return;
		if(confirm("您确定要删除吗？")){
			$("#submitForm").attr("action", "/xngzf/archives/delFangyuan.action?fyID=" + fyID).submit();			
		}
	}
	
	/** 批量删除 **/
	function batchDel(){
		if($("input[name='IDCheck']:checked").size()<=0){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'至少选择一条', ok:true,});
			return;
		}
		// 1）取出用户选中的checkbox放入字符串传给后台,form提交
		var allIDCheck = "";
		$("input[name='IDCheck']:checked").each(function(index, domEle){
			bjText = $(domEle).parent("td").parent("tr").last().children("td").last().prev().text();
// 			alert(bjText);
			// 用户选择的checkbox, 过滤掉“已审核”的，记住哦
			if($.trim(bjText)=="已审核"){
// 				$(domEle).removeAttr("checked");
				$(domEle).parent("td").parent("tr").css({color:"red"});
				$("#resultInfo").html("已审核的是不允许您删除的，请联系管理员删除！！！");
// 				return;
			}else{
				allIDCheck += $(domEle).val() + ",";
			}
		});
		// 截掉最后一个","
		if(allIDCheck.length>0) {
			allIDCheck = allIDCheck.substring(0, allIDCheck.length-1);
			// 赋给隐藏域
			$("#allIDCheck").val(allIDCheck);
			if(confirm("您确定要批量删除这些记录吗？")){
				// 提交form
				$("#submitForm").attr("action", "/xngzf/archives/batchDelFangyuan.action").submit();
			}
		}
	}

	
	
</script>
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
#btn1{
margin-left:140px;
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
    						<th>抢租客用户名</th>
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
				
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>

    
     <script>
     	function send(ppage){
     		$.ajax({
     			url:"/CBDParkingManagementSystem/checkTradeInfor.do",
				type:"post",
				data:{
					"page":ppage
				},
				dataType:"json",
     			success:function(data){
     			
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
				     			+"<td>"+trade.tenant.name+"</td>";
				     			
				     			+"<td><span class='point' onclick='orderAndBfer("+trade.id+","+trade.tenant.id+")'>我要投诉</span></td>"
				    			+"<td><span class='point' onclick='seeComplain("+trade.id+","+trade.tenant.id+")'>查看</span></td>"
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
    			  rent_id:rent_id1
    			},
    			success:function(message){
    			   if(message=="success"){
                    window.location.href="/CBDParkingManagementSystem/jsp/AddComplain.jsp";
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