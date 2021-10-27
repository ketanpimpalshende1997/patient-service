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

import com.ct.patient.dto.ProcedureMasterDto;
import com.ct.patient.entity.Procedure;
import com.ct.patient.entity.MasterProcedure;
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
					@Content(mediaType = "application/json", schema = @Schema(implementation = MasterProcedure.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/master/procedures")
	public List<ProcedureMasterDto> getAll() {
		return service.getAll();
	}
	
	
	@Operation(summary = "fetch all master procedures which are not deprecated ", description = "This API is used to fetch all master procedures which are not deprecated.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found all procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MasterProcedure.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/master/active/procedures")
	public List<ProcedureMasterDto> getAllActiveProcedures() {
		return service.getAllActiveProcedures();
	}

	@Operation(summary = "save procedure Details", description = "This API is used to save procedure details.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Saved procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/saveProcedures")
	public Response saveProcedures(@RequestBody Procedure procedure) {

		boolean isSaved = procedureService.save(procedure);
		if (isSaved)
			return new Response("saved successfully! ..");
		else
			return new Response("error ...");

	}

	@Operation(summary = "save procedure Details", description = "This API is used to save procedure details.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Saved procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@PostMapping("/master/save")
	public Response saveProcedureMaster(@RequestBody ProcedureMasterDto procedureMasterDto) {

		MasterProcedure procMaster = new MasterProcedure();
		procMaster.setProcedureCode(procedureMasterDto.getProcedureCode());
		procMaster.setDescription(procedureMasterDto.getDescription());

		if (procedureMasterDto.getIsDepricated().equalsIgnoreCase("yes")) {
			procMaster.setDepricated(true);
		} else {
			procMaster.setDepricated(false);
		}

		boolean isSaved = procedureService.saveMaster(procMaster);
		if (isSaved)
			return new Response("saved successfully! ..");
		else
			return new Response("error ...");

	}

	@Operation(summary = "fetch procedure Details by procedure code", description = "This API is used to fetch procedure details  by procedure code.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MasterProcedure.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@GetMapping("/getById/{id}")
	public MasterProcedure getWithProcedureCode(@PathVariable("id") String code) {
		return service.getByProcedureCode(code);
	}


	@Operation(summary = "fetch procedure Details by appointment id.", description = "This API is used to fetch procedure Details by appointment id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found procedure details successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MasterProcedure.class)) }),
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
					@Content(mediaType = "application/json", schema = @Schema(implementation = MasterProcedure.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.BadRequest.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMsg.InternalServerError.class)) }) })

	@DeleteMapping("/deleteProcedure/{id}")
	public Response deleteProcedure(@PathVariable("id") Long procedureId) {
				
		boolean isDeleted = procedureService.deleteProcedure(procedureId);

		if (isDeleted) {
			return new Response("Procedure Deleted successfully");
		} else {
			return new Response("Procedure Deleted successfully");
		}
	}
}
