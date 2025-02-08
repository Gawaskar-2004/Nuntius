package com.Nuntius.Nuntius.Service;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Group;
import com.Nuntius.Nuntius.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    // Method to save a group
    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    // Method to retrieve all groups
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    // Method to retrieve a group by its ID
    public Group getGroupById(String groupId) {
        return groupRepository.findById(Long.valueOf(groupId))
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with ID: " + groupId));
    }
}
