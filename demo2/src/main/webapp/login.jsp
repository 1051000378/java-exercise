<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/11
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
    <div id="loginDiv" style="height: 350px">
        <form action="/brand-demo/loginServlet" method="post" id="form">
            <h1 id="loginMsg">LOGIN IN</h1>
            <div id="errorMsg">${login_msg}</div>
            <p>Username:<input id="username" name="username" type="text"></p>
            <p>Password:<input id="password" name="password" type="password"></p>
            <p>Remember:<input id="remember" name="remember" type="checkbox"></p>
            <div id="subDiv">
                <input type="submit" class="button" value="login up">
                <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
                <a href="register.html">没有账号？</a>
            </div>

        </form>
    </div>
</body>
</html>
