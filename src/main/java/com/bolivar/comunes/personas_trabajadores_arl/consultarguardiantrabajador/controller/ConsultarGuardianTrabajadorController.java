package com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.controller;

import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.models.ConsultarGuardianTrabajadorResponse;
import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.services.ConsultarGuardianTrabajadorService;
import com.bolivar.error.handling.exception.BolivarBusinessException;
import com.bolivar.error.handling.model.ExceptionModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Tag(name = "personas_trabajadores_arl", description = "Agrupación de las operaciones para el dominio de negocio personas-trabajadores-arl")
public class ConsultarGuardianTrabajadorController {

    @Autowired
    ConsultarGuardianTrabajadorService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/api/v1/empresas/{ipIdenvio}/{ipValidacion}/trabajador/{nroDocumto}/empresa/{operation}")
    @Operation(summary = "Obtiene el listado de trabajadores de guardian", description = "Obtiene el listado de trabajadores de guardian"
            + "Esta operación consume sim_pck_extrac_infoguardian.prc_trabajadores_arl_guardian ubicada en base de datos de Tronador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = ConsultarGuardianTrabajadorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Error en parámetros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class)))})
    public ResponseEntity<ConsultarGuardianTrabajadorResponse> consultarData(
            @Parameter(name = "ipIdenvio", description = "2 Fechas AAAAMMDDAAAAMMDD", required = true) @PathVariable(name = "ipIdenvio") String ipIdenvio,
            @Parameter(name = "ipValidacion", description = "Ip validacion", required = true) @PathVariable(name = "ipValidacion") String ipValidacion,
            @Parameter(name = "nroDocumto", description = "Numero documento", required = true) @PathVariable(name = "nroDocumto") String nroDocumto,
            @Parameter(name = "operation", description = "Tipo operacion: nuevo, actualizacion", required = true) @PathVariable(name = "operation") String operation)
            throws BolivarBusinessException {

        return new ResponseEntity<>(service.consultarTrabajador(ipIdenvio, ipValidacion, nroDocumto, operation), HttpStatus.OK);
    }
}
