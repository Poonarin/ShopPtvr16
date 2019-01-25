<%-- 
    Document   : newProduct
    Created on : Oct 27, 2018, 9:43:58 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>newProduct</title>
    </head>
    <body>
        <h1>Добавить в магазин новый товар</h1>
        <form action="addProduct" method="POST" name="form1" id="_form"  >
        Наименование товара<br>
        <p><input type="text" name="name" placeholder="name"  autofocus required ></p><!--autofocus required - поле для обязательного заполнения--> 
        Цена
        <p><input type="text" name="price" placeholder="price" required></p> 
        Количество
        <p><input type="text" name="count" placeholder="count"  autofocus required ></p><!----> 
        
        <input type="submit" name ="send" value="Добавить">				
        </form>	
        
        <br>
        <p><a href="home">Home</a><br><br>
        
    </body>
</html>
