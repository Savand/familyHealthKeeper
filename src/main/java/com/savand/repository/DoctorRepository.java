package com.savand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savand.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{}
