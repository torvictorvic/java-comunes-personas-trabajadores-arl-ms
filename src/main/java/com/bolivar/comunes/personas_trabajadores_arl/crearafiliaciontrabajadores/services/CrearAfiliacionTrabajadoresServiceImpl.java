package com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.ProcAfiliarParamsDTO;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.AfiliacionTrabajadoresDataDTO;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresRequest;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresResponse;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.repository.PrcProcAfiliarRepository;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.CabecerasUtils;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.ManejoErroresUtils;
import com.bolivar.error.handling.constants.TipoErrorEnum;
import com.bolivar.error.handling.exception.BolivarBusinessException;

@Service
public class CrearAfiliacionTrabajadoresServiceImpl implements CrearAfiliacionTrabajadoresService {

	@Autowired
	PrcProcAfiliarRepository repositorio;

	@Override
	public CrearAfiliacionTrabajadoresResponse afiliarTrabajador(CrearAfiliacionTrabajadoresRequest peticion) {
		ProcAfiliarParamsDTO parametros = ProcAfiliarParamsDTO.builder().ipDatos(peticion.getDatosTrabajador())
				.ipProceso(peticion.getDatosProceso()).ipTipocot(peticion.getTipoCotizante()).ipValidacion("REFPORTARL")
				.build();

		repositorio.procAfiliarTrabajador(parametros);
		return validarResultado(parametros);
	}

	private CrearAfiliacionTrabajadoresResponse validarResultado(ProcAfiliarParamsDTO resultado) {
		if (resultado.getOpResultado() != 0) {
			throw BolivarBusinessException.builder().codigo("EBD01").categoria(TipoErrorEnum.NEGOCIO)
					.mensaje("Error al afiliar el trabajador")
					.errores(ManejoErroresUtils.mapeoErrores(resultado.getOpArrerrores(), "AfiliacionTrabajador")).build();
		} else {
			return CrearAfiliacionTrabajadoresResponse.builder().dataHeader(CabecerasUtils.generarCabeceraCorrecta())
					.data(AfiliacionTrabajadoresDataDTO.builder().respuesta(resultado.getOpSalida()).build()).build();
		}
	}

}
