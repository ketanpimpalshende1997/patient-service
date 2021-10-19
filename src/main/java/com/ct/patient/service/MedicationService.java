package com.ct.patient.service;

import java.util.List;

import com.ct.patient.dto.Medicinedto;
import com.ct.patient.entity.Medication;

public interface MedicationService {

	public boolean saveDrug(Medicinedto medicines);

	public List<Medication> findWithAppointmentId(Integer id);

	public boolean deleteMedication(Long medicationId);
}
