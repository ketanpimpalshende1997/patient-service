package com.ct.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Medicinedto {

	private Integer appointmentId;

	private String drugName;

	private String drugForm;

	private String discription;
}
