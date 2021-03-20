package com.mycompany.springapp.employee.repository;

import com.mycompany.springapp.employee.model.EmployeeModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Name: Upasana
 * Class Name: EmployeeRepository.java
 * date: 18-03-2021
 * Description: This class performs CRUD operations on Employee
 */
@Repository
public class EmployeeRepository {

    //Creating an object of EmployeeModel
    List<EmployeeModel> employeeList = new ArrayList<>();

    /**
     * Method Name: addEmployee
     * Parameters: EmployeeModel
     * Return Type: String
     * Description : This method adds an employee to the list.
     */
    public EmployeeModel addEmployee(EmployeeModel em)
    {
        this.employeeList.add(em);
        return em;
    }
    /**
     * Method Name: getAllEmployees
     * Parameters: No Parameters
     * Return Type: List<EmployeeModel>
     * Description : This method returns the list of employees
     */
    public List<EmployeeModel> getAllEmployees()
    {
        return employeeList;
    }
    /**
     * Method Name: deleteEmployee
     * Parameters: employeeId
     * Return Type: EmployeeModel
     * Description: This method deletes an employee from the list of employees.
     */
    public EmployeeModel deleteEmployee(Long employeeId)
    {
        EmployeeModel employeeDeleted = null;
        for(int i=0; i<this.employeeList.size(); i++)
        {
            employeeDeleted = this.employeeList.get(i);
            if(employeeDeleted.getEmployeeId() == employeeId)
            {
                this.employeeList.remove(i);
                break;
            }
        }
        return employeeDeleted;
    }
    /**
     * Method Name: updateEmployee
     * Parameters: employeeId
     * Return type: EmployeeModel
     * Description: This method updates the employee's salary and department name
     */
    public EmployeeModel updateEmployee(Long employeeId,EmployeeModel employee)
    {
        EmployeeModel employeeUpdated = null;
        for(int i = 0; i<this.employeeList.size(); i++)
        {
            employeeUpdated = this.employeeList.get(i);
            if(employeeUpdated.getEmployeeId() == employeeId)
            {
                employeeUpdated.setSalary(employee.getSalary());
                employeeUpdated.setDepartmentName(employee.getDepartmentName());
                this.employeeList.set(i,employeeUpdated);
                break;
            }
        }
        return employeeUpdated;
    }
    /**
     * Method Name: searchEmployee
     * Parameters: department,fromSalary,toSalary
     * Return Type: List<EmployeeModel>
     *Description: This method searches the list of employees who belong to a particular department and within a certain salary range
     */

    public List<EmployeeModel> searchEmployee(String department,double fromSalary,double toSalary)
    {
        //Creating a object of List<EmployeeModel>
        List<EmployeeModel> employees = new ArrayList<>();
        EmployeeModel es = null;
        for(int i = 0; i<this.employeeList.size(); i++)
        {
            es = this.employeeList.get(i);
            if(es.getDepartmentName().contains(department) && es.getSalary()>=fromSalary && es.getSalary()<=toSalary)
            {
                employees.add(es);
            }
        }
        return employees;
    }

}
