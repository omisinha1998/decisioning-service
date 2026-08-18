package com.omi.decisioning.repository;

import com.omi.decisioning.model.Decision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecisionRepository
        extends JpaRepository<Decision, Long> {
}