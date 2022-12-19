package com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.dto.database;

import com.bolivar.mybatis.util.core.annotation.BolivarObject;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@BolivarObject(objectName = "ARL_TYP_EXCL_TRBJ_DPTES_CP")
public class ArlTypExclTrbjDptesCp {
    private BigDecimal numeroSecuenciaPoliza;
    private BigDecimal numeroPoliza;
    private String empresaTipoIdentifiacion;
    private BigDecimal empresaNumeroIdentifiacion;
    private String trabajadorTipoIdentificacion;
    private BigDecimal trabajadorNumeroIdentificacion;
    private BigDecimal trabajadorCentroTrabajo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
    private Date rangoBusquedaFechaInicial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
    private Date rangoBusquedaFechaFinal;
}
