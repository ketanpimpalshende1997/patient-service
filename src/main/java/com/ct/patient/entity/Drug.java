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
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table
public class Drug {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "drugid")
	private Integer drugId;

	@Column(name = "drugname")
	private String drugName;

	@Column(name = "drugform")
	private String drugForm;

}
