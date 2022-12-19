package com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Collections;

import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.AfiliacionTrabajadoresDataDTO;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database.ArlTypTrbjSal;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.models.CrearAfiliacionTrabajadoresResponse;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.services.CrearAfiliacionTrabajadoresServiceImpl;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CrearAfiliacionTrabajadoresController.class)
class CrearAfiliacionTrabajadoresControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
    CrearAfiliacionTrabajadoresServiceImpl servicio;

	@Test
	void debeRetornarDatosAlAfiliarCorrectamente() throws Exception {
		String contenido = "{\"datosTrabajador\":{\"grupocotizante\":2,\"tipocotizante\":59,\"trbjdortipoidentificacion\":\"CC\",\"trbjdornumeroidentificacion\":80383989,\"empresadptocodigo\":14,\"empresaciudadcodigo\":0,\"trabajadorcentrotrabajo\":1,\"trbjdortipocontrato\":1,\"fechaingreso\":\"2022-03-23 00:00:00\",\"trbjdorcodigocargo\":50548,\"trbjdoringresomensual\":8000000,\"trbjdoribc\":7500000,\"trbjdorepscodigo\":17,\"trbjdorafpcodigo\":2,\"trbjdorfechainiciocobertura\":\"2022-03-23 03:00:00\",\"trbjdorfechafincobertura\":\"2022-04-23 03:00:00\",\"trbjdorindcdoracptcioncontrato\":\"S\",\"usuarioconectado\":\"79625048\",\"trbjdorformapago\":2,\"trbjdormodalidad\":1,\"trbjdoringresototal\":8000000,\"trbjdormcatransporte\":\"S\",\"localidad\":\"Fuera de Bogotá\",\"zona\":\"2\",\"codigoJornada\":1},\"tipoCotizante\":{\"trabajadorTipoCotizante\":\"59\"},\"datosProceso\":{\"p_COD_CIA\":2,\"p_COD_SECC\":70,\"p_COD_PRODUCTO\":722,\"p_COD_USR\":79625048,\"p_INFO1\":\"NT\",\"p_INFO2\":\"860036081\",\"p_INFO3\":\"1000387288016\",\"p_INFO4\":\"39744845698\"}}";
		ObjectMapper om = new ObjectMapper();
		CrearAfiliacionTrabajadoresRequest peticion = om.readValue(contenido, CrearAfiliacionTrabajadoresRequest.class);
		when(servicio.afiliarTrabajador(peticion)).thenReturn(CrearAfiliacionTrabajadoresResponse.builder()
				.dataHeader(DataHeaderDTO.builder().codRespuesta(0).errores(Collections.emptyList()).build())
				.data(AfiliacionTrabajadoresDataDTO.builder().respuesta(
						ArlTypTrbjSal.builder().empresanumeroidentificacion(BigDecimal.valueOf(860036081)).build())
						.build())
				.build());
		mockMvc.perform(post("/api/v1/trabajadores/estadosAfiliacion").content(contenido)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.dataHeader.codRespuesta").value("0"))
				.andExpect(jsonPath("$.data.respuesta.empresanumeroidentificacion").value("860036081"));
	}
}
