package com.mycompany.springapp.productapp.controller;


import com.mycompany.springapp.productapp.exception.ProductCreationException;
import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Value("${myproperty}")
    private String dummyField;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Autowired
    private ProductService ps;

    @GetMapping("/products")
    public @ResponseBody ResponseEntity<Iterable<ProductModel>> getAllProducts()
    {
        System.out.println(dummyField);
        System.out.println(dbUser);

        Iterable<ProductModel> list = ps.getAllProducts();

        return (new ResponseEntity<Iterable<ProductModel>>(list, HttpStatus.OK));
    }

    @PostMapping(path = "/products", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> createProduct(@RequestBody ProductModel productModel) throws ProductCreationException {
        System.out.println("create product");
        ResponseEntity<?> res = null;
        productModel = ps.createProduct(productModel);
        res = new ResponseEntity<>(productModel, HttpStatus.CREATED);
        return res;
    }
    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<ProductModel> deleteProduct(@PathVariable("id") Long id)
    {
        ProductModel productModel = ps.deleteProduct(id);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel, HttpStatus.NO_CONTENT);

        return res;
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable("id") Long id,
                                                      @RequestBody ProductModel productModel)
    {
        ProductModel productModel1 = ps.updateProduct(id,productModel);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel1,HttpStatus.OK);

        return res;
    }
    @PutMapping(value = "/products/update/{id}")
    public ResponseEntity<ProductModel> updateAnyOne(@PathVariable("id") Long id,
                                                      @RequestBody ProductModel productModel)
    {
        ProductModel productModel1 = ps.update(id,productModel);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel1,HttpStatus.OK);

        return res;
    }


    @GetMapping(value = "/products/search")
    public ResponseEntity<List<ProductModel>> searchProduct(@RequestParam("description") String description,
                                                            @RequestParam("fromPrice") double fromPrice,
                                                            @RequestParam("toPrice") double toPrice)
    {
        List<ProductModel> productsList = ps.searchProductByPrice(description,fromPrice,toPrice);
        ResponseEntity<List<ProductModel>> res = new ResponseEntity<List<ProductModel>>(productsList,HttpStatus.OK);
        return res;
    }

    @GetMapping(value = "/products/searchByDescription")
    public ResponseEntity<List<ProductModel>> searchProductByDescription(@RequestParam("description") String description)
    {
        List<ProductModel> productsList = ps.searchProductByDescription(description);
        ResponseEntity<List<ProductModel>> res = new ResponseEntity<List<ProductModel>>(productsList,HttpStatus.OK);
        return res;
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<ProductModel> searchProductById(@PathVariable("id") long id)
    {
        ProductModel productModel = ps.searchProductById(id);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel,HttpStatus.OK);
        return res;

    }


}
