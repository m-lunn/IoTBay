<%-- 
    Document   : register
    Created on : 02/04/2024, 4:07:12 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay Register</title>
    </head>
    <body>
        <h1>Registration Form</h1>
        <form action="welcome.jsp" method="POST">
            <table>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td><input type="email" name="email" placeholder="Enter Email" required></td>
                </tr>
                <tr>
                    <td><label for="fName">First Name:</label></td>
                    <td><input type="text" name="fName" placeholder="Enter First Name" required></td>
                </tr>
                <tr>
                    <td><label for="lName">Last Name:</label></td>
                    <td><input type="text" name="lName" placeholder="Enter Last Name" required></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" name="password" placeholder="Enter password" required></td>
                </tr>
                <tr>
                    <td><label for="dob">Date of Birth</label></td>
                    <td><input type="date" name="dob" required></td>
                </tr>
            </table><br>
            <div>
                <a href="index.jsp">
                    <button type="button">Cancel</button>
                </a>
                <input type="submit" value="Register">
            </div>
        </form>
    </body>
</html>
