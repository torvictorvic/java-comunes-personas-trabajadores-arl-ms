package com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database;

import com.bolivar.mybatis.util.core.annotation.BolivarObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@BolivarObject(objectName = "SIM_TYP_LOOKUP")
@Schema(name = "SimTypLookup")
public class SimTypLookup {
	@Schema(name = "codigo", description = "Código del tipo trabajador ")
	private String codigo;
	@Schema(name = "valor", description = "Valor del tipo trabajador")
	private String valor;
}
