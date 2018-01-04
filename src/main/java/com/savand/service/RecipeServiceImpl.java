package com.savand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savand.model.Recipe;
import com.savand.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

  @Autowired
  private RecipeRepository repository;


  @Override
  public List<Recipe> getRecipeList() {
    return repository.findAll();
  }

  @Override
  public Recipe getRecipeById(int id) {
    return repository.findOne(id);
  }

}
