<%-- 
    Document   : logout
    Created on : 02/04/2024, 5:30:43 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Logout</title>
    </head>
    <body>
        <h1>You have successfully logged out. Please click <a href="index.jsp">here</a> to return to the landing page.</h1>
        <% session.invalidate(); %>
    </body>
</html>
