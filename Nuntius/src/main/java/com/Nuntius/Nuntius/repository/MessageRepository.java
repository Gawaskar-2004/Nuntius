package com.Nuntius.Nuntius.repository;

import com.Nuntius.Nuntius.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
}