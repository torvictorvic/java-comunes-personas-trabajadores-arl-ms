package com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.ArlTypExclTrbjDptesCr;
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
@Schema(name = "ConsultaAfiliacionTrabajadorDataDTO")
public class ConsultaAfiliacionTrabajadorDataDTO {
    @Schema(name = "afiliaciones", description = "Lista de Afiliaciones del Trabajador")
    List<ArlTypExclTrbjDptesCr> afiliaciones;
}
