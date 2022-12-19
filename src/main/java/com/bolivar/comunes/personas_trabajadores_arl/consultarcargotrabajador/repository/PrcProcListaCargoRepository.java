package com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.repository;

import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.ConsultaListaCargoTrabajadorParamDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
/**
 * Lorgiam Arce
 * 17 03 2022
 * mapeo procedimiento para consulta cargo del trabajador
 */
@Mapper
public interface PrcProcListaCargoRepository {
    @Select(value = "{call ARL_PCK_LISTAS.Proc_Listacargo("
            + "#{parametros.ipCodigo, jdbcType = INTEGER, mode = IN},\n"
            + "#{parametros.ipSearchString, jdbcType = VARCHAR, mode = IN},\n"
            + "#{parametros.opArrLista, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_LISTA, typeHandler = com.bolivar.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayListaHandler, mode = OUT},\n"
            + "#{parametros.ipValidacion, jdbcType = VARCHAR, mode = IN},\n"
            + "#{parametros.ipProceso, jdbcType = STRUCT, jdbcTypeName = SIM_TYP_PROCESO, typeHandler = com.bolivar.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
            + "#{parametros.opResultado, jdbcType = INTEGER, mode = OUT},\n"
            + "#{parametros.opArrerrores, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.bolivar.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT}"
            + ")}")
    @Options(statementType = StatementType.CALLABLE)
    void prcConsultaListaCargo(@Param("parametros") ConsultaListaCargoTrabajadorParamDTO parametros);
}