package com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.utils.SimTypLookupUtils;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database.ArlTypHistNovsSalida;
import com.xxxxxxxx.error.handling.constants.TipoErrorEnum;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
public class ArlTypTblHistNovsSalidaHandler extends BaseTypeHandler<List<ArlTypHistNovsSalida>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<ArlTypHistNovsSalida> parameter, JdbcType jdbcType) throws SQLException {
        throw BolivarBusinessException.builder().codigo("-1").categoria(TipoErrorEnum.TECNICO)
                .mensaje("Método no implementado").build();
    }

    @Override
    public List<ArlTypHistNovsSalida> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public List<ArlTypHistNovsSalida> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public List<ArlTypHistNovsSalida> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        Array arregloHistoricoNovedades = (Array) cs.getObject(columnIndex);
        if(arregloHistoricoNovedades == null) {
            return Collections.emptyList();
        }
        Object[] objetoHistoricoNovedades = (Object[]) arregloHistoricoNovedades.getArray();
        List<ArlTypHistNovsSalida> respuestaHistoricoNovedades = new ArrayList<>();
        if (objetoHistoricoNovedades != null) {
            Arrays.stream(objetoHistoricoNovedades).forEach(trabajador -> {
                Struct structTrabajador = (Struct) trabajador;
                try {
                    Object[] datosTrabajador = structTrabajador.getAttributes();
                    if (datosTrabajador != null && datosTrabajador.length > 0) {
                        respuestaHistoricoNovedades.add(ArlTypHistNovsSalida.builder()
                                .tipoDocDesc(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[0]))
                                .tipotransaccion(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[1]))
                                .desccentrotrabajotransaccion(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[2]))
                                .fechatransaccion((Date) datosTrabajador[3])
                                .horatransaccion((String) datosTrabajador[4])
                                .fechaaplicacionnovedad((Date) datosTrabajador[5])
                                .usuariotransaccioncodigo((String) datosTrabajador[6])
                                .usuariotransaccionnombre((String) datosTrabajador[7])
                                .fechaIniInac((Date) datosTrabajador[8])
                                .fechaFinInac((Date) datosTrabajador[9])
                                .fechaIniCobertura((Date) datosTrabajador[10])
                                .fechaFinCobertura((Date) datosTrabajador[11])
                                .tipoCot((BigDecimal) datosTrabajador[12]).build());
                    }
                } catch (Exception e) {
                    log.error("Error mapeando atributos PL", e);
                }
            });
        }
        return respuestaHistoricoNovedades;
    }
}
