package com.csr.simpleauth.requestDataTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterRequestType {
    private String name;
    private String email;
    private String password;
    private int age;
}

