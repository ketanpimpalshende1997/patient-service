package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer> {

	public Drug findBydrugId(Integer drugId);

	public Drug findBydrugName(String drugName);
}
