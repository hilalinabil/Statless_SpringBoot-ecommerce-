package com.example.ecommerce.services;

import com.example.ecommerce.repositories.UserRepository;
import org.jasypt.springsecurity4.crypto.password.PasswordEncoder;

public class AuthService {

    final   public UserRepository repo ;
    final  public PasswordEncoder encoder ;

    public AuthService(UserRepository repo, PasswordEncoder encoder)
    {
        this.repo= repo;
        this.encoder = encoder ;
    }



    public static

}
