<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
    <head>
        <meta charset="utf-8"><link rel="icon" href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            /* css 代码  */
        </style>
        <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
        <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
        <script src="https://img.hcharts.cn/highcharts/modules/oldie.js"></script>
        <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
    </head>
    <body>
        <div id="container" style="min-width:800px;height:800px"></div>
        <script>
            var chart = Highcharts.chart('container', {
    chart: {
        type: 'bar'
    },
    title: {
        text: '各页面访问次数和平均耗时'
    },
    subtitle: {
        text: '数据来源: Wikipedia.org'
    },
    xAxis: {
    
 
        categories: [
         <c:forEach items="${sessionScope.List }" var="obj">
        '${obj.webpage}',
        </c:forEach>
        ],
        title: {
            text: null
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: '',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    },
    tooltip: {
        valueSuffix: ''
    },
    plotOptions: {
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'top',
        x: -40,
        y: 200,
        floating: true,
        borderWidth: 1,
        backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
        shadow: true
    },
    series: [{
        name: '访问次数',
        data: [
        <c:forEach items="${sessionScope.List }" var="obj">
        ${obj.wcount},
        </c:forEach>
        ]
    }, {
        name: '平均耗时',
        data: [
        <c:forEach items="${sessionScope.List }" var="obj">
        ${obj.htime},
        </c:forEach>
        ]
    }, {
        name: '耗时小于500的次数',
        data: [
        <c:forEach items="${sessionScope.List }" var="obj">
        ${obj.goodcount},
        </c:forEach>
        ]
    }]
});
        </script>
    </body>
    <a href="index.jsp">返回首页</a>
</html>