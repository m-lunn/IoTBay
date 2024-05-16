package com.uts.iotbay.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.uts.iotbay.model.Product;
import com.uts.iotbay.model.dao.DBManager;

public class ViewProductsServlet extends HttpServlet {

    private final DecimalFormat df = new DecimalFormat("0.00"); 
    Boolean switchView = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String category = (String) session.getAttribute("category");
        String search = (String) session.getAttribute("search");
        
        if(category != null || search != null){
            switchView = true;
            doPost(request, response);
            return;
        }

        ArrayList<Product> products = new ArrayList<>();

        try {
            products = manager.getAllProducts();
        } catch (SQLException ex) {
            Logger.getLogger(ViewProductsServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }

        String htmlInsert = generateProductsViewHTMLInsert(products);

        session.setAttribute("productsCount", products.size()+"");

        if(products.size() == 0){
            session.setAttribute("errorMsg", "No products found.");
        }

        session.setAttribute("products", htmlInsert);
        // response.sendRedirect("products.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
        rd.forward(request, response);
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        request.getSession().setAttribute("errorMsg", "");

        String displayCategory = (String)request.getParameter("category");
        String displaySearch = (String)request.getParameter("name");

        if(switchView) {
            displayCategory = (String) session.getAttribute("category");
            displaySearch = (String) session.getAttribute("search");
            switchView = false;
        }
        
        String category = displayCategory;
        String search = displaySearch;

        if(search == null || search.equals("")){search = "%";}

        if(category.equals("Any")){category = "%";}
        else {
            category = category.toLowerCase().substring(0, category.length() - 1);
        }

        ArrayList<Product> products = new ArrayList<>();

        try {
            products = manager.getFilteredProducts(category, search);
        } catch (SQLException ex) {
            Logger.getLogger(ViewProductsServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }

        String htmlInsert = generateProductsViewHTMLInsert(products);

        if(products.size() == 0){
            request.getSession().setAttribute("errorMsg", "No products found.");
        }

        request.getSession().setAttribute("productsCount", products.size()+"");

        request.getSession().setAttribute("category", displayCategory);
        request.getSession().setAttribute("search", displaySearch);

        request.getSession().setAttribute("products", htmlInsert);
        RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
        rd.forward(request, response);

    }

    private String generateProductsViewHTMLInsert(ArrayList<Product> products) {

        String htmlInsert = "";

        for(Product p : products) {
            htmlInsert += "<div class=\"product\">\n";
            htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><img class=\"product-img\" src=\"" + p.getImagePath().substring(2) + "\"</a>\n";
            htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><h3 class=\"product-name\">" + p.getName() + "</h3></a>\n";
            htmlInsert += "<div class=\"fill\"></div>";
            htmlInsert += "<div class=\"buy-line\">\n";
            htmlInsert += "<p class=\"price\">$" + df.format(p.getPrice()) + "</p>\n";
            htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><Button class=\"view-product-btn\">View Product</Button></a>\n";
            htmlInsert += "</div>\n</div>\n";
        }
        return htmlInsert;
    }

}