package com.bolivar.comunes.personas_trabajadores_arl.commons.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.bolivar.error.handling.model.ExceptionDetailModel;

public class ManejoErroresUtils {

	private ManejoErroresUtils() {
	}

	public static List<ExceptionDetailModel> mapeoErrores(List<SimTypError> errores, String componente) {
		return errores.stream()
				.map(error -> ExceptionDetailModel.builder().codigo(error.getIdError().toString())
						.descripcion(error.getDescError()).componente(componente).build())
				.collect(Collectors.toList());
	}
}
