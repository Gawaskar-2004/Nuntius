package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.model.Attachment;
import com.Nuntius.Nuntius.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @GetMapping
    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    @PostMapping
    public Attachment createAttachment(@RequestBody Attachment attachment) {
        return attachmentRepository.save(attachment);
    }
}
