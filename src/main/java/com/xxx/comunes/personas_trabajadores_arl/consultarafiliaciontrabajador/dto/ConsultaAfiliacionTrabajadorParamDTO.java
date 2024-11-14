package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.database.ArlTypExclTrbjDptesCp;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.ArlTypExclTrbjDptesCr;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaAfiliacionTrabajadorParamDTO {
    private ArlTypExclTrbjDptesCp ipParametros;
    private List<ArlTypExclTrbjDptesCr> opArrSalida;
    private String ipValidacion;
    private SimTypProceso ipProceso;
    private Integer opResultado;
    private List<SimTypError> opArrerrores;
}
