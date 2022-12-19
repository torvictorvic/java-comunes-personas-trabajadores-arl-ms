package com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.services;

import java.math.BigDecimal;

import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.models.RetirarTrabajadorDependienteRequest;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.models.RetirarTrabajadorDependienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.CabecerasUtils;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.ManejoErroresUtils;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.RetiroTrabajadorDataDTO;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.RetiroTrabajadorDependienteParamDTO;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.TrabajadorDTO;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.database.ArlTypExclTrbjDptes;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorRequestDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorResponseDTO;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.repository.PrcProcExcluirRepository;
import com.bolivar.error.handling.constants.TipoErrorEnum;
import com.bolivar.error.handling.exception.BolivarBusinessException;

@Service
public class RetirarTrabajadorDependienteServiceImpl implements RetirarTrabajadorDependienteService {

	@Autowired
	PrcProcExcluirRepository repositorio;

	@Override
	public RetirarTrabajadorDependienteResponse retirarTrabajador(RetirarTrabajadorDependienteRequest informacion) {
		RetiroTrabajadorDependienteParamDTO parametros = RetiroTrabajadorDependienteParamDTO.builder()
				.ipParametros(mapearDatosTrabajador(informacion.getTrabajador())).ipValidacion("REFPORTARL")
				.ipProceso(mapearDatosProceso(informacion.getTrabajador())).build();

		repositorio.prcExcluirTrabajador(parametros);

		return validarResultado(parametros);
	}

	private RetirarTrabajadorDependienteResponse validarResultado(RetiroTrabajadorDependienteParamDTO resultado) {
		if (resultado.getOpResultado() != 0) {
			throw BolivarBusinessException.builder().codigo("EBD01").categoria(TipoErrorEnum.NEGOCIO)
					.mensaje("Error al retirar el trabajador")
					.errores(ManejoErroresUtils.mapeoErrores(resultado.getOpArrerrores(), "RetiroTrabajador")).build();
		} else {
			return RetirarTrabajadorDependienteResponse.builder().dataHeader(CabecerasUtils.generarCabeceraCorrecta())
					.data(RetiroTrabajadorDataDTO.builder().resultado(resultado.getOpRespEjecuc()).build())
					.build();
		}

	}

	private ArlTypExclTrbjDptes mapearDatosTrabajador(TrabajadorDTO trabajador) {
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
