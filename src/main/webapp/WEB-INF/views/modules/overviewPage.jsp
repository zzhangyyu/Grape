<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Grape管理平台</title>
    <link rel="shortcut icon" href="<%=path%>/static/ico/favicon.png">

    <link rel="stylesheet" href="<%=path%>/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/static/custom/css/common-styles.css">
    <link rel="stylesheet" href="<%=path%>/static/font-awesome/css/font-awesome.min.css">
    <script src="<%=path%>/static/jquery/jquery-3.3.1.min.js"></script>
    <script src="<%=path%>/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/static/echarts/echarts.min.js"></script>
</head>

<body>
<%@include file="/WEB-INF/views/include/top.jsp" %>
<%@include file="/WEB-INF/views/include/left.jsp" %>

<div id="page-wrapper">
    <%@include file="/WEB-INF/views/include/header.jsp" %>
    <div id="page-inner">
        <div class="row">
            <div class="col-xs-6 col-md-4">
                <div class="panel panel-default">
                    <div id="chartExample" class="panel-body easypiechart-panel" style="height:400px;">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        showCharts();
    });

    function showCharts() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById("chartExample"));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '就诊人数-月视图',
                x: 'center'
            },
            tooltip: {},
            legend: {
                data: ['就诊人数'],
                x: 'right'
            },
            xAxis: {
                data: ["2018-01", "2018-02", "2018-03", "2018-04", "2018-05", "2018-06"]
            },
            yAxis: {},
            series: [{
                name: '就诊人数',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
</script>
</body>
</html>