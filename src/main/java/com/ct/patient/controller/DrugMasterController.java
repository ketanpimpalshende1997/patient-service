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

import com.ct.patient.dto.DrugMasterDto;
import com.ct.patient.dto.DrugDto;
import com.ct.patient.entity.MasterDrug;
import com.ct.patient.entity.Drug;
import com.ct.patient.exception.MedicationNotFound;
import com.ct.patient.response.ErrorMsg;
import com.ct.patient.response.Response;
import com.ct.patient.service.DrugService;
import com.ct.patient.service.DrugServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/drug")
public class DrugMasterController {

	@Autowired
	private DrugService service;

	@Autowired
	private DrugServiceI drugService;

	// ----------------------------- master -----------------------------

	@Operation(summary = "fetch All Master drugs", description = "This API is used to fetch drug data.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found drug data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("master/drugs")
	public List<MasterDrug> getAllDrugs() {
		return service.getAllDrugs();
	}

	@Operation(summary = "fetch particular master drug details", description = "This API is used to fetch particular master drug details by drugId")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found drug data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MasterDrug.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("master/drug/{id}")
	public MasterDrug getById(@PathVariable("id") Integer id) {
		return service.getByDrugId(id);
	}

	@Operation(summary = "save drug master data", description = "This API is used to save drug master data.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "saved drug data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MasterDrug.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/master/save")
	public Response saveMedications(@RequestBody DrugMasterDto drugDto) {
		boolean isSaved = drugService.saveDrugMaster(drugDto);
		if (isSaved)
			return new Response("saved successfully..");
		else
			return new Response("not saved");
	}

	@DeleteMapping("/master/delete/{drugId}")
	public Response saveMedications(@PathVariable String drugId) {
		drugService.deleteDrug(drugId);

		return new Response("deleted successfully..");

	}

	// ----------------- simple ----------------------------------

	@Operation(summary = "save drug details", description = "This API is used to save drug details.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "saved drug data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MasterDrug.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/saveDrugs")
	public Response saveMedications(@RequestBody DrugDto medDto) {
		boolean isSaved = drugService.saveDrug(medDto);
		if (isSaved)
			return new Response("saved successfully..");
		else
			return new Response("not saved");
	}

	@Operation(summary = "fetch medication details by appointment id", description = "This API is used to fetch medication details by appointment id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found medication data successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Drug.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByAppointmentId/{id}")
	public List<Drug> findMedicationByAppointment(@PathVariable("id") Integer id) {
		List<Drug> medList = drugService.findWithAppointmentId(id);
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

	@DeleteMapping("/deleteMedication/{id}")
	public Response deleteMedication(@PathVariable("id") Long id) {
		boolean isDeleted = drugService.deleteMedication(id);
		if (isDeleted) {
			return new Response("Medication Deleted successfully");
		} else {
			return new Response("Error in deleting medication");
		}
	}
}
