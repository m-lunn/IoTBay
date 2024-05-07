<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <br><br><br>
        </div>
        <table class="admin-table">
            <tr>
              <th></th>
              <th>Email</th>
              <th>Password</th>
              <th>Phone Number</th>
              <th>User Type</th>
              <th></th>
            </tr>
            <tr>
              <td><button class="x-btn">x</button></td>
              <td>Alfreds Futterkiste</td>
              <td>Maria Anders</td>
              <td>Germany</td>
              <td>Germany</td>
              <td><a href="logout.jsp"></a><button class="submit-btn2">View</button></a></td>
            </tr>
            <tr>
              <td><button class="x-btn">x</button></td>
              <td>Centro comercial Moctezuma</td>
              <td>Francisco Chang</td>
              <td>Mexico</td>
              <td>Germany</td>
              <td><a href="logout.jsp"></a><button class="submit-btn2">View</button></a></td>
            </tr>
            <tr>
              <td><button class="x-btn">x</button></td>
              <td>Centro comercial Moctezuma</td>
              <td>Francisco Chang</td>
              <td>Mexico</td>
              <td>Germany</td>
              <td><a href="logout.jsp"></a><button class="submit-btn2">View</button></a></td>
            </tr>
            <tr>
              <td><button class="x-btn">x</button></td>
              <td>Centro comercial Moctezuma</td>
              <td>Francisco Chang</td>
              <td>Mexico</td>
              <td>Germany</td>
              <td><a href="logout.jsp"></a><button class="submit-btn2">View</button></a></td>
            </tr>
            <tr>
              <td><button class="x-btn">x</button></td>
              <td>Centro comercial Moctezuma</td>
              <td>Francisco Chang</td>
              <td>Mexico</td>
              <td>Germany</td>
              <td><a href="logout.jsp"></a><button class="submit-btn2">View</button></a></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="logout.jsp"></a><button class="submit-btn2">Add</button></a></td>
              </tr>
        </table>
        <br><br><br><br>
        <td><button class="logout-btn"><a href="homedirect.jsp" class="login-text">Back</a></button></td>
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
