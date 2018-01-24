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

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @MockBean
    private PersonService personService;

//    @InjectMocks
//    private PersonController personController;

    @Autowired
    private MockMvc mockMvc;

//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
//    }

    @Test
    public void testGetPersonList() throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
        persons.add(new Person());

        when(personService.getPersonListOrderByIdAsc()).thenReturn((List) persons);
        mockMvc.perform(
                get("/persons"))
                .andExpect(status().isOk())
                .andExpect(view().name("personList"))
                .andExpect(model().attribute("personList", persons))
                .andDo(print());

    }

    //Todo: finish the test (error message = Required Integer parameter 'id' is not present)
    @Test
    public void testGetPersonPage() throws Exception {
        Person person = new Person();

        when(personService.getPersonById(10007)).thenReturn(person);
        Integer value = 10007;
        mockMvc.perform(
                get("/personPage").requestAttr("id", value))
                .andExpect(status().isOk())
                .andExpect(model().attribute("person", is(person)))
                .andExpect(view().name("personPage")
                )
                ;

    }
}