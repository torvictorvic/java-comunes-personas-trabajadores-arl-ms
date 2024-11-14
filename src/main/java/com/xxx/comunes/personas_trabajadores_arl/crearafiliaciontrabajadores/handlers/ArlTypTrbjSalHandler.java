package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.handlers;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypTrbjSal;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.utils.SimTypLookupUtils;
import com.xxxxxxxx.error.handling.constants.TipoErrorEnum;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;

public class ArlTypTrbjSalHandler extends BaseTypeHandler<ArlTypTrbjSal> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, ArlTypTrbjSal parameter, JdbcType jdbcType)
			throws SQLException {
		throw BolivarBusinessException.builder().codigo("-1").categoria(TipoErrorEnum.TECNICO)
				.mensaje("Método no implementado").build();

	}

	@Override
	public ArlTypTrbjSal getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return null;
	}

	@Override
	public ArlTypTrbjSal getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public ArlTypTrbjSal getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		Struct struct = (Struct) cs.getObject(columnIndex);
		if (struct != null) {
			Object[] atributos = struct.getAttributes();
			return ArlTypTrbjSal.builder().numerosecuenciapoliza((BigDecimal) atributos[0])
					.empresatipoidentificacion(SimTypLookupUtils.obtenerSimTypLookup(atributos[1]))
					.empresanumeroidentificacion((BigDecimal) atributos[2])
					.trbjdorcentrotrabajo(SimTypLookupUtils.obtenerSimTypLookup(atributos[3]))
					.trbjdortipoidentificacion(SimTypLookupUtils.obtenerSimTypLookup(atributos[4]))
					.trbjdornumeroidentificacion((BigDecimal) atributos[5]).trbjdorfechanacimiento((Date) atributos[6])
					.trbjdorsexo(SimTypLookupUtils.obtenerSimTypLookup(atributos[7]))
					.trbjdorepsdescripcion(SimTypLookupUtils.obtenerSimTypLookup(atributos[8]))
					.trbjdorafpdescripcion(SimTypLookupUtils.obtenerSimTypLookup(atributos[9]))
					.trbjdorfchainiciocbrtracntrato((Date) atributos[10])
					.trbjdorfchainiciocontrato((Date) atributos[11]).trbjdorfchafincontrato((Date) atributos[12])
					.trbjdoringresototal((BigDecimal) atributos[13]).trbjdoringresomensual((BigDecimal) atributos[14])
					.trbjdorcargodescripcion(SimTypLookupUtils.obtenerSimTypLookup(atributos[15]))
					.trbjdortipocontrato(SimTypLookupUtils.obtenerSimTypLookup(atributos[16]))
					.trbjdorformapago(SimTypLookupUtils.obtenerSimTypLookup(atributos[17]))
					.trbjdormodalidad(SimTypLookupUtils.obtenerSimTypLookup(atributos[18]))
					.trbjdorsuministratransporte(SimTypLookupUtils.obtenerSimTypLookup(atributos[19]))
					.trbjdoribc((BigDecimal) atributos[20])
					.pInfo1((String) atributos[21])
					.pInfo2((String) atributos[22])
					.pInfo3((String) atributos[23])
					.pInfo4((String) atributos[24])
					.pInfo5((String) atributos[25])
					.trbjdornombres((String) atributos[26])
					.trbjdortipocotizante(SimTypLookupUtils.obtenerSimTypLookup(atributos[27]))
					.build();
		} else {
			return null;
		}
	}

}
