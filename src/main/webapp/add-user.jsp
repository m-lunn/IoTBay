<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | Sign Up</title>

</head>

<body>
    <%
        String duplicateErr = (String) session.getAttribute("duplicateErr");
        String emailErr = (String) session.getAttribute("emailErr");
        String fnameErr = (String) session.getAttribute("fnameErr");
        String surnameErr = (String) session.getAttribute("surnameErr");
        String passwordErr = (String) session.getAttribute("passwordErr");
        String phoneErr = (String) session.getAttribute("phoneErr");
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passwordErr", "Enter password");
        session.setAttribute("fnameErr", "Enter first name");
        session.setAttribute("surnameErr", "Enter surname");
        session.setAttribute("phoneErr", "Enter phone number");
        session.setAttribute("duplicateErr", "");
    %>
    <div class="backdrop">
        <jsp:include page="/ConnServlet"/>   
        <div class="button-wrapper"></div>
        <div class="buttons">
            <ul class="menu-bar">
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="products">Products</a></button></li>
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html">Contact</a></button></li>
                <li><a href="manageaccount.jsp"><button id="mng-acc-btn" tabindex="-1"><img id="mng-acc-pic" src="./assets/account.png" alt="manage account button"></button></a></li>
                <li><a href="cart.jsp"><button id="cart-btn" tabindex="-1"><img id="cart-pic" src="./assets/shopping-cart.png" alt="manage account button"></button></a></li>
            </ul>
        </div>
        <br>
        <div class="logo">
            <img src="./assets/logo.png" id="logo" alt="logo">
            <!-- Logo created using DreamStudio by stability.ai -->
            <br>
        </div>
        <form action="add-user" method="post">
            <div class="details">
                <h2 class="heading-text">Create New User</h2>
                <h3 class="error-text"> <%= (duplicateErr != null ? duplicateErr : "")%> </h3>
                <table>
                    <tr>
                        <td><label for="type">User Type:</label></td>
                        <td>
                            <select name="type" id="type">
                                <option selected value="Customer">Customer</option>
                                <option value="Staff">Staff</option>
                            </select>
                        </td>
                    </tr>
                    <tr><td></td><td></td></tr>
                    <tr>
                        <td><label for="fname">First name:</label></td>
                        <td><input type="text" name="fname" placeholder="<%=(fnameErr != null ? fnameErr : "Enter first name")%>" required></td>
                    </tr>
                    <tr><td></td><td></td></tr>
                    <tr>
                        <td><label for="surname">Surname:</label></td>
                        <td><input type="text" id="surname" name="surname" placeholder="<%=(surnameErr != null ? surnameErr : "Enter surname")%>" required></td>
                    </tr>
                    <tr><td></td><td></td></tr>
                    <tr>
                        <td><label for="email">Email:</label></td>
                        <td><input type="text" name="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required></td>
                    </tr>
                    <tr><td></td><td></td></tr>
                    <tr>
                        <td><label for="phoneNo">Phone Number:</label></td>
                        <td><input type="text" id="phoneNo" name="phoneNo" placeholder="<%=(phoneErr != null ? phoneErr : "Enter phone number")%>" required></td>
                    </tr>
                    <tr><td></td><td></td></tr>
                    <tr>
                        <td><label for="password">Password:</label></td>
                        <td><input type="password" id="password" name="password" placeholder="<%=(passwordErr != null ? passwordErr : "Enter password")%>" required></td>
                    </tr>
                </table>
            </div>
            <br><br><br><br>
            <div class="page-btns">
                <button class="logout-btn2"><a href="view-users" class="login-text">Back</a></button>
                <button type="submit" class="logout-btn2"><div class="login-text">Create User</div></button>
            </div>
        </form>
        <br><br><br><br>
    </div>

    <div class="footer">
        <br>
        <ul class="footer-menu">
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="homedirect.jsp">Home</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="about.html">About</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="products">Products</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="contact.html">Contact</a></button></li>
        </ul>
        <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
    </div>	
</body>
</html>