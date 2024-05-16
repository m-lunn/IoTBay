<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.uts.iotbay.model.Users"%>
<%@page import="com.uts.iotbay.model.User"%>
<%@page import="com.uts.iotbay.model.Customer"%>
<%@page import="java.io.IOException"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
	<title>IoTBay | System-Admin</title>

</head>

<body>
  <%
    Users users = (Users)request.getSession().getAttribute("users");
    String emailFilter = (String) session.getAttribute("emailFilter");
    String phoneNoFilter = (String) session.getAttribute("phoneNoFilter");
  %>
  <div class="backdrop">
    <div class="button-wrapper"></div>
    <div class="buttons">
        <ul class="menu-bar">
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="about.html">About</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="products">Products</a></button></li>
					<li><button class="btn" tabindex="-1"> <a class="button-text" href="contact.html">Contact</a></button></li>
					<li><a href="manageaccount.jsp"><button id="mng-acc-btn" tabindex="-1"><img id="mng-acc-pic" src="/assets/account.png" alt="manage account button"></button></a></li>
                    <li><a href="cart.jsp"><button id="cart-btn" tabindex="-1"><img id="cart-pic" src="/assets/shopping-cart.png" alt="manage account button"></button></a></li>
        </ul>
    </div>
    <br>
    <div class="logo">
      <img src="/assets/logo.png" id="logo" alt="logo">
      <!-- Logo created using DreamStudio by stability.ai -->
      <br><br><br>
    </div>
    <form action="search-users", method="post" class="admin-search">
      <input type="text" id="emailFilter" name="emailFilter" value="<%= (emailFilter != null ? emailFilter : "")%>" placeholder="Filter by email...">
      <input type="text" id="phoneNoFilter" name="phoneNoFilter" value="<%= (phoneNoFilter != null ? phoneNoFilter : "")%>" placeholder="Filter by phone number...">
      <button type="submit" class="logout-btn2"><div class="login-text">Search</div></button>
    </form>
    <br><br>
    <table class="admin-table">
      <tr>
        <th></th>
        <th>ID</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>User Type</th>
        <th>Status</th>
        <th></th>
      </tr>
      <% 
        int i = 0;
        for (User user : users.getUsers()) {
          int id = users.getIds().get(i);
          String email = user.getEmail();
          String phoneNo = user.getPhoneNo();
          String type = "";
          String status = "";
          if (user instanceof Customer) {
            type = "Customer";
          }
          else {
            type = "Staff";
          }
          if (user.isActive()) {
            status = "Active";
          }
          else {
            status = "Inactive";
          }
      %>
      <tr>
        <form action="delete-user", method="post">
          <input type="hidden" name="id" value="<%= id%>">
          <td><button class="x-btn">x</button></td>
        </form>
        <td><%= id%></td>
        <td><%= email%></td>
        <td><%= phoneNo%></td>
        <td><%= type%></td>
        <td><%= status%></td>
        <form action="view-user", method="post">
          <input type="hidden" name="id" value="<%= id%>">
          <input type="hidden" name="type" value="<%= type%>">
          <td><button class="submit-btn2" onclick="">View</button></td>
        </form>
      </tr>
      <% i++; }%>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td><a href="add-user.jsp"><button class="submit-btn2">Add</button></a></td>
      </tr>
    </table>
    <br><br><br><br>
    <td><button class="logout-btn2"><a href="homedirect.jsp" class="login-text">Back</a></button></td>
    <br><br><br><br>
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
