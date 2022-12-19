package com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "HistorialNovedadesTrabajadoresRequest")
public class HistorialNovedadesTrabajadoresRequest {
    @Schema(name = "numeroDocumentoEmpresa", description = "Número de documento de la empresa asociada al trabajador")
    private String numeroDocumentoEmpresa;
    @Schema(name = "tipoDocumentoEmpresa", description = "Tipo de documento de la empresa asociada al trabajador")
    private String tipoDocumentoEmpresa;
    @Schema(name = "numeroDocumentoUsuario", description = "Número de documento del trabajador a consultar")
    private String numeroDocumentoUsuario;
    @Schema(name = "fechaDesde", description = "Parámetro de fecha desde la cual se desea consultar. Sea fecha de inicio, fin o registro")
    private String fechaDesde;
    @Schema(name = "fechaHasta", description = "Parámetro de fecha hasta la cual se desea consultar. Sea fecha de inicio, fin o registro")
    private String fechaHasta;
}
