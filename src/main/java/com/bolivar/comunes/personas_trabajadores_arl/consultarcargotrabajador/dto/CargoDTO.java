package com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Valid
@Schema(name = "CargoDTO")
public class CargoDTO {
    @Null
    @Schema(name = "codigo", description = "Codigo del Cargo")
    private Integer codigo;
    @NotNull
    @Schema(name = "descripcion", description = "Descripcion del Cargo")
    private String descripcion;
}
