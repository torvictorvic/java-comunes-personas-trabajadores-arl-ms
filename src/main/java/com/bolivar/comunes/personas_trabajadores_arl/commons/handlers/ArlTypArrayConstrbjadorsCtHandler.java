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
import java.util.Date;
import java.util.List;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.SimTypLookupUtils;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ArlTypConsltatrabajadoresCt;
import com.bolivar.error.handling.constants.TipoErrorEnum;
import com.bolivar.error.handling.exception.BolivarBusinessException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ArlTypArrayConstrbjadorsCtHandler extends BaseTypeHandler<List<ArlTypConsltatrabajadoresCt>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<ArlTypConsltatrabajadoresCt> parameter,
                                    JdbcType jdbcType) throws SQLException {
        throw BolivarBusinessException.builder().codigo("-1").categoria(TipoErrorEnum.TECNICO)
                .mensaje("Método no implementado").build();
    }
    @Override
    public List<ArlTypConsltatrabajadoresCt> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Collections.emptyList();
    }
    @Override
    public List<ArlTypConsltatrabajadoresCt> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Collections.emptyList();
    }
    @Override
    public List<ArlTypConsltatrabajadoresCt> getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        Array arregloTrabajadores = (Array) cs.getObject(columnIndex);
        Object[] objetoTrabajadores = (Object[]) arregloTrabajadores.getArray();
        List<ArlTypConsltatrabajadoresCt> respuestaTrabajadores = new ArrayList<>();
        if (objetoTrabajadores != null) {
            Arrays.stream(objetoTrabajadores).forEach(trabajador -> {
                Struct structTrabajador = (Struct) trabajador;
                try {
                    Object[] datosTrabajador = structTrabajador.getAttributes();
                    if (datosTrabajador != null && datosTrabajador.length > 0) {
                        respuestaTrabajadores.add(ArlTypConsltatrabajadoresCt.builder()
                                .ideNit((String) datosTrabajador[0]).nit((BigDecimal) datosTrabajador[1])
                                .fecIngreso((Date) datosTrabajador[2]).fecBaja((Date) datosTrabajador[3])
                                .descCentrotrab(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[4]))
                                .descCargo(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[5]))
                                .descEps(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[6]))
                                .descAfp(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[7]))
                                .descDependIndepen(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[8]))
                                .salario((BigDecimal) datosTrabajador[9]).claseRiesgo((String) datosTrabajador[10])
                                .tasaRiesgo((String) datosTrabajador[11])
                                .sexo(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[12]))
                                .fecNacimiento((Date) datosTrabajador[13]).estado((String) datosTrabajador[14])
                                .desCentrotrabCiudad(SimTypLookupUtils.obtenerSimTypLookup(datosTrabajador[15]))
                                .coberturaExteriorFecInicio((Date) datosTrabajador[16])
                                .coberturaExteriorFecFin((Date) datosTrabajador[17])
                                .coberturaExteriorIndicator((String) datosTrabajador[18])
                                .naturalesPrimerNombre((String) datosTrabajador[19])
                                .naturalesSegundoNombre((String) datosTrabajador[20])
                                .naturalesPrimerApellido((String) datosTrabajador[21])
                                .naturalesSegundoApellido((String) datosTrabajador[22]).build());
                    }
                } catch (Exception e) {
                    log.error("Error mapeando atributos PL", e);
                }
            });
        }
        return respuestaTrabajadores;
    }
}
