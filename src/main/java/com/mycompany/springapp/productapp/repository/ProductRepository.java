package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

 /*
 * author name: Upasana
 * class name: ProductRepository
 * date: 18-02-2021
 * description: This class performs the CRUD operation on product
 */
@Repository
public class ProductRepository {

    List<ProductModel> productsList = new ArrayList<>();

    public ProductModel createProduct(ProductModel productModel)
    {
        this.productsList.add(productModel);
        return productModel;
    }

    public List<ProductModel> getAllProducts()
    {
        return productsList;
    }

    public ProductModel deleteProduct(Long id)
    {
        ProductModel productModel = null;
        //logic for searching a product based on product id
        for(int i=0; i<this.productsList.size(); i++){
            productModel = this.productsList.get(i);
            if(productModel.getId() == id){
                //if product found than remove
                this.productsList.remove(i);
                break;
            }
        }
        return productModel;
    }

    //Logic for updating a product's price based on product ID
    public ProductModel updateProduct(long id,double price)
    {
        ProductModel pm = null;
        //logic for updating the product based on product ID
        for(int i = 0; i<this.productsList.size(); i++)
        {
            pm = this.productsList.get(i);
            if(pm.getId() == id)
            {
                //if product is found, then update the product
                pm.setPrice(price);
                this.productsList.set(i,pm);
                break;
            }
        }
        return pm;
    }

    /**
     * method name: searchProductByDescription
     * method parameters: String
     * method return type: List<ProductModel>
     * description: This function searches a product based on description
     * **/
    public List<ProductModel> searchProductByDescription(String description)
    {
        ProductModel pm = null;
        List<ProductModel> listOfProducts = new ArrayList<>();

        //loops through all the products
        for(int i = 0; i < this.productsList.size(); i++)
        {
            pm = this.productsList.get(i);
            //checks if the current product description matches with the user input
            if(pm.getDescription().contains(description))
            {
                //keep adding the matching product to a new list
                listOfProducts.add(pm);
            }
        }
        //return the new matching product list
        return listOfProducts;
    }

     public List<ProductModel> searchProduct(String description,double fromPrice,double toPrice)
     {
         ProductModel pm = null;
         List<ProductModel> listOfProducts = new ArrayList<>();

         //loops through all the products
         for(int i = 0; i < this.productsList.size(); i++)
         {
             pm = this.productsList.get(i);
             //checks if the current product description matches with the user input
             //and whether the product lies within the certain range
             if(pm.getDescription().contains(description) && (pm.getPrice()>=fromPrice && pm.getPrice()<=toPrice))
             {
                 //keep adding the matching product to a new list
                 listOfProducts.add(pm);
             }
         }
         //return the new matching product list
         return listOfProducts;
     }


     //This function searches a product based on productID
    public ProductModel searchProductById(long id)
    {
        ProductModel pm = null;
        for(int i = 0; i<this.productsList.size(); i++)
        {
            pm = this.productsList.get(i);
            if(pm.getId() == id)
            {
                break;
            }
        }
        return pm;
    }
}
