<%-- 
    Document   : productList
    Created on : 2024. 5. 8., 오후 4:11:11
    Author     : miyamacpro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | Home</title>
        <style>
        .container {
            width: 1000px; 
            height: 600px;
            background-color: #ffffff; 
            margin: 0 auto;
            padding: 40px;
        
        }
        .menu {
            float: left; /* 왼쪽에 배치 */
            width: 250px; /* 메뉴 너비 */
            font-size: 25px;
            
            color: black; /* 글자색 */
            
        }
        .content {
            width: 750px;
            float: right;
            
            
        }
        table {
            border-collapse: collapse;
            width: 100%; 
        }

        td {
            border: 0px;
            text-align: left; 
            vertical-align: top;
            height: 50px; 
            width: 250px;
        }
        
        
        </style>

</head>

	<body>
		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="#"><span class="active-page">Home</span></a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="products.jsp">Products</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Contact</a></button></li>
				</ul>
			</div>
			<br>
			<div class="logo">
				<img src="./assets/logo.png" id="logo" alt="logo">
				<!-- Logo created using DreamStudio by stability.ai -->
				<br>
			</div>
			

			<br><br><br><br><br>
                        
                    
                        
                        <div class="container">
                            <div class="sidebar">
                                <div class="menu">
                                    
                                    Account Details
                                    <br>
                                    <a href="orderhistory.jsp">Order History</a>
                                   
                                </div>
                            </div>
                            <div class="content">
                                <font size="6"><b>Account Details</b></font>
                                <br>
                                <hr>
                                <br>
                                <table>
                                    <tr>
                                        <td><font size="5"><b>Profile</b></font></td>
                                        <td><b>First name</b>
                                            <br>
                                            Uts
                                        </td>
                                        <td><b>Last name</b>
                                            <br>
                                            Uts
                                        </td>
                                        
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><b>Email address</b>
                                            <br>
                                            abcd@gmail.com
                                        </td>
                                        <td><b>Phone number</b>
                                            <br>
                                            123456789
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><b>Date of birth</b>
                                            <br>
                                            11/11/2000
                                        </td>
                                        <td><b>Password</b>
                                            <br>
                                            ********
                                        </td>
                                    </tr>
                                </table>
                                <br>
                                <hr>
                                <br>
                                <table>
                                    <tr>
                                        <td><font size="5"><b>Address Book</b></font></td>
                                        <td><b>Shipping address</b>
                                            <br>
                                            10 abcd rd Haymarket NSW
                                        </td>
                                        <td></td>
                                        
                                        
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><b>Billing address</b>
                                            <br>
                                            10 abcd rd Haymarket NSW
                                        </td>
                                        <td></td>
                                </table>
                                <br>
                                <hr>
                                <br>
                                <table>
                                    <tr>
                                        <td><font size="5"><b>Payment details</b></font></td>
                                        <td><b>Cardholder's Name</b>
                                            <br>
                                            Uts Uts
                                        </td>
                                        <td><b>Card number</b>
                                            <br>
                                            1234 1234 1234 1234
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><b>CVV</b>
                                            <br>
                                            123
                                        </td>
                                        <td><b>Expiry date (MM/YY)</b>
                                            <br>
                                            01/25
                                        </td>
                                </table>
                                <br>
                                <hr>
                            </div>
                        </div>
                        <br>
                        <br>
                <div class="footer">
                    <br>
			<div class="buttons">
				<ul class="logins-btns">
					<li>
						<div class="login-container">
							<button class="login-btn"><a href="login.jsp" class="login-text">Login</a></button>
						</div>
					</li>
					<li>
						<div class="login-container">
							<button class="login-btn"><a href="register.jsp" class="login-text">Sign Up</a></button>
						</div>
					</li>
				</ul>
			</div>
                        <br><br>
		
			<br>
			<ul class="footer-menu">
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="#"><span class="active-page">Home</span></a></button></li>
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">About</a></button></li>
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Products</a></button></li>
				<li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Contact</a></button></li>
			</ul>
			<p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
		</div>	
	</body>
</html>
