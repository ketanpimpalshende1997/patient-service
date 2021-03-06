package com.ct.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "allergy_details")
public class Allergy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Schema(description = "allergy id",  example = "123")
	@Column(name = "allergy_id")
	private String allergyId;

	@Schema(description = "allergy name",  example = "cough")
	@Column(name = "allergy_name")
	private String allergyName;

	@Schema(description = "allergy type",  example = "general")
	@Column(name = "allergy_type")
	private String allergyType;

	@Schema(description = "allergy fatal",  example = "xyz")
	@Column(name = "allergy_fatal")
	private String allergyFatal;

	@Schema(description = "allergy description",  example = "cough")
	@Column(name = "allergy_desc")
	private String allergyDesc;
	
	@Schema(description = "allergy Clinical Info",  example = "info")
	@Column(name = "allergy_clinical_info")
	private String allergyClinicalInfo;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "patient_details_id")
//	// @JsonIgnoreProperties("patientDetails")
//	@JsonIgnore
//	PatientDetails patientDetails;

	@Column(name="patient_details_id")
	private Long patientId;
	
}