package com.ct.patient.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "master_procedure")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MasterProcedure {

	@Id
	private String procedureCode;

	private String description;

	private boolean isDepricated;

}
