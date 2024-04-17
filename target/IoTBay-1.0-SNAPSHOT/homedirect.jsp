<%-- 
    Document   : homedirect
    Created on : 14 Apr 2024, 2:02:44 am
    Author     : michaellunn
--%>
<%@page import="com.uts.iotbay.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    User user = (User)request.getSession().getAttribute("user");
    if(user != null) {
       response.sendRedirect("landing.jsp");
    }
    else {
        response.sendRedirect("index.jsp");
    }
    
%>
