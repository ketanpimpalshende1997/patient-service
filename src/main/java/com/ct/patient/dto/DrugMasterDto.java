package com.ct.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DrugMasterDto {

	private String drugId;
	private String drugName;
	private String drugGenericName;
	private String drugBrandName;
	private String drugForm;
	private String drugStrength;
}
