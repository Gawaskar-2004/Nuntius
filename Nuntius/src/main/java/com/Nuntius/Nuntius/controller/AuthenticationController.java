//package com.Nuntius.Nuntius.controller;
//
//import com.Nuntius.Nuntius.model.Authentication;
//import com.Nuntius.Nuntius.repository.AuthenticationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/authentication")
//public class AuthenticationController {
//
//    @Autowired
//    private AuthenticationRepository authenticationRepository;
//
//    @GetMapping
//    public List<Authentication> getAllAuthentications() {
//        return authenticationRepository.findAll();
//    }
//
//    @PostMapping
//    public Authentication createAuthentication(@RequestBody Authentication authentication) {
//        return authenticationRepository.save(authentication);
//    }
//}
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//package com.Nuntius.Nuntius.model;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/authentication")
//public class AuthenticationController {
//
//    @Autowired
//    private UserService userService;
//
//    // User registration endpoint
//    @PostMapping("/register")
//    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserDto userDto) {
//        try {
//            // Register the user (without password encryption)
//            User user = new User(userDto.getname(), userDto.getEmail(), userDto.getPhone_no(), userDto.getPassword());
//            userService.saveUser(user);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "User registered successfully!");
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        } catch (Exception e) {
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("error", "Registration failed: " + e.getMessage());
//            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    // User login endpoint
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginDto loginDto) {
//        try {
//            User user = userService.authenticateUser(loginDto.getEmail(), loginDto.getPassword());
//            Map<String, Object> response = new HashMap<>();
//            response.put("token", "mock-jwt-token");  // In a real scenario, generate a JWT token here
//            response.put("user_id", user.getId());
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("error", "Login failed: " + e.getMessage());
//            return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
//        }
//    }
//}
package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.Dto.LoginRequest;
import com.Nuntius.Nuntius.model.Authentication;
import com.Nuntius.Nuntius.model.User;
import com.Nuntius.Nuntius.repository.AuthenticationRepository;
import com.Nuntius.Nuntius.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/v1/authentication")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    // Endpoint for user login
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        // Look up the user by email
//        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());
//        if (!optionalUser.isPresent()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body("Invalid credentials: User not found");
//        }
//
//        User user = optionalUser.get();
//
//        // Compare passwords (in production, use hashed passwords)
//        if (!user.getPassword().equals(loginRequest.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body("Invalid credentials: Incorrect password");
//        }
//
//        // Generate a token (using UUID for demonstration; consider using JWT in production)
//        String token = UUID.randomUUID().toString();
//
//        // Create a new Authentication record
//        Authentication auth = new Authentication();
//        auth.setUser(user);
//        auth.setToken(token);
//        auth.setLoginAt(LocalDateTime.now());
//        // logoutAt can be null initially
//        authenticationRepository.save(auth);
//
//        // Prepare the response payload
//        Map<String, Object> response = new HashMap<>();
//        response.put("token", token);
//        response.put("user", user);
//
//        return ResponseEntity.ok(response);
//    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Look up the user by email
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());
        if (!optionalUser.isPresent()) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }

        User user = optionalUser.get();

        // Compare passwords (should hash and compare securely in production)
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }

        // Generate a token (consider using JWT for better security)
        String token = UUID.randomUUID().toString();

        // Create a new Authentication record
        Authentication auth = new Authentication();
        auth.setUser(user);
        auth.setToken(token);
        auth.setLoginAt(LocalDateTime.now());
        authenticationRepository.save(auth);

        // Prepare the response payload
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", user);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();  // Destroy the user session
        return ResponseEntity.ok("User logged out successfully");
    }



//    // Endpoint for user logout (optional)
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(@RequestParam Long authId) {
//        Optional<Authentication> optionalAuth = authenticationRepository.findById(authId);
//        if (!optionalAuth.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("Authentication session not found");
//        }
//
//        Authentication authentication = optionalAuth.get();
//        authentication.setLogoutAt(LocalDateTime.now());
//        authenticationRepository.save(authentication);
//
//        return ResponseEntity.ok("Logout successful");
//    }
}

