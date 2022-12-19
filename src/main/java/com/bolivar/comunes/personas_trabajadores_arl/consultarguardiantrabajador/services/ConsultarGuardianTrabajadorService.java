package com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.services;

import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.models.ConsultarGuardianTrabajadorResponse;

import java.math.BigDecimal;

public interface ConsultarGuardianTrabajadorService {
    ConsultarGuardianTrabajadorResponse consultarTrabajador(String ipIdenvio, String ipValidacion, String nroDocumto, String operation);
}
