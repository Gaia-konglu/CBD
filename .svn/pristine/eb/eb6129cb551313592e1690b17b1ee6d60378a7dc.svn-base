<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showcarport.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript" src="./js/jquery.1.9.1.js"></script>
  </head>
  
  <body>
   <table>
   <thead>
   <tr>
   <td>地址</td>
   <td>编号</td>
   </tr>
   </thead>
   <tbody id="carports">
   
   </tbody>
   
   </table>
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
		   +"<td>"+carport.adress+"</td>"
		   +"<td>"+carport.carNum+"</td>"
		   +"</tr>";
		}
		$("#carports").html(content);
		$("#totalpage").html(pb.totalPageCount);
		$("#nowpage").html(pb.pageNow)
	    var nowpage=parseInt(pb.pageNow);
	
	var content2="<a href='javascript:showAllCarport("+(nowpage-1)+")'>上一页</a><a href='javascript:showAllCarport("+(nowpage+1)+")'>下一页</a>";
		$("#changepage").html(content2);
		
		}    
    });
    }
    
    
    showAllCarport(1);
    </script>
    
    
  </body>
</html>
