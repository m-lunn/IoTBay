<%-- 
    Document   : login
    Created on : 14 Apr 2024, 12:19:15 am
    Author     : michaellunn
--%>

<%@page import="com.uts.iotbay.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | Login</title>

</head>

	<body>

        <%String errorMsg = (String)request.getSession().getAttribute("errorMsg");
    
        if(errorMsg == null) {
           errorMsg ="";
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
				</ul>
			</div>
			<br>
			<div class="logo">
				<img src="./assets/logo.png" id="logo" alt="logo">
				<!-- Logo created using DreamStudio by stability.ai -->
				<br>
			</div>
			<div>
				<h1 class="heading-text">Welcome Back!</h1>
			</div>

            

			<br><br>
            <p class="error-msg"> <%= errorMsg%> </p>
            <br>
            <div class="form-container" id="login-form-container">
                <form action="login", method="post">
                    <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                    </div>
                    <br><br><br>
                    <button type="submit" class="submit-btn2">Login</button>
                    <br><br>
                    <a href="register.jsp" class="login-redirects">Don't have an account?</a>
                    <br>
                </form>
              </div>
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
