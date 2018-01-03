package com.savand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savand.model.Sickness;

public interface SicknessRepository extends JpaRepository<Sickness, Integer>{}
