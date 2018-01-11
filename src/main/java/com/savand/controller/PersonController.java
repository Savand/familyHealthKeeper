package com.savand.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.savand.model.Person;
import com.savand.service.PersonService;

@Controller
public class PersonController {

  @Autowired
  private PersonService service;
  
  @GetMapping("/persons")
  public String getPersonList(Model model) {
    List<Person> personList = service.getPersonListOrderByIdAsc();
    model.addAttribute("personList", personList);
    
    return "personList";
  }
  
  
    @GetMapping("/personPage")
    public String getPersonPage(@RequestParam(value="id") Integer id, Model model, HttpServletRequest request) {
      Person person = service.getPersonById(id);
      model.addAttribute("person", person);
      
      return "personPage";
    }
  
}
