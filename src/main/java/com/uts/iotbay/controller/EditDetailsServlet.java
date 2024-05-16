package com.uts.iotbay.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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

import com.uts.iotbay.model.User;

/**
 *
 * @author michaellunn
 */
// @WebServlet(urlPatterns = {"/editdetails"})
public class EditDetailsServlet extends HttpServlet {

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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "040302");
            
            User deleteUser = (User)request.getSession().getAttribute("user");
            String email = deleteUser.getEmail();
            PreparedStatement ps = con.prepareStatement("UPDATE Users SET isactive = 0 WHERE email = ?");
            ps.setString(1, email);
            ps.executeUpdate();

            response.sendRedirect("index.jsp");
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
        try {

            String fname = request.getParameter("fname");
            String surname = request.getParameter("surname");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirm-password");

            User user = (User)request.getSession().getAttribute("user");
            String email = user.getEmail();
            
            if(!password.equals(confirmPassword)) {
                request.getSession().setAttribute("errorMsg", "Passwords do not match.");
                RequestDispatcher rd = request.getRequestDispatcher("editdetails.jsp");
                rd.forward(request, response);
                return;
            }
            else{
                request.getSession().setAttribute("errorMsg", "");
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotbay", "root", "040302");

            PreparedStatement updateDetails = con.prepareStatement("UPDATE Users SET fname=?, surname =?, password = ? WHERE email = ?");
            updateDetails.setString(1, fname);
            updateDetails.setString(2, surname);
            updateDetails.setString(3, password);
            updateDetails.setString(4, email);
            updateDetails.executeUpdate();

            User updatedUser = (User)request.getSession().getAttribute("user");
            updatedUser.setFname(fname);
            updatedUser.setSurname(surname);
            updatedUser.setPassword(confirmPassword);

            request.getSession().setAttribute("user", updatedUser);

            RequestDispatcher rd = request.getRequestDispatcher("homedirect.jsp");
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
