<%-- 
    Document   : index
    Created on : 14 Apr 2024, 12:14:09 am
    Author     : michaellunn
--%>

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
	<title>IoTBay | Home</title>

</head>

	<body>
		<jsp:include page="/ConnServlet"/>
		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp"><span class="active-page">Home</span></a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="products">Products</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html">Contact</a></button></li>
				</ul>
			</div>
			<br>
			<div class="logo">
				<img src="/IoTBay-1.0-SNAPSHOT/assets/logo.png" id="logo" alt="logo">
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
							<a href="login.jsp"><button class="login-btn">Login</button></a>
						</div>
					</li>
					<li>
						<div class="login-container">
							<a href="register.jsp"><button class="login-btn">Sign Up</button></a>
						</div>
					</li>
				</ul>
			</div>
        <br><br><br><br>
		</div>
		<div class="footer">
			<br>
			<ul class="footer-menu">
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="homedirect.jsp"><span class="active-page">Home</span></a></button></li>
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="about.html">About</a></button></li>
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="products">Products</a></button></li>
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="contact.html">Contact</a></button></li>
			</ul>
			<p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
		</div>	
	</body>
</html>