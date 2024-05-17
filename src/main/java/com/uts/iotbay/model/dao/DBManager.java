package com.uts.iotbay.model.dao;
import com.uts.iotbay.Utils;
import com.uts.iotbay.model.Product;
import java.sql.*;
import java.util.ArrayList;

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
            Boolean isActive = Utils.bitToBool(rs.getInt("product_active"));
            String category = rs.getString("product_category");
            products.add(new Product(id, name, description, price, path, isActive, category));
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
            products.add(new Product(productID, productName, productDescription, productPrice, image_path));
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

    public Product getProduct(int id) throws SQLException {
        
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Products WHERE product_id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            String name = rs.getString("product_name");
            String description = rs.getString("product_description");
            float price = rs.getFloat("product_price");
            String imagePath = rs.getString("product_image_path");
            String category = rs.getString("product_category");

            return new Product(name, description, price, imagePath, category);
        }
        return null;
    }

    public void updateProduct(String name, String description, float price, String imagePath) throws SQLException {
            PreparedStatement ps = conn.prepareStatement("UPDATE Products SET product_name=?, product_description=?, product_price=?, product_image_path=? WHERE product_id=?");
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setFloat(3, price);
            ps.setString(4, imagePath);
            ps.executeUpdate();
        }
}