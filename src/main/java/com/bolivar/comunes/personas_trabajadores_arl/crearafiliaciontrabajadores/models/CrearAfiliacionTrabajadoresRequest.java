package com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypDatosTrbjdor;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypIngrsoTrbjTipocot;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "CrearAfiliacionTrabajadoresRequest")
public class CrearAfiliacionTrabajadoresRequest {
	@Valid
	@NotNull(message = "Los datos del trabajador son obligatorios")
	@Schema(name = "datosTrabajador", description = "Objeto con los datos del trabajador a afiliar")
	private ArlTypDatosTrbjdor datosTrabajador;
	@Valid
	@NotNull(message = "El tipo de cotizante es obligatorio")
	@Schema(name = "tipoCotizante", description = "Tipo de cotizante")
	private ArlTypIngrsoTrbjTipocot tipoCotizante;
	@Valid
	@NotNull(message = "Los datos del proceso son obligatorios")
	@Schema(name = "datosProceso", description = "Objeto con los datos del proceso")
	private SimTypProceso datosProceso;
}
