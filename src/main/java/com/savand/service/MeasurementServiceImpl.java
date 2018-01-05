package com.savand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savand.model.Measurement;
import com.savand.repository.MeasurementRepository;

@Service
public class MeasurementServiceImpl implements MeasurementService {

  @Autowired
  private MeasurementRepository repository;

  @Override
  public List<Measurement> getMeasurementList() {
    return repository.findAll();
  }

  @Override
  public Measurement getMeasurementById(int id) {
    return repository.findOne(id);
  }

}
