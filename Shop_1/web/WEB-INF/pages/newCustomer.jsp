<%-- 
    Document   : customer
    Created on : Dec 5, 2018, 1:58:59 PM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Покупатель</title>
    </head>
    <body>
         <div style="text-align: center; font-family: cursive"><h1>Добавляем нового покупателя</h1>
        <form action="addCustomer" method="POST" name="form1" id="_form1">
            Имя:<br>
            <input type="text" name="name"><br><br>
            Фамилия:<br>
            <input type="text" name="surname"><br><br>
            Деньги:<br>
            <input type="text" name="money"><br>
            <br>
            Логин:<br>
            <input type="text" name="login"><br><br>
            Пароль:<br>
            <input type="password" name="password1"><br><br>
            Повторите пароль:<br>
            <input type="password" name="password2">
            <br>
            <br><br>
            <input type="submit" value="Добавить"><br><br>
                <a href="/Shop">На главную</a> </div>
    </body>
</html>
