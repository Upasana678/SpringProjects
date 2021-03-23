package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.ProductCrudRepository;
import com.mycompany.springapp.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    @Autowired
    private ProductCrudRepository pcr;

    public Iterable<ProductModel> getAllProducts()
    {
        Iterable<ProductModel> productModelList = pcr.findAll();//pr.getAllProducts();
        return productModelList;
    }

    public ProductModel createProduct(ProductModel productModel)
    {
        productModel = pcr.save(productModel);//pr.createProduct(productModel);
        return productModel;
    }
    public ProductModel deleteProduct(Long id)
    {
        ProductModel productModel = null;
        Optional<ProductModel> optProduct = pcr.findById(id);
        if(optProduct.isPresent()){
            ProductModel product = optProduct.get();
            productModel = product;
            pcr.delete(product);
        }else {
            System.out.println("No matching product found");
        }
        //ProductModel productModel = pr.deleteProduct(id);
        return productModel;
    }
    public ProductModel updateProduct(long id, ProductModel productModel)
    {
        ProductModel productModel1 = null;
        Optional<ProductModel> optProduct = pcr.findById(id);
        if(optProduct.isPresent()){
            ProductModel product = optProduct.get();
            product.setDescription(productModel.getDescription());
            product.setPrice(productModel.getPrice());
            productModel1 = product;
            pcr.save(product);
        }else {
            System.out.println("No matching product found");
        }
        return productModel1;
    }
    public ProductModel update(long id, ProductModel productModel)
    {
        ProductModel productModel1 = null;
        Optional<ProductModel> optProduct = pcr.findById(id);
        if(optProduct.isPresent()){
            ProductModel product = optProduct.get();
         if(productModel.getPrice()!=0.0)
         {
             product.setPrice(productModel.getPrice());
         }
         if(productModel.getDescription() != null)
         {
             product.setDescription(productModel.getDescription());
         }
            productModel1 = product;
            pcr.save(product);
        }else {
            System.out.println("No matching product found");
        }
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
        ProductModel product = null;
        Optional<ProductModel> searchProduct = pcr.findById(id);
        if(searchProduct.isPresent())
        {
            product = searchProduct.get();
        }
        else
        {
            System.out.println("No product found");
        }
        //ProductModel productModel = pr.searchProductById(id);
        return product;
    }
}
