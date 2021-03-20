package com.mycompany.springapp.employee.service;

import com.mycompany.springapp.employee.model.EmployeeModel;
import com.mycompany.springapp.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository er;

    public List<EmployeeModel> getAllEmployees()
    {
        List<EmployeeModel> employeeList = er.getAllEmployees();
        return employeeList;
    }

    public EmployeeModel addEmployee(EmployeeModel employee)
    {
        EmployeeModel employeeAdded = er.addEmployee(employee);
        return employeeAdded;
    }

    public EmployeeModel deleteEmployee(Long employeeId)
    {
        EmployeeModel employeeDeleted = er.deleteEmployee(employeeId);
        return employeeDeleted;
    }

    public EmployeeModel updateEmployee(Long employeeId,EmployeeModel employee)
    {
        EmployeeModel employeeUpdated = er.updateEmployee(employeeId,employee);
        return employeeUpdated;
    }

    public List<EmployeeModel> searchEmployee(String department,double fromSalary,double toSalary)
    {
        List<EmployeeModel> listOfEmployees = er.searchEmployee(department,fromSalary,toSalary);
        return listOfEmployees;
    }
}
