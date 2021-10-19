package com.ct.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AllergyMaster {

	@Id
	@Column(name = "allergy_id")
	private Integer allergyMasterId;
	@Column(name = "allergy_code")
	private String allergyCode;
	@Column(name = "allergy_name")
	private String allergyName;
	@Column(name = "allergy_type")
	private String allergyType;
	@Column(name = "allergen_source")
	private String allergySource;
	@Column(name = "isoformsofallergen")
	private String isoformsofallergen;
	@Column(name = "allerginicity")
	private String allerginicity;

}
