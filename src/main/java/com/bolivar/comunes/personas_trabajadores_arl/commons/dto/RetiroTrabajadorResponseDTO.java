package com.bolivar.comunes.personas_trabajadores_arl.commons.dto;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.RetiroTrabajadorDataDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ActualizaRetiroTrabajadorResponse")
public class RetiroTrabajadorResponseDTO {
	@Schema(name = "dataHeader", description = "Cabecera de la respuesta")
	private DataHeaderDTO dataHeader;
	@Schema(name = "data", description = "Cuerpo de la respuesta")
	private RetiroTrabajadorDataDTO data;
}
