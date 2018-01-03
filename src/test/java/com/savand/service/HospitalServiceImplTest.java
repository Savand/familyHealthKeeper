package com.savand.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalServiceImplTest {

  @Autowired
  private HospitalService service;

  @Test
  public void testGetHospitalList() {
    System.out.println(service.getHospitalList());
  }

  @Test
  public void testGetHospitalById() {
    System.out.println(service.getHospitalById(100004));
  }

}
