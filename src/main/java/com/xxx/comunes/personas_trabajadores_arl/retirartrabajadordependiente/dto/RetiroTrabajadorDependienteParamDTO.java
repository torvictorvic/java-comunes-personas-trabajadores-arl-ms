package com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto;

import java.util.List;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.database.ArlTypExclTrbjDptes;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.ArlTypExclTrbjDptesR;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetiroTrabajadorDependienteParamDTO {
	private ArlTypExclTrbjDptes ipParametros;
	private ArlTypExclTrbjDptesR opRespEjecuc;
	private String ipValidacion;
	private SimTypProceso ipProceso;
	private Integer opResultado;
	private List<SimTypError> opArrerrores;
}
