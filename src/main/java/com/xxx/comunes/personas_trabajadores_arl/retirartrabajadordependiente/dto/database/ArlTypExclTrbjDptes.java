package com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.database;

import java.math.BigDecimal;
import java.util.Date;

import com.xxxxxxxx.mybatis.util.core.annotation.BolivarObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "ARL_TYP_EXCL_TRBJ_DPTES")
public class ArlTypExclTrbjDptes {
	private String trabajadorTipoIdentificacion;
	private BigDecimal trabajadorNumeroIdentificacion;
	private BigDecimal trabajadorCentroTrabajo;
	private String trabajadorTipoCotizante;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date trabajadorNovedadFechaRetiro;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaIngresoTrabajador;
	private String sexo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaNacmtoTrabajador;
	private String dptoLabora;
	private String muniLabora;
	private String pmcaAcptaConds;
}
