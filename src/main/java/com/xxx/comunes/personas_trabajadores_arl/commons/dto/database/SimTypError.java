package com.xxxxxxxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database;

import java.math.BigDecimal;

import com.xxxxxxxxxxxxx.mybatis.util.core.annotation.BolivarObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "SIM_TYP_ERROR")
public class SimTypError {

    @Schema(name = "idError", description = "Id del error")
    private BigDecimal idError;

    @Schema(name = "descError", description = "Descripción del error")
    private String descError;

    @Schema(name = "tipoError", description = "Tipo de error")
    private String tipoError;

    @Schema(name = "msgError", description = "Mensaje de error")
    private String msgError;

    @Schema(name = "msgError1", description = "Mensaje de error")
    private String msgError1;
}
