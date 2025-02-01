package com.Nuntius.Nuntius.controller;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Encryption;
import com.Nuntius.Nuntius.repository.EncryptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/encryption")
public class EncryptionController {

    @Autowired
    private EncryptionRepository encryptionRepository;

    // Get all encryption records
    @GetMapping
    public List<Encryption> getAllEncryption() {
        return encryptionRepository.findAll();
    }

    // Create a new encryption record
    @PostMapping
    public Encryption createEncryption(@RequestBody Encryption encryption) {
        return encryptionRepository.save(encryption);
    }

    // Get an encryption record by its ID
    @GetMapping("/{encryption_id}")
    public ResponseEntity<Encryption> getEncryptionById(@PathVariable Long encryption_id) {
        Encryption encryption = encryptionRepository.findById(encryption_id)
                .orElseThrow(() -> new ResourceNotFoundException("Encryption not found with id: " + encryption_id));
        return ResponseEntity.ok(encryption);
    }

    // Update an encryption record by its ID
    @PutMapping("/{encryption_id}")
    public ResponseEntity<Encryption> updateEncryption(@PathVariable Long encryption_id, @RequestBody Encryption encryptionDetails) {
        Encryption encryption = encryptionRepository.findById(encryption_id)
                .orElseThrow(() -> new ResourceNotFoundException("Encryption not found with id: " + encryption_id));

        encryption.setChat(encryptionDetails.getChat());
        encryption.setEncryptionKey(encryptionDetails.getEncryptionKey());
        encryption.setAlgorithm(encryptionDetails.getAlgorithm());
        encryption.setCreatedAt(encryptionDetails.getCreatedAt());

        Encryption updatedEncryption = encryptionRepository.save(encryption);
        return ResponseEntity.ok(updatedEncryption);
    }

    // Delete an encryption record by its ID
    @DeleteMapping("/{encryption_id}")
    public ResponseEntity<Void> deleteEncryption(@PathVariable Long encryption_id) {
        Encryption encryption = encryptionRepository.findById(encryption_id)
                .orElseThrow(() -> new ResourceNotFoundException("Encryption not found with id: " + encryption_id));

        encryptionRepository.delete(encryption);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
