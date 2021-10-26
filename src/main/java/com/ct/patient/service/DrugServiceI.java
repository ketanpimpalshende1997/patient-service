package com.ct.patient.service;

import java.util.List;

import com.ct.patient.dto.DrugMasterDto;
import com.ct.patient.dto.DrugDto;
import com.ct.patient.entity.Drug;

public interface DrugServiceI {

	public boolean saveDrug(DrugDto medicines);

	public List<Drug> findWithAppointmentId(Integer id);

	public boolean deleteMedication(Long medicationId);

	public boolean saveDrugMaster(DrugMasterDto drugDto);
}
