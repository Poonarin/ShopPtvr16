<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="css/page4.css"> 

        <title>JSP Page5</title> 
    </head> 
    <body> 
        <h1>Page 5</h1> 
        <a href="index.html">Главная страница</a> 

        <form action="registration" method="POST">
            Имя:
            <input type="text" name="name">
            Фамилия:
            <input type="text" name="surname">
            Email:
            <input type="text" name="email">
            <hr>
            Логин:
            <input type="text" name="login">
            <hr>
            Пароль:
            <input type="text" name="password1">
            Повторите пароль:
            <input type="text" name="password2">
            <hr>
            <input type="submit" value="Добавить">
            
        </form>

   

</body> 
</html>