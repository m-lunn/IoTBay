<%-- 
    Document   : main
    Created on : 02/04/2024, 5:09:54 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Main</title>
    </head>
    <body>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        
        <h1>Customer Dashboard</h1>
        <table>
            <thead><th>First Name</th><th>Last Name</th><th>Email</th><th>Password</th><th>Date of Birth</th></thead>
            <tr><td>${customer.fName}</td><td>${customer.lName}</td><td>${customer.email}</td><td>${customer.password}</td><td>${customer.dob}</td></tr>
        </table><br>
        <a href="logout.jsp">
            <button type="button">Logout</button>
        </a>
    </body>
</html>
