package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.DiagnosisMaster;

@Repository
public interface DiagnosisMasterRepository extends JpaRepository<DiagnosisMaster, String> {

	public DiagnosisMaster findBydiagnosisCode(String diagnosisCode);

	@Query("FROM DiagnosisMaster dm WHERE dm.isDepricated = false")
	List<DiagnosisMaster> findAllActiveDiagnosis();

}
