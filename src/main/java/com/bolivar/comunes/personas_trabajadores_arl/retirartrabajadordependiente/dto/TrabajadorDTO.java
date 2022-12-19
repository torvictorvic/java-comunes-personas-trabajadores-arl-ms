package com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Valid
@Schema(name = "TrabajadorDTO")
public class TrabajadorDTO {
	@NotNull
	@Schema(name = "fechaRetiroTrabajador", description = "Fecha de retiro del trabajador")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaRetiroTrabajador;
	@NotNull
	@Schema(name = "fechaNovedad", description = "Fecha de registro de la novedad del trabajador")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaNovedad;
	@NotNull
	@Schema(name = "fechaIngreso", description = "Fecha de ingreso del trabajador")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaIngreso;
	@NotNull
	@Schema(name = "numeroPoliza", description = "Número de póliza de la empresa de retiro")
	private BigDecimal numeroPoliza;
	@NotNull
	@Schema(name = "centroTrabajo", description = "centro de trabajo del trabajador")
	private Long centroTrabajo;
	@NotNull
	@Schema(name = "numeroIdentificacion", description = "Número de identificación del trabajador")
	private Long numeroIdentificacion;
	@NotNull
	@Schema(name = "tipoIdentificacion", description = "Tipo de identificación del trabajador")
	private String tipoIdentificacion;
	@Schema(name = "departamentoLabora", description = "Departamento donde labora el trabajador")
	private String departamentoLabora;
	@Schema(name = "municipioLabora", description = "Municipio donde labora el trabajador")
	private String municipioLabora;
	@NotNull
	@Schema(name = "tipoCotizante", description = "Tipo de cotizante del trabajador")
	private String tipoCotizante;
	@NotNull
	@Schema(name = "compania", description = "Código de la compañia")
	private Integer compania;
	@NotNull
	@Schema(name = "seccion", description = "Código de la sección")
	private Integer seccion;
	@NotNull
	@Schema(name = "producto", description = "Código del producto")
	private Integer producto;
	@Schema(name = "sistemaOrigen", description = "Sistema de origen, sirve para el medio de cargue de la tabla C2700003")
	private Integer sistemaOrigen;
	@Schema(name = "sexo", description = "Sexo del trabajador")
	private String sexo;
	@Schema(name = "aceptaCondiciones", description = "Marca de aceptación de condiciones")
	private String aceptaCondiciones;
	@NotNull
	@Schema(name = "numeroDocumentoEmpresa", description = "Número de documento de la empresa de retiro")
	private Long numeroDocumentoEmpresa;
	@NotNull
	@Schema(name = "tipoDocumentoEmpresa", description = "Tipo de documento de la empresa de retiro")
	private String tipoDocumentoEmpresa;
	@NotNull
	@Schema(name = "usuarioTransaccion", description = "Identificación del usuario que ejecuta el retiro")
	private String usuarioTransaccion;
}
