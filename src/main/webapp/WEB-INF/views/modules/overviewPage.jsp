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

    <%--=========================================CSS=========================================--%>
    <%--第三方插件--%>
    <link rel="stylesheet" href="<%=path%>/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/static/font-awesome/css/font-awesome.min.css">
    <%--自定义--%>
    <link rel="stylesheet" href="<%=path%>/static/custom/css/common-styles.css">
    <%--=========================================JS=========================================--%>
    <%--第三方插件--%>
    <script src="<%=path%>/static/jquery/jquery-3.3.1.min.js"></script>
    <script src="<%=path%>/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/static/echarts/echarts.min.js"></script>
    <script src="<%=path%>/static/metisMenu/js/metisMenu.min.js"></script>
    <%--自定义--%>
    <script src="<%=path%>/static/custom/js/change-style.js"></script>
    <script src="<%=path%>/static/custom/js/grape-charts.js"></script>
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
        showMounthDatas();
        changeActiveMenu("overview");
    });
</script>
</body>
</html>