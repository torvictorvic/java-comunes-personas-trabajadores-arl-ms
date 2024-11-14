package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.services.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.services.ConsultarAfiliacionTrabajadorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.ConsultaAfiliacionTrabajadorParamDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.database.ArlTypExclTrbjDptesCp;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models.ConsultarAfiliacionTrabajadorRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models.ConsultarAfiliacionTrabajadorResponse;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.repository.PrcProcConsultarRepository;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;

@ExtendWith(MockitoExtension.class)
class ConsultarAfiliacionTrabajadorServiceImplTest {

	private ConsultarAfiliacionTrabajadorRequest peticion;

	@Mock
	private PrcProcConsultarRepository repository;

	@InjectMocks
	private ConsultarAfiliacionTrabajadorServiceImpl consultaAfiliacionTrabajadorService;

	@BeforeEach
	void configurar() {
		peticion = ConsultarAfiliacionTrabajadorRequest.builder()
				.tipoDocEmpresa("NT").numDocEmpresa("123456").numDocTrabajador(BigDecimal.valueOf(1116287650L))
				.tipoDocTrabajador("CC").centroTrabajo(BigDecimal.ONE).numeroPoliza("8796654").numSecuPoliza("12688")
				.codCia(2).codSec(70).codProd(722).codUsr("166892").build();
	}

	@Test
	void debeResponserListadeAfiliaciones() {
		Mockito.doAnswer(i -> {
			ConsultaAfiliacionTrabajadorParamDTO parametrosInternos = i.getArgument(0);
			parametrosInternos.setOpResultado(0);
			parametrosInternos.setOpArrerrores(Collections.emptyList());
			return null;
		}).when(repository).prcConsultarTrabajador(setInfo());
		ConsultarAfiliacionTrabajadorResponse respuesta = consultaAfiliacionTrabajadorService
				.consultaAfiliacionTrabajador(peticion);
		Assertions.assertEquals(0, respuesta.getDataHeader().getCodRespuesta());
	}

	@Test
	void debeResponderErrorControlado() {

		Mockito.doAnswer(i -> {
			ConsultaAfiliacionTrabajadorParamDTO parametrosInternos = i.getArgument(0);
			parametrosInternos.setOpResultado(-1);
			parametrosInternos.setOpArrerrores(List.of(SimTypError
					.builder()
							.idError(new BigDecimal(10800))
							.descError("Error")
							.tipoError("NEGOCIO")
					.build()));
			return null;
		}).when(repository).prcConsultarTrabajador(setInfo());
		ConsultarAfiliacionTrabajadorResponse respuesta = consultaAfiliacionTrabajadorService
				.consultaAfiliacionTrabajador(peticion);
		Assertions.assertEquals(-1, respuesta.getDataHeader().getCodRespuesta());
		Assertions.assertEquals(0, respuesta.getData().getAfiliaciones().size());
	}



	@Test
	void debeResponderErrorControladoBussinesBolivar() {
		Mockito.doAnswer(i -> {
			ConsultaAfiliacionTrabajadorParamDTO parametrosInternos = i.getArgument(0);
			parametrosInternos.setOpResultado(-1);
			parametrosInternos.setOpArrerrores(Collections.emptyList());
			return null;
		}).when(repository).prcConsultarTrabajador(setInfo());

		Assertions.assertThrows(BolivarBusinessException.class, () -> {
			consultaAfiliacionTrabajadorService.consultaAfiliacionTrabajador(peticion);
		});
	}

	ConsultaAfiliacionTrabajadorParamDTO setInfo() {
		ArlTypExclTrbjDptesCp ipParametros = ArlTypExclTrbjDptesCp.builder().trabajadorTipoIdentificacion("CC")
				.trabajadorNumeroIdentificacion(new BigDecimal("1116287650"))
				.trabajadorCentroTrabajo(new BigDecimal("1")).rangoBusquedaFechaInicial(null)
				.rangoBusquedaFechaFinal(null).build();

		SimTypProceso simTypProceso = SimTypProceso.builder().p_COD_CIA(2).p_COD_SECC(70).p_COD_PRODUCTO(722)
				.p_INFO1("NT").p_INFO2("123456").p_INFO3("8796654").p_INFO4("12688").p_COD_USR("166892").build();

		ConsultaAfiliacionTrabajadorParamDTO paramsDTO = ConsultaAfiliacionTrabajadorParamDTO.builder()
				.ipParametros(ipParametros).ipValidacion("Comunes").ipProceso(simTypProceso).build();

		return paramsDTO;
	}
}
