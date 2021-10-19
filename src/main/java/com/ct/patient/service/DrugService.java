package com.ct.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.entity.Drug;
import com.ct.patient.repo.DrugRepository;

@Service
public class DrugService {

	@Autowired
	private DrugRepository repository;

	public List<Drug> getAllDrugs() {
		return repository.findAll();
	}

	public Drug getByDrugId(Integer drugId) {
		return repository.findBydrugId(drugId);
	}

	public Drug getWithDrugName(String name) {
		return repository.findBydrugName(name);
	}

}
