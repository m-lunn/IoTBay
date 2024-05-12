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
public class ModifyProductsServlet extends HttpServlet {

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

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");

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
                htmlInsert += "<div class=\"product-staff\">\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><img class=\"product-pic-staff\" src=\"../" + p.getImagePath() + "\"></a>\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\"><h3 class=\"product-name-staff\">" + p.getName() + "</h3></a>\n";
                htmlInsert += "<div class=\"modify-product-btns\">\n";
                htmlInsert += "<a href=\"product/edit/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"edit-product\">Edit</Button></a>\n";
                htmlInsert += "<a href=\"product/delete/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"delete-product\">Delete</Button></a>\n";
                htmlInsert += "</div>\n</div>\n";

            }

            if(products.size() == 0){
                request.getSession().setAttribute("errorMsg", "No products found.");
            }

            request.getSession().setAttribute("products", htmlInsert);
            RequestDispatcher rd = request.getRequestDispatcher("modifyproducts.jsp");
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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE product_category LIKE ? AND product_name LIKE ?");
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
                htmlInsert += "<a href=\"product/delete/" + p.getProductID() + "\">" + "<Button class=\"modify-product-btn\" id=\"delete-product\">Delete</Button></a>\n";
                htmlInsert += "</div>\n</div>\n";

            }

            if(products.size() == 0){
                request.getSession().setAttribute("errorMsg", "No products found.");
            }

            request.getSession().setAttribute("category", displayCategory);
            request.getSession().setAttribute("search", displaySearch);

            request.getSession().setAttribute("products", htmlInsert);
            RequestDispatcher rd = request.getRequestDispatcher("modifyproducts.jsp");
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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");
            
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