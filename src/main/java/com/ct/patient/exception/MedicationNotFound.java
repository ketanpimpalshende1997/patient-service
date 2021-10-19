package com.ct.patient.exception;

public class MedicationNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MedicationNotFound(String s) {
		super(s);
	}
}
