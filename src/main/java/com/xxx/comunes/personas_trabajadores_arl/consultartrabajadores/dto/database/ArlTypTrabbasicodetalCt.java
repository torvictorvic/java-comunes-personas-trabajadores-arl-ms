package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database;

import java.math.BigDecimal;

import com.xxxxxxxx.mybatis.util.core.annotation.BolivarObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@BolivarObject(objectName = "ARL_TYP_TRABBASICODETAL_CT")
public class ArlTypTrabbasicodetalCt {
	private String tipoDocumento;
	private BigDecimal numeroDocumento;
}
