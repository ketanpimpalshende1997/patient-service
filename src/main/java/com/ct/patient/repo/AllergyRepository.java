package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.request.Allergy;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long>
{

}
