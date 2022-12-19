package com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadorindependiente.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.RetiroTrabajadorDependienteParamDTO;

@Mapper
public interface PrcExcluirTrabIndRepository {
	@Select(value = "{call ARL_PCK_EXCLSION_TRBJ_DPNDTES.PRC_EXCLUIR_TRAB_IND("
			+ "#{parametros.ipParametros, jdbcType = STRUCT, jdbcTypeName = ARL_TYP_EXCL_TRBJ_DPTES, typeHandler = com.bolivar.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
			+ "#{parametros.opRespEjecuc, jdbcType = STRUCT, jdbcTypeName = ARL_TYP_EXCL_TRBJ_DPTES_R, typeHandler = com.bolivar.comunes.personas_trabajadores_arl.commons.handlers.ArlTypExclTrbjDptesRHandler, mode = OUT},\n"
			+ "#{parametros.ipValidacion, jdbcType = VARCHAR, mode = IN},\n"
			+ "#{parametros.ipProceso, jdbcType = STRUCT, jdbcTypeName = SIM_TYP_PROCESO, typeHandler = com.bolivar.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
			+ "#{parametros.opResultado, jdbcType = INTEGER, mode = OUT},\n"
			+ "#{parametros.opArrerrores, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.bolivar.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	void prcExcluirTrabajadorIndependiente(@Param("parametros") RetiroTrabajadorDependienteParamDTO parametros);
}
