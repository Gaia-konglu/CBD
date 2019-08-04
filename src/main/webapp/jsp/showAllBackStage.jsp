<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAllBackStage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript"  src="./js/jquery.1.9.1.js" ></script>
  
  </head>
  
  <body>
  根据条件查询：
 
 工号： <input type="text" name="num" id="inum">
  姓名：<input type="text" name="name" id="iname">
  <input type="submit" value="查询" onclick="findBycondition(1)">
  
  <table>
  <thead>
  <tr>
  <td>工号</td>
   <td>密码</td>
    <td>姓名</td>
     <td>电话</td>
     <td>拥有权限</td>
     <td>操作</td>
  </tr>
  </thead>
  <tbody id="backStage">
  
  
   
  </tbody>
  
  </table>
  <br>
    <span>当前第<span id="nowpage"></span>页，共<span id="totalpage"></span>页。</span>
   <!-- 填充上一页和下一页 -->
    <span id="changepage"></span>
  
  <script type="text/javascript">
  
  function showback(page){
   var p=parseInt($("#totalpage").html());    
    if(page>p){
    
    page=p;
    
    }
 
    if(page<1){
    page=1;
    }  
  $.ajax({
  url:"findAllback.do",
  type:"post",
  data:{
  pageNow:page
  },
  dataType:"json",
  success:function(data){
  
  var content="";
  var backs=data.bsblist;
  var pb=data.pb;
  for(var i=0;i<backs.length;i++){
   var back=backs[i];
  var userMP="";
  var complainMP="";
  var carMP="";
  var pactMP="";

if(back.user_authority!='0'){
userMP="用户管理权限<br>";
}

if(back.complain_authority!='0'){
complainMP="投诉管理权限<br>";
}
if(back.car_authority!='0'){
carMP="车位管理权限<br>";
}
if(back.pact_authority!='0'){
pactMP="合同管理权限";

}


    
     content+="<tr>"+"<td>"+back.num+"</td>"
     +"<td>"+back.pass+"</td>"
     +"<td>"+back.name+"</td>"
     +"<td>"+back.phone+"</td>"
     +"<td>"+userMP+complainMP+carMP+pactMP+"</td>"
     +"<td>"+"<button onclick='gotoUpdatePage("+back.id+")'>修改权限</button>"+
     "<button onclick='deleteBack("+back.id+")'>删除</button>"+"</td>"
     +"</tr>";
       
  
  }
  $("#backStage").html(content);
  $("#totalpage").html(pb.totalPageCount);
		$("#nowpage").html(pb.pageNow)
	    var nowpage=parseInt(pb.pageNow);
	
	var content2="<a href='javascript:showback("+(nowpage-1)+")'>上一页</a><a href='javascript:showback("+(nowpage+1)+")'>下一页</a>";
		$("#changepage").html(content2);
  }
  
  
  
  });
  }
  showback(1);
function  gotoUpdatePage(id){

window.location.href="findBackByid.do?id="+id;
}

function findBycondition(page){
   var p=parseInt($("#totalpage").html());    
    if(page>p){
    
    page=p;
    
    }
 
    if(page<1){
    page=1;
    }  
  $.ajax({
  url:"findBycondition.do",
  type:"post",
  data:{
  pageNow:page,
  num:$("#inum").val(),
  name:$("#iname").val()
  },
  dataType:"json",
  success:function(data){
  
  var content="";
  var backs=data.bsblist;
  var pb=data.pb;
  for(var i=0;i<backs.length;i++){
   var back=backs[i];
  var userMP="";
  var complainMP="";
  var carMP="";
  var pactMP="";

if(back.user_authority!='0'){
userMP="用户管理权限<br>";
}

if(back.complain_authority!='0'){
complainMP="投诉管理权限<br>";
}
if(back.car_authority!='0'){
carMP="车位管理权限<br>";
}
if(back.pact_authority!='0'){
pactMP="合同管理权限";

}


    
     content+="<tr>"+"<td>"+back.num+"</td>"
     +"<td>"+back.pass+"</td>"
     +"<td>"+back.name+"</td>"
     +"<td>"+back.phone+"</td>"
     +"<td>"+userMP+complainMP+carMP+pactMP+"</td>"
     +"<td>"+"<button onclick='gotoUpdatePage("+back.id+")'>修改权限</button>"+"</td>"
     +"</tr>";
       
  
  }
  $("#backStage").html(content);
  $("#totalpage").html(pb.totalPageCount);
		$("#nowpage").html(pb.pageNow)
	    var nowpage=parseInt(pb.pageNow);
	
	var content2="<a href='javascript:showback("+(nowpage-1)+")'>上一页</a><a href='javascript:showback("+(nowpage+1)+")'>下一页</a>";
		$("#changepage").html(content2);
  }
  
  
  
  });
  }
  
  
  function deleteBack(did){
   $.ajax({
  url:"deleteBack.do",
  type:"post",
  data:{
  id:did
  },
  success:function(data){
  
  window.location.reload();
  
  }
  
  });
  }

  </script>
  
  </body>
</html>
