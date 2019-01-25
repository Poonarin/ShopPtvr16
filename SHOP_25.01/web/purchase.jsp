<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- библиотека  для создания шаблонов в HTML документе -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>purchase</title>
    </head>
    <body>
        <h2>Продать товар покупателю</h2>
        
        <form action="takeProduct" method="POST" name="form1">
            <h3>Список товара</h3>
            <select name="selectedProduct">
                <c:forEach var="product" items="${listProducts}"><!-- конструкция списка, где каждый объект списка вставляется в переменную $(listProducts) -->
                    <option value="${product.id}">${product.name} - ${product.price} euro, ${product.count} шт.</option> 
                
                </c:forEach> 
            </select>
            
            
            <!-- ---------------------------------НЕ РАБОТАЕТ---------------------------------------------------->
            <!-- Библиотека JSTL-->
            <!--<input type='number' name='count' min='1' max='' placeholder='Количество' required value='1'>     -->
          <!--<select name="selectedCountProduct">
                <c:forEach var="count" items="${listProducts}" varStatus="count">
                <option value="${product.id}">${count.index+1}. ${product.count} tk.</option> 
                </c:forEach>
          </select>-->
            

            
      <!-- -------------------------------------------------------------------------------------------------->
           <h3>Список покупателей</h3>
            <select name="selectedCustomer">
                <c:forEach var="customer" items="${listCustomers}"><!-- конструкция списка,  -->
                    <option value="${customer.id}">${customer.name} ${customer.surname}</option> 
                </c:forEach> 
            </select>
         <!-- -------------------------------------------------------------------------------------------------->
            <button type="submit"  name="takeProduct" >Продать</button>
        </form>
        <p><a href="home">Home</a><br><br>
    </body>
</html>

