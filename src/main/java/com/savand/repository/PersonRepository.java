package com.savand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savand.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
