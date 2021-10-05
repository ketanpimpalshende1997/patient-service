package com.ct.patient.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ct.patient.request.Patient;

public interface PatientService {

	public ResponseEntity<Object> savePatientDetails(Patient request);

	public Patient fetchPatientDetails(Long patientId);
	
	public List<Patient> fetchAllPatients();

//	List<PatientRegistration> getAllPatients();
//
//	ResponseDTO save(PatientRegistration patient);
//
//	PatientRegistration getPatient(long id);
//
//	PatientRegistration updatePatient(long id, PatientRegistration patient);
//
//	void disablePatient(long id);

}
