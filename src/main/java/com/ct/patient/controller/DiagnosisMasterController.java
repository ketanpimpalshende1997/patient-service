package com.ct.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.patient.dto.Diagnosisdto;
import com.ct.patient.dto.MessageResponseDto;
import com.ct.patient.entity.Diagnosis;
import com.ct.patient.entity.DiagnosisMaster;
import com.ct.patient.response.ErrorMsg;
import com.ct.patient.response.Response;
import com.ct.patient.service.DiagnosisMasterService;
import com.ct.patient.service.DiagnosisService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/diagnosis")
@CrossOrigin(value = "*")
public class DiagnosisMasterController {

	@Autowired
	private DiagnosisMasterService service;

	@Autowired
	private DiagnosisService diagnosisService;

	@Operation(summary = "fetch all diagnosis master data", description = "This API is used to fetch all diagnosis master data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found diagnosis data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/diagnosiss")
	public List<DiagnosisMaster> getAll() {
		return service.getAllDiagnosis();
	}

	@Operation(summary = "save diagnosis master data", description = "This API is used to save diagnosis master data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Diagnosis data saved successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/saveDiagnosis/{id}")
	public Response saveDiagnosis(@RequestBody Diagnosisdto diagnosis, @PathVariable("id") Integer appointmentId) {
		boolean isSved = diagnosisService.saveDiagnoses(diagnosis, appointmentId);
		if (isSved)
			return new Response("saved Successfully...");
		else
			return new Response("error occured while saving ..");
	}

	@Operation(summary = "fetch diagnosis master data", description = "This API is used to fetch diagnosis master data by diagnosis code from diagnosis master data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found Diagnosis data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByDiagnosisCode/{code}")
	public DiagnosisMaster getByDiagnosisCode(@PathVariable("code") String diagnosisCode) {
		return service.getWithDiagnosisCode(diagnosisCode);
	}

	@Operation(summary = "fetch diagnosis master data", description = "This API is used to fetch diagnosis master data by diagnosis name from diagnosis master data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found Diagnosis data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByDiagnosisName/{name}")
	public DiagnosisMaster getByDiagnosisName(@PathVariable("name") String diagnosisName) {
		return service.getWithDiagnosisName(diagnosisName);
	}

	@Operation(summary = "fetch diagnosis master data by appointment id", description = "This API is used to fetch diagnosis master data by appointment id from diagnosis master data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found Diagnosis data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByAppointmentId/{id}")
	public List<Diagnosis> getDiagnosisByAppointmentId(@PathVariable("id") Long appointmentId) {
		return diagnosisService.findWithAppointmentId(appointmentId);
	}
	
	@Operation(summary = "delete diagnosis master data", description = "This API is used to fetch diagnosis master data by diagnosis code from diagnosis master data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "deleted diagnosis data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })


	@DeleteMapping("/deleteByDiagnosisCode/{id}")
	public Response removeDiagnosisFromAppointment(@PathVariable("id") Long diagnosisCode) {
		boolean isDeleted = diagnosisService.deleteByDignosisCode(diagnosisCode);
		if (isDeleted)
			return new Response("Diagnosis is deleted Successfully...");
		else
			return new Response("error occured while deleting...");
	}
}
