package com.ct.patient.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.dto.VitalDto;
import com.ct.patient.entity.Vital;
import com.ct.patient.repo.VitalRepository;

@Service
public class VitalServiceImpl implements VitalService {
	@Autowired
	private VitalRepository repository;

	@Override
	public boolean save(VitalDto vitals) {
		if (null != vitals.getVitalId()) {
			vitals.setVitalId(vitals.getVitalId());
		}

		Vital vital=new Vital();
		
		vital.setHeight(vitals.getHeight());
		vital.setWeight(vitals.getWeight());
		vital.setBloodPressure(vitals.getBloodPressure());
		vital.setBodyTemperature(vitals.getBodyTemperature());
		vital.setRespirationRate(vitals.getRespirationRate());
		vital.setAppointmentId(vitals.getAppointmentId());
		vital.setCreatedAt(new Date());
		vital.setUpdatedAt(new Date());

		Vital v = repository.save(vital);
		return v != null;
	}

	@Override
	public Vital findWithAppointmentId(Integer appointmentId) {
		return repository.findByAppointmentId(appointmentId);
	}

}
