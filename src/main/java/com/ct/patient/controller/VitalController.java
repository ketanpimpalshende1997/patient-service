package com.ct.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.patient.dto.VitalDto;
import com.ct.patient.entity.Vital;
import com.ct.patient.response.ErrorMsg;
import com.ct.patient.response.Response;
import com.ct.patient.service.VitalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/vital")
@CrossOrigin(value = "*")
public class VitalController {

	@Autowired
	private VitalService service;

	@Operation(summary = "save vital Details.", description = "This API is used to save vital details.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "saved details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	
	@PostMapping("/save")  //working
	public Response saveVitals(@RequestBody VitalDto vitals) {
		boolean isSaved = service.save(vitals);
		if (isSaved)
			return new Response("saved successfully ...");
		else
			return new Response("something went wrong");
	}

	@Operation(summary = "save vital Details by appointment id.", description = "This API is used to save vital Details by appointment id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "saved details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	
	@GetMapping("/getByAppointmentId/{appointmentId}") //working
	public Vital findVitalByAppointmentId(@PathVariable("appointmentId") Integer appointmentId) {
		return service.findWithAppointmentId(appointmentId);
	}
}
