package com.ct.patient.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table
public class DrugMaster {

	@Id
	private String drugId;
	private String drugName;
	private String drugGenericName;
	private String drugBrandName;
	private String drugForm;
	private String drugStrength;
	private boolean isDeprecated;

}
