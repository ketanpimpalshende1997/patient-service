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
@Entity
@Table(name = "emergency_details")
public class EmergencyContactRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "emergencyId", required = false, example = "12")
	private Long emergencyId;
	@Schema(description = "first Name", required = true, example = "vaibhav")
	private String firstName;
	@Schema(description = "last Name", required = true, example = "pimpalshende")
	private String lastName;
	@Schema(description = "relationship", required = true, example = "brother")
	private String relationship;
	@Schema(description = "email", required = true, example = "vaibhav@gmail.com")
	private String email;
	@Schema(description = "contact", required = true, example = "9876543210")
	private Long contact;
	@Schema(description = "address", required = true, example = "karve nagar, Pune")
	private String address;

}
