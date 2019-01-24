<%-- 
    Document   : passChange
    Created on : Jan 24, 2019, 9:40:03 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Смена пароля</h1>
        <form action="changePassword" method="POST">
            <br>
            <p>Действующий пароль: </p><br>
            <input type="text" name="oldPass">
            <p>Новый пароль: </p><br>
            <input type="text" name="newPass1">
            <p>Подтвердите пароль: </p><br>
            <input type="text" name="newPass2">
            <br><br>
            <input type="submit" value="Подтвердить">
            
            
            </form>
    </body>
</html>
