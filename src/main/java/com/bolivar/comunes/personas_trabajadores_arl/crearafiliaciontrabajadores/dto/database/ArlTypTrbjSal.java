package com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.dto.database;

import java.math.BigDecimal;
import java.util.Date;

import com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLookup;
import com.bolivar.mybatis.util.core.annotation.BolivarObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "ARL_TYP_TRBJ_SAL")
@Schema(name = "ArlTypTrbjSal")
public class ArlTypTrbjSal {
	@Schema(name = "numerosecuenciapoliza", description = "Empresa: Numero de secuencia de poliza")
	private BigDecimal numerosecuenciapoliza;
	@Schema(name = "empresatipoidentificacion", description = "Empresa: Tipo de Identificacion de la Empresa")
	private SimTypLookup empresatipoidentificacion;
	@Schema(name = "empresanumeroidentificacion", description = "Empresa: Numero de Identificacion")
	private BigDecimal empresanumeroidentificacion;
	@Schema(name = "trbjdorcentrotrabajo", description = "Trabajador: Centro de Trabajo c2700001.CENTRO_TRAB")
	private SimTypLookup trbjdorcentrotrabajo;
	@Schema(name = "trbjdortipoidentificacion", description = "Trabajador: Tipo de Documento")
	private SimTypLookup trbjdortipoidentificacion;
	@Schema(name = "trbjdornumeroidentificacion", description = "Trabajador: Numero de Documento")
	private BigDecimal trbjdornumeroidentificacion;
	@Schema(name = "trbjdorfechanacimiento", description = "Trabajador: Fecha de Nacimiento")
	private Date trbjdorfechanacimiento;
	@Schema(name = "trbjdorsexo", description = "Trabajador: Sexo")
	private SimTypLookup trbjdorsexo;
	@Schema(name = "trbjdorepsdescripcion", description = "Trabajador: Descripcion EPS")
	private SimTypLookup trbjdorepsdescripcion;
	@Schema(name = "trbjdorafpdescripcion", description = "Trabajador: Descripcion AFP")
	private SimTypLookup trbjdorafpdescripcion;
	@Schema(name = "trbjdorfchainiciocbrtracntrato", description = "Trabajador: Fecha inicio de cobertura de contrato")
	private Date trbjdorfchainiciocbrtracntrato;
	@Schema(name = "trbjdorfchainiciocontrato", description = "Trabajador: Fecha inicio de contrato")
	private Date trbjdorfchainiciocontrato;
	@Schema(name = "trbjdorfchafincontrato", description = "Trabajador: Fecha fin contrato")
	private Date trbjdorfchafincontrato;
	@Schema(name = "trbjdoringresototal", description = "Trabajador: Valor Total Contrato - Ingreso Total")
	private BigDecimal trbjdoringresototal;
	@Schema(name = "trbjdoringresomensual", description = "Trabajador: Ingreso Mensual")
	private BigDecimal trbjdoringresomensual;
	@Schema(name = "trbjdorcargodescripcion", description = "Trabajador: Descripcion del Cargo")
	private SimTypLookup trbjdorcargodescripcion;
	@Schema(name = "trbjdortipocontrato", description = "Trabajador: Descripcion del Tipo de Contrato")
	private SimTypLookup trbjdortipocontrato;
	@Schema(name = "trbjdorformapago", description = "Trabajador: Descripcion de la Forma de Pago")
	private SimTypLookup trbjdorformapago;
	@Schema(name = "trbjdormodalidad", description = "Trabajador: Descripcion de la Modalidad")
	private SimTypLookup trbjdormodalidad;
	@Schema(name = "trbjdorsuministratransporte", description = "Trabajador: Descripcion de Suministro de Transporte")
	private SimTypLookup trbjdorsuministratransporte;
	@Schema(name = "trbjdoribc", description = "Trabajador: IBC")
	private BigDecimal trbjdoribc;
	@Schema(name = "pInfo1", description = "Campo comodin")
	private String pInfo1;
	@Schema(name = "pInfo2", description = "Campo comodin")
	private String pInfo2;
	@Schema(name = "pInfo3", description = "Campo comodin")
	private String pInfo3;
	@Schema(name = "pInfo4", description = "Campo comodin")
	private String pInfo4;
	@Schema(name = "pInfo5", description = "Campo comodin")
	private String pInfo5;
	@Schema(name = "trbjdornombres", description = "Nombres del trabajador")
	private String trbjdornombres;
	@Schema(name = "trbjdortipocotizante", description = "Código y descripción del tipo de cotizante")
	private SimTypLookup trbjdortipocotizante;
}
