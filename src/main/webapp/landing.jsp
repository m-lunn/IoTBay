<%-- 
    Document   : landing
    Created on : 14 Apr 2024, 12:20:15 am
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
	<title>IoTBay</title>

</head>
	<%
		User user1 = (User)request.getSession().getAttribute("user");

		if(user1 == null){
			response.sendRedirect("homedirect.jsp");
		}
	

		String fname = user1.getFname();
		String email = user1.getEmail();
	%>
	<body>
		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp"><span class="active-page">Home</span></a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="products">Products</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html">Contact</a></button></li>
					<li><button id="mng-acc-btn" tabindex="-1"><a href="manageaccount.jsp"><img id="mng-acc-pic" src="./assets/account.png" alt="manage account button"></a></button></li>
					<li><button id="cart-btn" tabindex="-1"><a href="manageaccount.jsp"><img id="cart-pic" src="./assets/shopping-cart.png" alt="manage account button"></a></button></li>
				</ul>
			</div>
			<br>
			<div class="logo">
				<img src="./assets/logo.png" id="logo" alt="logo">
				<!-- Logo created using DreamStudio by stability.ai -->
				<br>
			</div>
			<div>
				<h1 class="heading-text">Welcome Back <%= fname%>!</h1>
			</div>
            <br>
            <div>
                <h2 class="subheading-text">You are logged in as: </h2>
                
                <h2 class="email-text"><%= email%></h2>
                <br>
				<form action="logout" method="post" id="logout">
                <button class="logout-btn" type="submit"><p class="login-text">Logout</p></button>
				</form>
                <br><br><br><br>
            </div>

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
