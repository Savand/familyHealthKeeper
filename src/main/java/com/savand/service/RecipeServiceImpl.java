package com.savand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savand.model.Drug;
import com.savand.repository.DrugRepository;

@Service
public class RecipeServiceImpl implements DrugService {

  @Autowired
  private DrugRepository repository;


  @Override
  public List<Drug> getDrugList() {
    return repository.findAll();
  }

  @Override
  public Drug getDrugById(int id) {
    return repository.findOne(id);
  }

}
