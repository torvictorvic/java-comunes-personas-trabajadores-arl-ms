package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.dto;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.CargoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "CreaCargoTrabajadorDataDTO")
public class CreaCargoTrabajadorDataDTO {
    @Schema(name = "cargo", description = "Informacion del Cargo Creado")
    CargoDTO cargo;
}
