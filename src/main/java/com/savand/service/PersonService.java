package com.savand.service;

import java.util.List;

import com.savand.model.Person;

public interface PersonService {

	List<Person> getPersonList();
	
	Person getPersonById(int id);
	
}
