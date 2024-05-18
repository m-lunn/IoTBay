package com.uts.iotbay.model;

import java.io.Serializable;

public class Produc implements Serializable {

    String name;
    String description;
    float price;
    String imagePath;
    int productID;
    boolean isActive;
    String category;

    public Product(String name, String description, float price, String imagePath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.isActive = true;
    }

    public Product(int productID, String name, String description, float price, String imagePath, String category) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }

    public String getProductCategory() {
        return category;
    }

    public void setProductCategory(String category) {
        this.category = category;
    }

}