
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
Product product1 = (Product)request.getSession().getAttribute("product");

if(product1 == null){
	response.sendRedirect("index.jsp");
}

String productname = product1.getName();
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
					<div class="left-column">
						<img src="https://m.media-amazon.com/images/I/51TY0OI74wL._AC_UF894,1000_QL80_.jpg" alt="Product Image">
					</div>
					<div class="right-column">
						<div class="product-description">
						<span>Router</span>
						<h1><%= productname></h1>
						<h2>$399.00</h2>
						<button class="addtocart-btn">Add to cart</button>
						<p1>TP-LINK TL-MR3420 3G/4G N300 Wireless Router Connect a 3/4G USB dongle to TL-MR3420 and instantly create your own Wi-Fi hotspot. Share a stable internet connection with your friends and family. TL-MR3420 is compatible with the majority of brands, Struggling to get a fast connection with more devices? TL-MR3420 delivers up to 300Mbps speeds for up to 32 online devices at the same time. 
							Stay connected with your smartphone, laptop, games console and more, TL-MR3420 also supports a WAN internet connection via an Ethernet cable. Switch between wired WAN and wireless 3/4G connections as required with this cost-effective all-in-one router.</p1>
					</div>
					</div>
				</div>

			</div> <!-- End of body -->
				 

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