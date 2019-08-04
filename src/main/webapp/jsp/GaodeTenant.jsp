<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'GaodeTenant.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
 html,
    body {
        height: 100%;
        margin: 0;
        width: 100%;
        padding: 0;
        overflow: hidden;
        font-size: 13px;
    }
    
    .map {
        height: 100%;
        width: 100%;
       /*  float: left; */
    }
    
        #right {
        color: #444;
        background-color: #f8f8f8;
        width: 30%;
        height: 80%;
        float: left;
    }
    
    #start,
    #stop,
    #right input {
        margin: 4px;
        margin-left: 15px;
    }
    
    .title {
        width: 96%;
        background-color: #dadada
    }
    
    button {
        border: solid 1px black;
        width:200px;
        height:50px;
       
    }
    
    .c {
        font-weight: 600;
        padding-left: 15px;
        padding-top: 4px;
    }
    
    #lnglat,
    #address,
    #nearestJunction,
    #nearestRoad,
    #nearestPOI,
    .title {
        padding-left: 15px;
    }
    </style>
  </head>
   <script src="/CBDParkingManagementSystem/js/jquery.1.9.1.js"></script>
  <body>
    <div id="container" class="map" tabindex="0"></div>
<!--      <div id='right'>
        <div>
            <div class='title'>开始时间:</div>
            <div ><input id='startTime' type="text" name="startTime" /></div>
            <div class='c'>结束时间:</div>
            <div ><input id='endTime' type="text" name="endTime" /></div>
            <div class='c'>关键字:</div>
            <div ><input id='keyword' type="text" name="keyword" /></div>
      		<div><button onclick="send()">提交</button></div>
      		<div id="lnglat" ></div>
        </div>
    </div> -->
    <script type="text/javascript" src='//webapi.amap.com/maps?v=1.4.10&key=44b8531837a793c477c3b32159813997&plugin=AMap.ToolBar'></script>
  <script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
     <script type="text/javascript">
        var map = new AMap.Map('container', {
           resizeEnable: true,
           zoom:15
        });
     	AMap.plugin('AMap.ToolBar',function(){
           var toolbar = new AMap.ToolBar();
           map.addControl(toolbar)
        });
        
        var marker =new AMap.Marker({
    				position: new AMap.LngLat(104.078395,30.649734),   
    				title: '北京'
					});
		
        map.add(marker);
        
        function send(){
     		$.ajax({
     			url:"showGaodeInfor.do",
				type:"post",
				data:{
					"startTime":$("#startTime").val(),
					"endTime":$("#endTime").val(),
					"keyword":$("#keyword").val()
				},
				dataType:"json",
     			success:function(data){
     			var rents=data.list;
     			var content="";
     			var markerList = [];
				for(var i = 0;i<rents.length;i++){
					var rent = rents[i];
					markerList[i] =new AMap.Marker({
    				position: new AMap.LngLat(rent.personCarSpaceInfor.lng,rent.personCarSpaceInfor.lat)  
    				
					});
					/* content+="<div>"
							+rent.personCarSpaceInfor.lnglat
							+"</div>"
							+"<div>"
							+rent.personCarSpaceInfor.lng
							+"</div>"
							+"<div>"
							+rent.personCarSpaceInfor.lat
							+"</div>" */
				}
				/* $("#lnglat").html(content); */
				map.add(markerList);
			}
     		});
     	}
        send();
        
        //// 创建一个 Marker 实例：
    /*  var marker1 = new AMap.Marker({
    position: new AMap.LngLat(104.069748,30.658724),   
    title: '北京'
	});
	 var marker2 = new AMap.Marker({
    position: new AMap.LngLat(104.053332,30.669983),   
    title: '北京'
	});
	 var marker3 = new AMap.Marker({
    position: new AMap.LngLat(104.065735,30.65948),   
    title: '北京'
	}); */
	
	// 多个点实例组成的数组
	/* var markerList = [marker1, marker2, marker3]; */
	// 将创建的点标记添加到已有的地图实例：
/* 	map.add(markerList); */
	
    </script>

  </body>
</html>
