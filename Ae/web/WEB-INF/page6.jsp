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

        <form action="addNewBook" method="POST">
            Имя
            <input type="text" name="name">
            Фамилия
            <input type="text" name="surname">
            CODE
            <input type="text" name="code">
            <hr>
            <input type="submit" value="Добавить">
            
        </form>

   

</body> 
</html>