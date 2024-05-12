<%@page import="com.uts.iotbay.model.Product"%>
<%@page import="com.uts.iotbay.model.User"%>
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
	<body>

        <% 
            User user = (User)request.getSession().getAttribute("user");
            String products = (String)request.getSession().getAttribute("products");
            String category = (String)request.getSession().getAttribute("category");
            String search = (String)request.getSession().getAttribute("search");
            String errorMsg = (String)request.getSession().getAttribute("errorMsg");
            String title = "All Products";

            request.getSession().setAttribute("category", "");
            request.getSession().setAttribute("search", "");
            request.getSession().setAttribute("errorMsg", "");

            if(search == null){search = "";}
            if(category == null){category = "";}
            if(errorMsg == null){errorMsg = "";}

            if(!category.equals("Any") && !category.equals("")){
                title = category;
            }


         %>

		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
                    <%  if(user != null){
                            if(user.isStaff()){
                                out.println("<li><button id=\"switch-view-btn\" tabindex=\"-1\"><a id=\"switch-view-text\" href=\"/staff/products\">Switch to Staff View</a></button></li>");
                            }
                        } %>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="#"><span class="active-page">Products</span></a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html">Contact</a></button></li>
					<li><button id="mng-acc-btn" tabindex="-1"><a href="manageaccount.jsp"><img id="mng-acc-pic" src="./assets/account.png" alt="manage account button"></a></button></li>
					<li><button id="cart-btn" tabindex="-1"><a href="manageaccount.jsp"><img id="cart-pic" src="./assets/shopping-cart.png" alt="cart button"></a></button></li>
				</ul>
			</div>
            <br>
			<div class="logo">
				<img src="./assets/logo.png" id="logo-small" alt="logo">
				<!-- Logo created using DreamStudio by stability.ai -->
                <h1 class="heading-text"><%=title%></h1>
                <br>
			</div>
            <div class="product-search">
                <form action="products" class="product-search-form" method="post">
                    <label class="product-search-form-label" for="category">Category:</label>
                    <select class="product-search-form-input" name="category" id="category">
                        <option value="Any">Any</option>
                        <option <%if(category.equals("Processors")){out.println("selected");}%> value="Processors">Processors</option>
                        <option <%if(category.equals("Sensors")){out.println("selected");}%> value="Sensors">Sensors</option>
                        <option <%if(category.equals("Cameras")){out.println("selected");}%> value="Cameras">Cameras</option>
                        <option <%if(category.equals("Routers")){out.println("selected");}%> value="Routers">Routers</option>
                        <option <%if(category.equals("Access Points")){out.println("selected");}%> value="Access Points">Access Points</option>
                        <option <%if(category.equals("Dongles")){out.println("selected");}%> value="Dongles">Dongles</option>
                        <option <%if(category.equals("Locks")){out.println("selected");}%> value="Locks">Locks</option>
                        <option <%if(category.equals("Recorders")){out.println("selected");}%> value="Recorders">Recorders</option>
                    </select>
                    <input class="product-search-form-input" type="text" id="name" name="name" placeholder="Search..." value="<%=search%>">
                    <Button class="product-search-form-input" id="product-search-submit" type="submit">
                        <img src="./assets/search.png" id="search-pic">
                    </Button>
                </form>
            </div>
            <br><br><br><br>
            <p class="error-msg"><%=errorMsg%></p>
            <div class="product-grid-container">
                <% out.println(products); %>
            </div>

            <br><br><br><br><br>


	</div>
     

        <div class="footer">
            <br>
            <ul class="footer-menu">
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="homedirect.jsp">Home</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="about.html">About</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="#"><span class="active-page">Products</span></a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="contact.html">Contact</a></button></li>
            </ul>
            <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
        </div>	
	</body>
</html>