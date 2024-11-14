package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.ConsultaAfiliacionTrabajadorDataDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ConsultarAfiliacionTrabajadorResponse")
public class ConsultarAfiliacionTrabajadorResponse {
    @Schema(name = "dataHeader", description = "Cabecera de la respuesta")
    private DataHeaderDTO dataHeader;
    @Schema(name = "data", description = "Cuerpo de la respuesta")
    private ConsultaAfiliacionTrabajadorDataDTO data;
}
