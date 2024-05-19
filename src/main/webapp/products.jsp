<%@page import="com.uts.iotbay.model.Product"%>
<%@page import="com.uts.iotbay.model.User"%>
<%@page import="com.uts.iotbay.model.Staff"%>
<%@page import="com.uts.iotbay.model.Customer"%>
<%@page import="com.uts.iotbay.model.dao.DBManager"%>
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
	<title>IoTBay | Products</title>

</head>
	<body>
        <% 
            DBManager manager = (DBManager) request.getSession().getAttribute("manager");
            if(manager == null){
                response.sendRedirect("homedirect.jsp");
            }

            User user = (User)request.getSession().getAttribute("user");
            String products = (String)request.getSession().getAttribute("products");

            String s = (String)request.getSession().getAttribute("productsCount");
            int productsCount = 0;

            if(s != null && s != ""){
                productsCount = Integer.parseInt(s);
            }

            String category = (String)request.getSession().getAttribute("category");
            String search = (String)request.getSession().getAttribute("search");
            String errorMsg = (String)request.getSession().getAttribute("errorMsg");
            String title = "All Products";
            
            request.getSession().setAttribute("errorMsg", "");
            request.getSession().setAttribute("productsCount", "");

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
                             if(!(user instanceof Customer)){
                                out.println("<li><a href=\"staff/products\"><button id=\"switch-view-btn\" tabindex=\"-1\"><p class=\"switch-view-text\">Switch to Staff View</p></button></a></li>");
                            }
                         } %>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="#"><span class="active-page">Products</span></a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html">Contact</a></button></li>
					<li><a href="manageaccount.jsp"><button id="mng-acc-btn" tabindex="-1"><img id="mng-acc-pic" src="assets/account.png" alt="manage account button"></button></a></li>
                    <li><a href="cart.jsp"><button id="cart-btn" tabindex="-1"><img id="cart-pic" src="assets/shopping-cart.png" alt="manage account button"></button></a></li>
				</ul>
			</div>
            <br>
			<div class="logo">
				<img src="assets/logo.png" id="logo-small" alt="logo">
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
                        <option <%if(category.equals("Printers")){out.println("selected");}%> value="Printers">Printers</option>
                        <option <%if(category.equals("Dongles")){out.println("selected");}%> value="Dongles">Dongles</option>
                        <option <%if(category.equals("Locks")){out.println("selected");}%> value="Locks">Locks</option>
                        <option <%if(category.equals("Recorders")){out.println("selected");}%> value="Recorders">Recorders</option>
                    </select>
                    <input class="product-search-form-input" type="text" id="name" name="name" placeholder="Search..." value="<%=search%>">
                    <Button class="product-search-form-input" id="product-search-submit" type="submit">
                        <img src="assets/search.png" id="search-pic">
                    </Button>
                </form>
            </div>
            <% if(productsCount > 0) {
                out.println("<p class=\"result-number\">Found " + productsCount + " results</p>");
            } %>
            <br>
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