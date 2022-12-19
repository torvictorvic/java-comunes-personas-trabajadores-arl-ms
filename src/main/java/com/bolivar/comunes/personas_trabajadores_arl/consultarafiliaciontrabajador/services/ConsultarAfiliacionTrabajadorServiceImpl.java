package com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.services;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.ErrorDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models.ConsultarAfiliacionTrabajadorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.CabecerasUtils;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.ManejoErroresUtils;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.ConsultaAfiliacionTrabajadorDataDTO;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.ConsultaAfiliacionTrabajadorParamDTO;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.database.ArlTypExclTrbjDptesCp;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models.ConsultarAfiliacionTrabajadorRequest;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.repository.PrcProcConsultarRepository;
import com.bolivar.error.handling.constants.TipoErrorEnum;
import com.bolivar.error.handling.exception.BolivarBusinessException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class ConsultarAfiliacionTrabajadorServiceImpl implements ConsultarAfiliacionTrabajadorService {

	@Autowired
	private PrcProcConsultarRepository repositorio;

	@Override
	public ConsultarAfiliacionTrabajadorResponse consultaAfiliacionTrabajador(
			ConsultarAfiliacionTrabajadorRequest peticion) {

		ArlTypExclTrbjDptesCp arlTypExclTrbjDptesCp = ArlTypExclTrbjDptesCp.builder()
				.trabajadorTipoIdentificacion(peticion.getTipoDocTrabajador())
				.trabajadorNumeroIdentificacion(peticion.getNumDocTrabajador())
				.trabajadorCentroTrabajo(peticion.getCentroTrabajo()).rangoBusquedaFechaInicial(peticion.getFecIni())
				.rangoBusquedaFechaFinal(peticion.getFecFin()).build();

		SimTypProceso simTypProceso = SimTypProceso.builder().p_COD_CIA(peticion.getCodCia())
				.p_COD_SECC(peticion.getCodSec()).p_COD_PRODUCTO(peticion.getCodProd())
				.p_INFO1(peticion.getTipoDocEmpresa()).p_INFO2(peticion.getNumDocEmpresa())
				.p_INFO3(peticion.getNumeroPoliza()).p_INFO4(peticion.getNumSecuPoliza())
				.p_COD_USR(peticion.getCodUsr()).build();

		ConsultaAfiliacionTrabajadorParamDTO consultaAfiliacionTrabajadorParamDTO = ConsultaAfiliacionTrabajadorParamDTO
				.builder().ipParametros(arlTypExclTrbjDptesCp).ipValidacion("Comunes").ipProceso(simTypProceso).build();

		repositorio.prcConsultarTrabajador(consultaAfiliacionTrabajadorParamDTO);
		return validarResultado(consultaAfiliacionTrabajadorParamDTO);

	}

	private ConsultarAfiliacionTrabajadorResponse validarResultado(ConsultaAfiliacionTrabajadorParamDTO resultado) {

		SimTypError error = resultado.getOpArrerrores().stream().filter(err -> err.getIdError().equals(new BigDecimal(10800)))
				.findFirst().orElse((SimTypError.builder().idError(new BigDecimal(0)).build()));

		if (resultado.getOpResultado() != 0  && !error.getIdError().equals(new BigDecimal(10800))) {
			throw BolivarBusinessException.builder().codigo("EBD02").categoria(TipoErrorEnum.NEGOCIO)
					.mensaje("Error al consultar las afiliaciones del trabajador").errores(ManejoErroresUtils
							.mapeoErrores(resultado.getOpArrerrores(), "ConsultaAfiliacionTrabajador"))
					.build();
		}else if (resultado.getOpResultado() != 0 && error.getIdError().equals(new BigDecimal(10800))) {
			return ConsultarAfiliacionTrabajadorResponse.builder().dataHeader(CabecerasUtils.generarCabeceraErrorControlado(List.of(ErrorDTO.builder()
							.descError(error.getDescError())
							.tipoError(error.getTipoError())
							.idError(error.getIdError().intValue())
							.build())))
					.data(ConsultaAfiliacionTrabajadorDataDTO.builder().afiliaciones(Collections.emptyList())
							.build())
					.build();
		}
		else {
			return ConsultarAfiliacionTrabajadorResponse.builder().dataHeader(CabecerasUtils.generarCabeceraCorrecta())
					.data(ConsultaAfiliacionTrabajadorDataDTO.builder().afiliaciones(resultado.getOpArrSalida())
							.build())
					.build();
		}
	}
}
