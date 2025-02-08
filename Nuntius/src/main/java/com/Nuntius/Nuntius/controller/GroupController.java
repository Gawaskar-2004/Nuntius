package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Group;
import com.Nuntius.Nuntius.model.User;
import com.Nuntius.Nuntius.repository.GroupRepository;
import com.Nuntius.Nuntius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    // Create a new group
    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }

    // Get a group by its ID
    @GetMapping("/{group_id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long group_id) {
        Group group = groupRepository.findById(group_id)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id: " + group_id));
        return ResponseEntity.ok(group);
    }
}
