package com.savand.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.savand.util.LocalDateAttributeConverter;

import lombok.Data;

@Entity
@Table(name = "persons")
public @Data class Person extends BaseEntity{
	
	@Column(name = "full_name", nullable = false)
	@NotNull
	private String fullName;
	
	@Column(name = "birthdate", nullable = false)
	@NotNull
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate birthDate;

	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", birthDate=" + birthDate + "]";
	}
	
	
}
