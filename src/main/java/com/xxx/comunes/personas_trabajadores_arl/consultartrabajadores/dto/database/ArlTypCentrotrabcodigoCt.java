package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database;

import com.xxxxxxxx.mybatis.util.core.annotation.BolivarObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@BolivarObject(objectName = "ARL_TYP_CENTROTRABCODIGO_CT")
public class ArlTypCentrotrabcodigoCt {
	private Long centroTrabCodigo;
}
