package com.ct.patient.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.patient.dto.MessageResponseDto;
import com.ct.patient.entity.MasterAllergy;
import com.ct.patient.entity.PatientDetails;
import com.ct.patient.repo.AllergyMasterRepository;
import com.ct.patient.response.ErrorMsg;
import com.ct.patient.service.IPatientDetailsService;
import com.ct.patient.utility.StatusMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/patient")
@CrossOrigin(value = "*")
public class PatientController {
	private Logger log = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private IPatientDetailsService patientDetailsService;

	@Operation(summary = "Save Patient Details", description = "This API is used to save details of a patient.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Patient details saved successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/save") // working
	public ResponseEntity<MessageResponseDto> savePatientDetails(@RequestBody PatientDetails patientDetails) {
		ResponseEntity<MessageResponseDto> resp = null;
		log.info("save patient details");
		try {

			patientDetailsService.addPatientDetails(patientDetails);
			log.info("sending the response");
			resp = new ResponseEntity<>(new MessageResponseDto(StatusMessage.USER_DETAILS_SAVED.getMessage()),
					HttpStatus.OK);
		} catch (Exception e) {
			log.error("save api catch block");
			e.printStackTrace();

			resp = new ResponseEntity<>(new MessageResponseDto(StatusMessage.SERVER_ERROR.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@Operation(summary = "Update Patient Details", description = "This API is used to update details of a patient.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Patient details updated successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PutMapping("/modify/{id}")
	public ResponseEntity<MessageResponseDto> updatePatientDetails(@PathVariable Long id,
			@RequestBody PatientDetails patientDetail) {
		try {
			log.info("Controller try  Updating Patinet Details");
			patientDetailsService.getUserById(id);

			patientDetailsService.updatePatientDetail(patientDetail);
			log.info("Controller try  Updating Patinet Details Sending Response");

			return new ResponseEntity<>(new MessageResponseDto(StatusMessage.USER_DETAILS_UPDATED.getMessage()),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageResponseDto(StatusMessage.SERVER_ERROR.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "fetch all Patients", description = "This API is used to fetch all patients.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "fetched all patients successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getAll") // working
	public List<PatientDetails> getAllPatientDetails() {
		return patientDetailsService.getAllUser();
	}

	@Operation(summary = "fetch particular Patient by id", description = "This API is used to fetch patient details by id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found patient details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PatientDetails.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getById/{id}") // working
	public PatientDetails getPatientDetailsById(@PathVariable("id") Long id) {
		return patientDetailsService.getUserById(id);
	}

//	@Operation(summary = "fetch patient details details by user id", description = "This API is used to fetch patient details by user id")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "found patient details successfully", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = PatientDetails.class)) }),
//			@ApiResponse(responseCode = "400", description = "Validation error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
//			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
//					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })
//
//	@GetMapping("/getByUserId/{id}")
//	public PatientDetails getUserDetailsById(@PathVariable("id") Long id) {
//		return patientDetailsService.getByUserId(id);
//	}

}
