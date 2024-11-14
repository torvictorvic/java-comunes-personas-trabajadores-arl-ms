package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.services.impl;

import static org.mockito.Mockito.doAnswer;

import java.math.BigDecimal;
import java.util.Collections;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.services.CrearAfiliacionTrabajadoresServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.ProcAfiliarParamsDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypDatosTrbjdor;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypIngrsoTrbjTipocot;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypTrbjSal;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresResponse;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.repository.PrcProcAfiliarRepository;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class CrearAfiliacionTrabajadoresServiceImplTest {
	@Mock
	PrcProcAfiliarRepository repositorio;

	@InjectMocks
	CrearAfiliacionTrabajadoresServiceImpl servicio;
	
	private final String CONTENIDO_GENERAL = "{\"datosTrabajador\":{\"grupocotizante\":1,\"tipocotizante\":1,\"trbjdortipoidentificacion\":\"CC\",\"trbjdornumeroidentificacion\":1073520770,\"empresadptocodigo\":14,\"empresaciudadcodigo\":0,\"trabajadorcentrotrabajo\":1,\"fechaingreso\":\"2022-03-22 15:53:00\",\"trbjdorcodigocargo\":50548,\"trbjdoringresomensual\":8000000,\"trbjdorepscodigo\":17,\"trbjdorafpcodigo\":2,\"trbjdorfechainiciocobertura\":\"2022-03-22 15:53:00\",\"usuarioconectado\":\"79625048\",\"trbjdorformapago\":2,\"trbjdormodalidad\":1,\"localidad\":\"Fuera de Bogotá\",\"zona\":\"Fuera de Bogotá\",\"codigoJornada\":1},\"tipoCotizante\":{\"trabajadorTipoCotizante\":\"1\"},\"datosProceso\":{\"p_COD_CIA\":2,\"p_COD_SECC\":70,\"p_COD_PRODUCTO\":722,\"p_COD_USR\":79625048,\"p_INFO1\":\"NT\",\"p_INFO2\":\"860036081\",\"p_INFO3\":\"1000387288016\",\"p_INFO4\":\"39744845698\"}}";
	private final String JSON_TRABAJADOR = "{\"grupocotizante\":1,\"tipocotizante\":1,\"trbjdortipoidentificacion\":\"CC\",\"trbjdornumeroidentificacion\":1073520770,\"empresadptocodigo\":14,\"empresaciudadcodigo\":0,\"trabajadorcentrotrabajo\":1,\"fechaingreso\":\"2022-03-22 15:53:00\",\"trbjdorcodigocargo\":50548,\"trbjdoringresomensual\":8000000,\"trbjdorepscodigo\":17,\"trbjdorafpcodigo\":2,\"trbjdorfechainiciocobertura\":\"2022-03-22 15:53:00\",\"usuarioconectado\":\"79625048\",\"trbjdorformapago\":2,\"trbjdormodalidad\":1,\"localidad\":\"Fuera de Bogotá\",\"zona\":\"Fuera de Bogotá\",\"codigoJornada\":1}";
	private final String JSON_TIPO_COT = "{\"trabajadorTipoCotizante\":\"1\"}";
	private final String JSON_IP_PROCESO = "{\"p_COD_CIA\":2,\"p_COD_SECC\":70,\"p_COD_PRODUCTO\":722,\"p_COD_USR\":79625048,\"p_INFO1\":\"NT\",\"p_INFO2\":\"860036081\",\"p_INFO3\":\"1000387288016\",\"p_INFO4\":\"39744845698\"}";

	@Test
	void debeRetornarRespuestaCorrectaSiBDRespondeCero() throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		CrearAfiliacionTrabajadoresRequest peticion = om.readValue(CONTENIDO_GENERAL, CrearAfiliacionTrabajadoresRequest.class);
		ArlTypDatosTrbjdor trabajadorStub = om.readValue(JSON_TRABAJADOR, ArlTypDatosTrbjdor.class);
		ArlTypIngrsoTrbjTipocot tipoCotStub = om.readValue(JSON_TIPO_COT, ArlTypIngrsoTrbjTipocot.class);
		SimTypProceso procesoStub = om.readValue(JSON_IP_PROCESO, SimTypProceso.class);
		ProcAfiliarParamsDTO parametros = ProcAfiliarParamsDTO.builder().ipDatos(trabajadorStub).ipTipocot(tipoCotStub)
				.ipProceso(procesoStub).ipValidacion("REFPORTARL").build();

		doAnswer(i -> {
			ProcAfiliarParamsDTO argumento = i.getArgument(0);
			argumento.setOpResultado(0);
			argumento.setOpArrerrores(Collections.emptyList());
			argumento.setOpSalida(
					ArlTypTrbjSal.builder().empresanumeroidentificacion(BigDecimal.valueOf(860036081)).build());
			return null;
		}).when(repositorio).procAfiliarTrabajador(parametros);

		CrearAfiliacionTrabajadoresResponse respuesta = servicio.afiliarTrabajador(peticion);
		Assertions.assertEquals(0, respuesta.getDataHeader().getCodRespuesta());
		Assertions.assertEquals(BigDecimal.valueOf(860036081),
				respuesta.getData().getRespuesta().getEmpresanumeroidentificacion());
	}

	@Test
	void debeLanzarExcepcionSiBDNoRespondeCero() throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		CrearAfiliacionTrabajadoresRequest peticion = om.readValue(CONTENIDO_GENERAL, CrearAfiliacionTrabajadoresRequest.class);
		ArlTypDatosTrbjdor trabajadorStub = om.readValue(JSON_TRABAJADOR, ArlTypDatosTrbjdor.class);
		ArlTypIngrsoTrbjTipocot tipoCotStub = om.readValue(JSON_TIPO_COT, ArlTypIngrsoTrbjTipocot.class);
		SimTypProceso procesoStub = om.readValue(JSON_IP_PROCESO, SimTypProceso.class);
		ProcAfiliarParamsDTO parametros = ProcAfiliarParamsDTO.builder().ipDatos(trabajadorStub).ipTipocot(tipoCotStub)
				.ipProceso(procesoStub).ipValidacion("REFPORTARL").build();

		doAnswer(i -> {
			ProcAfiliarParamsDTO argumento = i.getArgument(0);
			argumento.setOpResultado(-1);
			argumento.setOpArrerrores(Collections.singletonList(SimTypError.builder().descError("Error gracioso")
					.idError(BigDecimal.valueOf(-1)).tipoError("E").build()));
			argumento.setOpSalida(
					ArlTypTrbjSal.builder().empresanumeroidentificacion(BigDecimal.valueOf(860036081)).build());
			return null;
		}).when(repositorio).procAfiliarTrabajador(parametros);

		Assertions.assertThrows(BolivarBusinessException.class, () -> {
			servicio.afiliarTrabajador(peticion);
		});
	}

}
