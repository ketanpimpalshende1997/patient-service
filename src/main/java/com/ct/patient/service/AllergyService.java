package com.ct.patient.service;

import java.util.List;

import com.ct.patient.request.MasterAllergy;

public interface AllergyService {

	public MasterAllergy fetchAllergyDetails(String allergyId);

	public List<String> fetchAllergyIds();

	public List<String> fetchAllergyTypes();

}
