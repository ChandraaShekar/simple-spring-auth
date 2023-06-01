package com.csr.simpleauth.controllers;

import com.csr.simpleauth.entity.User;
import com.csr.simpleauth.registery.UserRegistery;
import com.csr.simpleauth.requestDataTypes.AuthRequest;
import com.csr.simpleauth.responseDataType.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRegistery userRegistery;

    @GetMapping("/v1/api/get-users")
    public List<User> getUsers(){
        return userRegistery.findAll();
    }

    @PostMapping("/v1/api/login")
    public UserResponse login(@RequestBody AuthRequest req){
        User user = userRegistery.findByEmail(req.getEmail());
        if(user != null){
            if(user.getPassword().equals(req.getPassword())){
                return new UserResponse(
                        "Found the user",
                        200,
                        user
                );
            } else {
                return new UserResponse(
                        "Wrong Password",
                        400,
                        null
                );
            }
        } else{
            return new UserResponse(
                    "User Not Found",
                    404,
                    null
            );
        }
    }

}
