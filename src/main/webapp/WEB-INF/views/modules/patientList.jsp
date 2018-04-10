<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test BootStrap</title>
    <link rel="stylesheet" href="<%=path%>/static/bootstrap/css/bootstrap.min.css">
    <script src="<%=path%>/static/js/jquery-3.3.1.min.js"></script>
    <script src="<%=path%>/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table">
    <caption>基本的表格布局</caption>
    <thead>
    <tr>
        <th>名称</th>
        <th>城市</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Tanmay</td>
        <td>Bangalore</td>
    </tr>
    <tr>
        <td>Sachin</td>
        <td>Mumbai</td>
    </tr>
    </tbody>
</table>
</body>
</html>