package com.bolivar.comunes.personas_trabajadores_arl.commons.handlers;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.bolivar.error.handling.constants.TipoErrorEnum;
import com.bolivar.error.handling.exception.BolivarBusinessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimTypArrayErrorHandler extends BaseTypeHandler<List<SimTypError>> {
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<SimTypError> parameter, JdbcType jdbcType)
			throws SQLException {
		throw BolivarBusinessException.builder().codigo("-1").categoria(TipoErrorEnum.TECNICO)
				.mensaje("Método no implementado").build();

	}

	@Override
	public List<SimTypError> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return Collections.emptyList();
	}

	@Override
	public List<SimTypError> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return Collections.emptyList();
	}

	@Override
	public List<SimTypError> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

		Array arregloErrores = (Array) cs.getObject(columnIndex);
		if(arregloErrores!=null){
			Object[] objetoErrores = (Object[]) arregloErrores.getArray();
			List<SimTypError> respuestaErrores = new ArrayList<>();

			if (objetoErrores != null) {
				Arrays.stream(objetoErrores).forEach(objeto -> {
					Struct structError = (Struct) objeto;
					try {
						Object[] datosError = structError.getAttributes();
						if (validarEstructuraError(datosError)) {
							respuestaErrores.add(SimTypError.builder()
									.idError(datosError[0] != null ? (BigDecimal) datosError[0] : new BigDecimal(-1))
									.descError(datosError[1] != null ? datosError[1].toString() : "").build());
						}

					} catch (Exception e) {
						log.error("Error mapeando atributos PL", e);
					}
				});
			}
			return respuestaErrores;
		}else{
			return Collections.emptyList();
		}
	}

	private boolean validarEstructuraError(Object[] datosError) {
		boolean resultado = false;
		if (datosError != null && datosError.length > 1) {
			resultado = true;
		}
		return resultado;
	}

}
