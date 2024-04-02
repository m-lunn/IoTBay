<%-- 
    Document   : welcome
    Created on : 02/04/2024, 4:14:26 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Welcome</title>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
        %>
        <h1>Welcome <%= fName + lName %>!</h1>
        <p>Your email is: <%= email %>.</p>
        <p>Your password is: <%= password %>.</p>
        <p>Your date of birth is: <%= dob %>.</p>
        <div>
            <a href="index.jsp">
                <button type="button">Cancel</button>
            </a>
            <a href="main.jsp">
                <button type="button">Continue</button>
            </a>
        </div>
        
        <%
            Customer customer = new Customer(email, password, fName, lName, dob);
            session.setAttribute("customer", customer);
        %>
    </body>
</html>
