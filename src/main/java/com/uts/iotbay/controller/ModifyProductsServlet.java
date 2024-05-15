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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uts.iotbay.model.Product;
import com.uts.iotbay.model.dao.DBManager;

public class ModifyProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("maanger");

        // try{
        //     String category = (String)request.getSession().getAttribute("category");
        //     String search = (String)request.getSession().getAttribute("search");

        //     Class.forName("com.mysql.cj.jdbc.Driver");
        //     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");

        //     if(request.getRequestURI().contains("delete")) {

        //         category = (String)request.getSession().getAttribute("category");
        //         if(category == null){category = "Any";}
        //         search = (String)request.getSession().getAttribute("search");
        //         if(search == null){search = "";}

        //         String[] url = request.getRequestURI().split("/");
        //         int idToDelete = Integer.parseInt(url[url.length-1]);

        //         PreparedStatement getProductName = con.prepareStatement("SELECT product_name FROM Products WHERE product_id = ?");
        //         getProductName.setInt(1, idToDelete);
        //         ResultSet rs = getProductName.executeQuery();
    
        //         if(rs.next()){
        //             String name = rs.getString("product_name");
        //             request.getSession().setAttribute("successMsg", name + " successfully deleted.");
        //         }

        //         deleteProduct(idToDelete);
        //         request.getSession().setAttribute("products", getProducts(category, search, request, response));
        //         response.sendRedirect("/staff/modifyproducts.jsp");
        //         return;

        //     }

            // if(category != null || search != null){
            //     switchView(request, response);
            //     return;
            // }

    ArrayList<Product> products = new ArrayList<>();

    try {
        products = manager.getAllProducts();
    } catch (SQLException ex) {
        Logger.getLogger(ModifyProductsServlet.class.getName()).log(Level.SEVERE, null, ex);    

    }

    String htmlInsert = "";

    for(Product p : products) {
        htmlInsert += "<div class=\"product-staff\">\n";
        htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><img class=\"product-pic-staff\" src=\"../" + p.getImagePath() + "\"></a>\n";
        htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><h3 class=\"product-name-staff\">" + p.getName() + "</h3></a>\n";
        htmlInsert += "<div class=\"modify-product-btns\">\n";
        htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"edit-product\">Edit</Button></a>\n";
        htmlInsert += "<a href=\"products/delete/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"delete-product\">Delete</Button></a>\n";
        htmlInsert += "</div>\n</div>\n";
    }

    if(products.size() == 0){
        request.getSession().setAttribute("errorMsg", "No products found.");
    }
    request.getSession().setAttribute("productsCount", products.size()+"");

    request.getSession().setAttribute("products", htmlInsert);
    
    RequestDispatcher rd = request.getRequestDispatcher("/modifyproducts.jsp");
    rd.forward(request, response);
    
    }  
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String displayCategory = (String)request.getParameter("category");
        if(displayCategory == null){
            displayCategory = "Any";
        }

        String category = displayCategory.toLowerCase();
       
        if(category.equals("any")){
            category = "%";
        }
        else {
            category = category.substring(0, category.length() - 1);
        }

        String displaySearch = (String)request.getParameter("name");
        if(displaySearch == null) {
            displaySearch = "";
        }
        String search = displaySearch;

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
                htmlInsert += "<div class=\"product-staff\">\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><img class=\"product-pic-staff\" src=\"../" + p.getImagePath() + "\"></a>\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><h3 class=\"product-name-staff\">" + p.getName() + "</h3></a>\n";
                htmlInsert += "<div class=\"modify-product-btns\">\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"edit-product\">Edit</Button></a>\n";
                htmlInsert += "<a href=\"products/delete/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"delete-product\">Delete</Button></a>\n";
                htmlInsert += "</div>\n</div>\n";

            }

            if(products.size() == 0){
                request.getSession().setAttribute("errorMsg", "No products found.");
            }

            request.getSession().setAttribute("productsCount", products.size()+"");

            request.getSession().setAttribute("category", displayCategory);
            request.getSession().setAttribute("search", displaySearch);

            request.getSession().setAttribute("products", htmlInsert);
            RequestDispatcher rd = request.getRequestDispatcher("/staff/modifyproducts.jsp");
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

    public void switchView(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String displayCategory = (String)request.getSession().getAttribute("category");

        String category = displayCategory.toLowerCase();
       
        if(category.equals("any")){
            category = "%";
        }
        else {
            category = category.substring(0, category.length() - 1);
        }

        String displaySearch = (String)request.getSession().getAttribute("search");

        String search = displaySearch;

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
                htmlInsert += "<div class=\"product-staff\">\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><img class=\"product-pic-staff\" src=\"../" + p.getImagePath() + "\"></a>\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><h3 class=\"product-name-staff\">" + p.getName() + "</h3></a>\n";
                htmlInsert += "<div class=\"modify-product-btns\">\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"edit-product\">Edit</Button></a>\n";
                htmlInsert += "<a href=\"products/delete/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"delete-product\">Delete</Button></a>\n";
                htmlInsert += "</div>\n</div>\n";

            }

            if(products.size() == 0){
                request.getSession().setAttribute("errorMsg", "No products found.");
            }

            request.getSession().setAttribute("productsCount", products.size()+"");

            request.getSession().setAttribute("category", displayCategory);
            request.getSession().setAttribute("search", displaySearch);

            request.getSession().setAttribute("products", htmlInsert);
            RequestDispatcher rd = request.getRequestDispatcher("/staff/modifyproducts.jsp");
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

    public void deleteProduct(int idToDelete) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");

            PreparedStatement ps = con.prepareStatement("UPDATE Products SET product_active = 0 WHERE product_id = ?");
            ps.setInt(1, idToDelete);
            ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch(Exception e){
            // PrintWriter out = response.getWriter();
            // out.println("<!DOCTYPE html>");
            // out.println("<html>");
            // out.println("<head>");
            // out.println("<title>Servlet LoginServlet</title>");            
            // out.println("</head>");
            // out.println("<body>");
            // StringWriter sw = new StringWriter();
            // PrintWriter pw = new PrintWriter(sw);
            // e.printStackTrace(pw);
            // out.println(sw.toString());
            // out.println("</body>");
            // out.println("</html>");
        }
    }

    public String getProducts(String category, String search, HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        String displayCategory = category;
        String displaySearch = search;

        category = category.toLowerCase();

        if(category.equals("any")){
            category = "%";
        }
        else {
            category = category.substring(0, category.length() - 1);
        }

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
                htmlInsert += "<div class=\"product-staff\">\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><img class=\"product-pic-staff\" src=\"../" + p.getImagePath() + "\"></a>\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><h3 class=\"product-name-staff\">" + p.getName() + "</h3></a>\n";
                htmlInsert += "<div class=\"modify-product-btns\">\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"edit-product\">Edit</Button></a>\n";
                htmlInsert += "<a href=\"products/delete/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"delete-product\">Delete</Button></a>\n";
                htmlInsert += "</div>\n</div>\n";

            }

            if(products.size() == 0){
                request.getSession().setAttribute("errorMsg", "No products found.");
            }

            request.getSession().setAttribute("productsCount", products.size()+"");

            request.getSession().setAttribute("category", displayCategory);
            request.getSession().setAttribute("search", displaySearch);

            request.getSession().setAttribute("products", htmlInsert);

            return htmlInsert;

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
        return null;

    }

    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}