package com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ConsultaTrabajadoresParamsDTO;

@Mapper
public interface PrcProcConsultaTrabajadoresOrdnRepository {
	@Select(value = "{call ARL_PCK_CONSULTA_TRAB_PAG_OPT.Proc_Consultatrabajadores_Ordn("
			+ "#{parametros.ipArrayParametros, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_LISTA, typeHandler = com.bolivar.mybatis.util.core.handler.InputListHandler, mode = IN},\n"
			+ "#{parametros.ipTrabajadoresdetalles, jdbcType = ARRAY, jdbcTypeName = ARL_TYP_ARRAY_TRABBASICDETL_CT, typeHandler = com.bolivar.mybatis.util.core.handler.InputListHandler, mode = IN},\n"
			+ "#{parametros.ipCentroTrabcodigo, jdbcType = ARRAY, jdbcTypeName = ARL_TYP_ARRAY_CNTROTRABCOD_CT, typeHandler = com.bolivar.mybatis.util.core.handler.InputListHandler, mode = IN},\n"
			+ "#{parametros.opArraydatostrabajadores, jdbcType = ARRAY, jdbcTypeName = ARL_TYP_ARRAY_CONSTRBJADORS_CT, typeHandler = com.bolivar.comunes.personas_trabajadores_arl.commons.handlers.ArlTypArrayConstrbjadorsCtHandler, mode = OUT},\n"
			+ "#{parametros.opNumeropoliza, jdbcType = NUMERIC, mode = OUT},\n"
			+ "#{parametros.opFechapoliza, jdbcType = VARCHAR, mode = OUT},\n"
			+ "#{parametros.ipValidacion, jdbcType = VARCHAR, mode = IN},\n"
			+ "#{parametros.ipProceso, jdbcType = STRUCT, jdbcTypeName = SIM_TYP_PROCESO, typeHandler = com.bolivar.mybatis.util.core.handler.InputTypeHandler, mode = IN},\n"
			+ "#{parametros.opResultado, jdbcType = INTEGER, mode = OUT},\n"
			+ "#{parametros.opArrerrores, jdbcType = ARRAY, jdbcTypeName = SIM_TYP_ARRAY_ERROR, typeHandler = com.bolivar.comunes.personas_trabajadores_arl.commons.handlers.SimTypArrayErrorHandler, mode = OUT},\n"
			+ "#{parametros.opTotalregistros, jdbcType = INTEGER, mode = INOUT},\n"
			+ "#{parametros.ipPaginaInicio, jdbcType = INTEGER, mode = IN},\n"
			+ "#{parametros.ipPaginaFin, jdbcType = INTEGER, mode = IN}\n"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE, flushCache = Options.FlushCachePolicy.TRUE)
	void prcConsultarTrabajadores(@Param("parametros") ConsultaTrabajadoresParamsDTO parametros);
}
