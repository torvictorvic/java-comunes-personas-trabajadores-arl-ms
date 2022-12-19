package com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.models;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ConsultarTrabajadoresRequest {
	private String estado;
	private String fecIngresoDesde;
	private String fecIngresoHasta;
	private String tipoCotizante;
	private String tipoDocumentoTrabajador;
	private Long numeroDocumentoTrabajador;
	private List<Long> codigosCentrosTrabajo;
	private Integer compania;
	private Integer seccion;
	private Integer producto;
	private String codUsr;
	private String tipoDocumentoEmpresa;
	private Long numeroDocumentoEmpresa;
	private Long numPol;
	private Long numSecuPol;
	private Integer nivelSupervision;
	private Integer paginaInicio;
	private Integer paginaFin;
	private Integer totalRegistros;
	private Boolean soloCalcular;
	private Integer ordenarPor;
	private Integer direccion;
	private String criterioFiltrado;
}
