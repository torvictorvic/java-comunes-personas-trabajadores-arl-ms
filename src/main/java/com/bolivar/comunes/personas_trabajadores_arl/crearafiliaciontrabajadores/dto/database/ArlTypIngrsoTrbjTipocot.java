package com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database;

import javax.validation.constraints.NotNull;

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
@BolivarObject(objectName = "ARL_TYP_INGRSO_TRBJ_TIPOCOT")
@Schema(name = "ArlTypIngrsoTrbjTipocot")
public class ArlTypIngrsoTrbjTipocot {
	@NotNull
	@Schema(name = "trabajadorTipoCotizante", description = "Tipo de cotizante del trabajador")
	private String trabajadorTipoCotizante;

}
