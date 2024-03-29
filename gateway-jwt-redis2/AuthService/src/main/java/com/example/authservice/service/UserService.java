package com.example.authservice.service;


import com.example.authservice.authen.UserPrincipal;
import com.example.authservice.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
