package com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.controller;

import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.models.ConsultarCargoTrabajadorResponse;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.models.ConsultarTrabajadoresRequest;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.models.ConsultarTrabajadoresResponse;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.services.ConsultarTrabajadoresService;
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
import java.util.List;

/**
 * Controlador que permite la consulta de trabajadores.
 *
 * @author javierPerezSB - Javier Steven Pérez F.
 * @version 1.0
 * @since 2022-11-07
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RestController
@Slf4j
@Tag(name = "personas_trabajadores_arl", description = "Agrupación de las operaciones para el dominio de negocio personas-trabajadores-arl")
public class ConsultarTrabajadoresController {

	private static final String CONSULTA_TRABAJADOR = "/empresas/trabajadores";

	@Autowired
	private ConsultarTrabajadoresService servicio;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = CONSULTA_TRABAJADOR)
	@Operation(summary = "Obtiene una lista de trabajadores", description =
			"Esta operación consume el SP ARL_PCK_CONSULTA_TRAB_PAG_OPT.Proc_Consultatrabajadores_Ordn y el SP ARL_PCK_CONSULTA_TRAB_PAG_OPT.PROC_CONTARTRABAJADORES ubicados en base de datos de Tronador.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = ConsultarTrabajadoresResponse.class))),
			@ApiResponse(responseCode = "400", description = "Error en parámetros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class)))})
	public ResponseEntity<ConsultarTrabajadoresResponse> consultarTrabajadores(
			@Parameter(name = "estado", description = "Estado de los trabajadores a consultar", required = false) @RequestParam(required = false, name = "estado") String estado,
			@Parameter(name = "fecIngresoDesde", description = "Fecha de inicio de rango de búsqueda por fecha de afiliación del trabajador", required = false) @RequestParam(required = false, name = "fecIngresoDesde") String fecIngresoDesde,
			@Parameter(name = "fecIngresoHasta", description = "Fecha final del rango de búsqueda por fecha de afiliación del trabajador", required = false) @RequestParam(required = false, name = "fecIngresoHasta") String fecIngresoHasta,
			@Parameter(name = "tipoCotizante", description = "Grupo de cotizante de los trabajadores a consultar (1 - Dependiente, 2 - Indpendientes)", required = false) @RequestParam(required = false, name = "tipoCotizante") String tipoCotizante,
			@Parameter(name = "tipoDocTrabajador", description = "Tipo de documento del trabajador a consultar", required = false) @RequestParam(required = false, name = "tipoDocTrabajador") String tipoDocTrabajador,
			@Parameter(name = "numDocTrabajador", description = "Número de documento del trabajador a consultar", required = false) @RequestParam(required = false, name = "numDocTrabajador") Long numeroDocumentoTrabajador,
			@Parameter(name = "centrosTrabajo", description = "Código de los centros de trabajado de los trabajadores a consultar", required = false) @RequestParam(required = false, name = "centrosTrabajo") List<Long> centrosTrabajo,
			@Parameter(name = "compania", description = "Código de compañía de la empresa a donde pertencen los trabajadores (Usualmente es 2)", required = false) @RequestParam(required = false, name = "compania") Integer compania,
			@Parameter(name = "seccion", description = "Código de la sección de la empresa de los trabajadores a consultar (Usualmente es 7)", required = false) @RequestParam(required = false, name = "seccion") Integer seccion,
			@Parameter(name = "producto", description = "Código del producto de los trabajadores a consultar (Usualmente es 722 o 782)", required = false) @RequestParam(required = false, name = "producto") Integer producto,
			@Parameter(name = "codUsr", description = "Número de documento del usuario que realiza la consulta", required = true) @RequestParam(required = true, name = "codUsr") String codUsr,
			@Parameter(name = "tipoDocEmpresa", description = "Tipo de documento de la empresa de los trabajadores a consultar", required = true) @RequestParam(required = true, name = "tipoDocEmpresa") String tipoDocumentoEmpresa,
			@Parameter(name = "numDocEmpresa", description = "Número de documento de la empresa de los trabajadores a consultar", required = true) @RequestParam(required = true, name = "numDocEmpresa") Long numeroDocumentoEmpresa,
			@Parameter(name = "numPol", description = "Número de póliza de la empresa de los trabajadores a consultar", required = false) @RequestParam(required = false, name = "numPol") Long numeroPoliza,
			@Parameter(name = "numSecuPol", description = "Número de secuencia de la póliza de la empresa de los trabajadores a consultar", required = false) @RequestParam(required = false, name = "numSecuPol") Long numeroSecuenciaPoliza,
			@Parameter(name = "nivelSupervision", description = "Nivel de supervisión del usuario que realiza la consulta (1 es externo, 2 es interno, no sabe el número de póliza ni de secuencia de la empresa)", required = false) @RequestParam(required = false, name = "nivelSupervision") Integer nivelSupervision,
			@Parameter(name = "paginaInicio", description = "Registro inicial de la página que desea visualizar", required = true) @RequestParam(required = true, name = "paginaInicio") Integer paginaInicio,
			@Parameter(name = "paginaFin", description = "Número del registro final de la página que desea visualizar", required = true) @RequestParam(required = true, name = "paginaFin") Integer paginaFin,
			@Parameter(name = "totalRegistros", description = "Total de registros (Solo si se conoce, para no volverlo a calcular)", required = false) @RequestParam(required = false, name = "totalRegistros") Integer totalRegistros,
			@Parameter(name = "soloCalcular", description = "Bandera que indica si se necesita el número de trabajadores o los registros", required = false) @RequestParam(required = false, name = "soloCalcular") Boolean soloCalcular,
			@Parameter(name = "ordenarPor", description = "Fila por la que se desea ordenar el resultado de la consulta", required = false) @RequestParam(required = false, name = "ordenarPor") Integer ordenarPor,
			@Parameter(name = "direccion", description = "Dirección en la que se desea el resultado. (1 - ASC, 2 - DESC)", required = false) @RequestParam(required = false, name = "direccion") Integer direccion,
			@Parameter(name = "criterioFiltrado", description = "Criterio de filtrado por el que se desea acotar el resultado", required = false) @RequestParam(required = false,name = "criterioFiltrado") String criterioFiltrado) throws BolivarBusinessException {
		ConsultarTrabajadoresRequest peticion = ConsultarTrabajadoresRequest.builder().estado(estado)
				.fecIngresoDesde(fecIngresoDesde).fecIngresoHasta(fecIngresoHasta).tipoCotizante(tipoCotizante)
				.tipoDocumentoTrabajador(tipoDocTrabajador).numeroDocumentoTrabajador(numeroDocumentoTrabajador)
				.codigosCentrosTrabajo(centrosTrabajo).compania(compania).seccion(seccion).producto(producto)
				.codUsr(codUsr).tipoDocumentoEmpresa(tipoDocumentoEmpresa)
				.numeroDocumentoEmpresa(numeroDocumentoEmpresa).numPol(numeroPoliza).numSecuPol(numeroSecuenciaPoliza)
				.nivelSupervision(nivelSupervision).paginaInicio(paginaInicio).paginaFin(paginaFin).totalRegistros(totalRegistros)
				.soloCalcular(soloCalcular).ordenarPor(ordenarPor).direccion(direccion).criterioFiltrado(criterioFiltrado).build();
		ConsultarTrabajadoresResponse consultarTrabajadoresResponse = servicio.consultarTrabajadores(peticion);
		return ResponseEntity.ok(consultarTrabajadoresResponse);
	}

}
