package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarguardiantrabajador.controller;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarguardiantrabajador.dto.ConsultarTrabajadorDataDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarguardiantrabajador.models.ConsultarGuardianTrabajadorResponse;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarguardiantrabajador.services.impl.ConsultarGuardianTrabajadorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

@WebMvcTest(ConsultarGuardianTrabajadorController.class)
public class ConsultarTrabajadorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ConsultarGuardianTrabajadorServiceImpl service;

    @Test
    void debeRetornarOkAlconsultasTrabajador() throws Exception{
        List<ConsultarTrabajadorDataDTO> EmpresaResponseList = new ArrayList<>();

        Mockito.when((
                        service.consultarTrabajador("2022071920220720", "S", "900106575" , "nuevo")))
                .thenReturn(ConsultarGuardianTrabajadorResponse.builder()
                        .dataHeader(DataHeaderDTO.builder()
                                .codRespuesta(0)
                                .errores(Collections.emptyList())
                                .build())
                        .data(EmpresaResponseList)
                        .build());

        mockMvc.perform(get("/api/v1/empresas/2022071920220720/S/trabajador/900106575/empresa/nuevo")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dataHeader.codRespuesta").value("0"));
    }
}