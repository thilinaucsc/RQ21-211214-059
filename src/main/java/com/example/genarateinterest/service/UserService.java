package com.example.genarateinterest.service;

import com.example.genarateinterest.dto.LoginRequest;
import com.example.genarateinterest.dto.LoginResponse;

public interface UserService {
    LoginResponse loginResponseMapping(String jwt, LoginRequest loginRequest);
}
