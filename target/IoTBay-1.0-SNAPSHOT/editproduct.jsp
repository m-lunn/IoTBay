<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
    <title>IoTBay - Edit Product</title>
</head>

<%
String productName="";
String productDescription="";
float productPrice="";
String productImagePath="";
String productCategory="";

String errorMsg = (String)request.getSession().getAttribute("errorMsg");
request.getSession().setAttribute("errorMsg", "");

if(errorMsg == null) {
    errorMsg = "";
}

Product product = (Product)request.getSession().getAttribute("product");
if(product != null) {
    String productName="";
    String productDescription="";
    float productPrice="";
    String productImagePath="";
    String productCategory="";
}
else {
    response.sendRedirect("products");
}
%>

<body>
    <div class="backdrop">
        <div class="button-wrapper"></div>
        <div class="buttons">
            <ul class="menu-bar">
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="homedirect.jsp">Home</a></button></li>
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">About</a></button></li>
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Products</a></button></li>
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="underconstruction.html">Contact</a></button></li>
            </ul>
        </div>
        <div>
            <h1 class="subheading-text">Editing Product: <%= productName%></h1>
        </div>
        <div class="product-container">
            <div class="left-column">
                <img src="<%= productImagePath%>" alt="Product Image">
            </div>
            <div class="right-column">
                <form action="updateProduct" method="post">
                    <!-- Input fields for updating product information -->
                    <div class="product-group">
                        <label for="productName">Product Name:</label>
                        <input value="<%=productName%>" type="name" id="productName" name="productName" value="TP-LINK TL-MR3420 3G/4G Wireless N300 Router" required>
                    </div>
                    <div class="product-group">
                        <label for="productPrice">Price:</label>
                        <input value="<%=productPrice%>" type="price" id="productPrice" name="productPrice" value="399.00" required>
                    </div>
                    <div class="product-group">
                        <label for="productDescription">Description:</label>
                        <input value="<%=productDescription%>" type="description" id="description" name="productDescription" rows="4" cols="50" value="TP-LINK TL-MR3420 3G/4G N300 Wireless Router. Connect a 3/4G USB dongle to TL-MR3420 and instantly create your own Wi-Fi hotspot. Share a stable internet connection with your friends and family. TL-MR3420 is compatible with the majority of brands, struggling to get a fast connection with more devices? TL-MR3420 delivers up to 300Mbps speeds for up to 32 online devices at the same time. Stay connected with your smartphone, laptop, games console and more. TL-MR3420 also supports a WAN internet connection via an Ethernet cable. Switch between wired WAN and wireless 3/4G connections as required with this cost-effective all-in-one router."</input>
                    </div>
                    <button type="" form="updateProduct" class="saveproduct-btn">Save Changes</button>
                    <button type="" class="saveproduct-btn">Close</button>
                </form>
            </div>
        </div>
    </div>

    <div class="footer">
        <br>
        <ul class="footer-menu">
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="homedirect.jsp">Home</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">About</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Products</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Contact</a></button></li>
        </ul>
        <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
    </div>
</body>

</html>
