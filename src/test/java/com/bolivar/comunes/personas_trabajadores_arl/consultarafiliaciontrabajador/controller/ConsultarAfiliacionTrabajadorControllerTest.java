package com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Collections;

import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models.ConsultarAfiliacionTrabajadorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.ConsultaAfiliacionTrabajadorDataDTO;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.models.ConsultarAfiliacionTrabajadorRequest;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.services.ConsultarAfiliacionTrabajadorServiceImpl;

@WebMvcTest(ConsultarAfiliacionTrabajadorController.class)
class ConsultarAfiliacionTrabajadorControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
    ConsultarAfiliacionTrabajadorServiceImpl servicio;

	@Test
	void debeRetornarResultadoCorrectoalConsultarlaAfiliacion() throws Exception {
		ConsultarAfiliacionTrabajadorRequest peticion = ConsultarAfiliacionTrabajadorRequest.builder()
				.tipoDocEmpresa("NT").numDocEmpresa("123456").numDocTrabajador(BigDecimal.valueOf(1116287650L))
				.tipoDocTrabajador("CC").centroTrabajo(BigDecimal.ONE).numeroPoliza("8796654").numSecuPoliza("12688")
				.codCia(2).codSec(70).codProd(722).codUsr("166892").build();
		when(servicio.consultaAfiliacionTrabajador(peticion)).thenReturn(ConsultarAfiliacionTrabajadorResponse.builder()
				.dataHeader(DataHeaderDTO.builder().codRespuesta(0).errores(Collections.emptyList()).build())
				.data(ConsultaAfiliacionTrabajadorDataDTO.builder().afiliaciones(Collections.emptyList()).build())
				.build());
		mockMvc.perform(get("/api/v1/empresas/afiliaciones").param("tipodoc", "CC").param("numdoc", "1116287650")
				.param("tipodocempresa", "NT").param("numdocempresa", "123456").param("centrotrabajo", "1")
				.param("numpoliza", "8796654").param("numsecpoliza", "12688").param("codcia", "2")
				.param("codsecc", "70").param("codprod", "722").param("codusr", "166892")
				.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.dataHeader.codRespuesta").value("0"));
	}
}
