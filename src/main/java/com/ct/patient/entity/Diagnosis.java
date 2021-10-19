package com.ct.patient.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diagnosis_details")
public class Diagnosis {

	@Id
	@Column(name = "identity")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "diagnosis_code")
	private String diagnosisCode;

	@Column(name = "diagnosis_name")
	private String diagnosisName;

	@Column(name = "discription")
	private String discription;

	private Long apointmentId;

	private Date createdAt;

	private Date updatedAt;

}
