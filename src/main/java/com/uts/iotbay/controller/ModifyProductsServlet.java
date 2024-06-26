package com.uts.iotbay.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.uts.iotbay.model.Product;
import com.uts.iotbay.model.dao.DBManager;

public class ModifyProductsServlet extends HttpServlet {

    Boolean switchView = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");

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
            Logger.getLogger(ModifyProductsServlet.class.getName()).log(Level.SEVERE, null, ex);    

        }

        String htmlInsert = generateStaffProductViewHTMLInsert(products);

        if(products.size() == 0){
            request.getSession().setAttribute("errorMsg", "No products found.");
        }

        request.getSession().setAttribute("productsCount", products.size()+"");
        request.getSession().setAttribute("products", htmlInsert);
        
        RequestDispatcher rd = request.getRequestDispatcher("modifyproducts.jsp");
        rd.forward(request, response);

    }  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");

        request.getSession().setAttribute("errorMsg", "");


        String displayCategory = (String)request.getParameter("category"); // Display category and display search are used to communicate 
        String displaySearch = (String)request.getParameter("name");       // what heading should be on the products page when using filters.
        
        if(switchView) {
            displayCategory = (String) session.getAttribute("category"); // The switchView boolean keeps track of whether a staff
            displaySearch = (String) session.getAttribute("search");     // user is switching between staff and customer view.
            switchView = false;                                               // In this case the session stores the attributes between these pages 
        }                                                                     // and they are then reused in the search fields
                                                                              // This results in smoother user experience. 
                                                                              // Otherwise, user would have to re-enter search fields everytime they switched view.
        String category = displayCategory;
        String search = displaySearch;

        if(search == null || search.equals("")){search = "%";}          // Checks if user submitted no search parameter. Sets to '%' for SQL LIKE matching.

        if(category == null || category.equals("Any")){category = "%";} // Same as above but for category.
        else {
            category = category.toLowerCase().substring(0, category.length() - 1);
        }

        ArrayList<Product> products = new ArrayList<>();

        try {
            products = manager.getFilteredProducts(category, search);
        } catch (SQLException ex) {
            Logger.getLogger(ViewProductsServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }

        String htmlInsert = generateStaffProductViewHTMLInsert(products);

        if(products.size() == 0){
            request.getSession().setAttribute("errorMsg", "No products found.");
        }

        request.getSession().setAttribute("productsCount", products.size()+"");
        request.getSession().setAttribute("category", displayCategory);
        request.getSession().setAttribute("search", displaySearch);
        request.getSession().setAttribute("products", htmlInsert);

        RequestDispatcher rd = request.getRequestDispatcher("modifyproducts.jsp");
        rd.forward(request, response);
    }

    // This method takes an ArrayList of products and converts them to a HTML formatted list that is injected into the jsp page.
    private String generateStaffProductViewHTMLInsert(ArrayList<Product> products) {

        String htmlInsert = "";

        for(Product p : products) {
            htmlInsert += "<div class=\"product-staff\">\n";
            htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><img class=\"product-pic-staff\" src=\"../" + p.getImagePath().substring(2) + "\"></a>\n";
            htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><h3 class=\"product-name-staff\">" + p.getName() + "</h3></a>\n";
            htmlInsert += "<div class=\"modify-product-btns\">\n";
            htmlInsert += "<a href=\"product/" + p.getName() + "\">" + "<Button class=\"modify-product-btn\" id=\"edit-product\">Edit</Button></a>\n";
            htmlInsert += "<a href=\"products/delete/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"delete-product\">Delete</Button></a>\n";
            htmlInsert += "</div>\n</div>\n";
        }
        return htmlInsert;
    }
}