<%-- 
    Document   : newRole
    Created on : Dec 4, 2018, 2:31:34 PM
    Author     : Sanata
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новaя роль</title>
    </head>
    <body>
        <h1>Добавить новую роль</h1>
        ${info}
        <form action="addRole" method="POST" name="form1" id="_form1">
             <p>Имя роли :<br><input type="text" name="nameRole">
            <p><input type="submit" value="Добавить"></p>
        </form>
        <hr>
        <p><button><a href="welcom">Home</a></button></p>
        
    </body>
</html>
