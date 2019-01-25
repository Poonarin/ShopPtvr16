<%-- 
    Document   : listTakeProducts
    Created on : Oct 27, 2018, 11:22:48 PM
    Author     : Lenovo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listTakeProducts</title>
    </head>
    
    <body>
        <h3>Список проданного товара</h3>
        <form action="returnProduct" method="POST">
            <ul>
                <c:forEach var="purchase" items="${takeProducts}"><!-- конструкция списка, где каждый объект списка вставляется в переменную $(listProducts)-->
                    <li> Товар <b>"${purchase.product.name}"</b>по цене ${purchase.product.price} euro   - купил <b>
                                   ${purchase.customer.name} ${purchase.customer.surname} ; </b>в количестве - ${purchase.quantity} tk. &nbsp;&nbsp; 
                         <a href="returnProduct?purchaseId=${purchase.id}">     Удалить</a></li>
                       <!--- <input type="hidden" value="${purchase.id}" name="returnProductId">--->    <!---   "hidden" - для скрытия поля,передающего в обработку libHistory.id--->
                       <!--- <button type="submit">Пополнить товар на складе</button>--->
                    </li>  
                </c:forEach> 
            </ul>
        </form>
        <br><p><a href="home">Home</a><br><br>
    </body>
</html>
