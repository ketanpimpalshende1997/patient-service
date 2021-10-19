package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.DiagnosisMaster;

@Repository
public interface DiagnosisMasterRepository extends JpaRepository<DiagnosisMaster, String> {

	public DiagnosisMaster findBydiagnosisCode(String diagnosisCode);

	public DiagnosisMaster findBydiagnosisName(String diagnosisName);
}
