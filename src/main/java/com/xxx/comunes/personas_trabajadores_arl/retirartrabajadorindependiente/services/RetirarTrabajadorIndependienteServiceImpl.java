package com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadorindependiente.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.utils.CabecerasUtils;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.utils.ManejoErroresUtils;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.RetiroTrabajadorDataDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.RetiroTrabajadorDependienteParamDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.TrabajadorDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.database.ArlTypExclTrbjDptes;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorRequestDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorResponseDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadorindependiente.repository.PrcExcluirTrabIndRepository;
import com.xxxxxxxx.error.handling.constants.TipoErrorEnum;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;

@Service
public class RetirarTrabajadorIndependienteServiceImpl implements RetirarTrabajadorIndependienteService {

	@Autowired
	PrcExcluirTrabIndRepository repositorio;

	@Override
	public RetiroTrabajadorResponseDTO retirarTrabajadorIndependiente(
			RetiroTrabajadorRequestDTO informacion) {
		RetiroTrabajadorDependienteParamDTO parametros = RetiroTrabajadorDependienteParamDTO.builder()
				.ipParametros(mapearDatosTrabajadorIndependiente(informacion.getTrabajador()))
				.ipValidacion("REFPORTARL").ipProceso(mapearDatosProceso(informacion.getTrabajador())).build();

		repositorio.prcExcluirTrabajadorIndependiente(parametros);

		return validarResultado(parametros);
	}

	private RetiroTrabajadorResponseDTO validarResultado(RetiroTrabajadorDependienteParamDTO resultado) {
		if (resultado.getOpResultado() != 0) {
			throw BolivarBusinessException.builder().codigo("EBD01").categoria(TipoErrorEnum.NEGOCIO)
					.mensaje("Error al retirar el trabajador")
					.errores(ManejoErroresUtils.mapeoErrores(resultado.getOpArrerrores(), "Trabajador")).build();
		} else {
			return RetiroTrabajadorResponseDTO.builder().dataHeader(CabecerasUtils.generarCabeceraCorrecta())
					.data(RetiroTrabajadorDataDTO.builder().resultado(resultado.getOpRespEjecuc()).build())
					.build();
		}
	}

	private ArlTypExclTrbjDptes mapearDatosTrabajadorIndependiente(TrabajadorDTO trabajador) {
		return ArlTypExclTrbjDptes.builder().trabajadorNovedadFechaRetiro(trabajador.getFechaRetiroTrabajador())
				.fechaIngresoTrabajador(trabajador.getFechaIngreso())
				.trabajadorCentroTrabajo(BigDecimal.valueOf(trabajador.getCentroTrabajo()))
				.trabajadorNumeroIdentificacion(BigDecimal.valueOf(trabajador.getNumeroIdentificacion()))
				.dptoLabora(trabajador.getDepartamentoLabora()).muniLabora(trabajador.getMunicipioLabora())
				.trabajadorTipoCotizante(trabajador.getTipoCotizante())
				.trabajadorTipoIdentificacion(trabajador.getTipoIdentificacion()).sexo(trabajador.getSexo())
				.pmcaAcptaConds(trabajador.getAceptaCondiciones()).build();
	}

	private SimTypProceso mapearDatosProceso(TrabajadorDTO trabajador) {
		return SimTypProceso.builder().p_COD_CIA(trabajador.getCompania()).p_COD_SECC(trabajador.getSeccion())
				.p_COD_PRODUCTO(trabajador.getProducto()).p_SISTEMA_ORIGEN(trabajador.getSistemaOrigen())
				.p_COD_USR(trabajador.getUsuarioTransaccion()).p_INFO3(trabajador.getNumeroPoliza().toString()).build();
	}
}
