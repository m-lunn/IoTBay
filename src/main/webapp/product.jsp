<%@page import="com.uts.iotbay.model.Product"%>
<%@page import="com.uts.iotbay.model.Staff"%>
<%@page import="com.uts.iotbay.model.Customer"%>
<%@page import="com.uts.iotbay.model.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="../styles.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay</title>

</head>
<body>
	<%
		User user = (User) request.getSession().getAttribute("user");
		Product product = (Product) request.getSession().getAttribute("product");

		String productName = product.getName();
		String productDescription = product.getDescription();
		String productPrice = product.getPrice() + "0";
		String productImagePath = product.getImagePath();
		String productCategory = product.getCategory();
		productCategory = productCategory.substring(0, 1).toUpperCase() + productCategory.substring(1);
	%>

	<div class="backdrop">
		<div class="button-wrapper"></div>
		<div class="buttons">
			<ul class="menu-bar">
				<%  if(user != null){
						 if(!(user instanceof Customer)){
							out.println("<li><a href=\"../staff/product/" + productName + "\"><button id=\"switch-view-btn\" tabindex=\"-1\"><p class=\"switch-view-text\">Switch to Staff View</p></button></a></li>");
						}
					 } %>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="../homedirect.jsp">Home</a></button></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="../about.html">About</a></button></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="../products"><span class="active-page">Products</span></a></button></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="../contact.html">Contact</a></button></li>
				<li><a href="../manageaccount.jsp"><button id="mng-acc-btn" tabindex="-1"><img id="mng-acc-pic" src="../assets/account.png" alt="manage account button"></button></a></li>
				<li><a href="cart.jsp"><button id="cart-btn" tabindex="-1"><img id="cart-pic" src="../assets/shopping-cart.png" alt="manage account button"></button></a></li>
			</ul>
		</div>

		<br>
		<div class="product-view-container">
			<img class="single-product-image" src="<%= "../" + productImagePath%>">
			<div class="product-details-container">
				<p class="single-product-category"><%=productCategory%></p>
				<p class="single-product-name"><%=productName%></p>
				<p class="single-product-price"><%= "$" + productPrice%></p>
				<Button class="single-product-add">Add to Cart</Button>
				<p class="single-product-description"><%=productDescription%></p>

			</div>
		</div>
		<div class="footer">
            <br>
            <ul class="footer-menu">
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="../homedirect.jsp">Home</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="../about.html">About</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="../products">Products</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="../contact.html">Contact</a></button></li>
            </ul>
            <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
        </div>	
</div>
	

</body>
</html>