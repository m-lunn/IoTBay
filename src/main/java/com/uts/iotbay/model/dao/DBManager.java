package com.uts.iotbay.model.dao;
import com.uts.iotbay.model.Product;
import java.sql.*;
import java.util.ArrayList;
import com.uts.iotbay.model.dao.DBManager;

public class DBManager {
    Connection conn;

    public DBManager(Connection conn) throws SQLException {   
        this.conn = conn;    
    }

    public ArrayList<Product> getAllProducts() throws SQLException{
        
        ArrayList<Product> products = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Products WHERE product_active = 1");
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("product_id");
            String name = rs.getString("product_name");
            String description = rs.getString("product_description");
            float price = rs.getFloat("product_price");
            String path = rs.getString("product_image_path");
            String category = rs.getString("product_category");
            products.add(new Product(id, name, description, price, path, category));
        }

        return products;

    }

    public ArrayList<Product> getFilteredProducts(String category, String search) throws SQLException {
        
        ArrayList<Product> products = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Products WHERE product_category LIKE ? AND product_name LIKE ? AND product_active = 1");
        ps.setString(1, "%" + category + "%");
        ps.setString(2, "%" + search + "%");

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            String productDescription = rs.getString(3);
            float productPrice = rs.getFloat(4);
            String image_path = rs.getString(5);
            String productCategory = rs.getString(6);
            products.add(new Product(productID, productName, productDescription, productPrice, image_path, productCategory));
        }

        return products;

    }

    public void deleteProduct(int id) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("UPDATE Products SET product_active = 0 WHERE product_id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public String getProductName(int id) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("SELECT product_name FROM Products WHERE product_id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
            return rs.getString("product_name");
        }
        return null;
    }

   

}