package com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.controller;

import java.math.BigDecimal;
import java.util.Date;

import com.bolivar.error.handling.model.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models.ConsultarAfiliacionTrabajadorRequest;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models.ConsultarAfiliacionTrabajadorResponse;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.services.ConsultarAfiliacionTrabajadorService;
import com.bolivar.error.handling.exception.BolivarBusinessException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador que consulta las afiliaciones vigentes del trabajador.
 *
 * @author Lorgiam-Arce - Lorgiam Arce Castaño
 * @version 1.0
 * @since 2022-03-05
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RestController
@Tag(name = "personas_trabajadores_arl", description = "Agrupación de las operaciones para el dominio de negocio personas-trabajadores-arl")
public class ConsultarAfiliacionTrabajadorController {


	private static final String CONSULTA_AFILIACION_TRABAJADOR = "/empresas/afiliaciones";

	@Autowired
	private ConsultarAfiliacionTrabajadorService consultarAfiliacionTrabajadorService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = CONSULTA_AFILIACION_TRABAJADOR)
	@Operation(summary = "Obtiene las Afiliaciones Vigentes del Trabajador", description = "Una entidad afiliacion-trabajador representa la relación"
			+ " de un trabajador con una empresa dependiente al tipo de cotizante. "
			+ "Esta operación consume el SP ARL_PCK_EXCLSION_TRBJ_DPNDTES.PROC_CONSULTAR ubicada en base de datos de Tronador.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = ConsultarAfiliacionTrabajadorResponse.class))),
			@ApiResponse(responseCode = "400", description = "Error en parámetros proporcionados", content = @Content(schema = @Schema(implementation = ExceptionModel.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = ExceptionModel.class))) })
	public ResponseEntity<ConsultarAfiliacionTrabajadorResponse> consultarAfiliacionTrabajador(
			@Parameter(name = "tipodocempresa", description = "Tipo de documento de la empresa",required = false) @RequestParam(required = false, name = "tipodocempresa") String tipoDocumentoEmpresa,
			@Parameter(name = "numdocempresa", description = "Número de documento de la empresa",required = false) @RequestParam(required = false, name = "numdocempresa") String numeroDocumentoEmpresa,
			@Parameter(name = "tipodoc", description = "Tipo de documento del trabajador",required = false) @RequestParam(required = false, name = "tipodoc") String tipoIdentificacionTrabajador,
			@Parameter(name = "numdoc", description = "Número de documento del trabajador",required = false) @RequestParam(required = false, name = "numdoc") BigDecimal numeroIdentificacionTrabajador,
			@Parameter(name = "centrotrabajo", description = "Número de identificacion del centro de trabajo",required = false) @RequestParam(required = false, name = "centrotrabajo") BigDecimal trabajadorCentroTrabajo,
			@Parameter(name = "numpoliza", description = "Número de la Poliza",required = false) @RequestParam(required = false, name = "numpoliza") String numeroPoliza,
			@Parameter(name = "numsecpoliza", description = "Número de secuencia de la poliza",required = false) @RequestParam(required = false, name = "numsecpoliza") String numeroSecuenciaPoliza,
			@Parameter(name = "codcia", description = "Código de compañía",required = false) @RequestParam(required = false, name = "codcia") Integer codCia,
			@Parameter(name = "codsecc", description = "Código de sección",required = false) @RequestParam(required = false, name = "codsecc") Integer codSecc,
			@Parameter(name = "codprod", description = "Código de producto",required = false) @RequestParam(required = false, name = "codprod") Integer codProducto,
			@Parameter(name = "codusr", description = "Código de usuario",required = false) @RequestParam(required = false, name = "codusr") String codUsr,
			@Parameter(name = "fecini", description = "Fecha Inicial de Rango de Busqueda",required = false) @RequestParam(required = false, name = "fecini") Date rangoBusquedaFechaInicial,
			@Parameter(name = "fecfin", description = "Fecha Final de Rango de Busqueda",required = false) @RequestParam(required = false, name = "fecfin") Date rangoBusquedaFechaFinal)
			throws BolivarBusinessException {
		ConsultarAfiliacionTrabajadorRequest peticion = ConsultarAfiliacionTrabajadorRequest.builder()
				.centroTrabajo(trabajadorCentroTrabajo).codCia(codCia).codProd(codProducto).codSec(codSecc)
				.codUsr(codUsr).fecFin(rangoBusquedaFechaFinal).fecIni(rangoBusquedaFechaFinal)
				.numDocEmpresa(numeroDocumentoEmpresa).numDocTrabajador(numeroIdentificacionTrabajador)
				.tipoDocEmpresa(tipoDocumentoEmpresa).tipoDocTrabajador(tipoIdentificacionTrabajador)
				.numeroPoliza(numeroPoliza).numSecuPoliza(numeroSecuenciaPoliza).build();
		return ResponseEntity.ok(consultarAfiliacionTrabajadorService.consultaAfiliacionTrabajador(peticion));
	}
}
