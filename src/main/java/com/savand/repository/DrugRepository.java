package com.savand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savand.model.Drug;

public interface DrugRepository extends JpaRepository<Drug, Integer> {
}
