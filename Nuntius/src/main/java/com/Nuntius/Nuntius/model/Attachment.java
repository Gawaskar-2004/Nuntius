package com.Nuntius.Nuntius.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String attachment_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MESSAGE_ID")
    private Message message_id;

    private String fileUrl;
    private String fileType;
    private LocalDateTime uploadDate;

    public Attachment() {}

    // Getters and Setters
    public String getAttachment_id() {
        return attachment_id;
    }

    public void setAttachmentId(String attachment_id) {
        this.attachment_id = attachment_id;
    }

    public Message getMessage() {
        return message_id;
    }

    public void setMessage(Message message_id) {
        this.message_id = message_id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }
}
