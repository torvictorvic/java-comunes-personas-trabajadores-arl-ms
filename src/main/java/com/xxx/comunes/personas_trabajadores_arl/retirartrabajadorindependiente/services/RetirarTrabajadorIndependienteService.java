package com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadorindependiente.services;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorRequestDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorResponseDTO;

public interface RetirarTrabajadorIndependienteService {
	RetiroTrabajadorResponseDTO retirarTrabajadorIndependiente(RetiroTrabajadorRequestDTO informacion);

}
