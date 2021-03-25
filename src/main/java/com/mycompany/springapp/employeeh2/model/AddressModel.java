package com.mycompany.springapp.employeeh2.model;

import javax.persistence.*;

@Entity(name = "EMPLOYEE_ADDRESS")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private Long addressId;//Primary key of the address table
    @Column(name = "HOUSE_NO")
    private String houseNo;//House no of the house of employee
    @Column(name = "STREET")
    private String street;
    @Column(name = "PINCODE")
    private Long pinCode;//Area pincode
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @OneToOne(mappedBy = "address")
    private EmpModel employee;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public EmpModel getEmployee() {
        return employee;
    }

    public void setEmployee(EmpModel employee) {
        this.employee = employee;
    }
}
