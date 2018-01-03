package com.savand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savand.model.Person;
import com.savand.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository repository;

	@Override
	public List<Person> getPersonList() {
		return repository.findAll();
	}

	@Override
	public Person getPersonById(int id) {
		return repository.findOne(id);
	}
	
}
