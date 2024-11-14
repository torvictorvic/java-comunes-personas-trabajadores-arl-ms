package com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database;

import com.xxxxxxxx.mybatis.util.core.annotation.BolivarObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "ARL_TYP_TBL_HIST_NOVS_SALIDA")
public class ArlTypTblHistNovsSalida {

    private List<ArlTypHistNovsSalida> ArlTypTblHistNovsSalida;
}
