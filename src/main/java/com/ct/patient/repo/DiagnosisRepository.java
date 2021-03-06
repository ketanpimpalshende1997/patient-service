package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.Diagnosis;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

	List<Diagnosis> findByAppointmentId(Long appointmentId);
}
