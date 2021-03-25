package com.mycompany.springapp.employeeh2.service;

import com.mycompany.springapp.employeeh2.model.AddressModel;
import com.mycompany.springapp.employeeh2.model.EmpModel;
import com.mycompany.springapp.employeeh2.repository.AddressRepository;
import com.mycompany.springapp.employeeh2.repository.EmployeeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmpService {

    @Autowired
    private EmployeeCrudRepository ecr;

    @Autowired
    private AddressRepository ar;

    public Iterable<EmpModel> getAllEmployees()
    {
        //findAll() returns all the rows present in the employee database and wraps all the rows into Iterable.
        Iterable<EmpModel> employeeList = ecr.findAll();
        return employeeList;
    }

    public EmpModel addEmployee(EmpModel employee)
    {
        //save() creates a new Employee into the database
        EmpModel employeeAdded = ecr.save(employee);
        return employeeAdded;
    }

    public EmpModel deleteEmployee(Long employeeId)
    {
       EmpModel employee = null;
       //findById(employeeId) returns the specific row and wraps it in Optional<>
        //Here Optional<> is used because if there is no data then also it will show the result
        Optional<EmpModel> employeeDeleted = ecr.findById(employeeId);

        //isPresent() checks if there is a row with the specified ID
        if(employeeDeleted.isPresent())
        {
            EmpModel emp = employeeDeleted.get();
            employee = emp;
            ecr.delete(emp);
        }
        else
        {
            System.out.println("No employee of ID "+employeeId+" exists");
        }
        return employee;
    }

    public EmpModel updateEmployee(long employeeId, EmpModel employee)
    {
       EmpModel employee1 = null;
       Optional<EmpModel> employeeOpt = ecr.findById(employeeId);
       if(employeeOpt.isPresent())
       {
           employee1= employeeOpt.get();
           if(employee.getDepartmentName() !=null)
           {
               employee1.setDepartmentName(employee.getDepartmentName());
           }
           if(employee.getSalary()!=0.0)
           {
               employee1.setSalary(employee.getSalary());
           }
           ecr.save(employee1);

       }
       else
       {
           System.out.println("No employee of ID "+employeeId+" exists");
       }
       return employee1;
    }

    public EmpModel searchEmployee(long employeeId)
    {
        EmpModel emp = null;
        Optional<EmpModel> employeeModelOptional = ecr.findById(employeeId);
        if(employeeModelOptional.isPresent())
        {
            emp = employeeModelOptional.get();
        }
        else
        {
            System.out.println("No employee of "+employeeId+" exists");
        }
        return emp;

    }

    public AddressModel updateAddress(Long empNo,AddressModel address)
    {
        Optional<EmpModel> emp = ecr.findById(empNo);
        AddressModel addressModel1 = emp.get().getAddress();
        if(emp.isPresent()) {
            if (address.getHouseNo() != null) {
                addressModel1.setHouseNo(address.getHouseNo());
            }
            if (address.getStreet() != null) {
                addressModel1.setStreet(address.getStreet());
            }
            if(address.getPinCode()!=0L)
            {
                addressModel1.setPinCode(address.getPinCode());
            }
            if(address.getState()!=null)
            {
                addressModel1.setState(address.getState());
            }
            if(address.getCountry()!=null)
            {
                addressModel1.setCountry(address.getCountry());
            }
            emp.get().setAddress(addressModel1);
            ecr.save(emp.get());
            //ar.save(address);


        }
        return address;
    }

}


