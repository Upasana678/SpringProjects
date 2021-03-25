package com.mycompany.springapp.employeeh2.controller;

import com.mycompany.springapp.employeeh2.model.AddressModel;
import com.mycompany.springapp.employeeh2.model.EmpModel;
import com.mycompany.springapp.employeeh2.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmpController {

    @Autowired
    private EmpService es;

    @GetMapping(path = "/showAllEmployees")
    public ResponseEntity<Iterable<EmpModel>> getAllEmployees()
    {
        Iterable<EmpModel> employeeList = es.getAllEmployees();
        ResponseEntity<Iterable<EmpModel>> res = new ResponseEntity<>(employeeList, HttpStatus.OK);
        return res;
    }

    @PostMapping(path = "/newEmployee")
    public ResponseEntity<EmpModel> addEmployee(@RequestBody EmpModel employee)
    {
        EmpModel newEmployee = es.addEmployee(employee);
        ResponseEntity<EmpModel> res = new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
        return res;

    }

    @DeleteMapping(path = "/terminate/{id}")
    public ResponseEntity<EmpModel> deleteEmployee(@PathVariable("id") Long id)
    {
        EmpModel employeeDeleted = es.deleteEmployee(id);
        ResponseEntity<EmpModel> res = new ResponseEntity<>(employeeDeleted,HttpStatus.NO_CONTENT);
        return res;
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<EmpModel> updateEmployee(@PathVariable("id") Long id, @RequestBody EmpModel employee)
    {
        EmpModel employeeUpdated = es.updateEmployee(id,employee);
        ResponseEntity<EmpModel> res = new ResponseEntity<>(employeeUpdated,HttpStatus.OK);
        return res;
    }

    @GetMapping(path = "/search/{id}")
    public ResponseEntity<EmpModel> searchEmployee(@PathVariable("id") long id)
    {
        EmpModel listOfEmployees = es.searchEmployee(id);
        ResponseEntity<EmpModel> res = new ResponseEntity<>(listOfEmployees,HttpStatus.OK);
        return res;
    }

    @PutMapping(path = "/updateAddress/{id}")
    public ResponseEntity<AddressModel> updateAddress(@PathVariable("id") Long empId,@RequestBody AddressModel address)
    {
        address = es.updateAddress(empId,address);
        ResponseEntity<AddressModel> res = new ResponseEntity<>(address,HttpStatus.OK);
        return res;
    }




}
