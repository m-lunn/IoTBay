<%-- 
    Document   : landing
    Created on : 14 Apr 2024, 12:20:15 am
    Author     : michaellunn
--%>
<%@page import="com.uts.iotbay.model.User"%>
<%@page import="com.uts.iotbay.model.Customer"%>
<%@page import="com.uts.iotbay.model.Staff"%>
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
		<% 
			User user = (User)request.getSession().getAttribute("user");
			if(user == null){
				response.sendRedirect("homedirect.jsp");
				return;
			}
			String fname = user.getFname();
			String email = user.getEmail();
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
				<h1 class="heading-text">Welcome Back <%= fname%>!</h1>
			</div>
            <br>

			<% if (user instanceof Customer) { %>
				<div>
					<h2 class="subheading-text">You are logged in as: </h2>
					
					<h2 class="email-text"><%= email%></h2>
					<br>
					<button class="logout-btn"><a href="logout" class="login-text" method="post">Logout</a></button>
					<br><br><br><br>
				</div>
				<% } else if (user instanceof Staff) { %>
				<div>
					<h2 class="subheading-text">You are logged in as staff: </h2>
					
					<h2 class="email-text"><%= email%></h2>
					<br>
					<button class="logout-btn"><a href="logout" class="login-text">Logout</a></button>
					<br><br><br><br>
				</div>
				<% } else { %>
				<div>
					<div>
						<h2 class="subheading-text">You are logged in as system admin: </h2>
						<br><br><br><br>
					</div>
			  
					  <form class="admin-content" action="view-users">
						<button type="submit" class="admin-btn">View Users</button>
					</form>
					<br><br><br><br>
					<button class="logout-btn"><a href="logout" class="login-text">Logout</a></button>
					<br><br><br><br>
				</div>
				<% } %>

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
