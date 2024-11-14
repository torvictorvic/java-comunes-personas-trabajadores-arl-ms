package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database;

import java.math.BigDecimal;
import java.util.Date;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLookup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArlTypConsltatrabajadoresCt {
	@Schema(name = "ideNit", description = "Tipo de identificación de trabajador")
	private String ideNit;
	@Schema(name = "nit", description = "Número de indentificación del trabajdor")
	private BigDecimal nit;
	@Schema(name = "fecIngreso", description = "Fecha de ingreso del trabajador")
	private Date fecIngreso;
	@Schema(name = "fecBaja", description = "Fecha de baja del trabajador")
	private Date fecBaja;
	@Schema(name = "descCentrotrab", description = "Código y descripción del centro de trabajo")
	private SimTypLookup descCentrotrab;
	@Schema(name = "descCargo", description = "Código y descripción del cargo del trabajador")
	private SimTypLookup descCargo;
	@Schema(name = "descEps", description = "Código y descripción de la EPS del trabajador")
	private SimTypLookup descEps;
	@Schema(name = "descAfp", description = "Código y descripción de la AFP del trabajador")
	private SimTypLookup descAfp;
	@Schema(name = "descDependIndepen", description = "Código y descripción del tipo de cotizante de trabajador")
	private SimTypLookup descDependIndepen;
	@Schema(name = "salario", description = "Salario trabajador")
	private BigDecimal salario;
	@Schema(name = "claseRiesgo", description = "Clase de riesgo de trabajador")
	private String claseRiesgo;
	@Schema(name = "tasaRiesgo", description = "Tasa de riesgo de trabajador")
	private String tasaRiesgo;
	@Schema(name = "sexo", description = "Sexo de trabajador")
	private SimTypLookup sexo;
	@Schema(name = "fecNacimiento", description = "Fecha de nacimiento de trabajador")
	private Date fecNacimiento;
	@Schema(name = "estado", description = "Estado de trabajador")
	private String estado;
	@Schema(name = "desCentrotrabCiudad", description = "Código y descripción del centro de trabajo de trabajador")
	private SimTypLookup desCentrotrabCiudad;
	@Schema(name = "coberturaExteriorFecInicio", description = "Fecha de inicio de cobertura en el exterior de trabajador")
	private Date coberturaExteriorFecInicio;
	@Schema(name = "coberturaExteriorFecFin", description = "Fecha de fin de cobertura en el exterior de trabajador")
	private Date coberturaExteriorFecFin;
	@Schema(name = "coberturaExteriorIndicator", description = "Indicador de cobertura en el exterior de trabajador")
	private String coberturaExteriorIndicator;
	@Schema(name = "naturalesPrimerNombre", description = "Primer nombre de trabajador")
	private String naturalesPrimerNombre;
	@Schema(name = "naturalesSegundoNombre", description = "Segundo nombre de trabajador")
	private String naturalesSegundoNombre;
	@Schema(name = "naturalesPrimerApellido", description = "Primer apellido de trabajador")
	private String naturalesPrimerApellido;
	@Schema(name = "naturalesSegundoApellido", description = "Segundo apellido de trabajador")
	private String naturalesSegundoApellido;
}
