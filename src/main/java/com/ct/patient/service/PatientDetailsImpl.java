package com.ct.patient.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.entity.PatientDetails;
import com.ct.patient.exception.PatientNotFoundException;
import com.ct.patient.repo.PatientDetailsRepository;

@Service
public class PatientDetailsImpl implements IPatientDetailsService {

	private Logger log = LoggerFactory.getLogger(PatientDetailsImpl.class);

	@Autowired
	private PatientDetailsRepository patientDetailsRepo;

	@Override
	public Long addPatientDetails(PatientDetails patientDetails) {
		PatientDetails pd = patientDetailsRepo.save(patientDetails);

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
		PatientDetails patientDetails = patientDetailsRepo.findById(id).get();

		if (null != patientDetails) {
			if (null == patientDetails.getAge()) {
				patientDetails.setAge(0);
			}
			return patientDetails;

		} else {
			throw new PatientNotFoundException(id);
		}
	}

}
