package com.bolivar.comunes.personas_trabajadores_arl.commons.handlers;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypArlTrabajador;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Date;

@Slf4j
public class SimTypArlTrabajadorHandler extends BaseTypeHandler<List<SimTypArlTrabajador>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<SimTypArlTrabajador> parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public List<SimTypArlTrabajador> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public List<SimTypArlTrabajador> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public List<SimTypArlTrabajador> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if (cs == null || cs.getObject(columnIndex) == null){
            return Collections.emptyList();
        }
        Array arregloCTs = (Array) cs.getObject(columnIndex);
        Object[] objetoCTs = (Object[]) arregloCTs.getArray();
        List<SimTypArlTrabajador> respuestaTrabajador = new ArrayList<>();
        if (objetoCTs != null) {
            Arrays.stream(objetoCTs).forEach(empresa -> {
                Struct structCT = (Struct) empresa;
                try {
                    Object[] datosCT = structCT.getAttributes();
                    if (datosCT != null && datosCT.length > 0) {

                        respuestaTrabajador.add(SimTypArlTrabajador.builder()
                                .idEnvio((BigDecimal) datosCT[0])
                                .tipoDocEmpresa((String) datosCT[1])
                                .numDocEmpresa((String) datosCT[2])
                                .genero((String) datosCT[3])
                                .tipDocEmpleado((String) datosCT[4])
                                .numDocEmpleado((String) datosCT[5])
                                .activo((BigDecimal) datosCT[6])
                                .autorizado((BigDecimal) datosCT[7])
                                .lugarExp((String) datosCT[8])
                                .fechExp((String) datosCT[9])
                                .fechaNacimiento((Date) datosCT[10])
                                .nombre((String) datosCT[11])
                                .apellidos((String) datosCT[12])
                                .tipContrato((String) datosCT[13])
                                .profesion((String) datosCT[14])
                                .centroTrabajo((String) datosCT[15])
                                .codCargo((String) datosCT[16])
                                .ocupacion((String) datosCT[17])
                                .salarioIbc((BigDecimal) datosCT[18])
                                .eps((String) datosCT[19])
                                .afp((String) datosCT[20])
                                .arl((String) datosCT[21])
                                .pais((String) datosCT[22])
                                .departamento((String) datosCT[23])
                                .ciudad((String) datosCT[24])
                                .rh((String) datosCT[25])
                                .nivelRiesgos((String) datosCT[26])
                                .centroCostos((String) datosCT[27])
                                .observacion((String) datosCT[28])
                                .direccion((String) datosCT[32])
                                .contrato((String) datosCT[30])
                                .fecIniContr((Date) datosCT[34])
                                .fecFinContr((Date) datosCT[35])
                                .mail((String) datosCT[31])
                                .build()
                        );
                    }
                } catch (Exception e) {
                    log.error("Error mapeando atributos PL", e);
                }
            });
        }
        return respuestaTrabajador;
    }
}
