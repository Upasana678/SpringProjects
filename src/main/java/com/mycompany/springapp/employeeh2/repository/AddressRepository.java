package com.mycompany.springapp.employeeh2.repository;

import com.mycompany.springapp.employeeh2.model.AddressModel;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressModel,Long> {
}
