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
import com.uts.iotbay.model.User;
import com.uts.iotbay.model.dao.DBManager;

public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager"); 
        Product editproduct = (Product)request.getSession().getAttribute("product");
        int productID = editproduct.getProductID();
        
        try {
            manager.deleteProduct(productID);
        } catch (SQLException ex) {
            // Logger.getLogger(ModifyProductsServlet.class.getName()).log(Level.SEVERE, null, ex);   

        }
        response.sendRedirect("products");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager"); 
        
        String name = request.getParameter("productName");
        String description = request.getParameter("productDescription");
        String price = request.getParameter("productPrice");
        // Need to change price into float somehow without intervening method
        String imagePath = request.getParameter("productImagePath");
        String category = request.getParameter("productCategory");

        Product product = (Product)request.getSession().getAttribute("product");
        int productID = product.getProductID();
        
        ArrayList<Product> products = new ArrayList<>();
        products = manager.getAllProducts();

        for (Product p : products) {
            if (name.equals(p.getName())) {
                request.getSession().setAttribute("errorMsg", "Product name cannot be the same.");
                RequestDispatcher rd = request.getRequestDispatcher("editproduct.jsp");
                rd.forward(request, response);
                return;
            }

            else {
                try {
                    manager.updateProduct(name, description, price, imagePath);
                } catch (SQLException ex) {
                    Logger.getLogger(EditDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);   
    
                }
                request.getSession().setAttribute("errorMsg", "");
            }
        }

        Product updatedProduct = (Product)request.getSession().getAttribute("product");
        updatedProduct.setName(name);
        updatedProduct.setDescription(description);
        updatedProduct.setPrice(price);
        updatedProduct.setImagePath(imagePath);

        request.getSession().setAttribute("product", updatedProduct);

        RequestDispatcher rd = request.getRequestDispatcher("products");
        rd.forward(request, response);
            
    }
}