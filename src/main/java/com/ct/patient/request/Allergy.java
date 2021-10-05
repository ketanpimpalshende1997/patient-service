package com.ct.patient.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "allergy")
@Entity
public class Allergy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Schema(description = "allergy id", example = "12")
	private String allergyId;
	@Schema(description = "allergy type", example = "abcd")
	private String allergyType;
	@Schema(description = "allergy name", example = "xyz")
	private String allergyName;
	@Schema(description = "allergy description", example = "abc xyz")
	private String allergyDescription;
	@Schema(description = "allergy clinical info", example = "xyz abc")
	private String allergyClinicalInfo;

}
