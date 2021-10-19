package com.ct.patient.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.entity.Allergy;
import com.ct.patient.entity.PatientDetails;
import com.ct.patient.exception.PatientNotFoundException;
import com.ct.patient.repo.AllergyRepository;
import com.ct.patient.repo.PatientDetailsRepository;

@Service
public class PatientDetailsImpl implements IPatientDetailsService {

	private Logger log = LoggerFactory.getLogger(PatientDetailsImpl.class);

	@Autowired
	private PatientDetailsRepository patientDetailsRepo;
	@Autowired
	private AllergyRepository allergyRepository;

	@Override
	public Long addPatientDetails(PatientDetails patientDetails) {
		PatientDetails pd = patientDetailsRepo.save(patientDetails);
		List<Allergy> allergies = patientDetails.getAllergies();
		allergies.forEach(al -> al.setPatientDetails(pd));
		allergyRepository.saveAll(allergies);
		return pd.getId();

	}

	@Override
	public Long updatePatientDetail(PatientDetails patientDetails) {
		log.info("Service---------Updating patient Details");
		return patientDetailsRepo.save(patientDetails).getId();
	}

	@Override
	public List<PatientDetails> getAllUser() {
		return patientDetailsRepo.findAll();
	}

	@Override
	public PatientDetails getUserById(Long id) {
		Optional<PatientDetails> patientDetails = patientDetailsRepo.findById(id);

		if (patientDetails.isPresent()) {
			return patientDetails.get();
		} else {
			throw new PatientNotFoundException(id);
		}
	}

	@Override
	public PatientDetails getByUserId(Long userId) {
		return patientDetailsRepo.findByuserId(userId);
	}

}
