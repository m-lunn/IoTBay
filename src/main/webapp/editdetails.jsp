
<%@page import="com.uts.iotbay.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | Sign Up</title>

</head>

	<body>

        <%
            String fname="";
            String surname="";
            String email="";
            String password="";

            String errorMsg = (String)request.getSession().getAttribute("errorMsg");

            User user = (User)request.getSession().getAttribute("user");
            if(user != null) {
                fname = user.getFname();
                surname = user.getSurname();
                email = user.getEmail();
                password = user.getPassword();
            }
            else {
                response.sendRedirect("homedirect.jsp");
            }
        %>


		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
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
				<h1 class="heading-text">Edit Details</h1>
			</div>

            <h2 class="subheading-text">You are logged in as: </h2>
                
            <h2 class="email-text"><%= email%></h2>

            <p class="error-msg"><%=errorMsg%></p>

			<br><br>
            <div class="form-container" id="editdetails-form-container">
                <form action="editdetails" method="post" id="editdetails">
                    <div class="form-group">
                        <label for="fname">First Name:</label>
                        <input value="<%=fname%>" type="text" id="fname" name="fname" required>
                    </div>
                    <div class="form-group">
                        <label for="surname">Surname:</label>
                        <input value="<%=surname%>" type="text" id="surname" name="surname" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input value="<%=password%>" type="password" id="password" name="password" required>
                    </div>
                    <div class="form-group">
                        <label for="confirm-password">Confirm Password:</label>
                        <input type="password" id="confirm-password" name="confirm-password" required>

                    </div>
                    <br><br><br>
                    <button type="submit" form="editdetails" class="submit-btn">Update Details</button>

                </form>

            </div> 
            <br><br>

            <div class="btn-row">
                <form action="editdetails" method="get" id="delete">
                    <button class="submit-btn" id="delete-btn" type="submit">Delete Account</button>
                </form>
            </div>
            <br><br>
		</div>

        <div class="footer">
            <br>
            <ul class="footer-menu">
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="homedirect.jsp">Home</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="about.html">About</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="products">Products</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="contact.html">Contact</a></button></li>
            </ul>
            <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
        </div>	
	</body>
</html>