//package com.Nuntius.Nuntius.Service;
//import com.Nuntius.Nuntius.model.User;
//import com.Nuntius.Nuntius.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public User getUserDetails(User user){
//        return userRepository.save(user);
//    }
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//
//
//}
package com.Nuntius.Nuntius.Service;

import com.Nuntius.Nuntius.model.User;
import com.Nuntius.Nuntius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Check if the email is already registered
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered.");
        }

        // Directly store password (⚠️ Not Secure)
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password)) // Simple password check
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }

    public User findUserById(int userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null); // Return user if found, otherwise return null
    }

    public User getUserById(int contactUserId) {
        return userRepository.findById(contactUserId).orElse(null);
    }
}
