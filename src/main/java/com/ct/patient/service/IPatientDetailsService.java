package com.ct.patient.service;

import java.util.List;

import com.ct.patient.entity.PatientDetails;

public interface IPatientDetailsService {

	public Long addPatientDetails(PatientDetails patientDetails);

	public List<PatientDetails> getAllUser();

	public PatientDetails getUserById(Long id);

	public PatientDetails getByUserId(Long userId);

	Long updatePatientDetail(PatientDetails patientDetails);

}
