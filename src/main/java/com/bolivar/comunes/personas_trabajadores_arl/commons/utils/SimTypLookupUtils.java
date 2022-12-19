package com.bolivar.comunes.personas_trabajadores_arl.commons.utils;

import java.sql.SQLException;
import java.sql.Struct;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLookup;

public class SimTypLookupUtils {

	private SimTypLookupUtils() {
	}

	public static SimTypLookup obtenerSimTypLookup(Object attribute) throws SQLException {
		SimTypLookup resultado = null;
		Struct struct = (Struct) attribute;
		if (struct != null) {
			Object[] datos = struct.getAttributes();
			resultado = SimTypLookup.builder().codigo(datos[0] == null ? "" : datos[0].toString())
					.valor(datos[1] == null ? "" : datos[1].toString()).build();
		}
		return resultado;
	}
}
