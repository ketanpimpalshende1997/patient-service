package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.MasterAllergy;

@Repository
public interface AllergyMasterRepository extends JpaRepository<MasterAllergy, Integer> {

	List<MasterAllergy> findByAllergyCode(String allergyCode);

}
