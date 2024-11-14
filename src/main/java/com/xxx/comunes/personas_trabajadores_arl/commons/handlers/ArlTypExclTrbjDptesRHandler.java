package com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Date;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.utils.SimTypLookupUtils;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.ArlTypExclTrbjDptesR;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.xxxxxxxx.error.handling.constants.TipoErrorEnum;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;

public class ArlTypExclTrbjDptesRHandler extends BaseTypeHandler<ArlTypExclTrbjDptesR> {
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, ArlTypExclTrbjDptesR parameter, JdbcType jdbcType)
			throws SQLException {
		throw BolivarBusinessException.builder().codigo("-1").categoria(TipoErrorEnum.TECNICO)
				.mensaje("Método no implementado").build();
	}

	@Override
	public ArlTypExclTrbjDptesR getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return null;
	}

	@Override
	public ArlTypExclTrbjDptesR getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public ArlTypExclTrbjDptesR getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		Struct struct = (Struct) cs.getObject(columnIndex);
		Object[] atributos = struct.getAttributes();

		return ArlTypExclTrbjDptesR.builder().trabajadorTipoIdentificacion(SimTypLookupUtils.obtenerSimTypLookup(atributos[0]))
				.trabajadorNumeroIdentificacion((BigDecimal) atributos[1])
				.descTipoCotizante(SimTypLookupUtils.obtenerSimTypLookup(atributos[2]))
				.descCentroTrabajo(SimTypLookupUtils.obtenerSimTypLookup(atributos[3])).fechaIngresoTrabajador((Date) atributos[4])
				.trabajadorNovedadFechaRetiro((Date) atributos[5]).fechaRetiroTrabajador((Date) atributos[6]).build();
	}
}
