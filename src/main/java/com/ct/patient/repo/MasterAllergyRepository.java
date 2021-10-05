package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ct.patient.request.MasterAllergy;

@Repository
public interface MasterAllergyRepository extends JpaRepository<MasterAllergy, String> {
//	@Query("select ma.allergy_id from master_allergy ma")
//	public List<String> findAllergyIds();

}
