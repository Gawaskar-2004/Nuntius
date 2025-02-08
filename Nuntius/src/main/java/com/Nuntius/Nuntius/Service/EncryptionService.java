package com.Nuntius.Nuntius.Service;

import com.Nuntius.Nuntius.exception.ResourceNotFoundException;
import com.Nuntius.Nuntius.model.Encryption;
import com.Nuntius.Nuntius.repository.EncryptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncryptionService {

    @Autowired
    private EncryptionRepository encryptionRepository;

    // Get all encryption records
    public List<Encryption> getAllEncryption() {
        return encryptionRepository.findAll();
    }

    // Create a new encryption record
    public Encryption createEncryption(Encryption encryption) {
        return encryptionRepository.save(encryption);
    }

    // Get an encryption record by its ID
    public Encryption getEncryptionById(Long encryptionId) {
        return encryptionRepository.findById(encryptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Encryption not found with id: " + encryptionId));
    }
}