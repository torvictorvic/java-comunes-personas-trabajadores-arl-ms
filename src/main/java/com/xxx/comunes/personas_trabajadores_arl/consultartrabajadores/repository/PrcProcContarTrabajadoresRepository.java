package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.repository;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ConsultaTrabajadoresParamsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface PrcProcContarTrabajadoresRepository {
    @Select(value = "{call ARL_PCK_CONSULTA_TRAB_PAG_OPT.PROC_CONTARTRABAJADORES("
            + "#{parametros.ipArrayParametros, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_LISTA, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputListHandler, mode = IN},\n"
            + "#{parametros.ipTrabajadoresdetalles, jdbcType = ARRAY, jdbcTypeName = ARL_TYP_ARRAY_TRABBASICDETL_CT, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputListHandler, mode = IN},\n"
            + "#{parametros.ipCentroTrabcodigo, jdbcType = ARRAY, jdbcTypeName = ARL_TYP_ARRAY_CNTROTRABCOD_CT, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputListHandler, mode = IN},\n"
            + "#{parametros.opTotalTrabajadores, jdbcType = INTEGER, mode = OUT},\n"
            + "#{parametros.opNumeropoliza, jdbcType = NUMERIC, mode = OUT},\n"
            + "#{parametros.opFechapoliza, jdbcType = VARCHAR, mode = OUT},\n"
            + "#{parametros.ipValidacion, jdbcType = VARCHAR, mode = IN},\n"
            + "#{parametros.ipProceso, jdbcType = STRUCT, jdbcTypeName = SIM_TYP_PROCESO, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
            + "#{parametros.opResultado, jdbcType = INTEGER, mode = OUT},\n"
            + "#{parametros.opArrerrores, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT},\n"
            + "#{parametros.opTotalregistros, jdbcType = INTEGER, mode = INOUT},\n"
            + "#{parametros.ipPaginaInicio, jdbcType = INTEGER, mode = IN},\n"
            + "#{parametros.ipPaginaFin, jdbcType = INTEGER, mode = IN}\n"
            + ")}")
    @Options(statementType = StatementType.CALLABLE)
    void prcContarTrabajadores(@Param("parametros") ConsultaTrabajadoresParamsDTO parametros);
}
