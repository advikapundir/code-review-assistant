package com.advika.codereviewassistant.service;

import com.advika.codereviewassistant.dto.LoginRequest;
import com.advika.codereviewassistant.dto.LoginResponse;
import com.advika.codereviewassistant.dto.RegisterRequest;
import com.advika.codereviewassistant.entity.User;

public interface UserService {

    User registerUser(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}