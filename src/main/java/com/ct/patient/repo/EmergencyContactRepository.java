package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.request.EmergencyContactRequest;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContactRequest, Long> {

}
