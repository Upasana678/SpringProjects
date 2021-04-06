package com.mycompany.springapp.productexception.repository;

import com.mycompany.springapp.productexception.model.ProductExceptionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductExceptionRepository extends CrudRepository<ProductExceptionModel,Long> {

    Optional<ProductExceptionModel> findByNameOfProduct(String name);
}
