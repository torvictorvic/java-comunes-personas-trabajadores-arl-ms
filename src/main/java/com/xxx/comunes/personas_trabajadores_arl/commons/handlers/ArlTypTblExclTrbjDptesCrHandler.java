package com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.utils.SimTypLookupUtils;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.ArlTypExclTrbjDptesCr;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.driver.OracleConnection;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;

@Slf4j
public class ArlTypTblExclTrbjDptesCrHandler extends BaseTypeHandler<Object> {

    private static final String TYPE_NAME = "ARL_TYP_EXCL_TRBJ_DPTES_CR";
    private static final String LIST_TYPE_NAME = "ARL_TYP_TBL_EXCL_TRBJ_DPTES_CR";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            log.info("El objeto ARL_TYP_EXCL_TRBJ_DPTES_CR está vacío");
            return;
        }
        ObjectMapper mapeador = new ObjectMapper();
        List<Struct> estructuras = new ArrayList<>();
        @SuppressWarnings("unchecked")
        List<ArlTypExclTrbjDptesCr> objetos = (List<ArlTypExclTrbjDptesCr>) parameter;
        objetos.forEach(objeto -> {
            Struct str;
            try {
                str = ps.getConnection().createStruct(TYPE_NAME, mapeador.convertValue(objeto, new TypeReference<Map<String, Object>>() {
                }).values().toArray());
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
            estructuras.add(str);
        });
        Array arreglo = (ps.getConnection().unwrap(OracleConnection.class)).createArrayOf(LIST_TYPE_NAME, estructuras.toArray());
        ps.setArray(i, arreglo);
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Array resultado = (Array) cs.getObject(columnIndex);
        if (resultado == null) {
            return Collections.emptyList();
        }
        Object[] arreglo = (Object[]) resultado.getArray();
        ArrayList<ArlTypExclTrbjDptesCr> listaFinal = new ArrayList<>();
        Arrays.stream(arreglo).forEach(objeto -> {
            Struct s = (Struct) objeto;
            var afiliacionTrabajador = new ArlTypExclTrbjDptesCr();
            Object[] attributes;
            try {
                attributes = s.getAttributes();
                afiliacionTrabajador.setTrabajadorTipoIdentificacion(SimTypLookupUtils.obtenerSimTypLookup(attributes[0]));
                afiliacionTrabajador.setTrabajadorNumeroIdentificacion((BigDecimal) attributes[1]);
                afiliacionTrabajador.setDescTrabajadorCentroTrabajo(SimTypLookupUtils.obtenerSimTypLookup(attributes[2]));
                afiliacionTrabajador.setTrabajadorDescripcionCotizante(SimTypLookupUtils.obtenerSimTypLookup(attributes[3]));
                afiliacionTrabajador.setTrabajadorFechaIngreso((Date) attributes[4]);
                afiliacionTrabajador.setTrabajadorFechaRetiro((Date) attributes[5]);
                afiliacionTrabajador.setTrabajadorFechaIniCobertura((Date) attributes[6]);
                listaFinal.add(afiliacionTrabajador);
            } catch (SQLException e) {
                log.error("Ocurrió un error obteniendo atributos.", e);
            }
        });
        return listaFinal;
    }


}
