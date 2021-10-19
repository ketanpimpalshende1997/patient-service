package com.ct.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisMaster {

	@Id
	@Column(name = "diagnosis_code")
	private String diagnosisCode;

	@Column(name = "diagnosis_name")
	private String diagnosisName;
}
