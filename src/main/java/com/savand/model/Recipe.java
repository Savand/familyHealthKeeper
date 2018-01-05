package com.savand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "recipes")
public @Data class Recipe extends BaseEntity{
	
  @Column(name = "medicine")
  @NotNull
	private String medicine;
	
  @Column(name = "cost")
	private Integer cost;
	
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "visit_id")
  private Visit visit;
  
  @Override
  public String toString() {
    return "Recipe [medicine=" + medicine + ", cost=" + cost + "]";
  }
  
  
}
