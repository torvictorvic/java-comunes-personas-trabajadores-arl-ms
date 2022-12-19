package com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.dto;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypArlTrabajador;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ConsultarTrabajadorDataDTO")
public class ConsultarTrabajadorDataDTO {
    @Schema(name = "informacionT", description = "Información de trabajadores de guardian.")
    private SimTypArlTrabajador informacionT; 
}
