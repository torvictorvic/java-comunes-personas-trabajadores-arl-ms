package com.bolivar.comunes.personas_trabajadores_arl.commons.dto.database;


import com.bolivar.mybatis.util.core.annotation.BolivarObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "sim_pck_extrac_infoguardian")
@Schema(name = "SimTypArlTrabajador")
public class SimTypArlTrabajador {
    @Schema(name = "idEnvio", description = "Id propio de la tabla de trabajadores")
    private BigDecimal idEnvio;

    @Schema(name = "tipoDocEmpresa", description = "Tipo de documento de empresa")
    private String tipoDocEmpresa;

    @Schema(name = "numDocEmpresa", description = "Numero de documento de empresa")
    private String numDocEmpresa;

    @Schema(name = "genero", description = "Genero de la persona")
    private String genero;

    @Schema(name = "tipDocEmpleado", description = "Tipo de documento de la empresa")
    private String tipDocEmpleado;

    @Schema(name = "numDocEmpleado", description = "Numero de documento del empleado")
    private String numDocEmpleado;

    @Schema(name = "activo", description = "Indica si un empleado esta activo")
    private BigDecimal activo;

    @Schema(name = "autorizado", description = "Indica si es un empleado con autizaciones")
    private BigDecimal autorizado;

    @Schema(name = "lugarExp", description = "Lugar expedición de la identificacion")
    private String lugarExp;

    @Schema(name = "fechExp", description = "Fecha expedición de la identificacion")
    private String fechExp;

    @Schema(name = "fechaNacimiento", description = "Fecha de nacimiento")
    private Date fechaNacimiento;

    @Schema(name = "nombre", description = "Nombres de la persona")
    private String nombre;

    @Schema(name = "apellidos", description = "Apellidos de la persona")
    private String apellidos;

    @Schema(name = "tipContrato", description = "Tipo de contrato")
    private String tipContrato;

    @Schema(name = "profesion", description = "Profesion de la persona")
    private String profesion;

    @Schema(name = "centroTrabajo", description = "Centro de Trabajo de la persona")
    private String centroTrabajo;

    @Schema(name = "codCargo", description = "Codido de la persona")
    private String codCargo;

    @Schema(name = "ocupacion", description = "Ocupacion de la persona")
    private String ocupacion;

    @Schema(name = "salarioIbc", description = "Salario Ibc de la persona")
    private BigDecimal salarioIbc;

    @Schema(name = "eps", description = "Eps de la persona")
    private String eps;

    @Schema(name = "afp", description = "Afp de la persona")
    private String afp;

    @Schema(name = "arl", description = "Arl de la persona")
    private String arl;

    @Schema(name = "pais", description = "Pais nacimiento de la persona")
    private String pais;

    @Schema(name = "departamento", description = "Departamento residencia de la persona")
    private String departamento;

    @Schema(name = "ciudad", description = "ciudad residencia de la persona")
    private String ciudad;

    @Schema(name = "rh", description = "Rh de la persona")
    private String rh;

    @Schema(name = "nivelRiesgos", description = "Nivel de riesgos de la persona")
    private String nivelRiesgos;

    @Schema(name = "centroCostos", description = "Centro de Costos asociado de la persona")
    private String centroCostos;

    @Schema(name = "observacion", description = "Observaciones para la persona")
    private String observacion;

    @Schema(name = "direccion", description = "Direccion de la persona")
    private String direccion;

    @Schema(name = "contrato", description = "Tipo de contrato de la persona")
    private String contrato;

    @Schema(name = "fecIniContr", description = "Fecha de inicio de contrato de la persona")
    private Date fecIniContr;

    @Schema(name = "fecIniContr", description = "Fecha de finalizacion de contrato de la persona")
    private Date fecFinContr;

    @Schema(name = "mail", description = "Email de la persona")
    private String mail;
}