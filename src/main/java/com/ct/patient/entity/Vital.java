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
@Table(name = "vital_signs")
public class Vital {

	@Id
	@Column(name = "vital_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vitalId;

	@Column(name = "height", nullable = false)
	private Double height;

	@Column(name = "weight", nullable = false)
	private Double weight;

	@Column(name = "blood_pressure", nullable = false)
	private String bloodPressure;

	@Column(name = "body_temperature", nullable = false)
	private Double bodyTemperature;

	@Column(name = "respiration_rate", nullable = false)
	private Double respirationRate;

	@Column(name = "appointment_id", nullable = false)
	private Integer appointmentId;

	private Date createdAt;

	private Date updatedAt;

}
