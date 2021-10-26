package com.ct.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Diagnosisdto {

	private Long appointmentId;
	private String diagnosisCode;
	private String description;
}
