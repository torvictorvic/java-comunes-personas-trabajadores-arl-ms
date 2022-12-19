package com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.services.impl;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypArlTrabajador;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.dto.ProcConsultarTrabajadorParams;

import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.models.ConsultarGuardianTrabajadorResponse;
import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.repository.PrcTrabajadoresArlGuardianRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ConsultarTrabajadorServiceImplTest {

    @Mock
    PrcTrabajadoresArlGuardianRepository repository;

    @InjectMocks
    ConsultarGuardianTrabajadorServiceImpl service;


    @Test
    void debeRetornarOkAlConsultasTrabajador() {
        List<SimTypArlTrabajador> EmpresaList = new ArrayList<>();
        EmpresaList.add(SimTypArlTrabajador.builder()
                .idEnvio(new BigDecimal(19992026))
                .tipoDocEmpresa(("CC"))
                .numDocEmpresa("12334")
                .genero("M")
                .tipDocEmpleado("M")
                .numDocEmpleado("1064836369")
                .activo(new BigDecimal(19992026))
                .autorizado(new BigDecimal(1))
                .lugarExp("")
                .fechExp("")
                .nombre("Benito")
                .apellidos("Mussolini")
                .build());
        Mockito.doAnswer(i -> {
            ProcConsultarTrabajadorParams params = i.getArgument(0);
            params.setOpResultado(BigDecimal.ZERO);
            params.setOpArrErrores(Collections.emptyList());
            params.setPoTrabajadores(EmpresaList);
            return null;
        }).when(repository).ejecutarProcConsultasTrabajador(setInfo());
        ConsultarGuardianTrabajadorResponse response = service.consultarTrabajador("2022071920220720", "S","0", "nuevo");
        Assertions.assertEquals(0, response.getDataHeader().getCodRespuesta());
    }

    @Test
    void debeObtenerErrorSiElResultadoEsVacio() throws ParseException {
        Mockito.doAnswer(i -> {
            List<SimTypError> opArrErrores = new ArrayList<>();
            SimTypError error = new SimTypError(new BigDecimal(-1), "prueba", "prueba", "prueba", "prueba");
            opArrErrores.add(error);
            ProcConsultarTrabajadorParams parametrosInternos = i.getArgument(0);
            parametrosInternos.setOpResultado(BigDecimal.valueOf(-1));
            parametrosInternos.setOpArrErrores(opArrErrores);
            parametrosInternos.setPoTrabajadores(Collections.emptyList());
            return null;
        }).when(repository).ejecutarProcConsultasTrabajador(setInfo());
        ConsultarGuardianTrabajadorResponse response = service.consultarTrabajador("2022071920220720", "S", "0", "nuevo");
        Assertions.assertEquals(-1, response.getDataHeader().getCodRespuesta());
    }

    private ProcConsultarTrabajadorParams setInfo() {
        ProcConsultarTrabajadorParams params = ProcConsultarTrabajadorParams.builder()
                .ipIdenvio("2022071920220720")
                .nroDocumto("0")
                .operation("nuevo")
                .ipValidacion("S")
                .ipProceso(new SimTypProceso())
                .build();
        return params;
    }
}