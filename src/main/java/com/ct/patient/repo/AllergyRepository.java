package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.Allergy;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {

	@Modifying
	@Query("DELETE FROM Allergy a WHERE a.id=:pid")
	void deleteById(Long pid);
	
	public List<Allergy> findByPatientId(Long id);
	

}
