package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.MasterDrug;

@Repository
public interface DrugMasterRepository extends JpaRepository<MasterDrug, String> {

	public MasterDrug findBydrugId(Integer drugId);

	public MasterDrug findBydrugName(String drugName);
	
	@Query("FROM MasterDrug order by drugId")
	List<MasterDrug> findAll();

	
}
