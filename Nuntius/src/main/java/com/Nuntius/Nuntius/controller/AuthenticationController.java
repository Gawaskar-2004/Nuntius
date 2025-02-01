package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.model.Authentication;
import com.Nuntius.Nuntius.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @GetMapping
    public List<Authentication> getAllAuthentications() {
        return authenticationRepository.findAll();
    }

    @PostMapping
    public Authentication createAuthentication(@RequestBody Authentication authentication) {
        return authenticationRepository.save(authentication);
    }
}