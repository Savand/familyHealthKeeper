package com.savand.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.savand.model.Drug;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrugServiceImplTest {

  @Autowired
  private DrugService service;

  @Test
  public void testGetRecipeById() {
    Drug recipeById = service.getDrugById(100018);
    System.out.println(recipeById);
  }

  @Test
  public void testGetRecipeList() {
    System.out.println(service.getDrugList());
  }

}
