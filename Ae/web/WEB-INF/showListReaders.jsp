<%-- 
    Document   : page3
    Created on : Dec 10, 2018, 11:03:46 AM
    Author     : pupil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/page3.css">
        <title>Библиотека </title>
    </head>
    <body>
        <h1>Список читателей</h1>
        <h2><b>${info}</b><br></h2>
        <hr>
                <ul>
            
            <c:forEach var="reader" items="${listReaders}">
                <li>${reader.name}, ${reader.surname}, ${reader.code}</li> 
            </c:forEach>
            
        </ul>
        
        
        
        
        <p><a href="index.html">Home</a></p>
        <hr>
        <script src="js/page3.js"></script>
    </body>
</html>
