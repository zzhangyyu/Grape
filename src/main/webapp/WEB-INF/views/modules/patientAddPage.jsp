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
    <%--开源库插件--%>
    <script src="<%=path%>/static/jquery/jquery-3.3.1.min.js"></script>
    <script src="<%=path%>/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/static/metisMenu/js/metisMenu.min.js"></script>
    <%--自定义--%>
    <script src="<%=path%>/static/custom/js/change-style.js"></script>

</head>
<body>
<%@include file="/WEB-INF/views/include/top.jsp" %>
<%@include file="/WEB-INF/views/include/left.jsp" %>

<div id="page-wrapper">
    <div class="header">
        <h1 class="page-header">
            <small>欢迎Admin</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li><a href="#">病历新增</a></li>
            <li class="active">Data</li>
        </ol>
    </div>
    <div id="page-inner">
        <div class="row">
            <form class="form-horizontal" role="form" id="add-patient_from" action="" method="post"
                  enctype="multipart/form-data">
                <div class="form-group">
                    <label class="col-md-1 control-label">*病人姓名：</label>
                    <div class="col-md-2">
                        <input name="patientName" id="patientName" value="${patientName}" type="text" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-1 control-label">*病人性别：</label>
                    <div class="col-md-1">
                        <select class="form-control">
                            <option>男</option>
                            <option>女</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-1 control-label">*病人年龄：</label>
                    <div class="col-md-2">
                        <input name="patientAge" id="patientAge" type="text" class="form-control" value="${patientAge}" disabled>
                    </div>
                </div>

                <div class="col-md-offset-3">
                    <button type="button" class="btn btn-info">放弃</button>
                    <button type="button" class="btn btn-info">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>

</script>

</body>
</html>