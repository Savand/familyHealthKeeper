package com.savand.service;

import java.util.List;

import com.savand.model.Person;

public interface PersonService {

  List<Person> getPersonListOrderByIdAsc();

  Person getPersonById(int id);

}
