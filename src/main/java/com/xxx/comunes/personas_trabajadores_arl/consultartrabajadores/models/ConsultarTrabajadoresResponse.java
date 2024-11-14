package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.models;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.ConsultarTrabajadoresDataResponseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ConsultarTrabajadoresResponse")
public class ConsultarTrabajadoresResponse {
	@Schema(name = "dataHeader", description = "Cabecera de la respuesta")
	private DataHeaderDTO dataHeader;
	@Schema(name = "data", description = "Cuerpo de la respuesta")
	private ConsultarTrabajadoresDataResponseDTO data;
}
