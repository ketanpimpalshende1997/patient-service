package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.MasterDrug;

@Repository
public interface DrugMasterRepository extends JpaRepository<MasterDrug, Integer> {

	public MasterDrug findBydrugId(Integer drugId);

	public MasterDrug findBydrugName(String drugName);
}
