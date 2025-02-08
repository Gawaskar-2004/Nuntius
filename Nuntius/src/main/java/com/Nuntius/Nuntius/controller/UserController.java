//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
//import com.Nuntius.Nuntius.model.User;
//import com.Nuntius.Nuntius.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/user")
//public class UserController {
//    @Autowired
//    private UserRepository userRepository;
//    @GetMapping
//    public List<User> getAllUser(){
//        return userRepository.findAll();
//    }
//    @PostMapping
//    public User createUser(@RequestBody User user){
//        return userRepository.save(user);
//    }
//    @GetMapping("{user_id}")
//    public ResponseEntity<User> getUserById(@PathVariable String user_id){
//        User user=userRepository.findById(user_id)
//                .orElseThrow(()->new ResourceNotFoundException("User not exit with user_id: "+user_id));
//        return ResponseEntity.ok(user);
//    }
//
//}
package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.model.User;
import com.Nuntius.Nuntius.Service.UserService;
import com.Nuntius.Nuntius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend requests
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    // User Registration
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // User Login
    @PostMapping("/login")
    public User loginUser(@RequestBody User loginRequest) {
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @GetMapping
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") int userId) {
        User user = userService.findUserById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok(user);


    }
}

