//package com.Nuntius.Nuntius.Service;
//
//import com.Nuntius.Nuntius.repository.UserRepository;
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class AuthenticationService {
//
//
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    }
//
//package com.Nuntius.Nuntius.Service;
//
//import com.Nuntius.Nuntius.Dto.UserDTO;
//import com.Nuntius.Nuntius.repository.UserRepository;
//import com.Nuntius.Nuntius.model.User;
//import com.Nuntius.Nuntius.Dto.LoginDTO;
//import com.Nuntius.Nuntius.Dto.UserDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AuthenticationService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    // Register a new user
//    public User registerUser(UserDTO userDTO) {
//        // Check if email already exists
//        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
//        if (existingUser.isPresent()) {
//            throw new RuntimeException("Email is already in use");
//        }
//
//        // Create a new User object (no password hashing)
//        User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPhone_no(), userDTO.getPassword());
//
//        // Save the user in the repository
//        return userRepository.save(user);
//    }
//
//    // Authenticate user during login
//    public User authenticateUser(LoginDTO loginDto) {
//        // Find the user by email
//        Optional<User> userOptional = userRepository.findByEmail(loginDto.getEmail());
//
//        if (userOptional.isEmpty()) {
//            throw new RuntimeException("User not found with the given email");
//        }
//
//        User user = userOptional.get();
//
//        // Check if the password matches (no hashing, compares plain text)
//        if (!loginDto.getPassword().equals(user.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//
//        return user;
//    }
//}
//package com.Nuntius.Nuntius.Service;
//
//import com.Nuntius.Nuntius.model.Authentication;
//import com.Nuntius.Nuntius.model.User;
//import com.Nuntius.Nuntius.repository.AuthenticationRepository;
//import com.Nuntius.Nuntius.repository.UserRepository;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.Optional;
//import java.util.stream.DoubleStream;
//
//@Service
//public class AuthenticationService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private AuthenticationRepository authenticationRepository;
//
//    private static final String SECRET_KEY = "your-secret-key"; // Should be stored securely
//
//    public String generateJwtToken(User user) {
//        // Generate JWT token
//        DoubleStream Jwts = DoubleStream.empty();
//        return Jwts.builder()
//                .setSubject(user.getEmail())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours expiration
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public Authentication loginUser(String email, String password) {
//        // Fetch user by email and validate password
//        Optional<User> userOptional = userRepository.findByEmail(email);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//
//            // In production, use BCrypt to validate the password
//            if (user.getPassword().equals(password)) {
//                // Generate JWT Token
//                String token = generateJwtToken(user);
//
//                // Save login details
//                Authentication authentication = new Authentication();
//                authentication.setUser(user);
//                authentication.setToken(token);
//                authentication.setLoginAt(LocalDateTime.now());
//                authentication.setLogoutAt(null); // Initially, logoutAt is null
//                return authenticationRepository.save(authentication);
//            }
//        }
//        throw new RuntimeException("Invalid email or password");
//    }
//
//    public Authentication logoutUser(Long authId) {
//        Optional<Authentication> authenticationOptional = authenticationRepository.findById(authId);
//        if (authenticationOptional.isPresent()) {
//            Authentication authentication = authenticationOptional.get();
//            authentication.setLogoutAt(LocalDateTime.now());
//            return authenticationRepository.save(authentication);
//        }
//        throw new RuntimeException("Authentication session not found");
//    }
//}
//
package com.Nuntius.Nuntius.Service;

import com.Nuntius.Nuntius.model.Authentication;
import com.Nuntius.Nuntius.model.User;
import com.Nuntius.Nuntius.repository.AuthenticationRepository;
import com.Nuntius.Nuntius.repository.UserRepository;
import com.Nuntius.Nuntius.Dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    // Method to handle user login
    public Authentication login(LoginRequest loginRequest) {
        // Look up the user by email
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("Invalid credentials: User not found");
        }

        User user = optionalUser.get();

        // Compare passwords (in production, use hashed passwords)
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid credentials: Incorrect password");
        }

        // Generate a token (using UUID for demonstration; consider using JWT in production)
        String token = UUID.randomUUID().toString();

        // Create a new Authentication record
        Authentication auth = new Authentication();
        auth.setUser(user);
        auth.setToken(token);
        auth.setLoginAt(LocalDateTime.now());
        authenticationRepository.save(auth);

        return auth;
    }

    // Method to handle user logout
    public void logout(Long authId) {
        Optional<Authentication> optionalAuth = authenticationRepository.findById(authId);
        if (!optionalAuth.isPresent()) {
            throw new RuntimeException("Authentication session not found");
        }

        Authentication authentication = optionalAuth.get();
        authentication.setLogoutAt(LocalDateTime.now());
        authenticationRepository.save(authentication);
    }
}

