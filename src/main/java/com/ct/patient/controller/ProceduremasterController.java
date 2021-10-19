package com.ct.patient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.patient.dto.Proceduredto;
import com.ct.patient.entity.Procedure;
import com.ct.patient.entity.ProcedureMaster;
import com.ct.patient.entity.Procedures;
import com.ct.patient.response.ErrorMsg;
import com.ct.patient.response.Response;
import com.ct.patient.service.ProcedureMsService;
import com.ct.patient.service.ProcedureService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/procedure")
@CrossOrigin(value = "*")
public class ProceduremasterController {

	@Autowired
	private ProcedureMsService service;

	@Autowired
	private ProcedureService procedureService;

	@Operation(summary = "fetch all procedure Details", description = "This API is used to fetch all procedure details.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found all procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProcedureMaster.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/procedures")
	public List<ProcedureMaster> getAll() {
		return service.getAll();
	}

	@Operation(summary = "save procedure Details", description = "This API is used to save procedure details.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Saved procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/saveProcedures/{id}")
	public Response saveProcedures(@RequestBody Proceduredto procedures, @PathVariable("id") Integer appointMentId) {
		Procedures proc = new Procedures();
		BeanUtils.copyProperties(procedures, proc);
		List<Procedures> list = new ArrayList<>();
		list.add(proc);
		boolean isSaved = procedureService.save(list, appointMentId);
		if (isSaved)
			return new Response("saved successfully! ..");
		else
			return new Response("error ...");

	}

	@Operation(summary = "fetch procedure Details by procedure code", description = "This API is used to fetch procedure details  by procedure code.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProcedureMaster.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getById/{id}")
	public ProcedureMaster getWithProcedureCode(@PathVariable("id") String code) {
		return service.getByProcedureCode(code);
	}

	@Operation(summary = "fetch procedure Details by procedure name", description = "This API is used to fetch procedure details  by procedure name.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProcedureMaster.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByName/{name}")
	public ProcedureMaster getWithProcedureName(@PathVariable("name") String name) {
		return service.getByProcedureName(name);

	}

	@Operation(summary = "fetch procedure Details by appointment id.", description = "This API is used to fetch procedure Details by appointment id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProcedureMaster.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getByAppointmentId/{id}")
	public List<Procedure> findProceduresByAppointmentId(@PathVariable("id") Integer appointmentId) {
		return procedureService.findWithAppointmentId(appointmentId);
	}

	@Operation(summary = "delete procedure Details by procedure id.", description = "This API is used to delete procedure Details by procedure id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProcedureMaster.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@DeleteMapping("/deleteProcedure/{procedureId}")
	public Response deleteProcedure(@PathVariable("procedureId") Long procedureId) {
		boolean isDeleted = procedureService.deleteProcedure(procedureId);

		if (isDeleted) {
			return new Response("Procedure Deleted successfully");
		} else {
			return new Response("Procedure Deleted successfully");
		}
	}
}
