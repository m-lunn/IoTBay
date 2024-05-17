<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.uts.iotbay.model.Payment"%>
<%@page import="com.uts.iotbay.model.User"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Space+Mono:ital,wght@0,400;0,700;1,400;1,700&display=swap"
        rel="stylesheet">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
    <title>IoTBay - View Payment Method</title>
</head>
<%
            String cardNumber="";
            String expiryDate="";
            String cvv="";
            String nameOnCard="";

            String errorMsg = (String)request.getSession().getAttribute("errorMsg");
            request.getSession().setAttribute("errorMsg", "");

            if(errorMsg == null) {
                errorMsg = "";
            }

    
            User user = (User)request.getSession().getAttribute("user");
    
            if(user == null){
                response.sendRedirect("homedirect.jsp");
            }
            String fname = user.getFname();
            String email = user.getEmail();
            String htmlInsert = (String)request.getSession().getAttribute("payment");
            String fromDate = (String)request.getSession().getAttribute("fromdate");
            String toDate = (String)request.getSession().getAttribute("todate");
    
    
        %>
<body>
    <div class="backdrop">
        <div class="button-wrapper"></div>
        <div class="buttons">
            <ul class="menu-bar">
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="products">Products</a></button></li>
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html"><span
                                class="active-page">Contact</span></a></button></li>
                <li><a href="manageaccount.jsp"><button id="mng-acc-btn" tabindex="-1"><img id="mng-acc-pic"
                                src="./assets/account.png" alt="manage account button"></button></a></li>
                <li><a href="cart.jsp"><button id="cart-btn" tabindex="-1"><img id="cart-pic"
                                src="./assets/shopping-cart.png" alt="manage account button"></button></a></li>
            </ul>
        </div>
        <br>
        <div class="logo">
            <img src="./assets/logo.png" id="logo" alt="logo">
            <!-- Logo created using DreamStudio by stability.ai -->
            <br>
            <div>
                <h1 class="heading-text">Payment Method Details</h1>
            </div>

            <br><br><br>
            <div class="access-logs-container">
                <table class="access-log-table">
                    <%out.println(htmlInsert);%>
                </table>
            </div>
            <br><br><br>
        </div>

    </div>

    <div class="footer">
        <br>
        <ul class="footer-menu">
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text"
                        href="homedirect.jsp">Home</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="about.html">About</a></button>
            </li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text"
                        href="products">Products</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text"
                        href="contact.html"><span class="active-page">Contact</span></a></button></li>
        </ul>
        <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
    </div>
</body>

</html>