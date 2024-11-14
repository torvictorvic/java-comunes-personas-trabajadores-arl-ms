package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database;

import java.math.BigDecimal;
import java.util.List;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaTrabajadoresParamsDTO {
	private SimTypArrayLista ipArrayParametros;
	private ArlTypArrayTrabbasicdetlCt ipTrabajadoresdetalles;
	private ArlTypArrayCntrotrabcodCt ipCentroTrabcodigo;
	private List<ArlTypConsltatrabajadoresCt> opArraydatostrabajadores;
	private BigDecimal opNumeropoliza;
	private String opFechapoliza;
	private String ipValidacion;
	private SimTypProceso ipProceso;
	private Integer opResultado;
	private List<SimTypError> opArrerrores;
	private Integer opTotalregistros;
	private Integer ipPaginaInicio;
	private Integer ipPaginaFin;
	private Integer opTotalTrabajadores;
}
