package com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.services;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.ErrorDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.CabecerasUtils;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.ManejoErroresUtils;
import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.ConsultaListaCargoTrabajadorDataDTO;
import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.ConsultaListaCargoTrabajadorParamDTO;
import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.models.ConsultarCargoTrabajadorResponse;
import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.repository.PrcProcListaCargoRepository;
import com.bolivar.error.handling.constants.TipoErrorEnum;
import com.bolivar.error.handling.exception.BolivarBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultarCargoTrabajadorServiceImpl implements ConsultarCargoTrabajadorService {

    @Autowired
    private PrcProcListaCargoRepository prcProcListaCargoRepository;

    @Override
    public ConsultarCargoTrabajadorResponse consultaListaCargoTrabajador(BigDecimal codigo, String cargo) {
        SimTypProceso simTypProceso = SimTypProceso.builder()
                .build();
        ConsultaListaCargoTrabajadorParamDTO consultaListaCargoTrabajadorParamDTO = ConsultaListaCargoTrabajadorParamDTO.builder()
                .ipCodigo(codigo)
                .ipSearchString(cargo)
                .ipValidacion("Comunes")
                .ipProceso(simTypProceso)
                .build();
        prcProcListaCargoRepository.prcConsultaListaCargo(consultaListaCargoTrabajadorParamDTO);
        return validarRespuesta(consultaListaCargoTrabajadorParamDTO);
    }

    private ConsultarCargoTrabajadorResponse validarRespuesta(ConsultaListaCargoTrabajadorParamDTO respuesta) {
        SimTypError error = respuesta.getOpArrerrores().stream().filter(err -> err.getIdError().equals(new BigDecimal(10001)))
                .findFirst().orElse((SimTypError.builder().idError(new BigDecimal(0)).build()));

        if (respuesta.getOpResultado() != 0 && !error.getIdError().equals(new BigDecimal(10001))) {
            throw BolivarBusinessException.builder().codigo("EBD03").categoria(TipoErrorEnum.NEGOCIO)
                    .errores(ManejoErroresUtils.mapeoErrores(respuesta.getOpArrerrores(), "ConsultaListaCargoTrabajador"))
                    .build();
        } else if (respuesta.getOpResultado() != 0 && error.getIdError().equals(new BigDecimal(10001))) {
            return ConsultarCargoTrabajadorResponse.builder().dataHeader(CabecerasUtils.generarCabeceraErrorControlado(List.of(ErrorDTO.builder()
                            .descError(error.getDescError())
                            .tipoError(error.getTipoError())
                            .idError(error.getIdError().intValue())
                            .build())))
                    .data(ConsultaListaCargoTrabajadorDataDTO.builder().cargos(Collections.emptyList())
                            .build())
                    .build();
        } else {
            return ConsultarCargoTrabajadorResponse.builder().dataHeader(CabecerasUtils.generarCabeceraCorrecta())
                    .data(ConsultaListaCargoTrabajadorDataDTO.builder().cargos(respuesta.getOpArrLista())
                            .build())
                    .build();
        }
    }
}
