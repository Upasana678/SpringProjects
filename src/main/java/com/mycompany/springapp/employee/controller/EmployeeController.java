package com.mycompany.springapp.employee.controller;

import com.mycompany.springapp.employee.model.EmployeeModel;
import com.mycompany.springapp.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService es;

    @GetMapping(path = "/getAllEmployees")
    public ResponseEntity<List<EmployeeModel>> getAllEmployees()
    {
        List<EmployeeModel> employeeList = es.getAllEmployees();
        ResponseEntity<List<EmployeeModel>> res = new ResponseEntity<>(employeeList,HttpStatus.OK);
        return res;
    }

    @PostMapping(path = "/addEmployee")
    public ResponseEntity<EmployeeModel> addEmployee(@RequestBody EmployeeModel employee)
    {
        EmployeeModel newEmployee = es.addEmployee(employee);
        ResponseEntity<EmployeeModel> res = new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
        return res;

    }

    @DeleteMapping(path = "/deleteEmployee/{id}")
    public ResponseEntity<EmployeeModel> deleteEmployee(@PathVariable("id") Long id)
    {
        EmployeeModel employeeDeleted = es.deleteEmployee(id);
        ResponseEntity<EmployeeModel> res = new ResponseEntity<>(employeeDeleted,HttpStatus.NO_CONTENT);
        return res;
    }

    @PutMapping(path = "/updateEmployee/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeeModel employee)
    {
        EmployeeModel employeeUpdated = es.updateEmployee(id,employee);
        ResponseEntity<EmployeeModel> res = new ResponseEntity<>(employeeUpdated,HttpStatus.OK);
        return res;
    }

    @GetMapping(path = "/searchEmployee")
    public ResponseEntity<List<EmployeeModel>> searchEmployee(@RequestParam("designation") String designation,@RequestParam("fromSalary") double fromSalary,@RequestParam("toSalary") double toSalary)
    {
        List<EmployeeModel> listOfEmployees = es.searchEmployee(designation,fromSalary,toSalary);
        ResponseEntity<List<EmployeeModel>> res = new ResponseEntity<>(listOfEmployees,HttpStatus.OK);
        return res;
    }

}
