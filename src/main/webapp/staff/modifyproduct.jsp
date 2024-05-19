<%@page import="com.uts.iotbay.model.Product"%>
<%@page import="com.uts.iotbay.model.Staff"%>
<%@page import="com.uts.iotbay.model.Customer"%>
<%@page import="com.uts.iotbay.model.User"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="../../styles.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | Staff</title>

</head>
<body>

	<%
	User user = (User) request.getSession().getAttribute("user");
	Product product = (Product) request.getSession().getAttribute("product");

	if(!(user instanceof Staff)){
		response.sendRedirect("products");
	}

	int productID = product.getProductID();
	String productName = product.getName();
	String productDescription = product.getDescription();
	String productPrice = product.getPrice() + "0";
	String productImagePath = product.getImagePath();
	String productCategory = product.getCategory();
	productCategory = productCategory.substring(0, 1).toUpperCase() + productCategory.substring(1);

	String priceError = (String)request.getSession().getAttribute("priceError");
	if(priceError == null){														 
		priceError = "";
	}
	request.getSession().setAttribute("priceError", "");
	%>

	<div class="backdrop">
		<div class="button-wrapper"></div>
		<div class="buttons">
			<ul class="menu-bar">
				<li><a href="../../product/<%=productName%>"><button id="switch-view-btn" tabindex="-1"><p class="switch-view-text">Switch to Customer View</p></button></a></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="../homedirect.jsp">Home</a></button></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="../about.html">About</a></button></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="../products"><span class="active-page">Products</span></a></button></li>
				<li><button class="btn" tabindex="-1"> <a class="button-text" href="../contact.html">Contact</a></button></li>
				<li><a href="../../manageaccount.jsp"><button id="mng-acc-btn" tabindex="-1"><img id="mng-acc-pic" src="../../assets/account.png" alt="manage account button"></button></a></li>
				<li><a href="../../cart.jsp"><button id="cart-btn" tabindex="-1"><img id="cart-pic" src="../../assets/shopping-cart.png" alt="manage account button"></button></a></li>
			</ul>
		</div>
		<h1 class="heading-text">Edit Product</h1>
		<div class="product-view-container">
			<div class="image-row">
				<img class="edit-product-image" src="<%= "../../" + productImagePath%>">
				<input type="file" class="image-input" name="filename" accept="image/*">
			</div>
			<form id="edit-product-form" action="update/<%=productID%>" method="post">
			<div class="product-details-container">
				<p class="error-msg"><%=priceError%></p>
				<div class="category-line">
					<p class="category-label">Category:</p>
					<select class="product-search-form-input" name="category" id="edit-product-category">
						<option <%if( productCategory.equals("Processor")){out.println("selected");}%> value="processor">Processor</option>
						<option <%if( productCategory.equals("Sensor")){out.println("selected");}%> value="sensor">Sensor</option>
						<option <%if( productCategory.equals("Camera")){out.println("selected");}%> value="camera">Camera</option>
						<option <%if( productCategory.equals("Router")){out.println("selected");}%> value="router">Router</option>
						<option <%if( productCategory.equals("Access point")){out.println("selected");}%> value="access point">Access Point</option>
						<option <%if( productCategory.equals("Printer")){out.println("selected");}%> value="printer">Printer</option>
						<option <%if( productCategory.equals("Dongle")){out.println("selected");}%> value="dongle">Dongle</option>
						<option <%if( productCategory.equals("Lock")){out.println("selected");}%> value="lock">Lock</option>
						<option <%if( productCategory.equals("Recorder")){out.println("selected");}%> value="recorder">Recorder</option>
					</select>
				</div>
				<div class="name-line">
					<p class="name-label">Name:</p>
					<input class="product-input" type="text" id="edit-product-name" value="<%=productName%>" name="name" placeholder="Enter product name..." required>
				</div>
				<div class="price-line">
					<p class="dollar-icon">$</p>
					<input class="product-input" type="text" id="edit-product-price" value="<%=productPrice%>" name="price" placeholder="Enter product price..." required>
				</div>
				<p class="description-label">Description:</p>
				<textarea rows = "4" cols = "60" name="description" placeholder="Enter product description..."><%=productDescription%></textarea>
			</div>
		</div>
	</form>
		<div class="edit-product-btn-row">
			<a href="../products/delete/<%=productID%>"><Button class="edit-submit-btn" id="edit-delete">Delete</Button></a>
			<a href="../products"><Button class="edit-submit-btn" id="edit-cancel">Cancel</Button></a>
			<a><Button type="submit" form="edit-product-form" class="edit-submit-btn" id="edit-save">Save</Button></a>
		</div>

		<br><br>
		<div class="footer">
            <br>
            <ul class="footer-menu">
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="../../homedirect.jsp">Home</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="../../about.html">About</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="../../products">Products</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="../../contact.html">Contact</a></button></li>
            </ul>
            <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
        </div>	
	</div>
	

</body>
</html>