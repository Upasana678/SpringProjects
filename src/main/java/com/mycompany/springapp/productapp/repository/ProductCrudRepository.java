package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCrudRepository extends CrudRepository<ProductModel,Long> {

    Optional<ProductModel> findByDescription(String description);
}
