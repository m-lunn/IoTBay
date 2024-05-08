<%-- 
    Document   : index
    Created on : 14 Apr 2024, 12:14:09 am
    Author     : michaellunn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | Home</title>

</head>

	<body>
		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="#"><span class="active-page">Home</span></a></button></li>
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
				<h1 class="heading-text">Welcome to IoTBay</h1>
			</div>

			<br><br><br><br><br>
			<div class="buttons">
				<ul class="logins-btns">
					<li>
						<div class="login-container">
							<button class="login-btn"><a href="login.jsp" class="login-text">Login</a></button>
						</div>
					</li>
					<li>
						<div class="login-container">
							<button class="login-btn"><a href="register.jsp" class="login-text">Sign Up</a></button>
						</div>
					</li>
				</ul>
			</div>
                        <br><br><br><br>
		</div>
		<div class="footer">
			<br>
			<ul class="footer-menu">
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="#"><span class="active-page">Home</span></a></button></li>
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">About</a></button></li>
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Products</a></button></li>
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Contact</a></button></li>
			</ul>
			<p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
		</div>	
	</body>
</html>
