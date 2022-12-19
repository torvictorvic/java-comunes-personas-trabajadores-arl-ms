package com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.models;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorRequestDTO;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class RetirarTrabajadorDependienteRequest extends RetiroTrabajadorRequestDTO {
}
