package com.ct.patient.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.dto.Medicinedto;
import com.ct.patient.entity.Medication;
import com.ct.patient.repo.MedicationRepository;

@Service
public class MedicationServiceImpl implements MedicationService {

	@Autowired
	private MedicationRepository repository;

	@Override
	public boolean saveDrug(Medicinedto medicines) {
		Medication medicine = new Medication();
		medicine.setAppointmentId(medicines.getAppointmentId());
		medicine.setDrugName(medicines.getDrugName());
		medicine.setDrugForm(medicines.getDrugForm());
		medicine.setDiscription(medicines.getDiscription());
		medicine.setCreatedAt(new Date());
		medicine.setUpdatedAt(new Date());
		Medication medicin = repository.save(medicine);
		return medicin != null;
	}

	@Override
	public List<Medication> findWithAppointmentId(Integer id) {

		return repository.findByAppointmentId(id);
	}

	@Override
	public boolean deleteMedication(Long medicationId) {
		try {
			repository.deleteById(medicationId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
