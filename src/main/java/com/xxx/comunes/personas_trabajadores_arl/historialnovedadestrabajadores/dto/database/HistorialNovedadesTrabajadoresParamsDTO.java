package com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialNovedadesTrabajadoresParamsDTO {
    private SimTypArrayLista ipHistoriconovedades;
    private List<ArlTypHistNovsSalida> opHistoriconovedades;
    private String ipValidacion;
    private SimTypProceso ipProceso;
    private Integer opResultado;
    private List<SimTypError> opArrerrores;

}
