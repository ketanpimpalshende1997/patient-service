package com.ct.patient.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@Column(name = "procedure_Id")
	private Long procedureId;

	@Column(name = "appointment_Id")
	private Integer appointmentId;

	private Date createdAt;

	private Date updatedAt;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "procedure_id")
	private List<Procedures> procedures;

	public Procedure(Integer appointmentId, Date createdAt, Date updatedAt, List<Procedures> procedures) {

		this.appointmentId = appointmentId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.procedures = procedures;
	}
}
