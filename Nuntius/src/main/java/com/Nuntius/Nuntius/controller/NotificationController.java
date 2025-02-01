package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Notification;
import com.Nuntius.Nuntius.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Notification")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    // Get all notifications
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Create a new notification
    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }

    // Get notification by ID
    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable String id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + id));
        return ResponseEntity.ok(notification);
    }
}
