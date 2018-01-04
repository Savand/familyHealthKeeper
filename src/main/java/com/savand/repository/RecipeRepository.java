package com.savand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savand.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
