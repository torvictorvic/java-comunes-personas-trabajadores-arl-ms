package com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLista;
import com.bolivar.mybatis.util.core.annotation.BolivarField;
import com.bolivar.mybatis.util.core.annotation.BolivarObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "SIM_TYP_ARRAY_LISTA")
public class SimTypArrayLista {
    @BolivarField(isArray = true, arrayFieldName = "SIM_TYP_LISTA")
    List<SimTypLista> simTypLista;
}
