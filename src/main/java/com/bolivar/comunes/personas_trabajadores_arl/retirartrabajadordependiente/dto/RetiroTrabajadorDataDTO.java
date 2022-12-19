package com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.ArlTypExclTrbjDptesR;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ActualizaRetiroTrabajadorDataDTO")
public class RetiroTrabajadorDataDTO {
	@Schema(name = "resultado", description = "Resultado de la ejecución del retiro")
	private ArlTypExclTrbjDptesR resultado;
}
