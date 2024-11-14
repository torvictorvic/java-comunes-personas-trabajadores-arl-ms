package com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.controller;

import javax.validation.Valid;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.models.RetirarTrabajadorDependienteRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.models.RetirarTrabajadorDependienteResponse;
import com.xxxxxxxx.error.handling.model.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorResponseDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.services.RetirarTrabajadorDependienteService;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador que expone Endpoint de retiro de trabajador dependiente.
 *
 * @author jsperez - Javier Steven Pérez Fernández
 * @version 1.0
 * @since 2022-03-01
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RestController
@Tag(name = "personas_trabajadores_arl", description = "Agrupación de las operaciones para el dominio de negocio personas-trabajadores-arl")
public class RetirarTrabajadorDependienteController {

	@Autowired
    RetirarTrabajadorDependienteService servicio;

	@Operation(summary = "Retiro de trabajador dependiente", description = "Realiza un retiro de un trabajador dependiente"
			+ "Esta operación consume el procedimiento ARL_PCK_EXCLSION_TRBJ_DPNDTES.Proc_Excluir en la base de datos Tronador")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = RetiroTrabajadorResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Error en parámetros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class))) })
	@PutMapping(path = "/dependientes/estadosRetiros", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RetirarTrabajadorDependienteResponse> retirarTrabajador (
			@RequestBody @Valid RetirarTrabajadorDependienteRequest informacionTrabajador) throws BolivarBusinessException{
		return ResponseEntity.ok(servicio.retirarTrabajador(informacionTrabajador));
	}

}
