package com.ct.patient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ct.patient.request.Patient;
import com.ct.patient.response.ErrorMsg;
import com.ct.patient.response.ResponseDTO;
import com.ct.patient.service.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin("*")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/getAll")
	public List<Patient> fetchAllPatients() {
		return patientService.fetchAllPatients();
	}

	@Operation(summary = "Save Patient Details", description = "This API is used to save basic details of a patient.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Patient details saved successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PutMapping("/patient")
	public ResponseEntity<Object> saveEmergencyContactDetails(@Valid @RequestBody Patient patientRequest) {

		return patientService.savePatientDetails(patientRequest);
	}

	@Operation(summary = "fetch particular patient Details", description = "This API is used to fetch particular patient details of a patient.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Patient details saved successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/patient/{id}")
	public Patient fetchPatientDetails(@PathVariable("id") Long patientId) {
		return patientService.fetchPatientDetails(patientId);
	}

//	
//	@GetMapping("/patients")
//	public List<Patient> all() {
//		return patientService.getAllPatients();
//	}
//
//	@Operation(summary = "Save Patient Details", description = "This API is used to save basic details of a patient.")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "Patient details saved successfully", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class)) }),
//			@ApiResponse(responseCode = "400", description = "Validation error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
//			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })
//
//	@PostMapping("/patients")
//	public ResponseDTO newPatient(@RequestBody Patient patient) {
//		return patientService.save(patient);
//	}
//
//	@Operation(summary = "Fetch Patient Details", description = "This API is used to Fetch basic details of a patient.")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "Patient details Fetched successfully", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class)) }),
//			@ApiResponse(responseCode = "400", description = "Validation error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
//			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })
//
//	@GetMapping("/patients/{id}")
//	public Patient one(@Parameter(description = "patient Id", example = "1234") @PathVariable long id) {
//		return patientService.getPatient(id);
//	}
//
//	@Operation(summary = "Update Patient Details", description = "This API is used to Update basic details of a patient.")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "Patient details Updated successfully", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class)) }),
//			@ApiResponse(responseCode = "400", description = "Validation error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
//			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })
//
//	@PutMapping("/patients/{id}")
//	public Patient replacePatient(@PathVariable long id, @RequestBody Patient patient) {
//		return patientService.updatePatient(id, patient);
//	}
//
//	@Operation(summary = "delete Patient Details", description = "This API is used to delete details of a patient.")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "Patient details deleted successfully", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class)) }),
//			@ApiResponse(responseCode = "400", description = "Validation error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
//			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })
//
//	@DeleteMapping("/patients/{id}")
//	public void deletePatient(@PathVariable long id) {
//		patientService.disablePatient(id);
//	}

}
