package com.mcmasters.notecards.controllers;

import com.mcmasters.notecards.mocks.User;
import com.mcmasters.notecards.repositories.UserRepo;
import com.mcmasters.notecards.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<User> LogIn(String username, String password) {
        return null;
    }

}
