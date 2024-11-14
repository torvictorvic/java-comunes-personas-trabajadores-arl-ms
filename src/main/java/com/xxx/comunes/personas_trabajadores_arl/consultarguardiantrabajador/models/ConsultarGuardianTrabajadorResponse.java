package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarguardiantrabajador.models;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarguardiantrabajador.dto.ConsultarTrabajadorDataDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ConsultarGuardianTrabajadorResponse")
public class ConsultarGuardianTrabajadorResponse {
    @Schema(name = "dataHeader", description = "Cabecera de la respuesta")
    private DataHeaderDTO dataHeader;
    @Schema(name = "data", description = "Cuerpo de la respuesta")
    private List<ConsultarTrabajadorDataDTO> data;
}
