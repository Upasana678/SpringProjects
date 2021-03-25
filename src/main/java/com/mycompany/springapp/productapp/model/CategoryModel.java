package com.mycompany.springapp.productapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "CATEGORY")
public class CategoryModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @OneToMany(fetch =  FetchType.LAZY,mappedBy = "categoryModel",cascade = CascadeType.ALL)//One to Many means one category has many products.
    //mappedBy means the category table should not create a foreign key of product rather category table should use the already created foreign key inside product table
    @JsonIgnore
    private List<ProductModel> productList;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductModel> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductModel> productList) {
        this.productList = productList;
    }


}
