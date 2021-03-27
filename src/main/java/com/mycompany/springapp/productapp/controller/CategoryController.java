package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    //Create an object of CategoryService
    @Autowired
    private CategoryService cs;

    @PostMapping("/category/createCategory")
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel category)
    {
        category = cs.createCategory(category);
        ResponseEntity<CategoryModel> response = new ResponseEntity<CategoryModel>(category, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/category/getCategory")
    public ResponseEntity<Iterable<CategoryModel>> getCategory()
    {
        Iterable<CategoryModel> categoryList = cs.getCategories();
        ResponseEntity<Iterable<CategoryModel>> response = new ResponseEntity<Iterable<CategoryModel>>(categoryList,HttpStatus.OK);
        return response;
    }

    @PutMapping("/category/updateCategory/{id}")
    public ResponseEntity<CategoryModel> updateCategory(@PathVariable Long id,@RequestBody CategoryModel category)
    {
        CategoryModel category1 = cs.updateCategory(id,category);
        ResponseEntity<CategoryModel> response = new ResponseEntity<CategoryModel>(category1,HttpStatus.OK);
        return response;
    }

    @DeleteMapping("category/deleteCategory/{id}")
    public ResponseEntity<CategoryModel> deleteCategory(@PathVariable Long id)
    {
        CategoryModel category = cs.deleteCategory(id);
        ResponseEntity<CategoryModel> response = new ResponseEntity<CategoryModel>(category,HttpStatus.NO_CONTENT);
        return response;
    }



}
