package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    //Create an object of CategoryRepository using Autowired annotation
    @Autowired
    private CategoryRepository cr;

    public CategoryModel createCategory(CategoryModel category)
    {
        CategoryModel categoryModel;
        categoryModel = cr.save(category);
        return categoryModel;
    }

    public Iterable<CategoryModel> getCategories()
    {
        Iterable<CategoryModel> categoryList = cr.findAll();
        return categoryList;
    }

    //Logic for updating category
    public CategoryModel updateCategory(Long id,CategoryModel category)
    {
        CategoryModel category1 = null;
        Optional<CategoryModel> optCategory = cr.findById(id);
        if(optCategory.isPresent())
        {
            category1 = optCategory.get();
            if(category.getCategoryName()!=null)
            {
                category1.setCategoryName(category.getCategoryName());
            }
            cr.save(category1);

        }
        else
        {
            System.out.println("No such category exists");
        }
        return category1;

    }

    //Logic for deleting category
    public CategoryModel deleteCategory(Long id)
    {
        CategoryModel category = null;
        Optional<CategoryModel> optCategory = cr.findById(id);
        if(optCategory.isPresent())
        {
            category = optCategory.get();
            cr.delete(category);
        }
        else
        {
            System.out.println("No such category is there in the database");
        }
        return category;
    }
}
