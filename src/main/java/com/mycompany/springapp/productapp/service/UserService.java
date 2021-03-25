package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.AddressModel;
import com.mycompany.springapp.productapp.model.UserModel;
import com.mycompany.springapp.productapp.repository.AddressOfUserRepository;
import com.mycompany.springapp.productapp.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserCrudRepository ucr;
    @Autowired
    private AddressOfUserRepository aour;

    public Long login(UserModel userModel)
    {
        Optional<UserModel> optionalUserModel = ucr.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if(optionalUserModel.isPresent()){
            return optionalUserModel.get().getId();
        }
        return 0L;
    }

    public UserModel register(UserModel userModel)
    {
        userModel = ucr.save(userModel);
        return userModel;
    }

    public AddressModel updateAddress(String emailAddress,AddressModel address)
    {
        Optional<UserModel> verifyUser = ucr.findByEmail(emailAddress);

        if(verifyUser.isPresent()) {

            if (address.getHouseNo() != null) {
                address.setHouseNo(address.getHouseNo());
            }
            if (address.getStreet() != null) {
                address.setStreet(address.getStreet());
            }
            if (address.getPinCode() != 0L) {
                address.setPinCode(address.getPinCode());
            }
            if (address.getCountry() != null) {
                address.setCountry(address.getCountry());
            }
            if (address.getState() != null) {
                address.setState(address.getState());
            }
            aour.save(address);
        }
        return address;
    }




}
