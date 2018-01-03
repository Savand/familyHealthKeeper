package com.savand.service;

import java.util.List;

import com.savand.model.Doctor;

public interface DoctorService {

  List<Doctor> getDoctorList();

  Doctor getDoctorById(int id);

}
