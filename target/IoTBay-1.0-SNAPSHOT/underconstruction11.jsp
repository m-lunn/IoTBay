<%@page import="com.uts.iotbay.model.Product"%>
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
Product product1 = (Product)request.getSession().getAttribute("productreal");

	String productName = product1.getName();
    String productDescription = product1.getDescription();
    float productPrice = product1.getPrice();
    String productImagePath = product1.getImagePath();
%>
	<body>
			<div class="backdrop">
				<div class="button-wrapper"></div>
				<div class="buttons">
					<ul class="menu-bar">
						<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
						<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">About</a></button></li>
						<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Products</a></button></li>
						<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Contact</a></button></li>
					</ul>
				</div>
				<div>
					<div class="left-column">
						<img src="<%= productImagePath %>" alt="Product Image">
					</div>
					<div class="right-column">
						<div class="product-description">
						<span>Router</span>
						<h1><%= productName %></h1>
						<h2><%= productPrice %></h2>
						<button class="addtocart-btn">Add to cart</button>
						<p1><%= productDescription %></p1>
					</div>
					</div>
				</div>

			</div> <!-- End of body -->
				 

			<div class="footer">
				<br>
				<ul class="footer-menu">
					<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="homedirect.jsp">Home</a></button></li>
					<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">About</a></button></li>
					<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Products</a></button></li>
					<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Contact</a></button></li>
				</ul>
				<p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
			</div>	
		</body>
	</html>
	<%
%>