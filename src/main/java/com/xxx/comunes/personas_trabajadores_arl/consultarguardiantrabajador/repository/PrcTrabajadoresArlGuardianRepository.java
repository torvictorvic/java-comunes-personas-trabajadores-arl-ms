package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarguardiantrabajador.repository;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarguardiantrabajador.dto.ProcConsultarTrabajadorParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface PrcTrabajadoresArlGuardianRepository {
    /**
     * Se define de esta forma la operacion que realiza el llamado al procedimiento prc_trabajadores_arl_guardian
     * del paquete SIM_PCK_EXTRAC_INFOGUARDIAN ubicado en la Base de datos de TRONADOR.
     */

    @Select(value = "{call SIM_PCK_EXTRAC_INFOGUARDIAN.prc_trabajadores_arl_guardian(\n" +
            "   #{procConsultasTrabajadorParams.ipIdenvio             , jdbcType = VARCHAR , mode = IN                              },\n" +
            "   #{procConsultasTrabajadorParams.poTrabajadores        , jdbcType = ARRAY   , jdbcTypeName = SIM_ARRAY_ARL_TRABAJADORES, typeHandler = com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers.SimTypArlTrabajadorHandler, mode = OUT},\n" +
            "   #{procConsultasTrabajadorParams.ipValidacion          , jdbcType = VARCHAR , mode = IN},\n" +
            "   #{procConsultasTrabajadorParams.nroDocumto            , jdbcType = NUMERIC , mode = IN},\n" +
            "   #{procConsultasTrabajadorParams.operation             , jdbcType = VARCHAR , mode = IN},\n" +
            "   #{procConsultasTrabajadorParams.ipProceso             , jdbcType = STRUCT  , jdbcTypeName = SIM_TYP_PROCESO         , typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n" +
            "   #{procConsultasTrabajadorParams.opResultado           , jdbcType = NUMERIC , mode = OUT                             },\n" +
            "   #{procConsultasTrabajadorParams.opArrErrores          , jdbcType = ARRAY   , jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT}\n" +
            "   )}"
    )
    @Options(statementType = StatementType.CALLABLE)
    void ejecutarProcConsultasTrabajador(@Param("procConsultasTrabajadorParams") ProcConsultarTrabajadorParams procConsultasTrabajadorParams);
}
