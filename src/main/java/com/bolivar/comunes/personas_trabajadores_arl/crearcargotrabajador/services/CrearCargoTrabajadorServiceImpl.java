package com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.services;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.CabecerasUtils;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.ManejoErroresUtils;
import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.CargoDTO;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.dto.CreaCargoTrabajadorDataDTO;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.dto.CreaCargoTrabajadorParamDTO;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorRequest;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.models.CrearCargoTrabajadorResponse;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.repository.PrcCreaCargoRepository;
import com.bolivar.error.handling.constants.TipoErrorEnum;
import com.bolivar.error.handling.exception.BolivarBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrearCargoTrabajadorServiceImpl implements CrearCargoTrabajadorService {

    @Autowired
    private PrcCreaCargoRepository prcCreaCargoRepository;

    @Override
    public CrearCargoTrabajadorResponse creaCargoTrabajador(CrearCargoTrabajadorRequest cargo) {
        SimTypProceso simTypProceso = SimTypProceso.builder()
                .build();
        CreaCargoTrabajadorParamDTO paramDTO = CreaCargoTrabajadorParamDTO.builder()
                .ipProceso(simTypProceso)
                .pDescCargo(cargo.getCargo().getDescripcion())
                .ipValidacion("Comunes").build();
        prcCreaCargoRepository.prcCreaCargoRepository(paramDTO);
        return validar(paramDTO);

    }

    private CrearCargoTrabajadorResponse validar(CreaCargoTrabajadorParamDTO resultado) {

        if (resultado.getOpResultado() != 0) {
            throw BolivarBusinessException.builder().codigo("EBD04").categoria(TipoErrorEnum.NEGOCIO)
                    .mensaje("Error al Crear el Cargo")
                    .errores(ManejoErroresUtils.mapeoErrores(resultado.getOpArrerrores(), "Cargo")).build();
        } else {
            return CrearCargoTrabajadorResponse.builder().dataHeader(CabecerasUtils.generarCabeceraCorrecta())
                    .data(CreaCargoTrabajadorDataDTO.builder().cargo(CargoDTO.builder().codigo(resultado.getPCodCargo()).descripcion(resultado.getPDescCargo()).build()).build())
                    .build();
        }
    }
}
