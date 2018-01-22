package com.savand.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.savand.util.LocalDateAttributeConverter;

import lombok.Data;

@Entity
@Table(name = "persons")
public @Data class Person extends BaseEntity {

  @Column(name = "full_name", nullable = false)
  @NotNull
  private String fullName;

  @Column(name = "birthdate", nullable = false)
  @NotNull
  @Convert(converter = LocalDateAttributeConverter.class)
  private LocalDate birthDate;
  
  @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
  @OrderBy("measureDateTime DESC")
  private List<Measurement> measurementList;
  
  @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
  @OrderBy("startDate DESC")
  private List<Sickness> sicknessList;

  @Override
  public String toString() {
    return "Person [fullName=" + fullName + ", birthDate=" + birthDate + "]";
  }

}
