package com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.models;

import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.CargoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "CrearCargoTrabajadorRequest")
public class CrearCargoTrabajadorRequest {
    @Valid
    @NotNull(message = "La información del cargo no puede ser nula")
    @Schema(name = "cargo", description = "Información necesaria para hacer el registro del cargo")
    CargoDTO cargo;

}
