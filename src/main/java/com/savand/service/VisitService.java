package com.savand.service;

import java.util.List;

import com.savand.model.Visit;

public interface VisitService {

  List<Visit> getVisitList();

  Visit getVisitById(int id);
}
