package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

	List<Drug> findByAppointmentId(Integer appointmentId);
}
