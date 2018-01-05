package com.savand.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.savand.model.Measurement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeasurementServiceImplTest {

  @Autowired
  private MeasurementService service;

  @Test
  public void testGetRecipeById() {
    Measurement recipeById = service.getMeasurementById(100018);
    System.out.println(recipeById);
  }

  @Test
  public void testGetRecipeList() {
    System.out.println(service.getMeasurementList());
  }

}
