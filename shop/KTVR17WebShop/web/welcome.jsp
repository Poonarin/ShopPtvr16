

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Главная</title>
       
    </head>
    <body>
        <header>
            
             ${info}<br>
            <nav>
                <ul class="menu"> 
                    <li><a href="showLogin"> Войти в систему</a></li>
                    <li><a href="logout"> Выйти из системы</a></li>
                    <li><a href="newProduct">Добавить продукты</a></li>
                    <li> <a href="newCustomer">Добавить покупателя</a></li>
                </ul>
            </nav>
        </header>
        <div> 
            <h1>Действия</h1>
            ${textToPage}<br>
            <ol>
            <li><a href="showProduct">Список продуктов</a></li>
            <li><a href="newCustomer">Добавить покупателя</a></li>
            <li><a href="showCustomer">Список покупателей</a></li>
            <li><a href="listAll">Покупка</a></li>
            </ol>
        </div>
    </body>
</html>
