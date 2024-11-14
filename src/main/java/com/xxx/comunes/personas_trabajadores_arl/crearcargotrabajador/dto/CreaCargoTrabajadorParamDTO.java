package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.dto;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
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
@Schema(name = "CreaCargoTrabajadorParamDTO")
public class CreaCargoTrabajadorParamDTO {
    private String pDescCargo; // in
    private Integer pCodCargo; // out
    private String pSeccion; //out
    private String pObs; //out
    private String ipValidacion;
    private SimTypProceso ipProceso;
    private Integer opResultado;
    private List<SimTypError> opArrerrores;


}
