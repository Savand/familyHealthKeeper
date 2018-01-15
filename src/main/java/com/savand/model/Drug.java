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
@Table(name = "drugs")
public @Data class Drug extends BaseEntity{
	
  @Column(name = "medicine")
  @NotNull
	private String name;
	
  @Column(name = "cost")
	private Integer cost;
	
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "visit_id")
  private Visit visit;
  
  @Override
  public String toString() {
    return "Drug [name=" + name + ", cost=" + cost + "]";
  }
  
  
}
