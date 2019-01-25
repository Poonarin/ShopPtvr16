<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>newCustomer</title>
    </head>
     <body>
        <h1>Добавить  нового покупателя</h1>
        <form action="addCustomer" method="POST" name="form1" id="_form"  >
         <p>Имя:<br> <input type="text" name="name"> 
             <p>Фамилия:<br><input type="text" name="surname">
             <p>Телефон:<br><input type="text" name="phone">
             <p>Город:<br><input type="text" name="city">
             <p>Логин:<br><input type="text" name="login">
            <p>Пароль:<br><input  name="password1" type="password">
            <p>Повторить пароль:<br><input  name="password2" type="password">
             
        <p>Кошелек:<br><input type="text" name="money" placeholder="money"  autofocus required > евро</p><!----> 
        
        <input type="submit" name ="send" value="Добавить">				
        </form>	
   
        <br>
        <!--<p><a href="home">Home</a><br><br>-->
        <p><a href="welcom">Home</a><br><br>
    </body>
</html>
