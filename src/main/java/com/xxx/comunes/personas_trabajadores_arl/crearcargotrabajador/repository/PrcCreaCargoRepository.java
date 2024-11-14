package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.repository;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.dto.CreaCargoTrabajadorParamDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

/**
 * Lorgiam Arce
 * 19 03 2022
 * mapeo procedimiento para crear cargo del trabajador
 */
@Mapper
public interface PrcCreaCargoRepository {
    @Select(value = "{call ARL_PCK_INGRSO_TRBJ_DPNDTES.Crea_Cargo("
            + "#{parametros.pDescCargo, jdbcType = VARCHAR, mode = IN},\n"
            + "#{parametros.pCodCargo, jdbcType = INTEGER, mode = OUT},\n"
            + "#{parametros.pSeccion, jdbcType = VARCHAR, mode = OUT},\n"
            + "#{parametros.pObs, jdbcType = VARCHAR, mode = OUT},\n"
            + "#{parametros.ipValidacion, jdbcType = VARCHAR, mode = IN},\n"
            + "#{parametros.ipProceso, jdbcType = STRUCT, jdbcTypeName = SIM_TYP_PROCESO, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
            + "#{parametros.opResultado, jdbcType = INTEGER, mode = OUT},\n"
            + "#{parametros.opArrerrores, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT}"
            + ")}")
    @Options(statementType = StatementType.CALLABLE)
    void prcCreaCargoRepository(@Param("parametros")CreaCargoTrabajadorParamDTO parametros);

}
