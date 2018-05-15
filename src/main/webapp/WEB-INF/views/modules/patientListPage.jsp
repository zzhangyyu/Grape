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
    <link rel="stylesheet" href="<%=path%>/static/dataTables/css/dataTables.bootstrap.css">
    <%--自定义--%>
    <link rel="stylesheet" href="<%=path%>/static/custom/css/common-styles.css">

    <%--=========================================JS=========================================--%>
    <%--开源库插件--%>
    <script src="<%=path%>/static/jquery/jquery-3.3.1.min.js"></script>
    <script src="<%=path%>/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/static/dataTables/js/jquery.dataTables.min.js"></script>
    <script src="<%=path%>/static/dataTables/js/dataTables.bootstrap.min.js"></script>
    <script src="<%=path%>/static/metisMenu/js/metisMenu.min.js"></script>
    <%--自定义--%>
    <script src="<%=path%>/static/custom/js/change-style.js"></script>

</head>
<body>
<%@include file="/WEB-INF/views/include/top.jsp" %>
<%@include file="/WEB-INF/views/include/left.jsp" %>

<input type="hidden" name="browserPatientBriefInfoList" id="browserPatientBriefInfoList"
       value="${browserPatientBriefInfoList}"/>

<div id="page-wrapper">
    <div class="header">
        <h1 class="page-header">
            病人管理
            <small>欢迎Admin</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li><a href="#">病人管理</a></li>
            <li class="active">Data</li>
        </ol>
    </div>
    <div id="page-inner">
        <div class="row">
            <form id="import-patient_from" action="<%=path%>/console/importPatientInfo" method="post"
                  enctype="multipart/form-data">
                <div class="col-md-offset-9 panel-heading">
                    <input id="show-patient-info-file-name" class="input-large" type="text" style="height:25px;">
                    <label for="patient-info-file" class="btn btn-info">导入</label>
                    <input id="patient-info-file" name="patientInfoFile" type="file" style="display:none"/>
                    <button id="saveBtn" class="btn btn-info">保存</button>
                </div>
            </form>
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Advanced Tables
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-patient">
                                <thead>
                                <tr>
                                    <th>病人姓名</th>
                                    <th>性别</th>
                                    <th>年龄</th>
                                    <th>就诊次数</th>
                                    <th>上次就诊时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="odd gradeX">
                                    <td>Trident</td>
                                    <td>男</td>
                                    <td>23</td>
                                    <td class="center">4</td>
                                    <td class="center">2018-05-01</td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>Lucy</td>
                                    <td>女</td>
                                    <td>15</td>
                                    <td class="center">2</td>
                                    <td class="center">2017-09-08</td>
                                </tr>
                                <c:forEach var="browserPatientBriefInfo" items="${browserPatientBriefInfoList}">
                                    <tr class="odd gradeX">
                                        <td>${browserPatientBriefInfo.patientName}</td>
                                        <td>${browserPatientBriefInfo.patientSex}</td>
                                        <td>${browserPatientBriefInfo.patientAge}</td>
                                        <td>000</td>
                                        <td>000</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        changeActiveMenu("patient");

        $('#patient-info-file').change(function () {
            $('#show-patient-info-file-name').val($(this).val());
        });

        $('#saveBtn').click(function () {

        });
        $('#dataTables-patient').dataTable(
            {
                searching: false,
                ordering: false,
                lengthChange: false,
                pagingType: "full_numbers",
                language: {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "显示 _MENU_ 项结果",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                }
            }
        );
    });

</script>

</body>
</html>