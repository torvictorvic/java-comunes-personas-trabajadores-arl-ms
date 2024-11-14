package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.controller;

import javax.validation.Valid;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresResponse;
import com.xxxxxxxx.error.handling.model.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.services.CrearAfiliacionTrabajadoresService;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador que expone endpoint de afiliación de trabajadores
 * 
 * @author jsperez - Javier Steven Pérez Fernández
 * @since 22/03/2022
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RestController
@Tag(name = "personas_trabajadores_arl", description = "Agrupación de las operaciones para el dominio de negocio personas-trabajadores-arl")
public class CrearAfiliacionTrabajadoresController {

	@Autowired
    CrearAfiliacionTrabajadoresService servicio;

	@Operation(summary = "Afiliacion de un trabajador", description = "Realiza la afiliacion de un trabajador. Esta "
			+ "operacion consume el procedimiento ARL_PCK_TRABAJADORES.PROC_AFILIAR ubicado en la base de datos Tronador.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = CrearAfiliacionTrabajadoresResponse.class))),
			@ApiResponse(responseCode = "400", description = "Error en parámetros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class))) })
	@PostMapping(path = "/trabajadores/estadosAfiliacion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CrearAfiliacionTrabajadoresResponse> afiliarTrabajador(
			@RequestBody @Valid CrearAfiliacionTrabajadoresRequest peticion) throws BolivarBusinessException {
		return new ResponseEntity<>(servicio.afiliarTrabajador(peticion), HttpStatus.CREATED);
	}
}
