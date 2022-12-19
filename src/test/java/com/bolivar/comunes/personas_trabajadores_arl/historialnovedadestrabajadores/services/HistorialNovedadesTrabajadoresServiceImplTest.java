package com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.services;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLista;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database.HistorialNovedadesTrabajadoresParamsDTO;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database.SimTypArrayLista;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresRequest;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models.HistorialNovedadesTrabajadoresResponse;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.repository.PrcConsultaNovedadesTrbjdrRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doAnswer;

@ExtendWith(MockitoExtension.class)
public class HistorialNovedadesTrabajadoresServiceImplTest {

    @Mock
    PrcConsultaNovedadesTrbjdrRepository repositorio;

    @InjectMocks
    HistorialNovedadesTrabajadoresServiceImpl servicio;

    @Test
    void historialNovedadesOK(){
        HistorialNovedadesTrabajadoresRequest request=HistorialNovedadesTrabajadoresRequest.builder()
                .numeroDocumentoUsuario("1073520770")
                .numeroDocumentoEmpresa("860036081")
                .tipoDocumentoEmpresa("NT")
                .fechaDesde("21/10/2021")
                .fechaHasta("21/10/2022")
                .build();

        List<SimTypLista> listSimTypLista = new ArrayList<>();

        SimTypLista idNit = new SimTypLista();
        idNit.setCodigo("ID_NIT");
        idNit.setValor(request.getNumeroDocumentoUsuario());
        listSimTypLista.add(idNit);

        SimTypLista fechaInicio = new SimTypLista();
        fechaInicio.setCodigo("ID_FECHA_TRANSACCION_DESDE");
        fechaInicio.setValor(request.getFechaDesde());
        listSimTypLista.add(fechaInicio);

        SimTypLista fechaFin = new SimTypLista();
        fechaFin.setCodigo("ID_FECHA_TRANSACCION_HASTA");
        fechaFin.setValor(request.getFechaHasta());
        listSimTypLista.add(fechaFin);

        HistorialNovedadesTrabajadoresParamsDTO parametrosPL=servicio.generarRequestPL(request);

        doAnswer(i -> {
            HistorialNovedadesTrabajadoresParamsDTO argumento = i.getArgument(0);
            argumento.setOpResultado(0);
            argumento.setIpHistoriconovedades(SimTypArrayLista.builder().simTypLista(listSimTypLista).build());
            argumento.setOpArrerrores(Collections.emptyList());
            return null;
        }).when(repositorio).prcConsultarHistoricoNovedades(parametrosPL);
        HistorialNovedadesTrabajadoresResponse responseService=servicio.consultarHistoricoNovedades(request);
        Assert.notNull(responseService.getDataHeader().getCodRespuesta().toString(),"0");

    }

    @Test
    void historialNovedadesFail(){
        HistorialNovedadesTrabajadoresRequest request=HistorialNovedadesTrabajadoresRequest.builder()
                .numeroDocumentoUsuario("1073520770")
                .numeroDocumentoEmpresa("860036081")
                .tipoDocumentoEmpresa("NT")
                .fechaDesde(null)
                .fechaHasta(null)
                .build();
        SimTypLista simTypLista = new SimTypLista();
        simTypLista.setCodigo("ID_NIT");
        simTypLista.setValor(request.getNumeroDocumentoUsuario());
        List<SimTypLista> listSimTypLista = new ArrayList<>();
        listSimTypLista.add(simTypLista);
        List<SimTypError> errorList= new ArrayList<>();
        SimTypError error= SimTypError.builder()
                .idError(new BigDecimal("1"))
                .descError("Error al consultar")
                .tipoError("Error al consultar")
                .msgError("Error al consultar")
                .msgError1("Error al consultar")
                .build();
        errorList.add(error);
        HistorialNovedadesTrabajadoresParamsDTO parametrosPL=servicio.generarRequestPL(request);
        doAnswer(i -> {
            HistorialNovedadesTrabajadoresParamsDTO argumento = i.getArgument(0);
            argumento.setOpResultado(-1);
            argumento.setOpArrerrores(errorList);
            return null;
        }).when(repositorio).prcConsultarHistoricoNovedades(parametrosPL);
        HistorialNovedadesTrabajadoresResponse responseService=servicio.consultarHistoricoNovedades(request);
        Assert.notNull(responseService.getDataHeader().getCodRespuesta().toString(),"-1");
    }
}
