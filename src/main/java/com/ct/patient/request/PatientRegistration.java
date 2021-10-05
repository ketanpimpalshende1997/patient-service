//package com.ct.patient.request;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//import io.swagger.v3.oas.annotations.media.Schema;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@Entity
//@Table(name = "patient_details")
//public class PatientRegistration {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long patientId;
//
//	@Schema(description = "Title", required = true, example = "Mr.")
//	private String title;
//
//	@Schema(description = "First name", required = true, example = "Yogendra")
//	private String firstName;
//
//	@Schema(description = "Last name", required = true, example = "Yadav")
//	private String lastName;
//
//	@Schema(description = "email", required = true, example = "Yogendra.yadav@gmail.com")
//	private String email;
//
//	@Schema(description = "Birth date", required = true, example = "02-03-1997")
//	private java.util.Date birthDate;
//
//	@Schema(description = "Contact Number", required = true, example = "9876543210")
//	private long contactNo;
//
//	@Schema(description = "race", required = true, example = "Yogendra")
//	private String race;
//
//	@Schema(description = "ethnicity", required = true, example = "Yogendra")
//	private String ethnicity;
//
//	@Schema(description = "Languages", required = true, example = "English, Hindi")
//	private String languages;
//
//	@Schema(description = "address", required = true, example = "Mumbai")
//	private String address;
//
//	@Schema(description = "Username", required = true, example = "Yogendra.Yadav")
//	private String username;
//
//	@Schema(description = "password", required = true, example = "Yogendra@123")
//	private String password;
//
//}
