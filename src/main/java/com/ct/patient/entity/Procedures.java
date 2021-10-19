package com.ct.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table
public class Procedures {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identity")
	private Long id;

	@Column(name = "procedure_code")
	private String procedureCode;

	@Column(name = "procedure_Name", nullable = false)
	private String procedureName;

	@Column(name = "discription")
	private String discription;

	@ManyToOne
	private Procedure procedure;
}
