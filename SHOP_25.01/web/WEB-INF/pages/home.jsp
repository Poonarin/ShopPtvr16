<%-- 
    Document   : home
    Created on : Oct 27, 2018, 7:15:40 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href = "${pageContext.request.contextPath}/css/home.css">
        <title>Home</title>
    </head>
    <body><!-------->
        <h1>Навигация по сайту</h1>
        
        <a href="newProduct"> Добавить товар</a><br><br>
        <a href="newCustomer"> Добавить покупателя</a><br><br>
        <a href="showProducts"> Список товаров</a><br><br>
        <a href="showCustomers"> Список покупателей</a><br><br>
        <a href="purchase">Продать товар покупателю</a><br><br>
        <a href="showTakeProduct">Список проданного товара</a><br><br>
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
