package com.savand.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.savand.util.LocalDateTimeAttributeConverter;

import lombok.Data;

@Entity
@Table(name = "measurements")
public @Data class Measurement extends BaseEntity{

  @Column(name = "measure_datetime", nullable = false)
  @NotNull
  @Convert(converter = LocalDateTimeAttributeConverter.class)
  private LocalDateTime measureDateTime;
  
  @Column(name = "indicator_value", nullable = false)
  @NotNull
  private String indicatorValue;
  
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, name = "measurement_type")
  @NotNull
  private MeasurementType measurementType;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  private Person person;
    
  public enum MeasurementType{
    TEMPERATURE_C("Temperature, C&deg;"), TEMPERATURE_F("Temperature, F&deg;"), BLOOD_PRESSURE_MMHG("Blood pressure, mmHg");
    
    private final String fieldDescription;

    private MeasurementType(String value) {
        fieldDescription = value;
    }
   
    public String getFieldDescription() {
        return fieldDescription;
    }
  }

  @Override
  public String toString() {
    return "Measurement [measureDateTime=" + measureDateTime + ", indicatorValue=" + indicatorValue
        + ", measurementType=" + measurementType + "]";
  }
  
  
}
