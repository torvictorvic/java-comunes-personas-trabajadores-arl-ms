package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database;

import java.util.List;

import com.xxxxxxxx.mybatis.util.core.annotation.BolivarField;
import com.xxxxxxxx.mybatis.util.core.annotation.BolivarObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@BolivarObject(objectName = "ARL_TYP_ARRAY_TRABBASICDETL_CT")
public class ArlTypArrayTrabbasicdetlCt {
	@BolivarField(isArray = true, arrayFieldName = "ARL_TYP_TRABBASICODETAL_CT")
	List<ArlTypTrabbasicodetalCt> detalle;
}
