<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

    <meta charset="utf-8">
    <title>Fullscreen Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/supersized.css">
    <link rel="stylesheet" href="/css/style1.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>

<div class="page-container">
    <h1>欢迎来到末端配送管理系统</h1>
    <form action="user/login" method="post">
        <input type="text" name="email" class="username" placeholder="请输入email">
        <span>${user_error_msg}</span>
        <input type="password" name="password" class="password" placeholder="请输入密码">
        <span>${password_error_msg}</span>
        <button type="submit">登录</button>

    </form>
    <!--  <div class="connect">
          <p>Or connect with:</p>
          <p>
              <a class="facebook" href=""></a>
              <a class="twitter" href=""></a>
          </p>
      </div> -->
</div>
<!-- <div align="center">Collect from <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a></div> -->

<!-- Javascript -->
<script src="/js/jquery-1.8.2.min.js"></script>
<script src="/js/supersized.3.2.7.min.js"></script>
<script src="/js/supersized-init.js"></script>
<script src="/js/scripts.js"></script>

</body>

</html>


