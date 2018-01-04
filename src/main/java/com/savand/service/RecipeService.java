package com.savand.service;

import java.util.List;

import com.savand.model.Recipe;

public interface RecipeService {

  List<Recipe> getRecipeList();

  Recipe getRecipeById(int id);

}
