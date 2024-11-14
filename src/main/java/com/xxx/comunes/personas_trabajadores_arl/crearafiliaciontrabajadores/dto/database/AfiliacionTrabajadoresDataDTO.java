package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AfiliacionTrabajadoresDataDTO")
public class AfiliacionTrabajadoresDataDTO {
	@Schema(name = "respuesta", description = "Datos de resumen de la afiliación")
	private ArlTypTrbjSal respuesta;
}
