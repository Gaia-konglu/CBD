<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Gaode.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 
 
 <style type="text/css">
/* input{
width:300px;
height:25px;
} */
.selects{
width:170px;
height:30px;
}  
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
        width: 70%;
        float: left;
    }
    
    #right {
        color: #444;
        background-color: #f8f8f8;
        width: 30%;
        height: 100%;
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
        background-color: #dadada;
        height:30px;
        text-align:center;
        line-height:30px;
    }
    
    button {
        border: solid 1px;
        margin-left: 15px;
        background-color: #dadafa;
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
 .result input{
 width:350px;
height:25px;
 }

 </style>
 
  </head>
  
  <body>	
    <div id="container" class="map" tabindex="0"></div>
    <div id='right'>
        <div>
            <div class='title'>选择模式</div>
            <input class="radio" type='radio' name='mode' value='dragMap' checked>拖拽地图模式</input>
            </br>
            <input class="radio" type='radio' name='mode' value='dragMarker'>拖拽标记模式</input>
        </div>
        <div>
            <button id='start'>开始选点</button>
            <button id='stop'>关闭选点</button>
        </div>
        <div class="result">
            <div class='title'>选址结果</div>
            <form action="/CBDParkingManagementSystem/addPartingSpace.do" method="post" enctype = "multipart/form-data">
            <div class='c'>小区地址:</div>
            <div ><input id='address' type="text" name="addr" /></div>
            <!-- <div class='c'>小区经纬:</div> -->
            <div ><input id='lnglat' type="hidden" name="lnglat" /></div>
            <div class='c'>车位产权证编号:</div>
            <div><input type="text" name="propertyNum" /></div>
            <div class='c'>小区车位编号:</div>
            <div><input  type="text" name="carNum" "/></div>
            <div class='c'>产权复印件:</div>
            <div ><input  type="file" name="imgFile"/></div>
            <button type="submit">提交申请</button>
            </form>
            
        </div>
    </div>
   
   
  <script type="text/javascript" src='//webapi.amap.com/maps?v=1.4.10&key=44b8531837a793c477c3b32159813997'></script>
  <script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
  <script type="text/javascript">
    AMapUI.loadUI(['misc/PositionPicker'], function(PositionPicker) {
        var map = new AMap.Map('container', {
            zoom: 16,
            scrollWheel: false
        })
        var positionPicker = new PositionPicker({
            mode: 'dragMap',
            map: map
        });
        AMap.plugin('AMap.ToolBar',function(){
           var toolbar = new AMap.ToolBar();
           map.addControl(toolbar)
        });
		//TODO:事件绑定、结果处理等
        positionPicker.on('success', function(positionResult) {
          
            document.getElementById('address').value = positionResult.address;
    		document.getElementById('lnglat').value = positionResult.position;
        });
        positionPicker.on('fail', function(positionResult) {
            
            document.getElementById('address').value = ' ';
            document.getElementById('lnglat').value = '';
        });
        var onModeChange = function(e) {
            positionPicker.setMode(e.target.value)
        }
        var startButton = document.getElementById('start');
        var stopButton = document.getElementById('stop');
        var dragMapMode = document.getElementsByName('mode')[0];
        var dragMarkerMode = document.getElementsByName('mode')[1];
        AMap.event.addDomListener(startButton, 'click', function() {
            positionPicker.start(map.getBounds().getSouthWest())
        })
        AMap.event.addDomListener(stopButton, 'click', function() {
            positionPicker.stop();
        })
        AMap.event.addDomListener(dragMapMode, 'change', onModeChange)
        AMap.event.addDomListener(dragMarkerMode, 'change', onModeChange);
        positionPicker.start();
        map.panBy(0, 1);

       /*  map.addControl(new AMap.ToolBar({
            liteStyle: true
        })) */
    });
    </script>
    
  </body>
</html>
