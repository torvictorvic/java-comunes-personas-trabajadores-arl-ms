package com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.RetiroTrabajadorDependienteParamDTO;

@Mapper
public interface PrcProcExcluirRepository {
	@Select(value = "{call ARL_PCK_EXCLSION_TRBJ_DPNDTES.PROC_EXCLUIR("
			+ "#{parametros.ipParametros, jdbcType = STRUCT, jdbcTypeName = ARL_TYP_EXCL_TRBJ_DPTES, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
			+ "#{parametros.opRespEjecuc, jdbcType = STRUCT, jdbcTypeName = ARL_TYP_EXCL_TRBJ_DPTES_R, typeHandler = com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers.ArlTypExclTrbjDptesRHandler, mode = OUT},\n"
			+ "#{parametros.ipValidacion, jdbcType = VARCHAR, mode = IN},\n"
			+ "#{parametros.ipProceso, jdbcType = STRUCT, jdbcTypeName = SIM_TYP_PROCESO, typeHandler = com.xxxxxxxx.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
			+ "#{parametros.opResultado, jdbcType = INTEGER, mode = OUT},\n"
			+ "#{parametros.opArrerrores, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	void prcExcluirTrabajador(@Param("parametros") RetiroTrabajadorDependienteParamDTO parametros);
}
