package com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database.ArlTypHistNovsSalida;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "HistorialNovedadesTrabajadoresResponse")
public class HistorialNovedadesTrabajadoresResponse {
    @Schema(name = "dataHeader", description = "Cabecera de la respuesta")
    private DataHeaderDTO dataHeader;
    @Schema(name = "data", description = "Cuerpo de la respuesta")
    private List<ArlTypHistNovsSalida> data;
}
