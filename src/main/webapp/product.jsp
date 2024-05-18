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
<body>
	<%
		Product product = (Product) request.getSession().getAttribute("product");

		String productName = product.getName();
		String productDescription = product.getDescription();
		float productPrice = product.getPrice();
		String productImagePath = product.getImagePath();
	%>

	<div class="backdrop">
		<div class="button-wrapper"></div>
		<div class="buttons">
			<ul class="menu-bar">
				<%  if(user != null){
						 if(!(user instanceof Customer)){
							out.println("<li><a href=\"staff/products\"><button id=\"switch-view-btn\" tabindex=\"-1\"><p class=\"switch-view-text\">Switch to Staff View</p></button></a></li>");
						}
					 } %>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="#"><span class="active-page">Products</span></a></button></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html">Contact</a></button></li>
				<li><a href="manageaccount.jsp"><button id="mng-acc-btn" tabindex="-1"><img id="mng-acc-pic" src="/assets/account.png" alt="manage account button"></button></a></li>
				<li><a href="cart.jsp"><button id="cart-btn" tabindex="-1"><img id="cart-pic" src="/assets/shopping-cart.png" alt="manage account button"></button></a></li>
			</ul>
		</div>

		<br>
		<div class="product-view-container">
			
		</div>

		<br><br><br><br><br>


</div>
	

</body>
</html>