package com.savand.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SicknessServiceImplTest {
	
	@Autowired
	private SicknessService service;
	
	@Test
	public void testGetSicknessList() {
		System.out.println(service.getSicknessById(100009));
	}

	@Test
	public void testGetSicknessById() {
		System.out.println(service.getSicknessList());
	}

}
