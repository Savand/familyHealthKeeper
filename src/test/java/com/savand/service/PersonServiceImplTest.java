package com.savand.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.savand.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest {

  @Autowired
  private PersonService service;

  @Test
  public void testGetPersonList() {
    List<Person> personList = service.getPersonList();
    System.out.println(personList);
  }

  @Test
  public void testGetPersonById() {
    System.out.println(service.getPersonById(100_000));
  }

}
