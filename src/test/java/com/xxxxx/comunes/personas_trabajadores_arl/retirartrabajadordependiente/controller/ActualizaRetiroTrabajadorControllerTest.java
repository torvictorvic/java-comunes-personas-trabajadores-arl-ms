package com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.models.RetirarTrabajadorDependienteRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.models.RetirarTrabajadorDependienteResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorRequestDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorResponseDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.services.RetirarTrabajadorDependienteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RetirarTrabajadorDependienteController.class)
class ActualizaRetiroTrabajadorControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
    RetirarTrabajadorDependienteServiceImpl servicio;

	@Test
	void debeRetornarResultadoAlRealizarRetiroCorrecto() throws Exception {
		String contenido = "{\"trabajador\":{\"fechaRetiroTrabajador\":\"2022-03-04 00:31:20\",\"fechaNovedad\":\"2022-03-03 00:31:20\",\"fechaIngreso\":\"2022-03-03 00:31:20\",\"numeroPoliza\":2060000051526,\"centroTrabajo\":1,\"numeroIdentificacion\":1073520770,\"tipoIdentificacion\":\"CC\",\"departamentoLabora\":\"1\",\"municipioLabora\":\"11\",\"tipoCotizante\":\"1\",\"compania\":2,\"seccion\":70,\"producto\":722,\"sistemaOrigen\":1526,\"sexo\":\"M\",\"aceptaCondiciones\":\"S\",\"numeroDocumentoEmpresa\":860034313,\"tipoDocumentoEmpresa\":\"NT\",\"usuarioTransaccion\":\"1073520770\"}}";
		ObjectMapper objectMapper = new ObjectMapper();
		RetirarTrabajadorDependienteRequest peticion = objectMapper.readValue(contenido, RetirarTrabajadorDependienteRequest.class);
		when(servicio.retirarTrabajador(peticion)).thenReturn(RetirarTrabajadorDependienteResponse.builder()
				.dataHeader(DataHeaderDTO.builder().codRespuesta(0).errores(Collections.emptyList()).build()).build());
		mockMvc.perform(put("/api/v1/dependientes/estadosRetiros").content(contenido.getBytes())
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.dataHeader.codRespuesta").value("0"));
	}
}