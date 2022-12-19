package com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models;

import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.AfiliacionTrabajadoresDataDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "CrearAfiliacionTrabajadoresResponse")
public class CrearAfiliacionTrabajadoresResponse {
	@Schema(name = "dataHeader", description = "Encabezado de la respuesta")
	private DataHeaderDTO dataHeader;
	@Schema(name = "data", description = "Cuerpo de la respuesta")
	private AfiliacionTrabajadoresDataDTO data;
}
