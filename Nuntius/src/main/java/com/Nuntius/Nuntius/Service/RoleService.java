package com.Nuntius.Nuntius.Service;

import com.Nuntius.Nuntius.model.Role;
import com.Nuntius.Nuntius.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Get all roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Create a new role
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
