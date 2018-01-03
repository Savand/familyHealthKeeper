package com.savand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savand.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
