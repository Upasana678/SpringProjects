package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.exception.BusinessException;
import com.mycompany.springapp.productapp.model.AddressModel;
import com.mycompany.springapp.productapp.model.UserModel;
import com.mycompany.springapp.productapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService us;

    @PostMapping(path = "/users")
    public ResponseEntity<String> login(@RequestBody UserModel userModel)
    {
        Long response = us.login(userModel);
        ResponseEntity<String> res;
        if(response == 0L)
        {
            res = new ResponseEntity<>("Incorrect Email or Password", HttpStatus.UNAUTHORIZED);
        }
        else
        {
            res = new ResponseEntity<>("OK",HttpStatus.OK);
        }
        return res;
    }

    @PostMapping(path = "/users/register")
    public ResponseEntity<?> register(@RequestBody UserModel userModel) throws BusinessException {
        ResponseEntity<?> res = null;//? means any datatype is allowed.
        userModel = us.register(userModel);
        /*try {
            userModel = us.register(userModel);
        }
        catch (BusinessException be)
        {
          res = new ResponseEntity<>(be.getErrorCode()+" - "+be.getErrorMessage(),HttpStatus.CONFLICT);
            return res;
        }*/
        res = new ResponseEntity<>(userModel,HttpStatus.CREATED);
        return res;
    }

    @PutMapping(path = "/users/updateAddress/{email}")
    public ResponseEntity<AddressModel> updateAddress(@PathVariable("email") String email,@RequestBody AddressModel address)
    {
        address = us.updateAddress(email,address);
        ResponseEntity<AddressModel> res = new ResponseEntity<>(address,HttpStatus.OK);
        return res;
    }


}
