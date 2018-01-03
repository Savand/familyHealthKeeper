package com.savand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity {

  @Column(name = "full_name", nullable = false)
  @NotNull
  private String fullName;

  @Column(name = "contacts", nullable = false)
  @NotNull
  private String contacts;

  @Column(name = "specialization", nullable = false)
  @NotNull
  private String specialization;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "hospital_id")
  private Hospital hospital;

  @Override
  public String toString() {
    return "Doctor [fullName=" + fullName + ", contacts=" + contacts + ", specialization=" + specialization + "]";
  }

}
