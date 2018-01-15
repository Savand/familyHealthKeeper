package com.savand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savand.model.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
  public List<Measurement> findAllByOrderByMeasureDateTimeDesc();
}
