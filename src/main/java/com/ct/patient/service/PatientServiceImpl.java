package com.ct.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ct.patient.repo.EmergencyContactRepository;
import com.ct.patient.repo.PatientRepository;
import com.ct.patient.request.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	EmergencyContactRepository emergencyContactRepo;

	@Override
	public ResponseEntity<Object> savePatientDetails(Patient patientRequest) {

		Patient savedPatient = patientRepo.save(patientRequest);

		if (patientRepo.findById(savedPatient.getPatientId()).isPresent())
			return ResponseEntity.ok().body("Patient details saved successfully.");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to save patient details.");

	}

	@Override
	public Patient fetchPatientDetails(Long patientId) {

		if (patientRepo.findById(patientId).isPresent())
			return patientRepo.findById(patientId).get();
		else
			return null;

	}

	@Override
	public List<Patient> fetchAllPatients() {
		return patientRepo.findAll();

	}

//	@Override
//	public ResponseDTO save(PatientRegistration patient) {
//		patientRepo.save(patient);
//
//		ResponseDTO response = new ResponseDTO();
//		response.setResponseCode(CodeConstants.SUCCESS);
//		response.setResponseMsg(CommonConstants.SUCCESS);
//		response.setTimeStamp(new Date().toString());
//		return response;
//	}
//
//	@Override
//	public List<Patient> getAllPatients() {
//		return patientRepository.findAll();
//	}
//
//	@Override
//	public PatientRegistration getPatient(long id) {
//		return patientRepo.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
//	}
//
//	@Override
//	public PatientRegistration updatePatient(long id, PatientRegistration patient) {
//		PatientRegistration dbPatient = patientRepo.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
//		dbPatient.setPatientId(id);
//		dbPatient.setFirstName(patient.getFirstName());
//		dbPatient.setLastName(patient.getLastName());
//		patientRegRepo.save(dbPatient);
//		return dbPatient;
//	}
//
//	@Override
//	public void disablePatient(long id) {
//		Patient dbPatient = this.getPatient(id);
//
//		//dbPatient.setDeleted(true);
//		//dbPatient.setActive(false);
//
//		patientRegRepo.save(dbPatient);
//
//	}
//	
//	@Override
//	public Patient getPatient(long id) {
//		return 		patientRegRepo.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
//	}

}
