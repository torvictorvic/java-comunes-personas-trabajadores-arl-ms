package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.services;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLista;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ArlTypArrayCntrotrabcodCt;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ArlTypArrayTrabbasicdetlCt;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ConsultaTrabajadoresParamsDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.SimTypArrayLista;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.models.ConsultarTrabajadoresRequest;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.models.ConsultarTrabajadoresResponse;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.repository.PrcProcConsultaTrabajadoresOrdnRepository;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.repository.PrcProcContarTrabajadoresRepository;
import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ConsultarTrabajadoresServiceTest {

    @Mock
    PrcProcConsultaTrabajadoresOrdnRepository repositorio;

    @Mock
    PrcProcContarTrabajadoresRepository repositorioContar;

    @InjectMocks
    ConsultarTrabajadoresServiceImpl servicio;

    @Test
    void consultarTrabajadoresOK(){

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
                .paginaInicio(1).paginaFin(2).soloCalcular(false)
                .tipoCotizante("Dependiente").ordenarPor(1).direccion(1)
                .criterioFiltrado("DOCTIPO")
                .build();

        List<SimTypLista> parametrosBusqueda = new ArrayList<>();
        servicio.validacionEntrada(peticion, parametrosBusqueda);
        servicio.validacionRequest(peticion, parametrosBusqueda);
        ConsultaTrabajadoresParamsDTO parametrosPL = ConsultaTrabajadoresParamsDTO.builder()
                .ipArrayParametros(SimTypArrayLista.builder().simTypLista(parametrosBusqueda).build())
                .ipTrabajadoresdetalles(ArlTypArrayTrabbasicdetlCt.builder()
                        .detalle(Collections.singletonList(servicio.validacionConsultaTrabajador(peticion))).build())
                .ipCentroTrabcodigo(
                        ArlTypArrayCntrotrabcodCt.builder().codigosCentros(servicio.validacionCentrosTrabajo(peticion)).build())
                .ipProceso(servicio.construccionIpProceso(peticion)).ipPaginaInicio(1).ipPaginaFin(2).ipValidacion("REFACTORING")
                .build();

        doAnswer(i -> {
            ConsultaTrabajadoresParamsDTO argumento = i.getArgument(0);
            argumento.setOpResultado(0);
            argumento.setOpNumeropoliza(new BigDecimal("1000387288016"));
            argumento.setOpTotalregistros(3);
            argumento.setOpArrerrores(Collections.emptyList());
            return null;
        }).when(repositorio).prcConsultarTrabajadores(parametrosPL);

        ConsultarTrabajadoresResponse responseService=servicio.consultarTrabajadores(peticion);
        Assert.notNull(responseService.getDataHeader().getCodRespuesta().toString(),"0");
    }

    @Test
    void consultarTrabajadoresFail(){

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
                .paginaInicio(1).paginaFin(2).soloCalcular(false).build();

        List<SimTypLista> parametrosBusqueda = new ArrayList<>();
        servicio.validacionEntrada(peticion, parametrosBusqueda);
        servicio.validacionRequest(peticion, parametrosBusqueda);
        ConsultaTrabajadoresParamsDTO parametrosPL = ConsultaTrabajadoresParamsDTO.builder()
                .ipArrayParametros(SimTypArrayLista.builder().simTypLista(parametrosBusqueda).build())
                .ipTrabajadoresdetalles(ArlTypArrayTrabbasicdetlCt.builder()
                        .detalle(Collections.singletonList(servicio.validacionConsultaTrabajador(peticion))).build())
                .ipCentroTrabcodigo(
                        ArlTypArrayCntrotrabcodCt.builder().codigosCentros(servicio.validacionCentrosTrabajo(peticion)).build())
                .ipProceso(servicio.construccionIpProceso(peticion)).ipPaginaInicio(1).ipPaginaFin(2).ipValidacion("REFACTORING")
                .build();

        List<SimTypError> errorList= new ArrayList<>();

        SimTypError error= SimTypError.builder()
                .idError(new BigDecimal("1"))
                .descError("Error al consultar")
                .tipoError("Error al consultar")
                .msgError("Error al consultar")
                .msgError1("Error al consultar")
                .build();
        errorList.add(error);
        doAnswer(i -> {
            ConsultaTrabajadoresParamsDTO argumento = i.getArgument(0);
            argumento.setOpResultado(-1);
            argumento.setOpArrerrores(errorList);
            return null;
        }).when(repositorio).prcConsultarTrabajadores(parametrosPL);

        ConsultarTrabajadoresResponse responseService=servicio.consultarTrabajadores(peticion);
        Assert.notNull(responseService.getDataHeader().getCodRespuesta().toString(),"-1");

    }

    @Test
    void debeRetornarRegistrosTotalesAlLlamarConSoloContar() {
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
                .paginaInicio(1).paginaFin(2).soloCalcular(true).build();

        List<SimTypLista> parametrosBusqueda = new ArrayList<>();
        servicio.validacionEntrada(peticion, parametrosBusqueda);
        servicio.validacionRequest(peticion, parametrosBusqueda);
        ConsultaTrabajadoresParamsDTO parametrosPL = ConsultaTrabajadoresParamsDTO.builder()
                .ipArrayParametros(SimTypArrayLista.builder().simTypLista(parametrosBusqueda).build())
                .ipTrabajadoresdetalles(ArlTypArrayTrabbasicdetlCt.builder()
                        .detalle(Collections.singletonList(servicio.validacionConsultaTrabajador(peticion))).build())
                .ipCentroTrabcodigo(
                        ArlTypArrayCntrotrabcodCt.builder().codigosCentros(servicio.validacionCentrosTrabajo(peticion)).build())
                .ipProceso(servicio.construccionIpProceso(peticion)).ipPaginaInicio(1).ipPaginaFin(2).ipValidacion("REFACTORING")
                .build();

        doAnswer(i -> {
            ConsultaTrabajadoresParamsDTO argumento = i.getArgument(0);
            argumento.setOpResultado(0);
            argumento.setOpNumeropoliza(new BigDecimal("1000387288016"));
            argumento.setOpTotalregistros(3);
            argumento.setOpArrerrores(Collections.emptyList());
            return null;
        }).when(repositorioContar).prcContarTrabajadores(parametrosPL);

        ConsultarTrabajadoresResponse responseService=servicio.consultarTrabajadores(peticion);
        Assert.notNull(responseService.getDataHeader().getCodRespuesta().toString(),"0");
    }

    @Test
    void validacionCentrosTrabajo(){

        ConsultarTrabajadoresRequest peticion = ConsultarTrabajadoresRequest.builder()
                .estado("RET").fecIngresoDesde("2020-03-01")
                .fecIngresoHasta("2020-03-31").tipoCotizante("")
                .tipoDocumentoTrabajador("CC").numeroDocumentoTrabajador(187230L)
                .codigosCentrosTrabajo(null).compania(2)
                .seccion(70).producto(722)
                .codUsr("79625048").tipoDocumentoEmpresa("NT")
                .numeroDocumentoEmpresa(860036081L).numPol(1000387288016L)
                .numSecuPol(39744845698L).nivelSupervision(1)
                .paginaInicio(1).paginaFin(2).soloCalcular(true).build();

        List<SimTypLista> parametrosBusqueda = new ArrayList<>();
        servicio.validacionEntrada(peticion, parametrosBusqueda);
        servicio.validacionRequest(peticion, parametrosBusqueda);
        ConsultaTrabajadoresParamsDTO parametrosPL = ConsultaTrabajadoresParamsDTO.builder()
                .ipArrayParametros(SimTypArrayLista.builder().simTypLista(parametrosBusqueda).build())
                .ipTrabajadoresdetalles(ArlTypArrayTrabbasicdetlCt.builder()
                        .detalle(Collections.singletonList(servicio.validacionConsultaTrabajador(peticion))).build())
                .ipCentroTrabcodigo(
                        ArlTypArrayCntrotrabcodCt.builder().codigosCentros(servicio.validacionCentrosTrabajo(peticion)).build())
                .ipProceso(servicio.construccionIpProceso(peticion)).ipPaginaInicio(1).ipPaginaFin(2).ipValidacion("REFACTORING")
                .build();

        doAnswer(i -> {
            ConsultaTrabajadoresParamsDTO argumento = i.getArgument(0);
            argumento.setOpResultado(0);
            argumento.setOpNumeropoliza(new BigDecimal("1000387288016"));
            argumento.setOpTotalregistros(3);
            argumento.setOpArrerrores(Collections.emptyList());
            return null;
        }).when(repositorioContar).prcContarTrabajadores(parametrosPL);

        ConsultarTrabajadoresResponse responseService=servicio.consultarTrabajadores(peticion);
        Assert.notNull(responseService.getDataHeader().getCodRespuesta().toString(),"0");
    }


    @Test
    void validacionConsultaTrabajador(){

        ConsultarTrabajadoresRequest peticion = ConsultarTrabajadoresRequest.builder()
                .estado("RET").fecIngresoDesde("2020-03-01")
                .fecIngresoHasta("2020-03-31").tipoCotizante("")
                .compania(2)
                .seccion(70).producto(722)
                .codUsr("79625048").tipoDocumentoEmpresa("NT")
                .numeroDocumentoEmpresa(860036081L).numPol(1000387288016L)
                .numSecuPol(39744845698L).nivelSupervision(1)
                .paginaInicio(1).paginaFin(2).soloCalcular(false).build();

        List<SimTypLista> parametrosBusqueda = new ArrayList<>();
        servicio.validacionEntrada(peticion, parametrosBusqueda);
        servicio.validacionRequest(peticion, parametrosBusqueda);
        ConsultaTrabajadoresParamsDTO parametrosPL = ConsultaTrabajadoresParamsDTO.builder()
                .ipArrayParametros(SimTypArrayLista.builder().simTypLista(parametrosBusqueda).build())
                .ipTrabajadoresdetalles(ArlTypArrayTrabbasicdetlCt.builder()
                        .detalle(Collections.singletonList(servicio.validacionConsultaTrabajador(peticion))).build())
                .ipCentroTrabcodigo(
                        ArlTypArrayCntrotrabcodCt.builder().codigosCentros(servicio.validacionCentrosTrabajo(peticion)).build())
                .ipProceso(servicio.construccionIpProceso(peticion)).ipPaginaInicio(1).ipPaginaFin(2).ipValidacion("REFACTORING")
                .build();

        List<SimTypError> errorList= new ArrayList<>();

        SimTypError error= SimTypError.builder()
                .idError(new BigDecimal("1"))
                .descError("Error al consultar")
                .tipoError("Error al consultar")
                .msgError("Error al consultar")
                .msgError1("Error al consultar")
                .build();
        errorList.add(error);
        doAnswer(i -> {
            ConsultaTrabajadoresParamsDTO argumento = i.getArgument(0);
            argumento.setOpResultado(-1);
            argumento.setOpArrerrores(errorList);
            return null;
        }).when(repositorio).prcConsultarTrabajadores(parametrosPL);

        ConsultarTrabajadoresResponse responseService=servicio.consultarTrabajadores(peticion);
        Assert.notNull(responseService.getDataHeader().getCodRespuesta().toString(),"-1");
    }

    @Test
    void validEnumOrdenarPor(){
       Assertions.assertEquals(servicio.getOrdenarPor(1),"DOCTIPO");
       Assertions.assertEquals(servicio.getOrdenarPor(2),"NIT");
       Assertions.assertEquals(servicio.getOrdenarPor(3),"CODTIPOCOTIZANTE");
       Assertions.assertEquals(servicio.getOrdenarPor(4),"CENTROTRABAJO");
       Assertions.assertEquals(servicio.getOrdenarPor(5),"INICOBERTURA");
       Assertions.assertEquals(servicio.getOrdenarPor(6),"FINCOBERTURA");
       Assertions.assertEquals(servicio.getOrdenarPor(7),"ESTADO");
       Assertions.assertEquals(servicio.getOrdenarPor(8),"");
    }

    @Test
    void validEnumDireccion(){
        Assertions.assertEquals(servicio.getDireccion(1),"ASC");
        Assertions.assertEquals(servicio.getDireccion(2),"DESC");
        Assertions.assertEquals(servicio.getDireccion(3),"");
    }
}
