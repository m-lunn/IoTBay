<%@page import="com.uts.iotbay.model.User"%>
<%@page import="com.uts.iotbay.model.Customer"%>
<%@page import="com.uts.iotbay.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | Landing</title>

</head>

	<body>
            
            <%
                User user = (User)request.getSession().getAttribute("target-user");
				String id = (String)request.getSession().getAttribute("id");
				String type = (String)request.getSession().getAttribute("type");
                String fname = user.getFname();
                String surname = user.getSurname();
                String email = user.getEmail();
				String phoneNo = user.getPhoneNo();

				String emailErr = (String) session.getAttribute("emailErr");
				String fnameErr = (String) session.getAttribute("fnameErr");
				String surnameErr = (String) session.getAttribute("surnameErr");
				String passwordErr = (String) session.getAttribute("passwordErr");
				String phoneErr = (String) session.getAttribute("phoneErr");
				session.setAttribute("emailErr", "");
				session.setAttribute("passwordErr", "");
				session.setAttribute("fnameErr", "");
				session.setAttribute("surnameErr", "");
				session.setAttribute("phoneErr", "");
            %>
            
            
            
		<div class="backdrop">
			<div class="button-wrapper"></div>
			<div class="buttons">
				<ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp"><span class="active-page">Home</span></a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Products</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Contact</a></button></li>
				</ul>
			</div>
			<br>
			<div class="logo">
				<img src="./assets/logo.png" id="logo" alt="logo">
				<!-- Logo created using DreamStudio by stability.ai -->
				<br>
			</div>
			<div>
				<h1 class="heading-text">Viewing user: <%= fname%> <%= surname%></h1>
			</div>
            <br>

			<form action="edit-user" method="post">
				<div class="details">
					<h2 class="heading-text">Details</h2>
					<table>
						<tr>
							<td><label>ID:</label></td>
							<td><label><%= id%></label></td>
						</tr>
						<tr><td></td><td></td></tr>
						<tr>
							<td><label>User type:</label></td>
							<td><label><%= type%></label></td>
						</tr>
						<tr><td></td><td></td></tr>
						<tr>
							<td><label for="email">Email:</label></td>
							<td><input type="text" name="email" value="<%= email%>" required></td>
						</tr>
						<tr>
							<td></td>
							<td><div class="error-text"><%= emailErr%></div></td>
						</tr>
							<tr>
								<td><label for="fname">First name:</label></td>
								<td><input type="text" name="fname" value="<%= fname%>" required></td>
							</tr>
						<tr>
							<td></td>
							<td><div class="error-text"><%= fnameErr%></div></td>
						</tr>
							<tr>
								<td><label for="surname">Surname:</label></td>
								<td><input type="text" id="surname" name="surname" value="<%= surname%>" required></td>
							</tr>
						<tr>
							<td></td>
							<td><div class="error-text"><%= surnameErr%></div></td>
						</tr>
						<tr>
							<td><label for="phoneNo">Phone Number:</label></td>
							<td><input type="text" id="phoneNo" name="phoneNo" value="<%= phoneNo%>" required></td>
						</tr>
						<tr>
							<td></td>
							<td><div class="error-text"><%= phoneErr%></div></td>
						</tr>
						<tr>
							<td><label for="status">User Status:</label></td>
							<td>
								<% if (user.isActive()) { %>
								<select name="status" id="status">
									<option selected value="true">Active</option>
									<option value="false">Inactive</option>
								</select>
								<% } else {%>
								<select name="status" id="status">
									<option value="true">Active</option>
									<option selected value="false">Inactive</option>
								</select>
								<% }%>
							</td>
					  	</tr>
						<tr><td></td><td></td></tr>
						<tr>
							<td><label for="password">Reset Password (optional):</label></td>
							<td><input type="password" id="password" name="password" placeholder="Enter new password"></td>
						</tr>
						<tr>
							<td></td>
							<td><div class="error-text"><%= passwordErr%></div></td>
						</tr>
					</table>
				</div>
				<br><br><br><br>
				<div class="page-btns">
					<form action="view-users" method="post"></form>
						<button class="logout-btn"><div class="login-text">Back</div></button>
					</form>
					<button type="submit" class="logout-btn"><div class="login-text">Apply</div></button>
				</div>
			</form>
			<br><br><br><br>
		</div>

        <div class="footer">
            <br>
            <ul class="footer-menu">
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="homedirect.jsp"><span class="active-page">Home</span></a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">About</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Products</a></button></li>
                <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Contact</a></button></li>
            </ul>
            <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
        </div>	
	</body>
</html>
