package com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.services.impl;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.CargoDTO;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.dto.CreaCargoTrabajadorParamDTO;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorRequest;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorResponse;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.repository.PrcCreaCargoRepository;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.services.CrearCargoTrabajadorServiceImpl;
import com.bolivar.error.handling.exception.BolivarBusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;


@ExtendWith(MockitoExtension.class)
class CrearCargoTrabajadorServiceImplTest {

    @Mock
    PrcCreaCargoRepository repository;

    @InjectMocks
    CrearCargoTrabajadorServiceImpl servicio;


    @Test
    void debeRetornarRespuestaCorrectaAlCrearElCargo() throws Exception {
        CrearCargoTrabajadorRequest peticion = CrearCargoTrabajadorRequest.builder()
                .cargo(CargoDTO.builder()
                        .codigo(123)
                        .descripcion("INGE")
                        .build())
                .build();
        SimTypProceso simTypProceso = SimTypProceso.builder()
                .build();
        CreaCargoTrabajadorParamDTO paramDTO = CreaCargoTrabajadorParamDTO.builder()
                .ipProceso(simTypProceso)
                .pDescCargo(peticion.getCargo().getDescripcion())
                .ipValidacion("Comunes").build();

        Mockito.doAnswer(i -> {
            CreaCargoTrabajadorParamDTO parametrosInternos = i.getArgument(0);
            parametrosInternos.setPCodCargo(123);
            parametrosInternos.setPSeccion("2");
            parametrosInternos.setPObs("4");
            parametrosInternos.setOpResultado(0);
            parametrosInternos.setOpArrerrores(Collections.emptyList());
            return null;
        }).when(repository).prcCreaCargoRepository(paramDTO);

        CrearCargoTrabajadorResponse respuesta = servicio.creaCargoTrabajador(peticion);

        Assertions.assertEquals(0, respuesta.getDataHeader().getCodRespuesta());
    }


    @Test
    void debeRetornarErrorControlado() throws Exception{
        CrearCargoTrabajadorRequest peticion = CrearCargoTrabajadorRequest.builder()
                .cargo(CargoDTO.builder()
                        .codigo(123)
                        .descripcion("INGE")
                        .build())
                .build();
        SimTypProceso simTypProceso = SimTypProceso.builder()
                .build();
        CreaCargoTrabajadorParamDTO paramDTO = CreaCargoTrabajadorParamDTO.builder()
                .ipProceso(simTypProceso)
                .pDescCargo(peticion.getCargo().getDescripcion())
                .ipValidacion("Comunes").build();

        Mockito.doAnswer(i -> {
            CreaCargoTrabajadorParamDTO parametrosInternos = i.getArgument(0);
            parametrosInternos.setOpResultado(-1);
            parametrosInternos.setOpArrerrores(Collections.emptyList());
            return null;
        }).when(repository).prcCreaCargoRepository(paramDTO);

        Assertions.assertThrows(BolivarBusinessException.class, () -> {
            servicio.creaCargoTrabajador(peticion);
        });
    }

}