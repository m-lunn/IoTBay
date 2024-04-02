<%-- 
    Document   : login
    Created on : 02/04/2024, 4:06:58 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Login</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <form action="welcome.jsp" method="POST">
            <table>
                <tr><td><label for="email">Email:</label></td><td><input type="email" name="email" placeholder="Enter Email" required></td></tr>
                <tr><td><label for="password">Password:</label></td><td><input type="password" name="password" placeholder="Enter password" required></td></tr>
            </table><br>
            <div>
                <a href="index.jsp">
                    <button type="button">Cancel</button>
                </a>
                <input type="submit" value="Login">
            </div>
        </form>
    </body>
</html>
