package com.ct.patient.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patient_details")
public class PatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;

	@Schema(description = "title", example = "Mr.")
	@Column(name = "title")
	private String title;

	@Schema(description = "first name",  example = "Ketan")
	@Column(name = "first_name")
	private String firstName;

	@Schema(description = "last name",  example = "Pimpalshende")
	@Column(name = "last_name")
	private String lastName;

	@Schema(description = "date of birth",  example = "13/3/1997")
	@Column(name = "birth_date")
	private LocalDate dob;

	@Schema(description = "age",  example = "25")
	@Column(name = "age")
	private Integer age;

	@Schema(description = "gender",  example = "Male")
	@Column(name = "gender")
	private String gender;

	@Schema(description = "race",  example = "xyz")
	@Column(name = "race")
	private String race;

	@Schema(description = "ethnicity",  example = "xyz")
	@Column(name = "ethnicity")
	private String ethnicity;

	@Schema(description = "language known",  example = "Marathi, Hindi")
	@Column(name = "languages")
	private String langKnown;

	@Schema(description = "email",  example = "ketanp@gmail.com")
	@Column(name = "email")
	private String email;

	@Schema(description = "contact no",  example = "98765432190")
	@Column(name = "contact_no")
	private String contactNo;

	@Schema(description = "address",  example = "Ganesh nagar, Pune")
	@Column(name = "address")
	private String address;

	@Schema(description = "city",  example = "pune")
	@Column(name = "city")
	private String city;

	@Schema(description = "pin code",  example = "442401")
	@Column(name = "pincode")
	private String pincode;

	@Schema(description = "state",  example = "Maharashtra")
	@Column(name = "state")
	private String state;

	@Schema(description = "country",  example = "India")
	@Column(name = "country")
	private String country;

	@Schema(description = "emergency contact title",  example = "Mr.")
	@Column(name = "emgr_title")
	private String emgrTitle;

	@Schema(description = "emergency contact first name",  example = "Vaibhav")
	@Column(name = "emgr_fname")
	private String emgrFname;

	@Schema(description = "emergency contact last name",  example = "Pimpalshende")
	@Column(name = "emgr_lname")
	private String emgrLname;

	@Schema(description = "emergency contact email",  example = "vaibhav@gmail.com")
	@Column(name = "emgr_email")
	private String emgrEmail;

	@Schema(description = "emergency contact contact no",  example = "9878987890")
	@Column(name = "emgr_contact_no")
	private String emgrContactNo;

	@Schema(description = "emergency contact relation",  example = "Brother")
	@Column(name = "emgr_relation")
	private String emgrRelation;

	@Schema(description = "emergency contact address",  example = "hanuman nagar, Pune")
	@Column(name = "emgr_address")
	private String emgrAddress;

	@Schema(description = "emergency contact city",  example = "Pune")
	@Column(name = "emgr_city")
	private String emgrCity;

	@Schema(description = "emergency contact pin code",  example = "454323")
	@Column(name = "emgr_pincode")
	private String emgrPincode;

	@Schema(description = "emergency contact state",  example = "Maharashtra")
	@Column(name = "emgr_state")
	private String emgrState;

	@Schema(description = "emergency contact country",  example = "India")
	@Column(name = "emgr_country")
	private String emgrCountry;


//	@OneToMany(mappedBy = "patientDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	// @JoinColumn(name = "pd_fk", referencedColumnName = "id")
//	private List<Allergy> allergies;

}
