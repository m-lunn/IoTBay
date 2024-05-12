<%-- 
    Document   : mypage
    Created on : 2024. 5. 8., ì¤í 3:20:14
    Author     : miyamacpro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        
        <%
            String fname = request.getParameter("name");
        %>
        
        <h1>Welcome Back!<$= fname $> </h1>
    </body>
</html>


