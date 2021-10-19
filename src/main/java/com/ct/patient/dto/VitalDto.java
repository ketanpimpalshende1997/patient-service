package com.ct.patient.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VitalDto {

	@Schema(description = "height of patient",  example = "176")
	private Double height;
	@Schema(description = "weight",  example = "78")
	private Double weight;
	@Schema(description = "blood pressure",  example = "120/80")
	private String bloodPressure;
	@Schema(description = "body temperature",  example = "98")
	private Double bodyTemperature;
	@Schema(description = "respiration",  example = "72")
	private Double respirationRate;
	@Schema(description = "appointment id",  example = "1")
	private Integer appointmentId;
	private Long vitalId;
}
