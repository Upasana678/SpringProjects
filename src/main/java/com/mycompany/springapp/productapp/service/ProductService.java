package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    public List<ProductModel> getAllProducts()
    {
        List<ProductModel> productModelList = pr.getAllProducts();
        return productModelList;
    }

    public ProductModel createProduct(ProductModel productModel)
    {
        productModel = pr.createProduct(productModel);
        return productModel;
    }
    public ProductModel deleteProduct(Long id)
    {
        ProductModel productModel = pr.deleteProduct(id);
        return productModel;
    }
    public ProductModel updateProduct(long id, ProductModel productModel)
    {
        ProductModel productModel1 = pr.updateProduct(id,productModel);
        return productModel1;
    }
    public List<ProductModel> searchProductByDescription(String description)
    {
        List<ProductModel> productsList = pr.searchProductByDescription(description);
        return productsList;
    }
    public List<ProductModel> searchProduct(String description,double fromPrice,double toPrice)
    {
        List<ProductModel> productsList = pr.searchProduct(description,fromPrice,toPrice);
        return productsList;
    }
    public ProductModel searchProductById(long id)
    {
        ProductModel productModel = pr.searchProductById(id);
        return productModel;
    }
}
