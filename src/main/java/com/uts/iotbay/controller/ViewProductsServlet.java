package com.uts.iotbay.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.uts.iotbay.model.Product;
import com.uts.iotbay.model.User;

/**
 *
 * @author michaellunn
 */
public class ViewProductsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        DecimalFormat df = new DecimalFormat("0.00");

        String category = (String)request.getSession().getAttribute("category");
        String search = (String)request.getSession().getAttribute("search");

        if(category != null || search != null){
            switchView(request, response);
            return;
        }

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay2", "root", "iotbay");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE product_active = 1");
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
                htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><img class=\"product-img\" src=\"" + p.getImagePath() + "\"</a>\n";
                htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><h3 class=\"product-name\">" + p.getName() + "</h3></a>\n";
                htmlInsert += "<div class=\"fill\"></div>";
                htmlInsert += "<div class=\"buy-line\">\n";
                htmlInsert += "<p class=\"price\">$" + df.format(p.getPrice()) + "</p>\n";
                htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><Button class=\"view-product-btn\">View Product</Button></a>\n";
                htmlInsert += "</div>\n</div>\n";
            }

            request.getSession().setAttribute("productsCount", products.size()+"");


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

        DecimalFormat df = new DecimalFormat("0.00");  
        request.getSession().setAttribute("errorMsg", "");

        String displayCategory = (String)request.getParameter("category");

        String category = (String)request.getParameter("category").toLowerCase();
       
        if(category.equals("any")){
            category = "%";
        }
        else {
            category = category.substring(0, category.length() - 1);
        }

        String displaySearch = (String)request.getParameter("name");
        String search = (String)request.getParameter("name");
        if(search.equals("")){
            search = "%";
        }


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay2", "root", "iotbay");

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
                htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><img class=\"product-img\" src=\"" + p.getImagePath() + "\"</a>\n";
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

    public int getUserID(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userID = -1;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay2", "root", "iotbay");
            
            User user = (User)request.getSession().getAttribute("user");
            String email = user.getEmail();

            PreparedStatement findUserID = con.prepareStatement("SELECT user_id from Users WHERE user_email = ?");
            findUserID.setString(1, email);
            ResultSet userIDs = findUserID.executeQuery();

            userID = -1;

            if(userIDs.next()) {
                userID = userIDs.getInt("user_id");
            }
        }
        catch(Exception e) {
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
        return userID;
    }

    public void switchView(HttpServletRequest request, HttpServletResponse response) throws IOException {

        DecimalFormat df = new DecimalFormat("0.00");  
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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay2", "root", "iotbay");

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
                htmlInsert += "<a href=\"product/" + p.getProductID() + "\"><img class=\"product-img\" src=\"" + p.getImagePath() + "\"</a>\n";
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