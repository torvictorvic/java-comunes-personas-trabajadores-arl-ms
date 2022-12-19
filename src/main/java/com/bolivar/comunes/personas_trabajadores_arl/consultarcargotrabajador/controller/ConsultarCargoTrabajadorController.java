package com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.controller;

import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.models.ConsultarCargoTrabajadorResponse;
import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.services.ConsultarCargoTrabajadorService;
import com.bolivar.error.handling.exception.BolivarBusinessException;
import com.bolivar.error.handling.model.ExceptionModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

import java.math.BigDecimal;

/**
 * Controlador que consulta los cargos del trabajador.
 *
 * @author Lorgiam-Arce - Lorgiam Arce Castaño
 * @version 1.0
 * @since 2022-03-17
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RestController
@Tag(name = "personas_trabajadores_arl", description = "Agrupación de las operaciones para el dominio de negocio personas-trabajadores-arl")
public class ConsultarCargoTrabajadorController {

    private static final String CONSULTA_CARGOS_TRABAJADOR = "/cargos";

    @Autowired
    private ConsultarCargoTrabajadorService consultaListaCargoTrabajadorService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = CONSULTA_CARGOS_TRABAJADOR)
    @Operation(summary = "Obtiene la lista de cargos disponibles para la creacion del trabajador", description =
            "Esta operación consume el SP ARL_PCK_LISTAS.Proc_Listacargo ubicada en base de datos de Tronador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = ConsultarCargoTrabajadorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Error en parámetros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class)))})
    public ResponseEntity<ConsultarCargoTrabajadorResponse> consultaListaCargoTrabajador(
            @Parameter(name = "cod", description = "Codigo del Cargo", required = false) @RequestParam(required = false, name = "cod") BigDecimal codigo,
            @Parameter(name = "desc", description = "Descripcion del Cargo",required = true) @RequestParam(required = true, name = "desc") String cargo
    ) throws BolivarBusinessException {
        return new ResponseEntity<>(consultaListaCargoTrabajadorService.consultaListaCargoTrabajador(codigo, cargo), HttpStatus.OK);
    }

}
