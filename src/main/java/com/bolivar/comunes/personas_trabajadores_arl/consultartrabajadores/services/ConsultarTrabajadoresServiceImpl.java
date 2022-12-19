package com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.utils.Direccion;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.utils.OrdenarPor;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.repository.PrcProcContarTrabajadoresRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.ErrorDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLista;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.CabecerasUtils;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.ConsultarTrabajadoresDataResponseDTO;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ArlTypArrayCntrotrabcodCt;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ArlTypArrayTrabbasicdetlCt;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ArlTypCentrotrabcodigoCt;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ArlTypTrabbasicodetalCt;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ConsultaTrabajadoresParamsDTO;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.SimTypArrayLista;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.models.ConsultarTrabajadoresRequest;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.models.ConsultarTrabajadoresResponse;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.repository.PrcProcConsultaTrabajadoresOrdnRepository;

@Service
@Slf4j
public class ConsultarTrabajadoresServiceImpl implements ConsultarTrabajadoresService {

	@Autowired
    PrcProcConsultaTrabajadoresOrdnRepository repositorio;

	@Autowired
	PrcProcContarTrabajadoresRepository repositorioContar;

	@Override
	public ConsultarTrabajadoresResponse consultarTrabajadores(ConsultarTrabajadoresRequest peticion) {

		List<SimTypLista> parametrosBusqueda = new ArrayList<>();
		validacionEntrada(peticion, parametrosBusqueda);
		validacionRequest(peticion, parametrosBusqueda);

		ConsultaTrabajadoresParamsDTO parametrosPL = ConsultaTrabajadoresParamsDTO.builder()
				.ipArrayParametros(SimTypArrayLista.builder().simTypLista(parametrosBusqueda).build())
				.ipTrabajadoresdetalles(ArlTypArrayTrabbasicdetlCt.builder()
						.detalle(Collections.singletonList(validacionConsultaTrabajador(peticion))).build())
				.ipCentroTrabcodigo(
						ArlTypArrayCntrotrabcodCt.builder().codigosCentros(validacionCentrosTrabajo(peticion)).build())
				.ipProceso(construccionIpProceso(peticion)).ipPaginaInicio(peticion.getPaginaInicio()).ipPaginaFin(peticion.getPaginaFin()).ipValidacion("REFACTORING")
				.build();

		if(peticion.getSoloCalcular().equals(true)) {
			repositorioContar.prcContarTrabajadores(parametrosPL);
		} else {
			repositorio.prcConsultarTrabajadores(parametrosPL);
		}

		if (parametrosPL.getOpResultado() == 0) {
			return ConsultarTrabajadoresResponse.builder().dataHeader(CabecerasUtils.generarCabeceraCorrecta())
					.data(ConsultarTrabajadoresDataResponseDTO.builder()
							.trabajadores(parametrosPL.getOpArraydatostrabajadores())
							.numeroPoliza(parametrosPL.getOpNumeropoliza().longValue())
							.fechaPoliza(parametrosPL.getOpFechapoliza())
							.totalRegistros(parametrosPL.getOpTotalTrabajadores() != null ? parametrosPL.getOpTotalTrabajadores().longValue(): null).build())
					.build();
		} else {
			ConsultarTrabajadoresResponse consultarTrabajadoresResponse = ConsultarTrabajadoresResponse.builder()
					.dataHeader(DataHeaderDTO.builder().codRespuesta(parametrosPL.getOpResultado())
							.errores(parametrosPL.getOpArrerrores().stream()
									.map(error -> ErrorDTO.builder().idError(error.getIdError().intValue())
											.descError(error.getDescError()).tipoError(error.getTipoError()).build())
									.collect(Collectors.toList()))
							.build())
					.build();
			log.warn(consultarTrabajadoresResponse.toString());
			return consultarTrabajadoresResponse;
		}
	}

	public void validacionEntrada(ConsultarTrabajadoresRequest peticion, List<SimTypLista> parametrosBusqueda) {
		if (peticion.getEstado() != null && !peticion.getEstado().isBlank() && !peticion.getEstado().isEmpty()) {
			SimTypLista estado = new SimTypLista();
			estado.setCodigo("ID_ESTADO");
			estado.setValor(peticion.getEstado());
			parametrosBusqueda.add(estado);
		}
		if (peticion.getFecIngresoDesde() != null && !peticion.getFecIngresoDesde().isBlank()
				&& !peticion.getFecIngresoDesde().isEmpty()) {
			SimTypLista fechaIngresoDesde = SimTypLista.builder().codigo("ID_FECHA_INGRESO_DESDE_EX")
					.valor(peticion.getFecIngresoDesde()).build();
			parametrosBusqueda.add(fechaIngresoDesde);
		}
		if (peticion.getFecIngresoHasta() != null && !peticion.getFecIngresoHasta().isBlank()
				&& !peticion.getFecIngresoHasta().isEmpty()) {
			SimTypLista fechaIngresoHasta = SimTypLista.builder().codigo("ID_FECHA_INGRESO_HASTA_EX")
					.valor(peticion.getFecIngresoHasta()).build();
			parametrosBusqueda.add(fechaIngresoHasta);
		}
	}

