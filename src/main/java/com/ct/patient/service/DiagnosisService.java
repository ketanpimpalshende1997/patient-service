package com.ct.patient.service;

import java.util.List;

import com.ct.patient.dto.Diagnosisdto;
import com.ct.patient.entity.Diagnosis;

public interface DiagnosisService {

	boolean saveDiagnoses(Diagnosisdto diagnoses);

	List<Diagnosis> findWithAppointmentId(Long id);

	boolean deleteByDignosisCode(Long id);
}
