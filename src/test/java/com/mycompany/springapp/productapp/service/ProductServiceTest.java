package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.exception.ProductCreationException;
import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import com.mycompany.springapp.productapp.repository.ProductCrudRepository;
import com.mycompany.springapp.productapp.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductCrudRepository productRepository;

    @Mock
    private CategoryRepository cr;

    @Test
    public void test_create_products_product_exists() {
        ProductModel pm1 = new ProductModel();
        pm1.setPrice(5000);
        pm1.setDescription("Garments");

        ProductModel pm2 = new ProductModel();
        pm2.setId(1L);
        pm2.setPrice(5000);
        pm2.setDescription("Garments");

        Mockito.when(productRepository.findByDescription(pm1.getDescription())).thenReturn(Optional.of(pm1));
        //When it encounters pcr.save(), Mockito will mock as a database call and save the object of ProductModel
        //Mockito.when(productRepository.save(pm1)).thenReturn(pm2);

        Assertions.assertThrows(ProductCreationException.class,
                ()->{
            productService.createProduct(pm1);
        });

    }

    @Test
    public void test_create_products_product() throws ProductCreationException {

        CategoryModel cm = new CategoryModel();
        cm.setCategoryId(1L);

        ProductModel pm1 = new ProductModel();
        pm1.setPrice(5000);
        pm1.setDescription("Garments");
        pm1.setCategoryModel(cm);

        ProductModel pm2 = new ProductModel();
        pm2.setCategoryModel(cm);
        pm2.setId(1L);
        pm2.setPrice(5000);
        pm2.setDescription("Garments");

        Mockito.when(productRepository.findByDescription(pm1.getDescription())).thenReturn(Optional.empty());
        Mockito.when(cr.findById(pm2.getCategoryModel().getCategoryId())).thenReturn(Optional.of(cm));
        //When it encounters pcr.save(), Mockito will mock as a database call and save the object of ProductModel
        Mockito.when(productRepository.save(pm1)).thenReturn(pm2);

        ProductModel pmResult = productService.createProduct(pm1);
        Assertions.assertEquals(pm2.getId(), pmResult.getId());

    }

    public void test_get_products_with_zero_size()
    {
        List<ProductModel> categories = (List<ProductModel>)productService.getAllProducts();
        Assertions.assertEquals(categories.size(), 0);
    }

    @Test
    public void test_get_products_with_non_zero_size()
    {
        ProductModel pm1 = new ProductModel();
        pm1.setId(1L);
        pm1.setPrice(7000);
        pm1.setDescription("Paints");

        List<ProductModel> listOfProducts = new ArrayList<>();
        listOfProducts.add(pm1);

        Mockito.when(productRepository.findAll()).thenReturn(listOfProducts);

        List<ProductModel> list = (List<ProductModel>)productService.getAllProducts();
        Assertions.assertEquals(list.size(),1);
    }







}
