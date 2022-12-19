package com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.services;

import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorRequest;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorResponse;

public interface CrearCargoTrabajadorService {
    CrearCargoTrabajadorResponse creaCargoTrabajador(CrearCargoTrabajadorRequest cargo);
}
