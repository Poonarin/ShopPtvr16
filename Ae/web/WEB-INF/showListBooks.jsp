<%-- 
    Document   : page2
    Created on : Dec 10, 2018, 10:36:44 AM
    Author     : pupil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/page2.css">
        <title>Библиотека</title>
    </head>
    <body>
        <h1>Список книг</h1>
        <h2><b>${info}</b><br></h2>
       
        <ul>
            
            <c:forEach var="book" items="${listBooks}">
                <li>${book.name}, ${book.author}, ${book.isbn}</li> 
            </c:forEach>
            
        </ul>
            <hr>
        <p><a href="index.html">Home</a></p>
        <hr>
        <script src="js/page2.js"></script>
    </body>
</html>
