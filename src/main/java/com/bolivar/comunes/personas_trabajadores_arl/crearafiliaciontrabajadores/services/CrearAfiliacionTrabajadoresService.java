package com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.services;

import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresRequest;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresResponse;

public interface CrearAfiliacionTrabajadoresService {
	public CrearAfiliacionTrabajadoresResponse afiliarTrabajador(CrearAfiliacionTrabajadoresRequest peticion);
}
