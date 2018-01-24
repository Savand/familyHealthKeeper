package com.savand.controller;

import com.savand.model.Person;
import com.savand.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @MockBean
    private PersonService personService;


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetPersonList() throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
        persons.add(new Person());

        when(personService.getPersonListOrderByIdAsc()).thenReturn(persons);
        mockMvc.perform(
                get("/persons"))
                .andExpect(status().isOk())
                .andExpect(view().name("personList"))
                .andExpect(model().attribute("personList", persons))
                .andDo(print());

    }

    @Test
    public void testGetPersonPage() throws Exception {
        Person person = new Person();
        Integer value = 100007;

        when(personService.getPersonById(value)).thenReturn(person);
        mockMvc.perform(
                get("/personPage").param("id", String.valueOf(value)))
                .andExpect(status().isOk())
                .andExpect(model().attribute("person", person))
                .andExpect(view().name("personPage")
                );

    }
}