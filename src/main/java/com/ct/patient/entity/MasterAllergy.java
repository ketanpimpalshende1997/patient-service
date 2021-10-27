package com.ct.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="master_allergy")
public class MasterAllergy {

	@Id
	@Column(name = "allergy_id")
	private Integer allergyId;
	@Column(name = "allergy_type")
	private String allergyType;
	@Column(name = "allergy_name")
	private String allergyName;
	@Column(name="allergy_description")
	private String allergyDescription;
	@Column(name = "allergy_code")
	private String allergyCode;


}
