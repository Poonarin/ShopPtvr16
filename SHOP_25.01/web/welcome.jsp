<%-- 
    Document   : welcome
    Created on : Dec 6, 2018, 2:10:21 PM
    Author     : Sanata
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href = "${pageContext.request.contextPath}/css/welcome.css">
        <title>Home</title>
    </head>
    <body><!-------->
        <h1>Навигация по сайту</h1>
         ${textToPage}<br>
        <p><a href="showLogin">Войти в систему</a></p>
        <p><a href="logout">Выйти из системы</a></p>
        <hr>
        <p><a href="showProducts"> Список товаров</a></p>
        <p>Для администратора:</p>
        <p><a href="newProduct"> Добавить товар</a></p>
        <p><a href="newCustomer"> Добавить покупателя</a></p>
        
        <p><a href="showCustomers"> Список покупателей</a></p>
        <p><a href="purchase">Продать товар покупателю</a></p>
        <p><a href="showTakeProduct">Список проданного товара</a></p>
        <!------>
      
        <h3>Товар добавлен:</h3> <!--- ${product}--->
        <b>Название -</b>  ${product.name}<br>   
        <b>Цена -</b>  ${product.price} euro<br>
        <b>Количество - </b>  ${product.count} tk
        <br><br>
        
        <h3>Добавлен покупатель:</h3><!---   или все данные читател ${customer}--->
        <b>Имя -</b>  ${customer.name}<br>
        <b>Фамилия -</b>  ${customer.surname}<br>
        <b>Кредит-</b> ${customer.money}<br>
    </body>
</html>
