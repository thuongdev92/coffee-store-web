package com.tdev.coffee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String product_Type_Name;

    public int getId() {
        return id;
    }

    public String getProduct_Type_Name() {
        return product_Type_Name;
    }

    public void setProduct_Type_Name(String product_Type_Name) {
        this.product_Type_Name = product_Type_Name;
    }
}
