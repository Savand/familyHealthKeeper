package com.savand.service;

import java.util.List;

import com.savand.model.Drug;

public interface DrugService {

  List<Drug> getDrugList();

  Drug getDrugById(int id);

}
