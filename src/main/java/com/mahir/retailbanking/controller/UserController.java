package com.mahir.retailbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mahir.retailbanking.model.User;
import com.mahir.retailbanking.service.UserService;
import com.mahir.retailbanking.security.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        User existingUser = userService.loginUser(user);

        Map<String, String> response = new HashMap<>();

        if (existingUser != null) {
            response.put("token", jwtUtil.generateToken(existingUser.getEmail()));
            response.put("accountNumber", existingUser.getAccountNumber());
            response.put("userName", existingUser.getName());
        } else {
            response.put("message", "Login Failed");
        }

        return response;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}