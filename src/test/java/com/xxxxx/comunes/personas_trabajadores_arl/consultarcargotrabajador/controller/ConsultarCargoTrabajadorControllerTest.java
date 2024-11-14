package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.models.ConsultarCargoTrabajadorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.ConsultaListaCargoTrabajadorDataDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.services.ConsultarCargoTrabajadorServiceImpl;

@WebMvcTest(ConsultarCargoTrabajadorController.class)
class ConsultarCargoTrabajadorControllerTest {

    @Autowired
    MockMvc mockMvc;

	@MockBean
    ConsultarCargoTrabajadorServiceImpl servicio;

    @Test
    void debeRetornarResultadoCorrectoalConsultarlosCargos() throws Exception {
        when(servicio.consultaListaCargoTrabajador(null, "ING"))
                .thenReturn(ConsultarCargoTrabajadorResponse.builder()
                        .dataHeader(DataHeaderDTO.builder()
                                .codRespuesta(0)
                                .errores(Collections.emptyList())
                                .build())
                        .data(ConsultaListaCargoTrabajadorDataDTO.builder().cargos(Collections.emptyList()).build())
                        .build());
        mockMvc.perform(get("/api/v1/cargos").param("desc","ING").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(jsonPath("$.dataHeader.codRespuesta").value("0"));
    }

}