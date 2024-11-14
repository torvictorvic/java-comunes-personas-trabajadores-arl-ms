package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.services;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.models.ConsultarCargoTrabajadorResponse;

import java.math.BigDecimal;

public interface ConsultarCargoTrabajadorService {
    ConsultarCargoTrabajadorResponse consultaListaCargoTrabajador(BigDecimal codigo, String cargo);
}
