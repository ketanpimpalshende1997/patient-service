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

import com.ct.patient.dto.MessageResponseDto;
import com.ct.patient.entity.Allergy;
import com.ct.patient.entity.MasterAllergy;
import com.ct.patient.repo.AllergyMasterRepository;
import com.ct.patient.repo.AllergyRepository;
import com.ct.patient.response.ErrorMsg;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/allergy")
public class AllergyController {
	@Autowired
	private AllergyMasterRepository allergyMasterRepo;

	@Autowired
	private AllergyRepository allergyRepository;
	// --------------------- master
	// ----------------------------------------------------

	@Operation(summary = "fetch all allergy", description = "This API is used to fetch master data of allergy.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found allergy details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/allAllergy")
	public List<MasterAllergy> getAllAllergy() {
		return allergyMasterRepo.findAll();
	}

	@Operation(summary = "fetch allergy details", description = "This API is used to fetch allergy details by allergy code.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found allergy details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getAllergyByCode/{allergyCode}")
	public List<MasterAllergy> getAllergyByCode(@PathVariable String allergyCode) {
		return allergyMasterRepo.findByAllergyCode(allergyCode);
	}

	// ------------------------------ normal
	// ----------------------------------------

	@Operation(summary = "save allergy details", description = "This API is used to save allergy details.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "saved allergy details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/save")
	public String saveAllergyDetails(@RequestBody Allergy allergy) {
		allergyRepository.save(allergy);
		return "allergy saved!";
	}

	@Operation(summary = "get allergy details by patient id", description = "This API is used to get allergy details by patient id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found allergy details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByPatientId/{id}")
	public List<Allergy> getAllergyDetails(@PathVariable("id") Long id) {
		return allergyRepository.findByPatientId(id);

	}

	@Operation(summary = "delete allergy by id", description = "This API is used to delete allergy details by id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "delete allergy details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@DeleteMapping("/delete/{id}")
	public String deleteAllergy(@PathVariable("id") Long id) {
		allergyRepository.deleteById(id);

		return "allergy deleted!";

	}

}
