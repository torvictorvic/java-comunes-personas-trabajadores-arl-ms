package com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.controller;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresResponse;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.services.HistorialNovedadesTrabajadoresServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HistorialNovedadesTrabajadoresController.class)
public class HistorialNovedadesTrabajadoresControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HistorialNovedadesTrabajadoresServiceImpl servicio;

    @Test
    void debeRetornarResultadoHistorialNovedades() throws Exception {
        HistorialNovedadesTrabajadoresRequest request=HistorialNovedadesTrabajadoresRequest.builder()
                .numeroDocumentoUsuario("1073520770")
                .numeroDocumentoEmpresa("860036081")
                .tipoDocumentoEmpresa("NT")
                .build();

        String responseText = IOUtils.toString(new FileInputStream("src/test/resources/historialnovedadestrabajadores/response.json"), "UTF-8");
        Type typeResponse = new TypeToken<HistorialNovedadesTrabajadoresResponse>() {}.getType();
        Gson gson = new Gson();
        HistorialNovedadesTrabajadoresResponse response = gson.fromJson(responseText, typeResponse);

        when(servicio.consultarHistoricoNovedades(request))
                .thenReturn(response);

        mockMvc.perform(get("/api/v1/historicoNovedades/trabajadores")
                        .param("numDocumentoEmpresa","860036081")
                        .param("numDocumentoTrabajador","860036081")
                        .param("tipoDocumentoEmpresa","NT")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }
}