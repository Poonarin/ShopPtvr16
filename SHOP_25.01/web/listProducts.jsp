<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- библиотека  для создания шаблонов в HTML документе -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listProducts</title>
    </head>
    <body>
        <h3>Список продуктов</h3>
        <ol type="1">
            <c:forEach var="product" items="${listProducts}" ><!-- конструкция списка, где каждый объект списка вставляется в переменную $(listProducts)-->    
                <li>   ${product.name}, ${product.price} euro - ${product.count} tk.	&nbsp;	&nbsp;
                    <a href="deleteProduct?deleteProductId=${product.id}">  Удалить </a><br> <!-- varStatus="num" для пронумерованного списка ${num.index+1} вместо <ol type="1">-->    
                </li>
            </c:forEach>
        </ol>
        <p><a href="home">Home</a><br><br>
    </body>
</html>
