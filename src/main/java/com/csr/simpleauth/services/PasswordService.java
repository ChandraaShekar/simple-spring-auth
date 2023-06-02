package com.csr.simpleauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public String hashPassword(String rawPassword){
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    public Boolean verifyPassword(String rawPassword, String hashedPassword){
        return bCryptPasswordEncoder.matches(rawPassword, hashedPassword);
    }

}
