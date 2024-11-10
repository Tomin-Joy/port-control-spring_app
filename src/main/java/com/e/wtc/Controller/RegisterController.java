package com.e.wtc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.wtc.Repository.UserRepo;
import com.e.wtc.entity.ApiUser;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    UserRepo repo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("")
    public ResponseEntity<ApiUser> newUser(@RequestBody ApiUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
