package com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.services;

import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresRequest;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresResponse;

public interface HistorialNovedadesTrabajadoresService {

    HistorialNovedadesTrabajadoresResponse consultarHistoricoNovedades(HistorialNovedadesTrabajadoresRequest request);

}