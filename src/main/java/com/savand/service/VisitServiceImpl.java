package com.savand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savand.model.Visit;
import com.savand.repository.VisitRepository;

@Service
public class VisitServiceImpl implements VisitService {

  @Autowired
  private VisitRepository repository;

  @Override
  public List<Visit> getVisitList() {
    return repository.findAll();
  }

  @Override
  public Visit getVisitById(int id) {
    return repository.findOne(id);
  }

}