	public void validacionRequest(ConsultarTrabajadoresRequest peticion, List<SimTypLista> parametrosBusqueda) {
		if (peticion.getTipoCotizante() != null && !peticion.getTipoCotizante().isBlank()
				&& !peticion.getTipoCotizante().isEmpty()) {
			SimTypLista tipoCotizante = SimTypLista.builder().codigo("ID_DEPEND_INDEPEN")
					.valor(peticion.getTipoCotizante()).build();
			parametrosBusqueda.add(tipoCotizante);
		}
		if(peticion.getOrdenarPor() != null) {
			if(!getOrdenarPor(peticion.getOrdenarPor()).isEmpty() && !getOrdenarPor(peticion.getOrdenarPor()).isBlank()){
				SimTypLista ordenarPor = SimTypLista.builder().codigo("ID_ORDENAR_POR")
						.valor(getOrdenarPor(peticion.getOrdenarPor())).build();
				parametrosBusqueda.add(ordenarPor);
			}
		}
		if(peticion.getDireccion() != null) {
			if(!getDireccion(peticion.getDireccion()).isEmpty() && !getDireccion(peticion.getDireccion()).isBlank()){
				SimTypLista direccion = SimTypLista.builder().codigo("ID_DIRECCION")
						.valor(getDireccion(peticion.getDireccion())).build();
				parametrosBusqueda.add(direccion);
			}
		}if(peticion.getCriterioFiltrado() != null && !peticion.getCriterioFiltrado().isBlank()
				&& !peticion.getCriterioFiltrado().isEmpty()){
			SimTypLista criterioFiltrado = SimTypLista.builder().codigo("ID_CRITERIO_FILTRADO").
					valor(peticion.getCriterioFiltrado()).build();
			parametrosBusqueda.add(criterioFiltrado);
		}
	}

	public ArlTypTrabbasicodetalCt validacionConsultaTrabajador(ConsultarTrabajadoresRequest peticion) {
		if (peticion.getNumeroDocumentoTrabajador() != null && peticion.getTipoDocumentoTrabajador() != null) {
			return ArlTypTrabbasicodetalCt.builder()
					.numeroDocumento(BigDecimal.valueOf(peticion.getNumeroDocumentoTrabajador()))
					.tipoDocumento(peticion.getTipoDocumentoTrabajador()).build();
		} else {
			return null;
		}
	}

	public List<ArlTypCentrotrabcodigoCt> validacionCentrosTrabajo(ConsultarTrabajadoresRequest peticion) {
		if (peticion.getCodigosCentrosTrabajo() != null) {
			return peticion.getCodigosCentrosTrabajo().stream()
					.map(numero -> ArlTypCentrotrabcodigoCt.builder().centroTrabCodigo(numero).build())
					.collect(Collectors.toList());
		} else {
			return Collections.emptyList();
		}
	}

	public SimTypProceso construccionIpProceso(ConsultarTrabajadoresRequest peticion) {
		return SimTypProceso.builder().p_COD_CIA(peticion.getCompania()).p_COD_SECC(peticion.getSeccion())
				.p_COD_PRODUCTO(peticion.getProducto()).p_COD_USR(peticion.getCodUsr())
				.p_INFO1(peticion.getTipoDocumentoEmpresa()).p_INFO2(peticion.getNumeroDocumentoEmpresa() + "")
				.p_INFO3(peticion.getNumPol() + "").p_INFO4(peticion.getNumSecuPol() + "")
				.p_INFO5(peticion.getNivelSupervision() + "").build();
	}

	public String getOrdenarPor(Integer value) {
		switch (value) {
			case 1: {
				return OrdenarPor.DOCTIPO.value();
			}
			case 2: {
				return OrdenarPor.NIT.value();
			}
			case 3: {
				return OrdenarPor.DESCTIPOCOTIZANTE.value();
			}
			case 4: {
				return OrdenarPor.DESCENTROTRABAJO.value();
			}
			case 5: {
				return OrdenarPor.INICOBERTURA.value();
			}
			case 6: {
				return OrdenarPor.FINCOBERTURA.value();
			}
			case 7: {
				return OrdenarPor.ESTADO.value();
			}
			default:{
				return "";
			}
		}
	}

	public String getDireccion(Integer value){
		switch (value) {
			case 1: {
				return Direccion.ASC.value();
			}
			case 2: {
				return Direccion.DESC.value();
			}
			default:{
				return "";
			}
		}
	}
}
