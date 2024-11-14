package com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers;

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

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLista;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimTypArrayListaHandler extends BaseTypeHandler<Object> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		throw BolivarBusinessException.builder().mensaje("Esta opción no está implementada").build();
	}

	@Override
	public List<SimTypLista> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return Collections.emptyList();
	}

	@Override
	public List<SimTypLista> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return Collections.emptyList();
	}

	@Override
	public List<SimTypLista> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		Array resultado = (Array) cs.getObject(columnIndex);
		if (resultado == null) {
			return Collections.emptyList();
		}
		Object[] arreglo = (Object[]) resultado.getArray();
		ArrayList<SimTypLista> listaFinal = new ArrayList<>();
		Arrays.stream(arreglo).forEach(objeto -> {
			Struct s = (Struct) objeto;
			var simTypLista = new SimTypLista();
			Object[] attributes;
			try {
				attributes = s.getAttributes();
				simTypLista.setCodigo((String) attributes[0]);
				simTypLista.setValor((String) attributes[1]);
				simTypLista.setDatosAdicionales((String) attributes[2]);
				listaFinal.add(simTypLista);
			} catch (SQLException e) {
				log.error("Ocurrió un error obteniendo atributos.", e);
			}
		});
		return listaFinal;
	}
}
