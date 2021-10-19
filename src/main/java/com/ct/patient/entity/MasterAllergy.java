package com.ct.patient.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "master_allergy")
@Entity
public class MasterAllergy {
	@Id
	private String allergyId;
	private String allergyType;
	private String allergyName;
	private String allergyDescription;
	private String allergyClinicalInfo;

}
