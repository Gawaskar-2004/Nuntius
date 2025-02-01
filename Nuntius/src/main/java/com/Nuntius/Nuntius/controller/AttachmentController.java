package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Attachment;
import com.Nuntius.Nuntius.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Attachment")
public class AttachmentController {

    @Autowired
    private AttachmentRepository attachmentRepository;

    // Get all attachments
    @GetMapping
    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    // Create a new attachment
    @PostMapping
    public Attachment createAttachment(@RequestBody Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    // Get attachment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Attachment> getAttachmentById(@PathVariable String id) {
        Attachment attachment = attachmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attachment not found with id: " + id));
        return ResponseEntity.ok(attachment);
    }
}