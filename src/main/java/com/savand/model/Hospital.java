package com.savand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "hospitals")
public @Data class Hospital extends BaseEntity {

  @Column(name = "full_name", nullable = false)
  @NotNull
  private String fullName;

  @Column(name = "address", nullable = false)
  @NotNull
  private String address;

  @Column(name = "web_site_url", nullable = false)
  @NotNull
  private String webSiteUrl;

  @Column(name = "rate")
  private Integer rate;

  @Override
  public String toString() {
    return "Hospital [fullName=" + fullName + ", address=" + address + ", webSiteUrl=" + webSiteUrl + ", rate=" + rate
        + "]";
  }

}
