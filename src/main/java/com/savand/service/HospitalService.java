package com.savand.service;

import java.util.List;

import com.savand.model.Hospital;

public interface HospitalService {
	
	List<Hospital> getHospitalList();

	Hospital getHospitalById(int id);

}
