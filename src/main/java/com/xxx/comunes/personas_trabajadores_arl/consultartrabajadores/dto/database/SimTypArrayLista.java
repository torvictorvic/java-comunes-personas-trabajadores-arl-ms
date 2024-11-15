package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database;

import java.util.List;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLista;
import com.xxxxxxxx.mybatis.util.core.annotation.BolivarField;
import com.xxxxxxxx.mybatis.util.core.annotation.BolivarObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "SIM_TYP_ARRAY_LISTA")
public class SimTypArrayLista {
	@BolivarField(isArray = true, arrayFieldName = "SIM_TYP_LISTA")
	List<SimTypLista> simTypLista;
}
