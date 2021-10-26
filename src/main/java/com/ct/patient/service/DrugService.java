package com.ct.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.entity.DrugMaster;
import com.ct.patient.repo.DrugMasterRepository;

@Service
public class DrugService {

	@Autowired
	private DrugMasterRepository repository;

	public List<DrugMaster> getAllDrugs() {
		return repository.findAll();
	}

	public DrugMaster getByDrugId(Integer drugId) {
		return repository.findBydrugId(drugId);
	}

	public DrugMaster getWithDrugName(String name) {
		return repository.findBydrugName(name);
	}

}
