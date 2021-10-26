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
@Table(name = "drug_details")
public class Drug {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String drugId;
	private String drugName;
	private String drugGenericName;
	private String drugBrandName;
	private String drugForm;

	@Column(name = "appointment_Id", nullable = false)
	private Integer appointmentId;

	private Date createdAt;

	private Date updatedAt;

	private String createdBy;

	private String updatedBy;

}
