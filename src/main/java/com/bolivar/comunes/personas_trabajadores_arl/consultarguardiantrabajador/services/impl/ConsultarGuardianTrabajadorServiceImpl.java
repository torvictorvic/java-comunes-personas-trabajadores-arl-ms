package com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.services.impl;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.ErrorDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypArlTrabajador;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.dto.ConsultarTrabajadorDataDTO;
import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.dto.ProcConsultarTrabajadorParams;
import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.models.ConsultarGuardianTrabajadorResponse;
import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.repository.PrcTrabajadoresArlGuardianRepository;
import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.services.ConsultarGuardianTrabajadorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ConsultarGuardianTrabajadorServiceImpl implements ConsultarGuardianTrabajadorService {

    @Autowired
    private PrcTrabajadoresArlGuardianRepository repositorio;

    @Override
    public ConsultarGuardianTrabajadorResponse consultarTrabajador(String ipIdenvio, String ipValidacion, String nroDocumto, String operation) {

        SimTypProceso simTypProceso = SimTypProceso.builder().build();

        ProcConsultarTrabajadorParams procConsultarTrabajadorParams = ProcConsultarTrabajadorParams.builder().ipIdenvio(ipIdenvio)
                .ipValidacion(ipValidacion).nroDocumto(nroDocumto).operation(operation).ipProceso(simTypProceso).build();
        repositorio.ejecutarProcConsultasTrabajador(procConsultarTrabajadorParams);

        return validarResultado(procConsultarTrabajadorParams);
    }



    private ConsultarGuardianTrabajadorResponse validarResultado(ProcConsultarTrabajadorParams resultado) {
        ArrayList<ErrorDTO> errores = new ArrayList<>();

        if (resultado.getPoTrabajadores() == null || resultado.getPoTrabajadores().isEmpty()) {
            ErrorDTO error = new ErrorDTO(-1, "No se obtuvieron resultados", "Error en la consulta");
            errores.add(error);
            return ConsultarGuardianTrabajadorResponse.builder().dataHeader(
                    DataHeaderDTO.builder().codRespuesta(-1).errores(errores).build()).build();
        }

        List<ConsultarTrabajadorDataDTO> trabajadores = new ArrayList<>();
        for (SimTypArlTrabajador trabajador: resultado.getPoTrabajadores()) {
            System.out.println(trabajador);
            trabajadores.add( ConsultarTrabajadorDataDTO.builder().informacionT(
                    SimTypArlTrabajador.builder()
                            .idEnvio(trabajador.getIdEnvio())
                            .tipoDocEmpresa(trabajador.getTipoDocEmpresa())
                            .numDocEmpresa(trabajador.getNumDocEmpresa())
                            .genero(trabajador.getGenero())
                            .tipDocEmpleado(trabajador.getTipDocEmpleado())
                            .numDocEmpleado(trabajador.getNumDocEmpleado())
                            .autorizado(trabajador.getAutorizado())
                            .lugarExp(trabajador.getLugarExp())
                            .fechExp(trabajador.getFechExp())
                            .fechaNacimiento(trabajador.getFechaNacimiento())
                            .nombre(trabajador.getNombre())
                            .apellidos(trabajador.getApellidos())
                            .tipContrato(trabajador.getTipContrato())
                            .profesion(trabajador.getProfesion())
                            .centroTrabajo(trabajador.getCentroTrabajo())
                            .codCargo(trabajador.getCodCargo())
                            .ocupacion(trabajador.getOcupacion())
                            .salarioIbc(trabajador.getSalarioIbc())
                            .eps(trabajador.getEps())
                            .afp(trabajador.getAfp())
                            .arl(trabajador.getArl())
                            .pais(trabajador.getPais())
                            .departamento(trabajador.getDepartamento())
                            .ciudad(trabajador.getCiudad())
                            .rh(trabajador.getRh())
                            .nivelRiesgos(trabajador.getNivelRiesgos())
                            .centroCostos(trabajador.getCentroCostos())
                            .observacion(trabajador.getObservacion())
                            .direccion(trabajador.getDireccion())
                            .contrato(trabajador.getContrato())
                            .fecIniContr(trabajador.getFecIniContr())
                            .fecFinContr(trabajador.getFecFinContr())
                            .mail(trabajador.getMail())
                            .activo(trabajador.getActivo())
                            . build()
            ).build());
        }

        return ConsultarGuardianTrabajadorResponse.builder().
                dataHeader(DataHeaderDTO.builder().codRespuesta(0).errores(Collections.emptyList()).build())
                .data(trabajadores).build();

    }
}
