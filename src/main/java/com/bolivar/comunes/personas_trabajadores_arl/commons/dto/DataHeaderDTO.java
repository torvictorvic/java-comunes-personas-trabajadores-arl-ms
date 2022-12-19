package com.bolivar.comunes.personas_trabajadores_arl.commons.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "DataHeaderDTO")
public class DataHeaderDTO {
	@Schema(name = "codRespuesta", description = "Código de respuesta de la petición")
	private Integer codRespuesta;
	@Schema(name = "errores", description = "Lista de errores generados cuando la respuesta de la petición no es correcta")
	private List<ErrorDTO> errores;
}
