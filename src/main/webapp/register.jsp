<%-- 
    Document   : register
    Created on : 14 Apr 2024, 12:20:29 am
    Author     : michaellunn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.uts.iotbay.model.dao.DBManager"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Space+Mono:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | Sign Up</title>

</head>
    <%

    DBManager manager = (DBManager) request.getSession().getAttribute("manager");
    if(manager == null){
        response.sendRedirect("homedirect.jsp");
    }

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
	<body>
		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="products">Products</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html">Contact</a></button></li>
                    <li><a href="manageaccount.jsp"><button id="mng-acc-btn" tabindex="-1"><img id="mng-acc-pic" src="assets/account.png" alt="manage account button"></button></a></li>
                    <li><a href="cart.jsp"><button id="cart-btn" tabindex="-1"><img id="cart-pic" src="assets/shopping-cart.png" alt="manage account button"></button></a></li>
				</ul>
			</div>
			<br>
			<div class="logo">
				<img src="assets/logo.png" id="logo" alt="logo">
				<!-- Logo created using DreamStudio by stability.ai -->
				<br>
			</div>
			<div>
				<h1 class="heading-text">Sign Up</h1>
			</div>

			<br><br><br>
            <h3 class="error-msg"><%= (duplicateErr != null ? duplicateErr : "")%></h3>
                <form class="register-form" action="register" method="post">
                    <br>
                    <div class="form-group">
                        <label for="first name">First Name:</label>
                        <input class="register-input" type="text" id="first name" name="fname" placeholder="<%=(fnameErr != null ? fnameErr : "Enter first name")%>" required>
                    </div>
                    <div class="form-group">
                        <label for="surname">Surname:</label>
                        <input class="register-input" type="text" id="surname" name="surname" placeholder="<%=(surnameErr != null ? surnameErr : "Enter surname")%>">
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input class="register-input" type="text" id="email" name="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Number:</label>
                        <input class="register-input" type="text" id="phone" name="phone" placeholder="<%=(phoneErr != null ? phoneErr : "Enter phone number")%>" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input class="register-input" type="password" id="password" name="password" placeholder="<%=(passwordErr != null ? passwordErr : "Enter password")%>" required>
                    </div>
                    <br>
                    <button type="submit" class="submit-btn">Create New Account</button>
                    <br>
                    <a href="login.jsp" class="login-redirects">Already have an account?</a>
                    <br>
                </form>
              <br><br><br>
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
