package com.savand.service;

import java.util.List;

import com.savand.model.Sickness;

public interface SicknessService {

  List<Sickness> getSicknessList();

  Sickness getSicknessById(int id);
}
