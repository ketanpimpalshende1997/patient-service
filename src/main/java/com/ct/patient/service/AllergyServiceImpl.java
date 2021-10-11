package com.ct.patient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.repo.MasterAllergyRepository;
import com.ct.patient.request.MasterAllergy;

@Service
public class AllergyServiceImpl implements AllergyService {

	@Autowired
	MasterAllergyRepository alleryRepo;

	@Override
	public MasterAllergy fetchAllergyDetails(String allergyId) {
		if (alleryRepo.findById(allergyId).isPresent())
			return alleryRepo.findById(allergyId).get();
		else
			return null;

	}

	@Override
	public List<String> fetchAllergyIds() {
		List<String> allergyIds = new ArrayList<>();
		List<MasterAllergy> list = alleryRepo.findAll();

		for (MasterAllergy ma : list) {
			allergyIds.add(ma.getAllergyId());
		}

		return allergyIds;

	}

	@Override
	public List<String> fetchAllergyTypes() {
		List<String> allergyTypes = new ArrayList<>();
		List<MasterAllergy> list = alleryRepo.findAll();

		for (MasterAllergy ma : list) {
			allergyTypes.add(ma.getAllergyType());
		}
		return allergyTypes;
	}

}
