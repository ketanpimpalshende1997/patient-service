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
@Table(name = "procedure_details")
public class Procedure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "appointment_Id")
	private Integer appointmentId;

	@Column(name = "procedure_code")
	private String procedureCode;

	@Column(name = "description")
	private String description;

	private Date createdAt;

	private Date updatedAt;

	private String createdBy;

	private String updatedBy;

}
