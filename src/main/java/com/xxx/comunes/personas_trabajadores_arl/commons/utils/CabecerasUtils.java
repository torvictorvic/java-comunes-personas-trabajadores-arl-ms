package com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.utils;

import java.util.Collections;
import java.util.List;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.ErrorDTO;

public class CabecerasUtils {
	private CabecerasUtils() {

	}

	public static DataHeaderDTO generarCabeceraCorrecta() {
		return DataHeaderDTO.builder().codRespuesta(0).errores(Collections.emptyList()).build();
	}

	public static DataHeaderDTO generarCabeceraErrorControlado(List<ErrorDTO> dto) {
		return DataHeaderDTO.builder().codRespuesta(-1).errores(dto).build();
	}
}
