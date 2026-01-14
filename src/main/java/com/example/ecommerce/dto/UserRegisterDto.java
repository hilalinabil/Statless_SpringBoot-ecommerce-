package com.example.ecommerce.dto;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class UserRegisterDto {

    private String username;
    private String email;
    private BCrypt.Hasher password;


    public UserRegisterDto(String username, String email, BCrypt.Hasher password) {}
}
