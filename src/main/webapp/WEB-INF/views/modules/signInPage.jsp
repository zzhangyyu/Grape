<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Grape管理平台</title>

    <link rel="shortcut icon" href="<%=path%>/static/ico/favicon.png">
    <!--CSS-->
    <link rel="stylesheet" href="<%=path%>/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/static/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path%>/static/custom/css/form-elements.css">
    <link rel="stylesheet" href="<%=path%>/static/custom/css/signInPage.css">

    <!--JS-->
    <script src="<%=path%>/static/jquery/jquery-3.3.1.min.js"></script>
    <script src="<%=path%>/static/jquery/jquery.backstretch.min.js"></script>
    <script src="<%=path%>/static/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Grape</strong>管理平台</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to our site</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" onsubmit="return checkSignIn()" action="welcomePage" method="post"
                              class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="userName" placeholder="请输入用户名..." class="form-control"
                                       id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="请输入密码..." class="form-control"
                                       id="form-password">
                            </div>
                            <button type="submit" class="btn" id="signInBtn">登录!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" id="errorMsg" value="${errorMsg}"/>
</div>

<script>
    $(function () {
        $.backstretch("<%=path%>/static/img/homePageBg.jpg"); //背景
        alertErrorMsg();
    });

    function alertErrorMsg() {
        var errorMsg = $('#errorMsg').val();
        if (errorMsg != null && errorMsg != '') {
            alert(errorMsg);
            $('#errorMsg').val("");
        }
    }

    function checkSignIn() {
        var username = document.getElementById("form-username");
        var password = document.getElementById("form-password");
        if (username.value == "") {
            alert("请输入用户名！");
            return false;
        }
        else if (password.value == "") {
            alert("请输入密码！");
            return false;
        } else {
            return true;
        }
    }
</script>
</body>
</html>