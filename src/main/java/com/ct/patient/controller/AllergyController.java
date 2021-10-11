package com.ct.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ct.patient.request.MasterAllergy;
import com.ct.patient.response.ErrorMsg;
import com.ct.patient.response.ResponseDTO;
import com.ct.patient.service.AllergyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin("*")
public class AllergyController {

	@Autowired
	AllergyService allergyService;

	@Operation(summary = "fetch allergy Details", description = "This API is used to fetch allergy details of a patient.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Allergy details fetched successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/allergy/{id}")
	public MasterAllergy fetchAllergyDetails(@PathVariable("id") String allergyId) {
		return allergyService.fetchAllergyDetails(allergyId);
	}

	@GetMapping("/allergy/ids")
	public List<String> fetchAllergyIds() {
		return allergyService.fetchAllergyIds();
	}
	
	
	
	@GetMapping("/allergy/types")
	public List<String> fetchAllergyTypes() {
		return allergyService.fetchAllergyTypes();
	}
	
	

	
	
}
