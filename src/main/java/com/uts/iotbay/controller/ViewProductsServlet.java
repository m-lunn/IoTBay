package com.uts.iotbay.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.uts.iotbay.model.Product;
import com.uts.iotbay.model.dao.DBManager;

public class ViewProductsServlet extends HttpServlet {

    private final DecimalFormat df = new DecimalFormat("0.00"); 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String category = (String) session.getAttribute("category");
        String search = (String) session.getAttribute("search");
        
        if(category != null || search != null){
            doPost(request, response);
            return;
        }

        ArrayList<Product> products = new ArrayList<>();

        try {
            products = manager.getAllProducts();
        } catch (SQLException ex) {
            Logger.getLogger(ViewProductsServlet.class.getName()).log(Level.SEVERE, null, ex);    
        }

        String htmlInsert = "";

        for(Product p : products) {
            htmlInsert += "<div class=\"product\">\n";
            htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><img class=\"product-img\" src=\"/" + p.getImagePath() + "\"</a>\n";
            htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><h3 class=\"product-name\">" + p.getName() + "</h3></a>\n";
            htmlInsert += "<div class=\"fill\"></div>";
            htmlInsert += "<div class=\"buy-line\">\n";
            htmlInsert += "<p class=\"price\">$" + df.format(p.getPrice()) + "</p>\n";
            htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><Button class=\"view-product-btn\">View Product</Button></a>\n";
            htmlInsert += "</div>\n</div>\n";
        }

        session.setAttribute("productsCount", products.size()+"");

        if(products.size() == 0){
            session.setAttribute("errorMsg", "No products found.");
        }

        session.setAttribute("products", htmlInsert);
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

        String htmlInsert = "";

        for(Product p : products) {
            htmlInsert += "<div class=\"product\">\n";
            htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><img class=\"product-img\" src=\"/" + p.getImagePath() + "\"</a>\n";
            htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><h3 class=\"product-name\">" + p.getName() + "</h3>\n";
            htmlInsert += "<div class=\"fill\"></div>";
            htmlInsert += "<div class=\"buy-line\">\n";
            htmlInsert += "<p class=\"price\">$" + df.format(p.getPrice()) + "</p>\n";
            htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><Button class=\"view-product-btn\">View Product</Button></a>\n";
            htmlInsert += "</div>\n</div>\n";
        }

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

    public void switchView(HttpServletRequest request, HttpServletResponse response) throws IOException {
 
        request.getSession().setAttribute("errorMsg", "");

        String displayCategory = (String)request.getSession().getAttribute("category");
        String category = (String)request.getSession().getAttribute("category").toString().toLowerCase();
       
        if(category.equals("any")){
            category = "%";
        }
        else {
            category = category.substring(0, category.length() - 1);
        }

        String displaySearch = (String)request.getSession().getAttribute("search");
        String search = (String)request.getSession().getAttribute("search");
        if(search.equals("")){
            search = "%";
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE product_category LIKE ? AND product_name LIKE ? AND product_active = 1");
            ps.setString(1, "%" + category + "%");
            ps.setString(2, "%" + search + "%");

            ResultSet rs = ps.executeQuery();

            ArrayList<Product> products = new ArrayList<>();

            while(rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                String productDescription = rs.getString(3);
                float productPrice = rs.getFloat(4);
                String image_path = rs.getString(5);
                products.add(new Product(productID, productName, productDescription, productPrice, image_path));
            }

            String htmlInsert = "";

            for(Product p : products) {
                htmlInsert += "<div class=\"product\">\n";
                htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><img class=\"product-img\" src=\"/" + p.getImagePath() + "\"</a>\n";
                htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><h3 class=\"product-name\">" + p.getName() + "</h3>\n";
                htmlInsert += "<div class=\"fill\"></div>";
                htmlInsert += "<div class=\"buy-line\">\n";
                htmlInsert += "<p class=\"price\">$" + df.format(p.getPrice()) + "</p>\n";
                htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><Button class=\"view-product-btn\">View Product</Button></a>\n";
                htmlInsert += "</div>\n</div>\n";
            }

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
        catch(Exception e){
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            out.println(sw.toString());
            out.println("</body>");
            out.println("</html>");
        }

    }

}