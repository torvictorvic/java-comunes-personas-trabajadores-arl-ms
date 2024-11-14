package com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.repository;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database.HistorialNovedadesTrabajadoresParamsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;


@Mapper
public interface PrcConsultaNovedadesTrbjdrRepository {

    @Select(value = "{call ARL_PCK_TRABAJADORES.PRC_CONSULTA_NOVEDADES_TRBJDR("
            + "#{parametros.ipHistoriconovedades, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_LISTA, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputListHandler, mode = IN},\n"
            + "#{parametros.opHistoriconovedades, jdbcType = ARRAY, jdbcTypeName = ARL_TYP_TBL_HIST_NOVS_SALIDA, typeHandler =com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers.ArlTypTblHistNovsSalidaHandler, mode = OUT},\n"
            + "#{parametros.ipValidacion, jdbcType = VARCHAR, mode = IN},\n"
            + "#{parametros.ipProceso, jdbcType = STRUCT, jdbcTypeName = SIM_TYP_PROCESO, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
            + "#{parametros.opResultado, jdbcType = INTEGER, mode = OUT},\n"
            + "#{parametros.opArrerrores, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT}\n"
            + ")}")
    @Options(statementType = StatementType.CALLABLE)
    void prcConsultarHistoricoNovedades(@Param("parametros") HistorialNovedadesTrabajadoresParamsDTO parametros);
}
