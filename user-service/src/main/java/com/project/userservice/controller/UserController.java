package com.project.userservice.controller;

import com.project.userservice.model.User;
import com.project.userservice.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userServiceImp;

    @Autowired
    public UserController(UserServiceImpl userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImp.saveUser(user));
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userServiceImp.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(userServiceImp.getUserById(id));
    }

}
