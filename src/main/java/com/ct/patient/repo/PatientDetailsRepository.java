package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.PatientDetails;

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {

//	PatientDetails findByuserId(Long userId);
}