package com.ct.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DrugDto {

	private Integer appointmentId;
	private String drugId;
	private String drugName;
	private String drugGenericName;
	private String drugBrandName;
	private String drugForm;

}
