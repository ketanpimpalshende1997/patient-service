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

import com.ct.patient.dto.Medicinedto;
import com.ct.patient.entity.Drug;
import com.ct.patient.entity.Medication;
import com.ct.patient.exception.MedicationNotFound;
import com.ct.patient.response.ErrorMsg;
import com.ct.patient.response.Response;
import com.ct.patient.service.DrugService;
import com.ct.patient.service.MedicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/drug")
public class DrugController {

	@Autowired
	private DrugService service;

	@Autowired
	private MedicationService medService;

	@Operation(summary = "fetch drug list", description = "This API is used to fetch drug data.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found drug data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/drugs")
	public List<Drug> getAllDrugs() {
		return service.getAllDrugs();
	}

	@Operation(summary = "fetch drug details", description = "This API is used to fetch drug details by drugId")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found drug data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Drug.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/drugs/{id}")
	public Drug getById(@PathVariable("id") Integer id) {
		return service.getByDrugId(id);
	}

	@Operation(summary = "save drug details", description = "This API is used to save drug details.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "saved drug data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Drug.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/saveDrugs")
	public Response saveMedications(@RequestBody Medicinedto medDto) {
		boolean isSaved = medService.saveDrug(medDto);
		if (isSaved)
			return new Response("saved successfully..");
		else
			return new Response("not saved");
	}

	@Operation(summary = "fetch drug details by drug name", description = "This API is used to fetch drug details by drug name.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found drug data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Drug.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByDrugName/{name}")
	public Drug getByDrugname(@PathVariable("name") String drugName) {
		return service.getWithDrugName(drugName);
	}

	@Operation(summary = "fetch medication details by appointment id", description = "This API is used to fetch medication details by appointment id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found medication data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Medication.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByAppointmentId/{id}")
	public List<Medication> findMedicationByAppointment(@PathVariable("id") Integer id) {
		List<Medication> medList = medService.findWithAppointmentId(id);
		if (!medList.isEmpty())
			return medList;
		else
			throw new MedicationNotFound("not found with appointment");
	}

	@Operation(summary = "delete medication details by medication id", description = "This API is used to delete medication details by medication id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Deleted medication data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@DeleteMapping("/deleteMedication/{medicationId}")
	public Response deleteMedication(@PathVariable("medicationId") Long medicationId) {
		boolean isDeleted = medService.deleteMedication(medicationId);
		if (isDeleted) {
			return new Response("Medication Deleted successfully");
		} else {
			return new Response("Error in deleting medication");
		}
	}
}
