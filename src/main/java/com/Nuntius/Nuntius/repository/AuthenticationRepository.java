package com.Nuntius.Nuntius.repository;

import com.Nuntius.Nuntius.model.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
}
