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
    private UserRepository userRepository;  // Inject the UserRepository

    // Get all groups
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

    // Update a group by its ID
    @PutMapping("/{group_id}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long group_id, @RequestBody Group groupDetails) {
        Group group = groupRepository.findById(group_id)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id: " + group_id));

        // Set group name
        group.setGroupName(groupDetails.getGroupName());

        // Ensure the 'created_by' user exists
        if (groupDetails.getCreatedBy() != null) {
            User user = userRepository.findById(groupDetails.getCreatedBy().getUser_id())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + groupDetails.getCreatedBy().getUser_id()));
            group.setCreatedBy(user);
        }

        // Set created at
        group.setCreatedAt(groupDetails.getCreatedAt());

        // Save and return the updated group
        Group updatedGroup = groupRepository.save(group);
        return ResponseEntity.ok(updatedGroup);
    }

    // Delete a group by its ID
    @DeleteMapping("/{group_id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long group_id) {
        Group group = groupRepository.findById(group_id)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id: " + group_id));

        groupRepository.delete(group);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
