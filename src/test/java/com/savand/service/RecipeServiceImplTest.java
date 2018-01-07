package com.savand.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.savand.model.Recipe;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceImplTest {

  @Autowired
  private RecipeService service;

  @Test
  public void testGetRecipeById() {
    Recipe recipeById = service.getRecipeById(100018);
    System.out.println(recipeById);
  }

  @Test
  public void testGetRecipeList() {
    System.out.println(service.getRecipeList());
  }

}