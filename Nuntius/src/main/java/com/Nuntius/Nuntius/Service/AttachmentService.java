package com.Nuntius.Nuntius.Service;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Attachment;
import com.Nuntius.Nuntius.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    // Get all attachments
    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    // Create a new attachment
    public Attachment createAttachment(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    // Get attachment by ID
    public Attachment getAttachmentById(String id) {
        return attachmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attachment not found with id: " + id));
    }
}
