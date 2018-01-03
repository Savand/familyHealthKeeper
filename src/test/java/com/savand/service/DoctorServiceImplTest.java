package com.savand.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.savand.model.Doctor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceImplTest {

  @Autowired
  DoctorService service;

  @Test
  public void testGetDoctorById() {
    Doctor doctorById = service.getDoctorById(100007);
    System.out.println(doctorById);
  }

  @Test
  public void testGetDoctorList() {
    System.out.println(service.getDoctorList());
  }

}
