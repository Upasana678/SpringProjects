package com.mycompany.springapp.productexception.controller;

import com.mycompany.springapp.productexception.exception.ProductException;
import com.mycompany.springapp.productexception.model.ProductExceptionModel;
import com.mycompany.springapp.productexception.service.ProductExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductExceptionController {

    @Value("${myproperty}")
    private String dummyField;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Autowired
    private ProductExceptionService pes;

    @GetMapping("/show")
    public ResponseEntity<Iterable<ProductExceptionModel>> getAllProducts()
    {
        Iterable<ProductExceptionModel> list = pes.getAllProducts();
        ResponseEntity<Iterable<ProductExceptionModel>> res = new ResponseEntity<Iterable<ProductExceptionModel>>(list, HttpStatus.OK);
        return res;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createProduct(@RequestBody ProductExceptionModel product) throws ProductException {
        product = pes.createProduct(product);
        ResponseEntity<?> res = new ResponseEntity<>(product,HttpStatus.CREATED);
        return res;
    }

    @DeleteMapping("/deleteProducts/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws ProductException {
        ProductExceptionModel product = pes.deleteProduct(id);
        ResponseEntity<?> res = new ResponseEntity<>(product,HttpStatus.NO_CONTENT);
        return res;
    }

    @PutMapping("/updateProducts/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody ProductExceptionModel product) throws ProductException {
        ProductExceptionModel product1 = pes.updateProduct(id,product);
        ResponseEntity<?> res = new ResponseEntity<>(product1,HttpStatus.OK);
        return res;
    }
}
