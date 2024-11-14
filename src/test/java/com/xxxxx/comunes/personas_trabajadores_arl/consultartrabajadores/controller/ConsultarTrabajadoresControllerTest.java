package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.controller;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.models.ConsultarTrabajadoresRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.models.ConsultarTrabajadoresResponse;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.services.ConsultarTrabajadoresServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebMvcTest(ConsultarTrabajadoresController.class)
public class ConsultarTrabajadoresControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ConsultarTrabajadoresServiceImpl servicio;

    @Test
    void debeRetornarResultadoConsultaTrabajadores() throws Exception {

        List<Long> codigosCentrosTrabajo=new ArrayList<>();
        codigosCentrosTrabajo.add(345L);
        codigosCentrosTrabajo.add(51L);
        codigosCentrosTrabajo.add(26L);
        codigosCentrosTrabajo.add(343L);
        codigosCentrosTrabajo.add(60L);
        codigosCentrosTrabajo.add(53L);
        codigosCentrosTrabajo.add(349L);
        codigosCentrosTrabajo.add(346L);
        codigosCentrosTrabajo.add(50L);
        codigosCentrosTrabajo.add(59L);
        codigosCentrosTrabajo.add(352L);

        ConsultarTrabajadoresRequest peticion = ConsultarTrabajadoresRequest.builder()
                .estado("RET").fecIngresoDesde("2020-03-01")
                .fecIngresoHasta("2020-03-31").tipoCotizante("")
                .tipoDocumentoTrabajador("CC").numeroDocumentoTrabajador(187230L)
                .codigosCentrosTrabajo(codigosCentrosTrabajo).compania(2)
                .seccion(70).producto(722)
                .codUsr("79625048").tipoDocumentoEmpresa("NT")
                .numeroDocumentoEmpresa(860036081L).numPol(1000387288016L)
                .numSecuPol(39744845698L).nivelSupervision(1)
                .paginaInicio(1).paginaFin(2).build();

        String responseText = IOUtils.toString(new FileInputStream("src/test/resources/consultartrabajadores/response.json"), "UTF-8");
        Type typeResponse = new TypeToken<ConsultarTrabajadoresResponse>() {}.getType();
        Gson gson = new Gson();
        ConsultarTrabajadoresResponse response = gson.fromJson(responseText, typeResponse);

        when(servicio.consultarTrabajadores(peticion))
                .thenReturn(response);

        mockMvc.perform(get("/api/v1/empresas/trabajadores")
                .param("compania","2")
                .param("seccion","70")
                .param("producto","722")
                .param("codUsr","79625048")
                .param("tipoDocEmpresa","NT")
                .param("numDocEmpresa","860036081")
                .param("numPol","1000387288016")
                .param("numSecuPol","39744845698")
                .param("nivelSupervision","1")
                .param("paginaInicio","1")
                .param("paginaFin","2")
                .param("fecIngresoDesde","2020-03-01")
                .param("fecIngresoHasta","2020-03-31")
                .param("soloCalcular", "true")
                        .param("ordenarPor","1")
                        .param("direccion","1")
                        .param("criterioFiltrado","DOCTIPO")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();




    }
}
