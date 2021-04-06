package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.exception.BusinessException;
import com.mycompany.springapp.productapp.model.AddressModel;
import com.mycompany.springapp.productapp.model.UserModel;
import com.mycompany.springapp.productapp.repository.AddressOfUserRepository;
import com.mycompany.springapp.productapp.repository.UserCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserCrudRepository ucr;
    @Autowired
    private AddressOfUserRepository aour;

    public Long login(UserModel userModel)
    {
        Optional<UserModel> optionalUserModel = ucr.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if(optionalUserModel.isPresent()){
            LOGGER.info("Login sucessful");//info() is used to provide information
            //info() is used in the develop and test environment;
            return optionalUserModel.get().getId();
        }
        return 0L;
    }

    public UserModel register(UserModel userModel) throws BusinessException {
        //Logic for finding whether user with this phone number exists or not
        String phoneNumber = userModel.getPhoneNumber();
        Optional<UserModel> optUserPhoneNumber = ucr.findByPhoneNumber(phoneNumber);
        if(optUserPhoneNumber.isPresent())
        {
            BusinessException be = new BusinessException("Auth_001","User with this phone number already exists.Try with another phone number");
            LOGGER.error("User already exists");
            //error logs are enabled in the acceptance and production environment
            throw be;
        }
        else
        {
            ucr.save(userModel);
        }

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
