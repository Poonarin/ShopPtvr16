<%-- 
    Document   : showLogin
    Created on : Dec 17, 2018, 3:55:02 PM
    Author     : Anastasia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/showLogin.css">
        <title>Вход в систему</title>
    </head>
    <body>
        <div style="text-align: center; font-family: cursive"><h1>Вход в систему</h1>
        ${info}<hr><br>
        <form action="login" method="POST" name="form1" id="_form1">
             Логин:<br>
            <input type="text" name="login"><br>
            <br>
             Пароль:<br>
            <input type="password" name="password"><br>
            <br>
            <input type="submit" value="Войти">
        </form><br><br>
        <a href="newCustomer">Зарегистрироваться </a>
        <br>
        <a href="/Shop">На главную</a></div>
        <script src="${pageContext.request.contextPath}/js/showLogin.js"></script>
        </form><br>
    </body>
</html>
