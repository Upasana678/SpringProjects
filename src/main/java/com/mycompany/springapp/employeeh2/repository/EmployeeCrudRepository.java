package com.mycompany.springapp.employeeh2.repository;

import com.mycompany.springapp.employeeh2.model.EmpModel;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository<EmpModel,Long> {
}
