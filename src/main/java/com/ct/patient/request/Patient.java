package com.ct.patient.request;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name = "patient_details")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "patientId", required = true, example = "12")
	private long patientId;

	@Schema(description = "Title", required = true, example = "Mr.")
	private String title;

	@Schema(description = "First name", required = true, example = "Yogendra")
	private String firstName;

	@Schema(description = "Last name", required = true, example = "Yadav")
	private String lastName;

	@Schema(description = "Birth date", required = true, example = "02-03-1997")
//	@DateTimeFormat(pattern="dd/MM/yyyy")
	private java.util.Date birthDate;

	@Schema(description = "age", required = true, example = "24")
	private String age;

	@Schema(description = "gender", required = true, example = "Male")
	private String gender;

	@Schema(description = "race", required = true, example = "Yogendra")
	private String race;

	@Schema(description = "ethnicity", required = true, example = "Yogendra")
	private String ethnicity;

	@Schema(description = "Languages", required = true, example = "English, Hindi")
	private String languages;

	@Schema(description = "email", required = true, example = "Yogendra.yadav@gmail.com")
	private String email;

	@Schema(description = "Contact Number", example = "9876543210")
	private Long contactNo;

	@Schema(description = "address", required = true, example = "Mumbai")
	private String address;

	@Schema(description = "Emergency Contact Details", required = true)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emergency_contact_id")
//	@NotNull(message = "Emergency Contact Details are mandatory.")
	private EmergencyContactRequest emergencyContact;

	@Schema(description = "Allergies")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Allergy> allergies;

}