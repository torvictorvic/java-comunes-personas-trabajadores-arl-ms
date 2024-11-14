package com.xxxxxxxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database;

import java.math.BigDecimal;
import java.util.Date;

import com.xxxxxxxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLookup;
import com.xxxxxxxxxxxxx.mybatis.util.core.annotation.BolivarObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "ARL_TYP_EXCL_TRBJ_DPTES_R")
public class ArlTypExclTrbjDptesR {

	@Schema(name = "trabajadorTipoIdentificacion", description = "Tipo de identificación del trabajador")
	private SimTypLookup trabajadorTipoIdentificacion;

	@Schema(name = "trabajadorNumeroIdentificacion", description = "Número de identificación del trabajador")
	private BigDecimal trabajadorNumeroIdentificacion;

	@Schema(name = "descTipoCotizante", description = "Descripción tipo de cotización")
	private SimTypLookup descTipoCotizante;

	@Schema(name = "descCentroTrabajo", description = "Descripción centro de trabajo")
	private SimTypLookup descCentroTrabajo;

	@Schema(name = "trabajadorNovedadFechaRetiro", description = "Fecha de novedad de retiro")
	private Date trabajadorNovedadFechaRetiro;

	@Schema(name = "fechaIngresoTrabajador", description = "Fecha de ingreso del trabajador")
	private Date fechaIngresoTrabajador;

	@Schema(name = "fechaRetiroTrabajador", description = "Fecha de retiro del trabajador")
	private Date fechaRetiroTrabajador;
}
