package com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.repository;

import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.ConsultaAfiliacionTrabajadorParamDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface PrcProcConsultarRepository {
    @Select(value = "{call ARL_PCK_TRABAJADORES.PROC_CONSULTAR("
            + "#{parametros.ipParametros, jdbcType = STRUCT, jdbcTypeName = ARL_TYP_EXCL_TRBJ_DPTES_CP, typeHandler = com.bolivar.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
            + "#{parametros.opArrSalida, jdbcType = ARRAY, jdbcTypeName = ARL_TYP_TBL_EXCL_TRBJ_DPTES_CR, typeHandler = com.bolivar.comunes.personas_trabajadores_arl.commons.handlers.ArlTypTblExclTrbjDptesCrHandler, mode = OUT},\n"
            + "#{parametros.ipValidacion, jdbcType = VARCHAR, mode = IN},\n"
            + "#{parametros.ipProceso, jdbcType = STRUCT, jdbcTypeName = SIM_TYP_PROCESO, typeHandler = com.bolivar.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
            + "#{parametros.opResultado, jdbcType = INTEGER, mode = OUT},\n"
            + "#{parametros.opArrerrores, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.bolivar.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT}"
            + ")}")
    @Options(statementType = StatementType.CALLABLE)
    void prcConsultarTrabajador(@Param("parametros") ConsultaAfiliacionTrabajadorParamDTO parametros);
}
