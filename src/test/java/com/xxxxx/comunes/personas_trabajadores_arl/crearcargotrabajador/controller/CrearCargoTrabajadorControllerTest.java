package com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.controller;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.CargoDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.dto.CreaCargoTrabajadorDataDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorResponse;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.crearcargotrabajador.services.CrearCargoTrabajadorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CrearCargoTrabajadorController.class)
class CrearCargoTrabajadorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CrearCargoTrabajadorServiceImpl servicio;

    @Test
    void debeRetornarRespuestaCorrectaAlCrearElCargo() throws Exception {
        String contenido = "{\n\"cargo\":\n{\n\"descripcion\":\"INGE\"\n}\n}";
        ObjectMapper objectMapper = new ObjectMapper();
        CrearCargoTrabajadorRequest peticion = objectMapper.readValue(contenido, CrearCargoTrabajadorRequest.class);
        when(servicio.creaCargoTrabajador(peticion)).thenReturn(CrearCargoTrabajadorResponse.builder()
                .dataHeader(DataHeaderDTO.builder()
                        .errores(Collections.emptyList())
                        .codRespuesta(0)
                        .build())
                .data(CreaCargoTrabajadorDataDTO.builder().cargo(
                        CargoDTO.builder()
                                .descripcion("INGE")
                                .codigo(123)
                                .build()
                ).build())
                .build());

        mockMvc.perform(post("/api/v1/cargos").content(contenido.getBytes()).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dataHeader.codRespuesta").value("0"));

    }

}