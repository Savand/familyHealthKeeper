package com.savand.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.savand.util.LocalDateAttributeConverter;

import lombok.Data;

@Entity
@Table(name = "sickness_history")
public @Data class Sickness extends BaseEntity {

  @Column(name = "start_date", nullable = false)
  @NotNull
  @Convert(converter = LocalDateAttributeConverter.class)
  private LocalDate startDate;

  @Column(name = "end_date")
  @Convert(converter = LocalDateAttributeConverter.class)
  private LocalDate endDate;

  @Column(name = "description", nullable = false)
  @NotNull
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  private Person person;

  @Override
  public String toString() {
    return "Sickness [startDate=" + startDate + ", endDate=" + endDate + ", description=" + description + "]";
  }

}
