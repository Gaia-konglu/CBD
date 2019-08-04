<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FindAllIndividualCarport.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
        显示全部私人招租车位信息的JSP
    
     <table border = 1>
       <thead>
         <tr>
          <th>小区地址</th>
          <th>产权证编号</th>
          <th>车位编号</th>
          <th>产权证复印件</th>
         </tr>    
       </thead>
       <tbody>             
          <c:forEach items="${sessionScope.RentInforList }" var="obj">
				<tr>				  
				  <td> ${obj.addr} </td>
                   <td> ${obj.propertyNum} </td>             
                   <td> ${obj.carNum} </td>               
                   <td> <img src="/CBDParkingManagementSystem/img/${obj.copy}"> </td>
                   
                   <%-- <td> 
                   <a href="/Library/JSP/modifyBooks.jsp?bid=${obj.bid}"> 修改图书 </a>  <br/>
                    </td> --%>
				</tr>
			</c:forEach>
       </tbody>
       
    </table>
  
  ${sessionScope.RentInforList }
    
  </body>
</html>
