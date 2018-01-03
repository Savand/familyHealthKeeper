package com.savand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savand.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
