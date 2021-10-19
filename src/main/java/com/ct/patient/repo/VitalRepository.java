package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.Vital;

@Repository
public interface VitalRepository extends JpaRepository<Vital, Long> {

	Vital findByAppointmentId(Integer id);
}
