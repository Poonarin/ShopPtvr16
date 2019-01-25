<%-- 
    Document   : showUserRoles
    Created on : Dec 4, 2018, 2:28:44 PM
    Author     : Sanata
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Назначение ролей</title>
    </head>

    <body>
        <h2>Назначение пользователяm ролей</h2>
        <form action="changeCustomerRole" method="POST">
            <table>
                <tr>
                    <th>Пользователь</th>
                    <th>Новая роль</th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td>
                        <select name="customer" value="">
                          <!---  <c:forEach var="customer" items="${listCustomers}"><option value="${customer.id}">${customer.login}</option></c:forEach>--->
                            <c:forEach var="entry" items="${mapCustomers}">
                                <option value="${entry.key.id}"> , роль: ${entry.value} </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select name="role">
                            <c:forEach var="role" items="${listRoles}">
                                <option value="${role.id}">${role.name}</option>
                            </c:forEach>
                        </select>
                     </td>    
                         <td><button type="submit" name="setButton">Назначить</button> </td>
                         <td><button type="submit" name="deleteButton">Удалить</button> </td>
                      </tr>   
            </table>   
        </form>
        <hr>
        <p><p><button><a href="welcom">Home</a></button></p>
    </body>
</html>
