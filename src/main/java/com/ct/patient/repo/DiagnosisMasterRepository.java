package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.MasterDiagnosis;

@Repository
public interface DiagnosisMasterRepository extends JpaRepository<MasterDiagnosis, String> {

	public MasterDiagnosis findBydiagnosisCode(String diagnosisCode);

	@Query("FROM MasterDiagnosis dm WHERE dm.isDepricated = false")
	List<MasterDiagnosis> findAllActiveDiagnosis();

}
