<%-- 
    Document   : newProduct
    Created on : Dec 5, 2018, 2:04:43 PM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <div style="text-align: center; font-family: cursive"> <title>Новый товар </title>
    </head>
    <body>
     <h1>Добавляем товар </h1>
     <hr><br>
        <form action="addProduct" method="POST" name="form1" id="_form1">
             Название:<br>
            <input type="text" name="name"><br><br>
             Цена товара:<br>
            <input type="text" name="price"><br><br>
             Количество товаров:<br>
            <input type="text" name="count"><br><br>
            <br>
            <input type="submit" value="Добавить"><br><br>
             <a href="/Shop">На главную</a></div>
        </form><br><br>
    </body>
</html>
