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

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drug_Id")
	private Long medicationId;

	@Column(name = "appointment_Id", nullable = false)
	private Integer appointmentId;

	@Column(name = "drug_name", nullable = false)
	private String drugName;

	@Column(name = "drug_form")
	private String drugForm;

	@Column(name = "discription")
	private String discription;

	private Date createdAt;

	private Date updatedAt;

	private String createdBy;

	private String updatedBy;

}
