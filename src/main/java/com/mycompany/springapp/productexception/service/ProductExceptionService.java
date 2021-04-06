package com.mycompany.springapp.productexception.service;

import com.mycompany.springapp.productexception.exception.ProductException;
import com.mycompany.springapp.productexception.model.ProductExceptionModel;
import com.mycompany.springapp.productexception.repository.ProductExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductExceptionService {

    @Autowired
    private ProductExceptionRepository per;

    /*
    *Method name: getAllProducts
    * Argument List: None
    * Description:This method returns all products in a database
     */
    public Iterable<ProductExceptionModel> getAllProducts()
    {
        Iterable<ProductExceptionModel> productList = per.findAll();
        return productList;
    }
    /*
    *Method name: createProduct
    * Argument List: product
    * Description: This method creates a product in the database
     */
    public ProductExceptionModel createProduct(ProductExceptionModel product) throws ProductException {
        Optional<ProductExceptionModel> productOptional = per.findByNameOfProduct(product.getNameOfProduct());
        if(productOptional.isPresent())
        {
            ProductException pe = new ProductException("This product already exists.","Auth_001");
            throw pe;
        }
        else
        {
            per.save(product);
        }
        return product;
    }
    /*
    *Method Name:deleteProduct
    * Arguments:Product ID
    * Description: This method deletes a product of the specified id in the database
     */
    public ProductExceptionModel deleteProduct(Long id) throws ProductException {
        ProductExceptionModel productDeleted = null;
        Optional<ProductExceptionModel> optProduct = per.findById(id);
        if(optProduct.isPresent())
        {
            ProductExceptionModel p = optProduct.get();
            productDeleted = p;
            per.delete(p);
        }
        else
        {
            ProductException pe = new ProductException("This product with id ="+id+"doesn't exist","Auth_002");
            throw pe;
        }
        return productDeleted;
    }
    /*
    *Method Name:updateProduct
    * Arguments: id,product
    * Description:It updates the product with the specified parameters.
     */

    public ProductExceptionModel updateProduct(Long id,ProductExceptionModel product) throws ProductException {
        ProductExceptionModel product1 = null;
        Optional<ProductExceptionModel> optProduct = per.findById(id);
        if(optProduct.isPresent())
        {
            ProductExceptionModel product2 = optProduct.get();
            if(product.getPrice()!=0.0)
            {
                product2.setPrice(product.getPrice());
            }
            if(product.getNameOfProduct()!=null)
            {
                product2.setNameOfProduct(product.getNameOfProduct());
            }
            product1 = product2;


        }
        else
        {
            ProductException pe = new ProductException("This product with id="+id+" doesn't exist","Auth_003");
            throw pe;
        }
        return product1;

    }


}
