package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @InjectMocks //creates a singleton dummy object for category service
    private CategoryService categoryService;

    @Mock //create a dummy singleton object of repository and also inject it inside category service
    private CategoryRepository categoryRepository;

    @Test
    public void test_createCategory(){

        CategoryModel categoryModel1 = new CategoryModel();
        categoryModel1.setCategoryName("Food");

        CategoryModel categoryModel3 = new CategoryModel();
        categoryModel3.setCategoryId(1L);
        categoryModel3.setCategoryName("Food");

        //when cr.save() than return a category model which has id inside
        Mockito.when(categoryRepository.save(categoryModel1)).thenReturn(categoryModel3);

        CategoryModel categoryModel2 = categoryService.createCategory(categoryModel1);
        Assertions.assertNotNull(categoryModel2.getCategoryId(), "Test failed because new category should have an Id");
    }

    @Test
    public void test_getCategories_With_0_size(){

        List<CategoryModel> categories = (List<CategoryModel>)categoryService.getCategories();
        Assertions.assertEquals(categories.size(), 0);
    }

    @Test
    public void test_getCategories_With_non_zero_size(){

        CategoryModel cm = new CategoryModel();
        cm.setCategoryId(1L);
        cm.setCategoryName("Food");

        List<CategoryModel> listOFcat = new ArrayList<>();
        listOFcat.add(cm);

        Mockito.when(categoryRepository.findAll()).thenReturn(listOFcat);

        List<CategoryModel> categories = (List<CategoryModel>)categoryService.getCategories();
        Assertions.assertEquals(categories.size(), 1);
    }
    @Test
    public void test_update_category()
    {
        CategoryModel cm = new CategoryModel();
        cm.setCategoryId(1L);
        cm.setCategoryName("Electronics");

        CategoryModel cm1 = new CategoryModel();
        cm1.setCategoryId(1L);
        cm1.setCategoryName("Paints");

        Mockito.when(categoryRepository.findById(cm.getCategoryId())).thenReturn(Optional.of(cm));
        Mockito.when(categoryRepository.save(cm)).thenReturn(cm1);

        CategoryModel cm4 = categoryService.updateCategory(cm.getCategoryId(),cm1);

        Assertions.assertEquals(cm4.getCategoryName(),cm1.getCategoryName(),"Test not passed because you have not updated the category");

    }
    @Test
    public void test_update_category_ctaegoryNotFound()
    {
        CategoryModel cm = new CategoryModel();
        cm.setCategoryId(1L);
        cm.setCategoryName("Electronics");

        Mockito.when(categoryRepository.findById(cm.getCategoryId())).thenReturn(Optional.empty());

        CategoryModel cm4 = categoryService.updateCategory(cm.getCategoryId(),cm);

        Assertions.assertNull(cm4,"Test not passed because category was found");

    }
    @Test
    public void test_delete_category()
    {
        CategoryModel cc1 = new CategoryModel();
        cc1.setCategoryId(1L);
        cc1.setCategoryName("Fruits");

        Mockito.when(categoryRepository.findById(cc1.getCategoryId())).thenReturn(Optional.of(cc1));
        Mockito.doNothing().when(categoryRepository).delete(cc1);

        CategoryModel cm1 = categoryService.deleteCategory(cc1.getCategoryId());
        Assertions.assertEquals(cc1.getCategoryId(), cm1.getCategoryId(),"This test failed because you have not deleted one of the categories");

    }
}
