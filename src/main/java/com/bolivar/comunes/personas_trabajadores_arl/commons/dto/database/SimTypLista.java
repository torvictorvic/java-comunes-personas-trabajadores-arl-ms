package com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database;

import com.bolivar.mybatis.util.core.annotation.BolivarObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "SIM_TYP_LISTA")
public class SimTypLista {

    @Schema(name = "codigo", description = "Código del tipo SIM_TYP_LISTA del trabajador")
    private String codigo;

    @Schema(name = "valor", description = "Valor del tipo SIM_TYP_LISTA del trabajador")
    private String valor;

    @Schema(name = "datosAdicionales", description = "Datos Adicionales del SIM_TYP_LISTA del trabajador")
    private String datosAdicionales;

    @Schema(name = "imagenAsociada", description = "Atributo del SIM_TYP_LISTA de la base dae ")
    private String imagenAsociada;
}
