package com.ct.patient.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.dto.Diagnosisdto;
import com.ct.patient.entity.Diagnosis;
import com.ct.patient.repo.DiagnosisRepository;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	@Autowired
	private DiagnosisRepository repository;

	@Override
	public boolean saveDiagnoses(Diagnosisdto diagnoses, long appointmentId) {
		Diagnosis diagnose = new Diagnosis();
		diagnose.setApointmentId(appointmentId);
		diagnose.setDiagnosisCode(diagnoses.getDiagnosisCode());
		diagnose.setDiagnosisName(diagnoses.getDiagnosisName());
		diagnose.setDiscription(diagnoses.getDiscription());
		diagnose.setCreatedAt(new Date());
		diagnose.setUpdatedAt(new Date());
		Diagnosis d = repository.save(diagnose);
		return d != null;
	}

	@Override
	public List<Diagnosis> findWithAppointmentId(Long id) {
		return repository.findByapointmentId(id);
	}

	@Override
	public boolean deleteByDignosisCode(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
