package com.ct.patient.service;

import com.ct.patient.dto.VitalDto;
import com.ct.patient.entity.Vital;

public interface VitalService {

	public boolean save(VitalDto vital);
	public Vital findWithAppointmentId(Integer appointmentId);
}
