<%-- 
    Document   : register
    Created on : 14 Apr 2024, 12:20:29 am
    Author     : michaellunn
--%>

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
            session.setAttribute("existErr", "");
        %>
		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="index.jsp">Home</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Products</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Contact</a></button></li>
				</ul>
			</div>
			<br>
			<div class="logo">
				<img src="./assets/logo.png" id="logo" alt="logo">
				<!-- Logo created using DreamStudio by stability.ai -->
				<br>
			</div>
			<div>
				<h1 class="heading-text">Sign Up</h1>
			</div>

			<br><br><br>
            <h3 class="error-text"> <%= (duplicateErr != null ? duplicateErr : "")%> </h3>
            <div class="form-container">
                <form action="register" method="post">
                    <div class="form-group">
                        <label for="first name">First Name:</label>
                        <input type="text" id="first name" name="fname" placeholder="<%=(fnameErr != null ? fnameErr : "Enter first name")%>" required>
                    </div>
                    <div class="form-group">
                        <label for="surname">Surname:</label>
                        <input type="text" id="surname" name="surname" placeholder="<%=(surnameErr != null ? surnameErr : "Enter surname")%>" required>
                    </div>
                    <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required>
                    </div>
                    <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" placeholder="<%=(passwordErr != null ? passwordErr : "Enter password")%>" required>
                    </div>
                    <br><br><br><br>
                    <button type="submit" class="submit-btn">Create New Account</button>
                    <a href="login.jsp" class="login-redirects">Already have an account?</a>
                </form>
              </div> 
              <br><br><br>
		</div>

        <div class="footer">
            <br>
            <ul class="footer-menu">
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="index.jsp">Home</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">About</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Products</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Contact</a></button></li>
            </ul>
            <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
        </div>	
	</body>
</html>
