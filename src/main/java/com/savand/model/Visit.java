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
@Table(name = "visits")
public @Data class Visit extends BaseEntity {
  
  @Column(name = "visit_date", nullable = false)
  @NotNull
  @Convert(converter = LocalDateAttributeConverter.class)
  private LocalDate visitDate;
  
  @Column(name = "next_visit_date", nullable = false)
  @NotNull
  @Convert(converter = LocalDateAttributeConverter.class)
  private LocalDate nextVisitDate;
  
  @Column(name = "conclusion", nullable = false)
  @NotNull
  private String conclusion;
  
  @Column(name = "file_url", nullable = false)
  @NotNull
  private String fileUrl;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sickness_id")
  private Sickness sickness;
  
  @Column(name = "rate")
  private Integer rate;

  
  @Override
  public String toString() {
    return "Visit [visitDate=" + visitDate + ", nextVisitDate=" + nextVisitDate + ", conclusion=" + conclusion
        + ", fileUrl=" + fileUrl + ", rate=" + rate + "]";
  }
  
}
