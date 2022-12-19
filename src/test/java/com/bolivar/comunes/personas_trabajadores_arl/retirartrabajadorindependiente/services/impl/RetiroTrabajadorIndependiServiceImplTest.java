package com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadorindependiente.services.impl;

import static org.mockito.Mockito.doAnswer;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadorindependiente.services.RetirarTrabajadorIndependienteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypError;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypProceso;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.RetiroTrabajadorDependienteParamDTO;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.TrabajadorDTO;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.database.ArlTypExclTrbjDptes;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorRequestDTO;
import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.RetiroTrabajadorResponseDTO;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadorindependiente.repository.PrcExcluirTrabIndRepository;
import com.bolivar.error.handling.exception.BolivarBusinessException;

@ExtendWith(MockitoExtension.class)
class RetiroTrabajadorIndependiServiceImplTest {

	@Mock
	PrcExcluirTrabIndRepository repositorio;

	@InjectMocks
    RetirarTrabajadorIndependienteServiceImpl servicio;

	@Test
	void debeRetornarRespuestaCorrectaSiBDRespondeCeroAlRetirarTrabajadorIndependiente() {
		RetiroTrabajadorRequestDTO peticion = RetiroTrabajadorRequestDTO.builder()
				.trabajador(TrabajadorDTO.builder().aceptaCondiciones("S").centroTrabajo(1L).compania(2)
						.departamentoLabora("1").fechaIngreso(parseDate("2022-03-03 00:31:20"))
						.fechaNovedad(parseDate("2022-03-03 00:31:20"))
						.fechaRetiroTrabajador(parseDate("2022-03-04 00:31:20")).municipioLabora("11")
						.numeroDocumentoEmpresa(860034313L).numeroIdentificacion(1073520770L)
						.numeroPoliza(BigDecimal.valueOf(2060000051526L)).producto(722).seccion(70).sexo("M")
						.sistemaOrigen(1526).tipoCotizante("1").tipoDocumentoEmpresa("NT").tipoIdentificacion("CC")
						.usuarioTransaccion("1073520770").build())
				.build();
		ArlTypExclTrbjDptes trabajador = ArlTypExclTrbjDptes.builder().dptoLabora("1")
				.fechaIngresoTrabajador(parseDate("2022-03-03 00:31:20")).muniLabora("11").pmcaAcptaConds("S").sexo("M")
				.trabajadorCentroTrabajo(BigDecimal.valueOf(1))
				.trabajadorNovedadFechaRetiro(parseDate("2022-03-04 00:31:20"))
				.trabajadorNumeroIdentificacion(BigDecimal.valueOf(1073520770L)).trabajadorTipoCotizante("1")
				.trabajadorTipoIdentificacion("CC").build();
		SimTypProceso procesoStub = SimTypProceso.builder().p_COD_CIA(2).p_COD_PRODUCTO(722).p_COD_SECC(70)
				.p_INFO3("2060000051526").p_COD_USR("1073520770").p_SISTEMA_ORIGEN(1526).build();
		RetiroTrabajadorDependienteParamDTO parametros = RetiroTrabajadorDependienteParamDTO.builder()
				.ipParametros(trabajador).ipProceso(procesoStub).ipValidacion("REFPORTARL").build();
		doAnswer(i -> {
			RetiroTrabajadorDependienteParamDTO argumento = i.getArgument(0);
			argumento.setOpResultado(0);
			argumento.setOpArrerrores(Collections.emptyList());
			return null;
		}).when(repositorio).prcExcluirTrabajadorIndependiente(parametros);
		RetiroTrabajadorResponseDTO resultado = servicio.retirarTrabajadorIndependiente(peticion);
		Assertions.assertEquals(0, resultado.getDataHeader().getCodRespuesta());
		Assertions.assertEquals(0, resultado.getDataHeader().getErrores().size());

	}

	@Test
	void debeLanzarErrorSiBDRespondeSiEsDiferenteDeCero() {
		RetiroTrabajadorRequestDTO peticion = RetiroTrabajadorRequestDTO.builder()
				.trabajador(TrabajadorDTO.builder().aceptaCondiciones("S").centroTrabajo(1L).compania(2)
						.departamentoLabora("1").fechaIngreso(parseDate("2022-03-03 00:31:20"))
						.fechaNovedad(parseDate("2022-03-03 00:31:20"))
						.fechaRetiroTrabajador(parseDate("2022-03-04 00:31:20")).municipioLabora("11")
						.numeroDocumentoEmpresa(860034313L).numeroIdentificacion(1073520770L)
						.numeroPoliza(BigDecimal.valueOf(2060000051526L)).producto(722).seccion(70).sexo("M")
						.sistemaOrigen(1526).tipoCotizante("1").tipoDocumentoEmpresa("NT").tipoIdentificacion("CC")
						.usuarioTransaccion("1073520770").build())
				.build();
		ArlTypExclTrbjDptes trabajador = ArlTypExclTrbjDptes.builder().dptoLabora("1")
				.fechaIngresoTrabajador(parseDate("2022-03-03 00:31:20")).muniLabora("11").pmcaAcptaConds("S").sexo("M")
				.trabajadorCentroTrabajo(BigDecimal.valueOf(1))
				.trabajadorNovedadFechaRetiro(parseDate("2022-03-04 00:31:20"))
				.trabajadorNumeroIdentificacion(BigDecimal.valueOf(1073520770L)).trabajadorTipoCotizante("1")
				.trabajadorTipoIdentificacion("CC").build();
		SimTypProceso procesoStub = SimTypProceso.builder().p_COD_CIA(2).p_COD_PRODUCTO(722).p_COD_SECC(70)
				.p_INFO3("2060000051526").p_COD_USR("1073520770").p_SISTEMA_ORIGEN(1526).build();
		RetiroTrabajadorDependienteParamDTO parametros = RetiroTrabajadorDependienteParamDTO.builder()
				.ipParametros(trabajador).ipProceso(procesoStub).ipValidacion("REFPORTARL").build();
		doAnswer(i -> {
			RetiroTrabajadorDependienteParamDTO argumento = i.getArgument(0);
			argumento.setOpResultado(-1);
			argumento.setOpArrerrores(Collections.singletonList(SimTypError.builder().idError(BigDecimal.valueOf(-1))
					.descError("Error de prueba").tipoError("W").build()));
			return null;
		}).when(repositorio).prcExcluirTrabajadorIndependiente(parametros);
		Assertions.assertThrows(BolivarBusinessException.class, () -> {
			servicio.retirarTrabajadorIndependiente(peticion);
		});
	}

	private Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

}
