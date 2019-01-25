<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- библиотека  для создания шаблонов в HTML документе -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listCustomers</title>
    </head>
    <body>
        <h3>Список покупателей</h3>
        <ol type="1"><!---пронумерованный список можно по-другому см.файл listBooks.jsp --->
            <c:forEach var="customer" items="${listCustomers}"><!-- конструкция списка, где каждый объект списка вставляется в переменную $(listBooks) -->
                 <li>${customer.name}  ${customer.surname}</li>       
            </c:forEach>
        </ol>
        <p><a href="home">Home</a><br><br> 
    </body>
</html>
