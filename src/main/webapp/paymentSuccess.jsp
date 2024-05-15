<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Mono">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
    <title>IoTBay | Create Payment</title>
</head>
<body>
    <div class="backdrop">
        <div class="button-wrapper"></div>
        <div class="buttons">
            <ul class="menu-bar">
                <li><button class="btn" tabindex="-1"> <a class="button-text" href="index.jsp">Home</a></button></li>
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
            <h1 class="heading-text">Payment Success</h1>
        </div>

        <br><br><br>
        <div class="form-container">
            <form action="payment.jsp" method="post">
                <div class="form-group">
                    <label for="cardNumber">Card Number:</label>
                    <input type="text" id="cardNumber" name="cardNumber" placeholder="Card Number" required>
                </div>
                <div class="form-group">
                    <label for="expiryDate">Expiry Date:</label>
                    <input type="text" id="expiryDate" name="expiryDate" placeholder="MM/YY" required>
                </div>
                <div class="form-group">
                    <label for="cvv">CVV:</label>
                    <input type="text" id="cvv" name="cvv" placeholder="CVV" required>
                </div>
                <div class="form-group">
                    <label for="nameOnCard">Name on Card:</label>
                    <input type="text" id="nameOnCard" name="nameOnCard" placeholder="Name on Card" required>
                </div>
                <button type="submit" class="submit-btn">Create Payment</button>
            </form>
        </div>
        <br><br><br>
    </div>

    <div class="footer">
        <br>
        <ul class="footer-menu">
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="index.jsp">Home</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">About</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Products</a></button></li>
            <li><button class="footer-button" tabindex="-1"><a class="footer-button-text" href="underconstruction.html">Contact</a></button></li>
        </ul>
        <p class="bottom-text">By Groot | University of Technology | Autumn 2024</p>
    </div>
</body>
</html>