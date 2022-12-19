package com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.bolivar.mybatis.util.core.annotation.BolivarObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "ARL_TYP_DATOS_TRBJDOR")
@Schema(name = "ArlTypDatosTrbjdor")
public class ArlTypDatosTrbjdor {
	@Schema(name = "grupocotizante", description = "Indicador del grupo de cotizante [1] dependiente [2] independiente")
	private String grupocotizante;
	@Schema(name = "tipocotizante", description = "Indicador de tipo de cotizante. c2700001.DEPEND_INDEPEN")
	private String tipocotizante;
	@Schema(name = "tipocotizantedes", description = "Descripcion del tipo de cotizante")
	private String tipocotizantedes;
	@Schema(name = "trbjdorsecnciatercero", description = "Trabajador: Secuencia Tercero")
	private BigDecimal trbjdorsecnciatercero;
	@NotNull
	@Schema(name = "trbjdortipoidentificacion", description = "Trabajador: Tipo de Documento")
	private String trbjdortipoidentificacion;
	@Schema(name = "trbjdornumeroidentificacion", description = "Trabajador: Numero de Documento")
	@NotNull
	private BigDecimal trbjdornumeroidentificacion;
	@Schema(name = "empresadptocodigo", description = "Empresa: Codigo del Departamento")
	private Integer empresadptocodigo;
	@Schema(name = "empresaciudadcodigo", description = "Empresa: Codigo de Ciudad")
	private Integer empresaciudadcodigo;
	@Schema(name = "trabajadorcentrotrabajo", description = "Trabajador: Centro de Trabajo")
	private Long trabajadorcentrotrabajo;
	@Schema(name = "trbjdortipocontrato", description = "Trabajador: Tipo de Contrato")
	private BigDecimal trbjdortipocontrato;
	@Schema(name = "trbjdordessexo", description = "Trabajador: Descripcion del sexo")
	private String trbjdordessexo;
	@Schema(name = "fechaingreso", description = "Fecha de ingreso del trabajador. c2700001.FEC_INGRESO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaingreso;
	@Schema(name = "trbjdorcodigocargo", description = "Trabajador: Codigo de Cargo")
	@NotNull
	private Integer trbjdorcodigocargo;
	@Schema(name = "trbjdordesccargo", description = "Trabajador: Descripcion del cargo")
	private String trbjdordesccargo;
	@NotNull
	@Schema(name = "trbjdoringresomensual", description = "Ingreso mensual del trabajador. c2700001.SALARIO")
	private BigDecimal trbjdoringresomensual;
	@Schema(name = "trbjdoribc", description = "Trabajador: IBC")
	private BigDecimal trbjdoribc;
	@NotNull
	@Schema(name = "trbjdorepscodigo", description = "Código de la EPS del trabajador. c2700001.COD_EPS")
	private Integer trbjdorepscodigo;
	@Schema(name = "trbjdorepsdes", description = "Nombre de la EPS")
	private String trbjdorepsdes;
	@NotNull
	@Schema(name = "trbjdorafpcodigo", description = "Código de la AFP del trabajador. c2700001.COD_AFP")
	private Integer trbjdorafpcodigo;
	@Schema(name = "trbjdorafpdes", description = "Nombre de la AFP")
	private String trbjdorafpdes;
	@Schema(name = "trbjdormcapensionado", description = "Trabajador C2700001.Mca_Pensionado")
	private String trbjdormcapensionado;
	@Schema(name = "trbjdorcolombianoext", description = "Trabajador C2700001.Mca_Res_Ext")
	private String trbjdorcolombianoext;
	@NotNull
	@Schema(name = "trbjdorfechainiciocobertura", description = "Trabajador: Fecha de Inicio de Contrato/cobertura")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date trbjdorfechainiciocobertura;
	@Schema(name = "trbjdorfechafincobertura", description = "Trabajador: Fecha fin de Contrato/cobertura")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date trbjdorfechafincobertura;
	@Schema(name = "trbjdorextranjero", description = "TrabajadorC2700001.Mca_Extranjero")
	private String trbjdorextranjero;
	@Schema(name = "usuarioconectado", description = "Usuario conectado al portal")
	private String usuarioconectado;
	@Schema(name = "trbjdorindcdoracptcioncontrato", description = "Trabajador: Inidicador de acpetacion del contrato")
	private String trbjdorindcdoracptcioncontrato;
	@Schema(name = "trbjdorconsultable", description = "Trabajador: [S] SI ES CONSULTABLE [CLIENTE RESTINGIDO]")
	private String trbjdorconsultable;
	@Schema(name = "trbjdortiponovedad", description = "Trabajador: Tipo Novedad")
	private String trbjdortiponovedad;
	@Schema(name = "trbjdorfechanovedad", description = "Trabajador: Fecha de novedad")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date trbjdorfechanovedad;
	@Schema(name = "trbjdorformapago", description = "Trabajador: Forma de Pago")
	private String trbjdorformapago;
	@Schema(name = "trbjdoringresototal", description = "Trabajador: Valor Total Contrato - Ingreso Total")
	private BigDecimal trbjdoringresototal;
	@Schema(name = "trbjdormcatransporte", description = "Trabajador: Marca transporte")
	private String trbjdormcatransporte;
	@Schema(name = "trbjdormodalidad", description = "Modalidad de trabajo")
	private Integer trbjdormodalidad;
	@Schema(name = "localidad", description = "Localidad del trabajador")
	private String localidad;
	@Schema(name = "zona", description = "Zona del trabajador")
	private String zona;
	@Schema(name = "codigoJornada", description = "Código de la jornada asignada [solo para DEPENDIENTES]")
	private Integer codigoJornada;
	@Schema(name = "descErrTercero", description = "Descripcion error resultado de Terceros")
	private String descErrTercero;
	@Schema(name = "pInfo1", description = "Campo comodín usado para la marca de ingreso masivo")
	private String pInfo1;
	@Schema(name = "pInfo2", description = "Campo comodin")
	private String pInfo2;
	@Schema(name = "pInfo3", description = "Campo comodin")
	private String pInfo3;
	@Schema(name = "pInfo4", description = "Campo comodin")
	private String pInfo4;
	@Schema(name = "pInfo5", description = "Campo comodin")
	private String pInfo5;
}
