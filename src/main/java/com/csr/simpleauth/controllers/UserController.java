package com.csr.simpleauth.controllers;

import com.csr.simpleauth.entity.User;
import com.csr.simpleauth.registery.UserRegistery;
import com.csr.simpleauth.requestDataTypes.AuthRequest;
import com.csr.simpleauth.requestDataTypes.RegisterRequestType;
import com.csr.simpleauth.responseDataType.UserResponse;
import com.csr.simpleauth.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserRegistery userRegistery;
    private PasswordService passwordService;

    @GetMapping("/v1/api/get-users")
    public List<User> getUsers(){
        return userRegistery.findAll();
    }

    @PostMapping("/v1/api/register")
    public User register(@RequestBody RegisterRequestType registerUserInfo){
//        System.out.println(("Hello"));
        String hashedPassword = passwordService.hashPassword(registerUserInfo.getPassword());
        User user = new User(
                registerUserInfo.getName(),
                registerUserInfo.getEmail(),
                registerUserInfo.getAge(),
                hashedPassword
        );
        System.out.println(registerUserInfo.toString());
        return userRegistery.save(user);
    }

    @PostMapping("/v1/api/login")
    public UserResponse login(@RequestBody AuthRequest req){

        User user = userRegistery.findByEmail(req.getEmail());
        Boolean isUserFound = user != null;
        Boolean isPasswordCorrect = passwordService.verifyPassword(req.getPassword(), user.getPassword());

        if(isUserFound){
            if(isPasswordCorrect){
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
