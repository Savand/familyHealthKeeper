package com.savand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savand.model.Doctor;
import com.savand.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  private DoctorRepository repository;

  @Override
  public Doctor getDoctorById(int id) {
    return repository.findOne(id);
  }

  @Override
  public List<Doctor> getDoctorList() {
    return repository.findAll();
  }

}
