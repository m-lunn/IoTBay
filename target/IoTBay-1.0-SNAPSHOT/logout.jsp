<%-- 
    Document   : logout
    Created on : 14 Apr 2024, 1:53:57 am
    Author     : michaellunn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    request.getSession().invalidate();
    response.sendRedirect("index.jsp");
%>
