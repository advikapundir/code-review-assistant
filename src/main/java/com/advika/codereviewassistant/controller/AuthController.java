package com.advika.codereviewassistant.controller;

import com.advika.codereviewassistant.dto.RegisterRequest;
import com.advika.codereviewassistant.entity.User;
import com.advika.codereviewassistant.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.advika.codereviewassistant.dto.LoginRequest;
import com.advika.codereviewassistant.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest request) {

        System.out.println(">>> REGISTER API HIT <<<");

        User user = userService.registerUser(request);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        System.out.println(">>> LOGIN API HIT <<<");

        return ResponseEntity.ok(userService.login(request));
    }
}