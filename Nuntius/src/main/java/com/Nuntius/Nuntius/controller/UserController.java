package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.User;
import com.Nuntius.Nuntius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable String user_id){
        User user=userRepository.findById(user_id)
                .orElseThrow(()->new ResourceNotFoundException("User not exit with user_id: "+user_id));
        return ResponseEntity.ok(user);
    }
    @PutMapping("{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable String user_id, @RequestBody User userdetails){
        User updateUser=userRepository.findById(user_id)
                .orElseThrow(()->new ResourceNotFoundException("User not exit with user_id: "+user_id));
        updateUser.setUser_id(userdetails.getUser_id());
        updateUser.setEmail(userdetails.getEmail());
        updateUser.setName(userdetails.getName());
        updateUser.setPhone_no(userdetails.getPhone_no());
        updateUser.setCreated_at(userdetails.getCreated_at());
        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }
    @DeleteMapping("{user_id}")
    public ResponseEntity<User> deleteUser(@PathVariable String user_id){
        User user=userRepository.findById(user_id)
                .orElseThrow(()->new ResourceNotFoundException("User not exit with user_id: "+user_id));
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
