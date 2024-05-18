<%-- 
    Document   : login
    Created on : 14 Apr 2024, 12:19:15 am
    Author     : michaellunn
--%>

<%@page import="com.uts.iotbay.model.User"%>
<%@page import="com.uts.iotbay.model.dao.DBManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Space+Mono:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | Login</title>

</head>

	<body>

        <%
            DBManager manager = (DBManager) request.getSession().getAttribute("manager");
            if(manager == null){
                response.sendRedirect("index.jsp");
            }

            String loginErr = (String)request.getSession().getAttribute("loginErr");
            request.getSession().setAttribute("loginErr", "");
    
            if(loginErr == null) {
            loginErr ="";
            }
        %>  
		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="products">Products</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html">Contact</a></button></li>
                    <li><a href="manageaccount.jsp"><button id="mng-acc-btn" tabindex="-1"><img id="mng-acc-pic" src="/assets/account.png" alt="manage account button"></button></a></li>
                    <li><a href="cart.jsp"><button id="cart-btn" tabindex="-1"><img id="cart-pic" src="/assets/shopping-cart.png" alt="manage account button"></button></a></li>
				</ul>
			</div>
			<br>
			<div class="logo">
				<img src="/assets/logo.png" id="logo" alt="logo">
				<!-- Logo created using DreamStudio by stability.ai -->
				<br>
			</div>
			<div>
				<h1 class="heading-text">Welcome Back!</h1>
			</div>

            

			<br><br>
            <p class="error-msg"><%= loginErr%></p>
            <br>
            <div>
                <form class="login-form" action="login", method="post">
                    <br>
                    <div class="form-group">
                    <label for="email">Email:</label>
                    <input class="register-input" type="text" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                    <label for="password">Password:</label>
                    <input class="register-input" type="password" id="password" name="password" required>
                    </div>
                    <button type="submit" class="submit-btn2">Login</button>
                    <br>
                    <a href="register.jsp" class="login-redirects">Don't have an account?</a>
                    <br>
                </form>
              </div>
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