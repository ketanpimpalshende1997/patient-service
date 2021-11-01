package com.ct.patient.repo;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.MasterDiagnosis;

@Repository
public interface DiagnosisMasterRepository extends JpaRepository<MasterDiagnosis, String> {

	public MasterDiagnosis findBydiagnosisCode(String diagnosisCode);

	@Query("FROM MasterDiagnosis dm WHERE dm.isDepricated = false  order by diagnosisCode")
	List<MasterDiagnosis> findAllActiveDiagnosis();

	@Query("FROM MasterDiagnosis order by diagnosisCode")
	List<MasterDiagnosis> findAll();
}
