package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarguardiantrabajador.dto;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcConsultarTrabajadorParams {
    //Parámetros de entrada
    private String ipIdenvio;                                 // *
    private String ipValidacion;                              // *
    private String nroDocumto;                                   // *
    private String operation;                                 // *
    private SimTypProceso ipProceso;                         // *

    //Parámetros de salida
    private List<SimTypArlTrabajador> poTrabajadores;        // *
    private BigDecimal opResultado;                          // *
    private List<SimTypError> opArrErrores;                  // *
}
