package com.uts.iotbay.model;

import java.io.Serializable;

public class Product implements Serializable {
    
    int id;
    String name;
    String description;
    float price;
    String imagePath;
    Boolean isActive;
    String category;

    public Product(String name, String description, float price, String imagePath, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.category = category;
        this.isActive = true;
    }

    public Product(int id, String name, String description, float price, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
    }
    public Product(int id, String name, String description, float price, String imagePath, Boolean isActive, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.isActive = isActive;
        this.category = category;
    }
    public Product() {
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
        return id;
    }

    
    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setProductID(int productID) {
        this.id = productID;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        this.isActive = active;
    }

}