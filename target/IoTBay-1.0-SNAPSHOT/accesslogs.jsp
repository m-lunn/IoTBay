<%-- 
    Document   : landing
    Created on : 14 Apr 2024, 12:20:15 am
    Author     : michaellunn
--%>
<%@page import="com.uts.iotbay.User"%>
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
	<%
		User user = (User)request.getSession().getAttribute("user");
		String fname = user.getFname();
		String email = user.getEmail();
        String htmlInsert = (String)request.getSession().getAttribute("accesslogs");
        String fromDate = (String)request.getSession().getAttribute("fromdate");
        String toDate = (String)request.getSession().getAttribute("todate");

	%>
	<body>
		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="#"><span class="active-page">Home</span></a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Products</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Contact</a></button></li>
					<li><button id="mng-acc-btn" tabindex="-1"><a href="manageaccount.html"><img id="mng-acc-pic" src="./assets/account.png" alt="manage account button"></a></button></li>
				</ul>
			</div>
			<br>
			<div class="logo">
				<img src="./assets/logo.png" id="logo" alt="logo">
				<!-- Logo created using DreamStudio by stability.ai -->
				<br>
			</div>
			<div>
				<h1 class="heading-text">Access Logs</h1>
			</div>
            <br>
            <div>
                <h2 class="subheading-text">All logs for:</h2>
                
                <h2 class="email-text"><%= email%></h2>
                <br>
                <div class="date-range">
                    <form action="accesslogs" class="date-range-form" method="post">
                        <label class="date-range-form-label" for="from">From:</label>
                        <input class="date-range-form-input" type="date" id="from" name="from" value="<%=fromDate%>">
                        <label class="date-range-form-label" for="to">To:</label>
                        <input class="date-range-form-input" type="date" id="to" name="to" value="<%=toDate%>">
                        <input class="date-range-form-input" id="date-range-submit" type="submit" value="Filter">
                    </form>
                </div>
                <br>
                <div class="access-logs-container">
                <%out.println(htmlInsert);%>
                </div>
                <br><br><br><br>
            </div>

	</div>
     

        <div class="footer">
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
