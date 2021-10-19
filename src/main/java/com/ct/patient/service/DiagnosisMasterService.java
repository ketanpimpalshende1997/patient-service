package com.ct.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.entity.DiagnosisMaster;
import com.ct.patient.repo.DiagnosisMasterRepository;

@Service
public class DiagnosisMasterService {

	@Autowired
	private DiagnosisMasterRepository repo;

	public List<DiagnosisMaster> getAllDiagnosis() {
		return repo.findAll();
	}

	public DiagnosisMaster getWithDiagnosisCode(String code) {
		return repo.findBydiagnosisCode(code);
	}

	public DiagnosisMaster getWithDiagnosisName(String name) {
		return repo.findBydiagnosisName(name);
	}
}
