package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.AddressModel;
import org.springframework.data.repository.CrudRepository;

public interface AddressOfUserRepository extends CrudRepository<AddressModel,Long> {
}
