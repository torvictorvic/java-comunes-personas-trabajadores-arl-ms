package com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto;

import java.util.List;

import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypDatosTrbjdor;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypIngrsoTrbjTipocot;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypTrbjSal;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcAfiliarParamsDTO {
	private ArlTypDatosTrbjdor ipDatos;
	private ArlTypIngrsoTrbjTipocot ipTipocot;
	private ArlTypTrbjSal opSalida;
	private String ipValidacion;
	private SimTypProceso ipProceso;
	private Integer opResultado;
	private List<SimTypError> opArrerrores;
}
