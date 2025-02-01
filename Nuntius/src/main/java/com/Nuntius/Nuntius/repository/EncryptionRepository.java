package com.Nuntius.Nuntius.repository;

import com.Nuntius.Nuntius.model.Encryption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncryptionRepository extends JpaRepository<Encryption, Long> {

}
