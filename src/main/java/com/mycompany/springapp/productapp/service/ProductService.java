package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.exception.ProductCreationException;
import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import com.mycompany.springapp.productapp.repository.ProductCrudRepository;
import com.mycompany.springapp.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    @Autowired
    private ProductCrudRepository pcr;
    @Autowired
    private CategoryRepository cr;

    public Iterable<ProductModel> getAllProducts()
    {
        Iterable<ProductModel> productModelList = pcr.findAll();//pr.getAllProducts();
        return productModelList;
    }


    public ProductModel createProduct(ProductModel productModel) throws ProductCreationException {
        //This is the logic of creating a product with exception.
        //If the product is already present then it throws an exception
        Optional<ProductModel> product = pcr.findByDescription(productModel.getDescription());
        if(product.isPresent())
        {
            ProductCreationException pce = new ProductCreationException("This Product already exists","Auth_002");
            throw pce;
        }
        else
        {
            Optional<CategoryModel>  optCategory = cr.findById(productModel.getCategoryModel().getCategoryId());
            productModel.setCategoryModel(optCategory.get());
            productModel = pcr.save(productModel);//pr.createProduct(productModel);

        }
        return productModel;

        //This is the old method of creating a product model
        /*
        Optional<CategoryModel>  optCategory = cr.findById(productModel.getCategoryModel().getCategoryId());
        productModel.setCategoryModel(optCategory.get());
        productModel = pcr.save(productModel);//pr.createProduct(productModel);
        return productModel;
        */
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
    /*
    public List<ProductModel> searchProduct(String description,double fromPrice,double toPrice)
    {
        List<ProductModel> productsList = pr.searchProduct(description,fromPrice,toPrice);
        return productsList;
    }
    */

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

    public List<ProductModel> searchProductByPrice(String description,double fromPrice,double toPrice)
    {
        List<ProductModel> list = new ArrayList<>();
        List<ProductModel> list1 = new ArrayList<>();
        Iterable<ProductModel> listOfProducts = null;
        listOfProducts = list;
        listOfProducts = pcr.findAll();
        ProductModel p = null;

        for(int i = 0; i < list.size();i++)
        {
            p = list.get(i);
            if(p.getDescription().contains(description) && (p.getPrice()>=fromPrice && p.getPrice()<=toPrice))
            {
                list1.add(p);
            }
        }
        return list1;
    }



}
