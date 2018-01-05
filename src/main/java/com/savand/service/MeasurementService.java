package com.savand.service;

import java.util.List;

import com.savand.model.Measurement;

public interface MeasurementService {

  List<Measurement> getMeasurementList();

  Measurement getMeasurementById(int id);

}
