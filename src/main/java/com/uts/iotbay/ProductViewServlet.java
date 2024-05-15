package com.uts.iotbay;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author michaellunn
 */
//@WebServlet(urlPatterns = {"/login"})
public class ProductViewServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
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
        try {
            String[] url = request.getRequestURI().split("/");
            int productId = Integer.parseInt(url[url.length - 1]);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "iotbay");

            PreparedStatement findProduct = con.prepareStatement("select * from products where product_id=?");
            findProduct.setInt(1, productId);
            ResultSet rs = findProduct.executeQuery();

            if(rs.next()) {
                String productNameDB = rs.getString("product_name");
                String productDescriptionDB = rs.getString("product_description");
                float productPriceDB = rs.getFloat("product_price");
                String productImgPathDB = rs.getString("product_image_path");
                String productCategoryDB = rs.getString("product_category");

                    String sqlInsert = "INSERT INTO AccessLogs (product_id, date_accessed, activity_type) VALUES (?, CURRENT_TIMESTAMP(),\"Successful Login\")";
                    PreparedStatement logStatement = con.prepareStatement(sqlInsert);
                    logStatement.setInt(1, productId);
                    logStatement.executeUpdate();
                    request.getSession().setAttribute("errorMsg", "");
                    Product product = new Product(productId, productNameDB, productDescriptionDB, productPriceDB, productImgPathDB, productCategoryDB);
                    request.getSession().setAttribute("product", product);
                    RequestDispatcher rd = request.getRequestDispatcher("underconstruction.jsp");
                    rd.forward(request, response);
            }
            else {
                request.getSession().setAttribute("errorMsg", "Incorrect username or password. Please try again.");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
        
        catch(Exception e){
//            PrintWriter out = response.getWriter();
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet LoginServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            StringWriter sw = new StringWriter();
//            PrintWriter pw = new PrintWriter(sw);
//            e.printStackTrace(pw);
//            out.println(sw.toString());
//            out.println("</body>");
//            out.println("</html>");
        }
//        
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
