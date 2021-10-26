package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.DrugMaster;

@Repository
public interface DrugMasterRepository extends JpaRepository<DrugMaster, Integer> {

	public DrugMaster findBydrugId(Integer drugId);

	public DrugMaster findBydrugName(String drugName);
}
