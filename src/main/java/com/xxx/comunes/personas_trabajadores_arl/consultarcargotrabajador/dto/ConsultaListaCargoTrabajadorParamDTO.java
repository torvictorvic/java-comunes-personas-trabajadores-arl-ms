package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLista;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaListaCargoTrabajadorParamDTO {
    private BigDecimal ipCodigo;
    private String ipSearchString;
    private List<SimTypLista> opArrLista;
    private String ipValidacion;
    private SimTypProceso ipProceso;
    private Integer opResultado;
    private List<SimTypError> opArrerrores;
}
