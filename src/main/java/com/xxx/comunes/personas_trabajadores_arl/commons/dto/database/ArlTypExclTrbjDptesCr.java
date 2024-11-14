package com.xxxxxxxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database;

import com.xxxxxxxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database.SimTypLookup;
import com.xxxxxxxxxxxxx.mybatis.util.core.annotation.BolivarObject;
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
@BolivarObject(objectName = "ARL_TYP_EXCL_TRBJ_DPTES_CR")
public class ArlTypExclTrbjDptesCr {

    @Schema(name = "trabajadorTipoIdentificacion", description = "Tipo de identificación de trabajador")
    private SimTypLookup trabajadorTipoIdentificacion;

    @Schema(name = "trabajadorNumeroIdentificacion", description = "Número de indentificación del trabajdor")
    private BigDecimal trabajadorNumeroIdentificacion;

    @Schema(name = "descTrabajadorCentroTrabajo", description = "Tipo de descripción del centro de trabajo")
    private SimTypLookup descTrabajadorCentroTrabajo;

    @Schema(name = "trabajadorDescripcionCotizante", description = "Tipo de descripción de cotización")
    private SimTypLookup trabajadorDescripcionCotizante;

    @Schema(name = "trabajadorFechaIngreso", description = "Fecha de ingreso del trabajador")
    private Date trabajadorFechaIngreso;

    @Schema(name = "trabajadorFechaIniCobertura", description = "Fecha de inicio de cobertura del trabajador")
    private Date trabajadorFechaIniCobertura;

    @Schema(name = "trabajadorFechaRetiro", description = "Fecha de retiro del trabajador")
    private Date trabajadorFechaRetiro;
}
