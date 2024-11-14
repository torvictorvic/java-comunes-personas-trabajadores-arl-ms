package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarAfiliacionTrabajadorRequest {
	private String tipoDocEmpresa;
	private String numDocEmpresa;
	private String tipoDocTrabajador;
	private BigDecimal numDocTrabajador;
	private BigDecimal centroTrabajo;
	private String numeroPoliza;
	private String numSecuPoliza;
	private Integer codCia;
	private Integer codSec;
	private Integer codProd;
	private String codUsr;
	private Date fecIni;
	private Date fecFin;
}
