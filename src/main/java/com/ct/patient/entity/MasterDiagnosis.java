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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="master_diagnosis")
public class MasterDiagnosis {

	@Id
	@Column(name = "diagnosis_code")
	private String diagnosisCode;

	private String description;

//	@Column(columnDefinition = "boolean default false")
	private boolean isDepricated;

}
