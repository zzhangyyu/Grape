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
</head>

<body>
<%@include file="/WEB-INF/views/include/top.jsp" %>
<%@include file="/WEB-INF/views/include/left.jsp" %>

<div id="page-wrapper">
    <div class="header">
        <h1 class="page-header">
            <small>欢迎Admin</small>
        </h1>
    </div>
</div>

</body>
</html>