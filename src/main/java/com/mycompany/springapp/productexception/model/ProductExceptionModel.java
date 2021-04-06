package com.mycompany.springapp.productexception.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "PRODUCTS")
public class ProductExceptionModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTS_ID")
    private Long id;
    @Column(name = "PRODUCTS_NAME")
    private String nameOfProduct;
    @Column(name = "PRICE")
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
