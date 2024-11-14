package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.services.impl;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.ConsultaListaCargoTrabajadorParamDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.models.ConsultarCargoTrabajadorResponse;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.repository.PrcProcListaCargoRepository;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.services.ConsultarCargoTrabajadorServiceImpl;
import com.xxxxxxxx.error.handling.exception.BolivarBusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ConsultarCargoTrabajadorServiceImplTest {

    @Mock
    private PrcProcListaCargoRepository repository;

    @InjectMocks
    private ConsultarCargoTrabajadorServiceImpl consultaListaCargoTrabajadorService;


    @Test
    void debeResponderListadeCargos() {
        SimTypProceso simTypProceso = SimTypProceso.builder().build();
        ConsultaListaCargoTrabajadorParamDTO paramDTO =
                ConsultaListaCargoTrabajadorParamDTO.builder()
                        .ipCodigo(null)
                        .ipSearchString("ING")
                        .ipValidacion("Comunes")
                        .ipProceso(simTypProceso)
                        .build();
       Mockito.doAnswer(i -> {
            ConsultaListaCargoTrabajadorParamDTO parametrosInternos = i.getArgument(0);
            parametrosInternos.setOpResultado(0);
            parametrosInternos.setOpArrerrores(Collections.emptyList());
            return null;
        }).when(repository).prcConsultaListaCargo(paramDTO);

        ConsultarCargoTrabajadorResponse respuesta = consultaListaCargoTrabajadorService
                .consultaListaCargoTrabajador(null, "ING");

        Assertions.assertEquals(0, respuesta.getDataHeader().getCodRespuesta());

    }


    @Test
    void debeResponderErrorControlado() {
        SimTypProceso simTypProceso = SimTypProceso.builder().build();
        ConsultaListaCargoTrabajadorParamDTO paramDTO =
                ConsultaListaCargoTrabajadorParamDTO.builder()
                        .ipCodigo(null)
                        .ipSearchString("STS")
                        .ipValidacion("Comunes")
                        .ipProceso(simTypProceso)
                        .build();
        Mockito.doAnswer(i -> {
            ConsultaListaCargoTrabajadorParamDTO parametrosInternos = i.getArgument(0);
            parametrosInternos.setOpResultado(-1);
            parametrosInternos.setOpArrerrores(List.of(SimTypError
                    .builder()
                    .idError(new BigDecimal(10001))
                    .descError("Error")
                    .tipoError("NEGOCIO")
                    .build()));
            return null;
        }).when(repository).prcConsultaListaCargo(paramDTO);

        ConsultarCargoTrabajadorResponse respuesta = consultaListaCargoTrabajadorService
                .consultaListaCargoTrabajador(null, "STS");

        Assertions.assertEquals(-1, respuesta.getDataHeader().getCodRespuesta());
        Assertions.assertEquals(0, respuesta.getData().getCargos().size());
    }


    @Test
    void debeResponderErrorControladoBussinesBolivar() {
        SimTypProceso simTypProceso = SimTypProceso.builder().build();
        ConsultaListaCargoTrabajadorParamDTO paramDTO =
                ConsultaListaCargoTrabajadorParamDTO.builder()
                        .ipCodigo(null)
                        .ipSearchString("ING")
                        .ipValidacion("Comunes")
                        .ipProceso(simTypProceso)
                        .build();
        Mockito.doAnswer(i -> {
            ConsultaListaCargoTrabajadorParamDTO parametrosInternos = i.getArgument(0);
            parametrosInternos.setOpResultado(-1);
            parametrosInternos.setOpArrerrores(Collections.emptyList());
            return null;
        }).when(repository).prcConsultaListaCargo(paramDTO);

        Assertions.assertThrows(BolivarBusinessException.class, () -> {
            consultaListaCargoTrabajadorService.consultaListaCargoTrabajador(null,"ING");
        });
    }


}