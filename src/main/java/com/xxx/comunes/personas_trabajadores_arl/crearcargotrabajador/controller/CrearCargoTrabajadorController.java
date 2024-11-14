package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.controller;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorResponse;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.services.CrearCargoTrabajadorService;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;
import com.xxxxxxxx.error.handling.model.ExceptionModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controlador que crea los cargos del trabajador.
 *
 * @author Lorgiam-Arce - Lorgiam Arce Castaño
 * @version 1.0
 * @since 2022-03-19
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RestController
@Tag(name = "personas_trabajadores_arl", description = "Agrupación de las operaciones para el dominio de negocio personas-trabajadores-arl")
public class CrearCargoTrabajadorController {

    private static final String CREA_CARGOS_TRABAJADOR = "/cargos";

    @Autowired
    private CrearCargoTrabajadorService crearCargoTrabajadorService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = CREA_CARGOS_TRABAJADOR)
    @Operation(summary = "Crea los Cargos disponibles para la creacion del Trabajador", description =
            "Esta operación consume el SP ARL_PCK_INGRSO_TRBJ_DPNDTES.Crea_Cargo ubicada en base de datos de Tronador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = CrearCargoTrabajadorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Error en parámetros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class)))})
    public ResponseEntity<CrearCargoTrabajadorResponse> creaCargoTrabajador(@RequestBody @Valid CrearCargoTrabajadorRequest crearCargoTrabajadorRequest) throws BolivarBusinessException {
        return new ResponseEntity<>(crearCargoTrabajadorService.creaCargoTrabajador(crearCargoTrabajadorRequest), HttpStatus.OK);
    }

}
