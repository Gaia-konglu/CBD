<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addCarportSuccess.jsp' starting page</title>
    <meta http-equiv="refresh" content="3;url=jsp/showcarport2.jsp" />
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
   添加成功！ <br>

	<div class="container">
		<h3>提示内容</h3>
		<p>
			<span>页面自动跳转至查询陀</span> <a href="jsp/showcarport2.jsp">跳转</a> <span>等待时间：</span>
			<span class="second">3</span>
		</p>
		</section>
		<!-- END MAIN CONTENT -->
	</div>
	<script type="text/javascript">$(function() {
			var wait = $(".second").html();
			timeOut(); /**			 * 实现倒计时			 */
			function timeOut() {
				if (wait != 0) {
					setTimeout(function() {
						$('.second').text(--wait);						timeOut();
					}, 1000);
				}
			}
		});
	</script>



</body>
</html>
