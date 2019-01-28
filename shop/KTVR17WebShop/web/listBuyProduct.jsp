

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
                    <li>Покупка завершена
                         <a href="returnProduct?purchaseId=${purchase.id}"></a></li> 
            </c:forEach>
            </ul>
        </form>
    </body>
</html>
