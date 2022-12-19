package com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLista;
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
@Schema(name = "ConsultaListaCargoTrabajadorDataDTO")
public class ConsultaListaCargoTrabajadorDataDTO {
    @Schema(name = "cargos", description = "Lista de Cargos del Trabajador")
    List<SimTypLista> cargos;
}
