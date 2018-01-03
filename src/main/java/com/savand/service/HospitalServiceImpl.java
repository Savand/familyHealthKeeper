package com.savand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savand.model.Hospital;
import com.savand.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepository repository;
	
	@Override
	public List<Hospital> getHospitalList() {
		return repository.findAll();
	}

	@Override
	public Hospital getHospitalById(int id) {
		return repository.findOne(id);
	}

}
