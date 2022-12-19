package com.bolivar.comunes.personas_trabajadores_arl.commons.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ErrorDTO")
public class ErrorDTO {
    @Schema(name = "idError", description = "Identificador del error")
    private Integer idError;
    @Schema(name = "descError", description = "Descripción del error")
    private String descError;
    @Schema(name = "tipoError", description = "Tipo de error")
    private String tipoError;
}
