package com.mycompany.springapp.productapp.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ADDRESS")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private Long addressId;
    @Column(name = "HOUSE_NO")
    private String houseNo;
    @Column(name = "STREET")
    private String street;
    @Column(name = "PINCODE")
    private Long pinCode;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @OneToOne(mappedBy = "address") //This will enable bidirectional mapping with address to user i,e which address is mapped to which user and viceversa.
    private UserModel userModel;

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

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
