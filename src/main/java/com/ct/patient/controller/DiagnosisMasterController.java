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

import com.ct.patient.dto.DiagnosisMasterDto;
import com.ct.patient.dto.Diagnosisdto;
import com.ct.patient.dto.MessageResponseDto;
import com.ct.patient.entity.Diagnosis;
import com.ct.patient.entity.DiagnosisMaster;
import com.ct.patient.response.ErrorMsg;
import com.ct.patient.response.Response;
import com.ct.patient.service.DiagnosisMasterServiceI;
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
	private DiagnosisMasterServiceI service;

	@Autowired
	private DiagnosisService diagnosisService;

	// ---------------------- MASTER -------------------------------

	@Operation(summary = "save diagnosis master data", description = "This API is used to save diagnosis  master data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Diagnosis data saved successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/master/save")
	public Response saveDiagnosisMasterData(@RequestBody DiagnosisMasterDto diagnosisMasterDto) {

		DiagnosisMaster diagnosisMaster = new DiagnosisMaster();
		diagnosisMaster.setDiagnosisCode(diagnosisMasterDto.getDiagnosisCode());
		diagnosisMaster.setDescription(diagnosisMasterDto.getDescription());

		if (diagnosisMasterDto.getIsDepricated().equalsIgnoreCase("yes")) {
			diagnosisMaster.setDepricated(true);
		} else {
			diagnosisMaster.setDepricated(false);
		}

		boolean isSaved = service.saveDiagnosisMasterData(diagnosisMaster);
		if (isSaved)
			return new Response("Diagnosis master data is saved Successfully...");
		else
			return new Response("error occured while saving...");

	}

	@Operation(summary = "fetch diagnosis master data by diagnosis code", description = "This API is used to fetch diagnosis master data by diagnosis code from diagnosis master data by diagnosis code")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found Diagnosis data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByDiagnosisCode/{diagnosisCode}")
	public DiagnosisMaster getByDiagnosisCode(@PathVariable("diagnosisCode") String diagnosisCode) {
		return service.getWithDiagnosisCode(diagnosisCode);
	}

	@Operation(summary = "fetch all active diagnosis master data", description = "This API is used to fetch all active diagnosis master data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found diagnosis data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/master/active/diagnosis")
	public List<DiagnosisMasterDto> getAllActiveDiagnosis() {
		return service.getAllActiveDiagnosis();
	}

	// ------------------------- SIMPLE ---------------------------------

	@Operation(summary = "fetch all diagnosis master data", description = "This API is used to fetch all diagnosis master data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found diagnosis data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/allDiagnosis")
	public List<DiagnosisMasterDto> getAll() {
		return service.getAllDiagnosis();
	}

	@Operation(summary = "save diagnosis with appointment id", description = "This API is used to save diagnosis with appointment id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Diagnosis data saved successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/saveDiagnosis")
	public Response saveDiagnosis(@RequestBody Diagnosisdto diagnosis) {
		boolean isSved = diagnosisService.saveDiagnoses(diagnosis);
		if (isSved)
			return new Response("saved Successfully...");
		else
			return new Response("error occured while saving ..");
	}

	@Operation(summary = "delete diagnosis data by appointment id", description = "This API is used to fetch diagnosis master data by diagnosis code from diagnosis data by appointment id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "deleted diagnosis data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@DeleteMapping("/deleteByDiagnosisCode/{id}")
	public Response removeDiagnosisFromAppointment(@PathVariable("id") Long id) {
		boolean isDeleted = diagnosisService.deleteByDignosisCode(id);
		if (isDeleted)
			return new Response("Diagnosis is deleted Successfully...");
		else
			return new Response("error occured while deleting...");
	}

	@Operation(summary = "fetch diagnosis data by appointment id", description = "This API is used to fetch diagnosis master data by appointment id from diagnosis master data")
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

}
