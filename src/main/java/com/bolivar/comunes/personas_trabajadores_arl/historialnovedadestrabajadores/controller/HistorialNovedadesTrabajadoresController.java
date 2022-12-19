package com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.controller;

import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresRequest;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresResponse;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.services.HistorialNovedadesTrabajadoresService;
import com.bolivar.error.handling.exception.BolivarBusinessException;
import com.bolivar.error.handling.model.ExceptionModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RestController
@Slf4j
@Tag(name = "personas_trabajadores_arl", description = "Agrupación de las operaciones para el dominio de negocio personas-trabajadores-arl")
public class HistorialNovedadesTrabajadoresController {

    private static final String CONSULTA_HISTORICO_NOVEDADES = "/historicoNovedades/trabajadores";

    @Autowired
    private HistorialNovedadesTrabajadoresService servicio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = CONSULTA_HISTORICO_NOVEDADES)
    @Operation(summary = "Obtiene el historico de novedades por trabajador", description =
            "Esta operación consume el SP ARL_PCK_TRABAJADORES.PRC_CONSULTA_NOVEDADES_TRBJDR ubicada en base de datos de Tronador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = HistorialNovedadesTrabajadoresResponse.class))),
            @ApiResponse(responseCode = "400", description = "Error en parámetros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class)))})
    public ResponseEntity<HistorialNovedadesTrabajadoresResponse> consultarHistorialNovedades(
            @Parameter(name = "numDocumentoEmpresa", description = "Nit empresa", required = true) @RequestParam(required = true, name = "numDocumentoEmpresa") String numDocumentoEmpresa,
            @Parameter(name = "tipoDocumentoEmpresa", description = "Tipo de documento de la empresa", required = true) @RequestParam(required = true, name = "tipoDocumentoEmpresa") String tipoDocumentoEmpresa,
            @Parameter(name = "numDocumentoTrabajador", description = "Numero Documento Trabajador", required = true) @RequestParam(required = true, name = "numDocumentoTrabajador") String numDocumentoTrabajador,
            @Parameter(name = "fechaDesde", description = "Fecha Inicio Transaccion",required = false) @RequestParam(required = false, name = "fechaDesde") String fechaDesde,
            @Parameter(name = "fechaHasta", description = "Fecha Hasta Transaccion",required = false) @RequestParam(required = false, name = "fechaHasta") String fechaHasta)
            throws BolivarBusinessException {
        HistorialNovedadesTrabajadoresRequest request=HistorialNovedadesTrabajadoresRequest.builder()
                .numeroDocumentoUsuario(numDocumentoTrabajador)
                .numeroDocumentoEmpresa(numDocumentoEmpresa)
                .tipoDocumentoEmpresa(tipoDocumentoEmpresa)
                .fechaDesde(fechaDesde)
                .fechaHasta(fechaHasta)
                .build();
        HistorialNovedadesTrabajadoresResponse response=servicio.consultarHistoricoNovedades(request);
        return ResponseEntity.ok(response);
    }
}
