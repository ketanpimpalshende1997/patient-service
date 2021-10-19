package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.AllergyMaster;

@Repository
public interface AllergyMasterRepository extends JpaRepository<AllergyMaster, Integer> {

	List<AllergyMaster> findByAllergyCode(String allergyCode);

}
