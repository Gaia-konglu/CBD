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
<script type="text/javascript" src="../scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="../scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="../scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="../style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="../scripts/artDialog/artDialog.js?skin=default"></script>
<title>信息管理系统</title>
<style>
	#box_top{
		background-color:#f3f2f0;
		color:#757370;
	}
</style>
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

	/** 普通跳转 **/
	function jumpNormalPage(page){
		$("#submitForm").attr("action", "house_list.html?page=" + page).submit();
	}
	
	
</script>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<form id="submitForm" name="submitForm" action="" method="post">
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
		
		<div>您所属企业：${sessionScope.companyBean.name}<br/>
		
		<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
						<!-- <form action="" method="post"> -->
							车位位置
							<input placeholder="请输入" name="fangyuanEntity.fyXqCode" id="fyXq" class="ui_select01" onchange="getFyDhListByFyXqCode();"/> 
							车位号
							<input placeholder="请输入" name="fangyuanEntity.fyDhCode" id="fyDh" class="ui_select01"/>
							合同编号
							<input placeholder="请输入" name="fangyuanEntity.fyHxCode" id="fyHx" class="ui_select01"/>
							合同开始时间
							<input type="date" name="fangyuanEntity.fyStatus" id="fyStatus" class="ui_select01"/>
                                                                                    合同结束时间
                            <input type="date" name="fangyuanEntity.fyStatus" id="fyStatus2" class="ui_select01"/>
                            <input type="button" value="查询" class="ui_input_btn01" onclick="search();" />
						</div>
					</div>
				</div>
			</div>
			
		
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr class="thead">
							<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
							</th>
							<th>车位位置</th>
							<th>车位号</th>
							<th>合同编号</th>
							<th>合同开始时间</th>
							<th>合同结束时间</th>
						</tr>
						<tbody class="middle_info">
     	 				<!-- ajax传回来的值 -->
							<!-- <tr>
								<td><input type="checkbox" name="IDCheck" value="14458579642011" class="acb" /></td>
								<td>城中区</td>
								<td>瑞景河畔16号楼1-111</td>
								<td>65.97㎡</td>
								<td>65.97㎡</td>
								<td>一室一厅一卫</td>
							</tr> -->
						</tbody>
					</table>
				</div>
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
	</form>
	 <input id="addr" type="hidden"/>
	<input id="p_number" type="hidden"/>
	<input id="b_number" type="hidden"/>
	<input id="start_time" type="hidden"/>
	<input id="end_time" type="hidden"/> 
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
<input id="companyName" type="hidden" value="${sessionScope.name}"/>
     <script>
     	function companyAreadyRentedList(ppage){
     		/* var jsonobj = {"name":"${sessionScope.name}"}; */
     		$.ajax({
     			url:"/CBDParkingManagementSystem/alreadyRent.do",
				type:"post",
				data:{
					page:ppage,
					addr:$("#addr").val(),
					p_number:$("#p_number").val(),
					b_number:$("#b_number").val(),
					start_time:$("#start_time").val(),
					end_time:$("#end_time").val(),
					/* flag:$("#flag").val(), */
				},
				dataType:"json",
     			success:function(data){
     				/* alert(data); */
					var carports = data.list;
					var totalPage = data.totalPage;
					var num = data.num;
					var content = "";
					for(var i=0;i<carports.length;i++){
						var carport = carports[i];
						content += "<tr>"
								+"<td><input type='checkbox' name='IDCheck' value='14458579642011' class='acb' /></td>"
				     			+"<td>"+carport.adress+"</td>"
				     			+"<td>"+carport.carNum+"</td>"
				     			+"<td>"+carport.crc.number+"</td>"
				     			+"<td>"+carport.crc.startTime+"</td>"
				     			+"<td>"+carport.crc.endTime+"</td>"
		     					+"</tr>";
					}
					$(".middle_info").html(content);
					$("#currentpage").html(ppage);
					$("#totalpage").html(totalPage);
					$("#num").html(num);
					/* $("#flag").val(""); */
     			}
     		});
     	}
     	<!-- 进行方法调用 -->
     	companyAreadyRentedList(1);
		function prePage(){
		//	alert("pre");
			var current=$("#currentpage").html();
			var currentPage=parseInt(current);
			if(currentPage > 1){
				companyAreadyRentedList(currentPage - 1);
			}
		}
		function nextPage(){
		//	alert("next");
			var current=$("#currentpage").html();
			var currentPage=parseInt(current);
			var total=$("#totalpage").html();
			var totalPage=parseInt(total);
			if(currentPage < totalPage){
				companyAreadyRentedList(currentPage + 1);
			}
		}
		function endPage(){
		//	alert("end");
			var total=$("#totalpage").html();
			var totalPage=parseInt(total);
			companyAreadyRentedList(totalPage);
		}
		function jump(){
			//先获取input框用户输入的值
			var jumpValue = parseInt($("#jumpNumTxt").val());
			var total = parseInt($("#totalpage").html());
			/* alert(jumpValue);
			alert(total); */
			if(jumpValue >= 1 && jumpValue <= total){
				companyAreadyRentedList(jumpValue);
			}
		}
		/** 模糊查询企业已租赁车位 **/
		/* var flag = ""; */
		function search(){
			var addr = $("#fyXq").val();
			var p_number = $("#fyDh").val();
			var b_number = $("#fyHx").val();
			var start_time = $("#fyStatus").val();
			var end_time = $("#fyStatus2").val();
			/* flag = "search"; */
			$("#addr").val(addr);
			$("#p_number").val(p_number);
			$("#b_number").val(b_number);
			$("#start_time").val(start_time);
			$("#end_time").val(end_time);
			/* $("#flag").val(flag); */
			companyAreadyRentedList(1);
		}
     </script>
     <!-- 设置翻页按钮 -->
     <!-- <div class="bottom_buttons">
    		<button name="first" onclick="companyAreadyRentedList(1)">首页</button>
    		<button name="top" onclick="prePage()">上一页</button>
    			<button>
    				<span id="currentpage">1</span>/
    				<span id="totalpage">0</span>
    			</button>
    		<button name="down" onclick="nextPage()">下一页</a></button>
    		<button name="last" onclick="endPage()">末页</button>
		</div> -->
</body>
</html>