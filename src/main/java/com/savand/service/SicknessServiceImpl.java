package com.savand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savand.model.Sickness;
import com.savand.repository.SicknessRepository;

@Service
public class SicknessServiceImpl implements SicknessService {

  @Autowired
  private SicknessRepository repository;

  @Override
  public List<Sickness> getSicknessList() {
    return repository.findAll();
  }

  @Override
  public Sickness getSicknessById(int id) {
    return repository.findOne(id);
  }

}
