package com.uts.iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uts.iotbay.model.dao.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddProductServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        float price = -1;
        try {
            price = Float.parseFloat(request.getParameter("price"));
        } catch(NumberFormatException e) {
            Logger.getLogger(ProductViewServlet.class.getName()).log(Level.SEVERE, null, e);
            session.setAttribute("priceError", "Not a valid price.");
            response.sendRedirect("addproduct.jsp");
            return;
        }

        if(price <= 0) {
            session.setAttribute("priceError", "Not a valid price.");
            response.sendRedirect("addproduct.jsp");
            return;
        }

        try {
            manager.addProduct(name, description, price, category);
        } catch (SQLException ex) {
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        session.setAttribute("successMsg", name + " successfully added.");
        response.sendRedirect("products");


    }
}

