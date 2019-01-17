<%-- 
    Document   : listPaid
    Created on : Dec 5, 2018, 2:50:06 PM
    Author     : pupil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Список оплаченных товаров</h1>
        ${info}
        <form action="returnProduct" method="POST">
            <ul>
           <c:forEach var="purchase" items="${buyProducts}">
                    <li>Товар: ${purchase.product.name} куплен: ${purchase.customer.name} ${purchase.customer.surname}</li> 
            </c:forEach>
            </ul>
        </form>
    </body>
</html>
