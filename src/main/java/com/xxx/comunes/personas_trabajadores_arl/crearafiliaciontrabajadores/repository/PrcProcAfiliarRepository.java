package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.ProcAfiliarParamsDTO;

@Mapper
public interface PrcProcAfiliarRepository {
	@Select(value = "{call ARL_PCK_TRABAJADORES.PROC_AFILIAR("
			+ "#{params.ipDatos, jdbcType = STRUCT, jdbcTypeName = ARL_TYP_DATOS_TRBJDOR, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
			+ "#{params.ipTipocot, jdbcType = STRUCT, jdbcTypeName = ARL_TYP_INGRSO_TRBJ_TIPOCOT, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
			+ "#{params.opSalida, jdbcType = STRUCT, jdbcTypeName = ARL_TYP_TRBJ_SAL, typeHandler = com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.handlers.ArlTypTrbjSalHandler, mode = OUT},\n"
			+ "#{params.ipValidacion, jdbcType = VARCHAR, mode = IN},\n"
			+ "#{params.ipProceso, jdbcType = STRUCT, jdbcTypeName = SIM_TYP_PROCESO, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
			+ "#{params.opResultado, jdbcType = INTEGER, mode = OUT},\n"
			+ "#{params.opArrerrores, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	void procAfiliarTrabajador(@Param("params") ProcAfiliarParamsDTO params);
}
