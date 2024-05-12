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
        search {
            width: 100px;
            
        }
            
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
                                <font size="6"><b>Order History</b></font>
                                <br><br>
                                <b>Search : </b><input class="search" id="search_history">
                                <br>
                                <hr>
                                <br>
                                
                                <table>
                                    <tr>
                                        <td>PROCESSING 
                                            <br>
                                            234834
                                            <br>
                                            03 May 2024
                                            <br>
                                            $150
                                            <br><br>
                                            
                                            <button type="button" >Edit</button>
                                            <button type="button" >Cancel</button>
                                        </td>
                                        <td>Screen 03
                                            <br>
                                            Screen 05
                                        </td> 
                                    </tr>
                                    
                                </table>
                                
                                <br>
                                <hr>
                                <br>
                                <table>
                                    <tr>
                                        <td>COMPLETE
                                            <br>
                                            234859
                                            <br>
                                            03 September 2020
                                            <br>
                                            $150
                                        </td>
                                        <td>Screen 03
                                            <br>
                                            Screen 05
                                        </td> 
                                    </tr>
                                    
                                </table>
                                <br>
                                <hr>
                                <br>
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
