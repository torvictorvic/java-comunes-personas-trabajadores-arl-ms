package com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.services;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.ErrorDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLista;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.commons.utils.CabecerasUtils;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database.HistorialNovedadesTrabajadoresParamsDTO;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database.SimTypArrayLista;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresRequest;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresResponse;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HistorialNovedadesTrabajadoresServiceImpl implements HistorialNovedadesTrabajadoresService {

    @Autowired
    PrcConsultaNovedadesTrbjdrRepository repository;

    @Override
    public HistorialNovedadesTrabajadoresResponse consultarHistoricoNovedades(HistorialNovedadesTrabajadoresRequest request) {

        HistorialNovedadesTrabajadoresParamsDTO parametrosPL=generarRequestPL(request);
        log.info("ParametrosPL ARL_PCK_CONSULTAS.Proc_Historiconovedadesempresa: "+parametrosPL.toString());
        repository.prcConsultarHistoricoNovedades(parametrosPL);
        if (parametrosPL.getOpResultado() == 0) {
            log.info("Resultado recibido. Generando respuesta HistorialNovedadesTrabajadoresResponse...");
           return HistorialNovedadesTrabajadoresResponse.builder()
                    .dataHeader(CabecerasUtils.generarCabeceraCorrecta())
                    .data(parametrosPL.getOpHistoriconovedades())
                    .build();
        }else{
            log.info("Fallo en el llamado del procedimiento. Generando respuesta HistorialNovedadesTrabajadoresResponse con lista de errores ...");
            HistorialNovedadesTrabajadoresResponse response = HistorialNovedadesTrabajadoresResponse.builder()
                    .dataHeader(DataHeaderDTO.builder().codRespuesta(parametrosPL.getOpResultado())
                            .errores(parametrosPL.getOpArrerrores().stream()
                                    .map(error -> ErrorDTO.builder().idError(error.getIdError().intValue())
                                            .descError(error.getDescError()).tipoError(error.getTipoError()).build())
                                    .collect(Collectors.toList())).build())
                    .data(null)
                    .build();
            log.warn(response.toString());
            return response;
        }
    }
    public HistorialNovedadesTrabajadoresParamsDTO generarRequestPL(HistorialNovedadesTrabajadoresRequest request){
        SimTypProceso proceso=SimTypProceso.builder()
                .p_INFO1(request.getTipoDocumentoEmpresa())
                .p_INFO2(request.getNumeroDocumentoEmpresa())
                .p_INFO5("1")
                .p_COD_USR(request.getNumeroDocumentoUsuario()).build();

        List<SimTypLista> listSimTypLista = new ArrayList<>();

        if(request.getNumeroDocumentoUsuario()!=null && !request.getNumeroDocumentoUsuario().isEmpty()
                && !request.getNumeroDocumentoUsuario().isBlank()){
            SimTypLista simTypLista = new SimTypLista();
            simTypLista.setCodigo("ID_NIT");
            simTypLista.setValor(request.getNumeroDocumentoUsuario());
            listSimTypLista.add(simTypLista);
        }

        if(request.getFechaDesde()!=null && !request.getFechaDesde().isEmpty()
                && !request.getFechaDesde().isBlank()){
            SimTypLista simTypLista = new SimTypLista();
            simTypLista.setCodigo("ID_FECHA_TRANSACCION_DESDE");
            simTypLista.setValor(request.getFechaDesde());
            listSimTypLista.add(simTypLista);
        }

        if(request.getFechaHasta()!=null && !request.getFechaHasta().isEmpty()
                && !request.getFechaHasta().isBlank()){
            SimTypLista simTypLista = new SimTypLista();
            simTypLista.setCodigo("ID_FECHA_TRANSACCION_HASTA");
            simTypLista.setValor(request.getFechaHasta());
            listSimTypLista.add(simTypLista);
        }

        return HistorialNovedadesTrabajadoresParamsDTO.builder()
                .ipHistoriconovedades(SimTypArrayLista.builder().simTypLista(listSimTypLista).build())
                .ipProceso(proceso)
                .ipValidacion("Validacion")
                .build();
    }
}