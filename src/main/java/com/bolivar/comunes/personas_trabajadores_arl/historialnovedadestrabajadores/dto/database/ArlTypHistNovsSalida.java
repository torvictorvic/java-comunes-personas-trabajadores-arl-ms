package com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.dto.database;

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
@BolivarObject(objectName = "ARL_TYP_HIST_NOVS_SALIDA")
@Schema(name = "ArlTypHistNovsSalida")
public class ArlTypHistNovsSalida {
   @Schema(name = "tipoDocDesc", description = "Código y valor del tipo de documento del trabajador")
   private SimTypLookup tipoDocDesc;
   @Schema(name = "tipotransaccion", description = "Código y valor del tipo de la novedad registrada")
   private SimTypLookup tipotransaccion;
   @Schema(name = "ideNit", description = "Código y valor del número de documento del trabajador")
   private SimTypLookup ideNit;
   @Schema(name = "desccentrotrabajotransaccion", description = "Código y descripción del centro de trabajo")
   private SimTypLookup desccentrotrabajotransaccion;
   @Schema(name = "fechatransaccion", description = "Fecha de la transacción")
   private Date fechatransaccion;
   @Schema(name = "horatransaccion", description = "Hora de la transacción")
   private String horatransaccion;
   @Schema(name = "fechaaplicacionnovedad", description = "Fecha de inicio de la aplicación de la novedad")
   private Date fechaaplicacionnovedad;
   @Schema(name = "usuariotransaccioncodigo", description = "Número de documento/código de BD del usuario que registra la transacción")
   private String usuariotransaccioncodigo;
   @Schema(name = "usuariotransaccionnombre", description = "Nombre del usuario que registra la transacción")
   private String usuariotransaccionnombre;
   @Schema(name = "fechaIniInac", description = "Fecha de inicio de inactividad para novedades específicas")
   private Date fechaIniInac;
   @Schema(name = "fechaFinInac", description = "Fecha fin de inactividad para novedades específicas")
   private Date fechaFinInac;
   @Schema(name = "fechaIniCobertura", description = "Fecha de inicio de cobertura de la novedad")
   private Date fechaIniCobertura;
   @Schema(name = "fechaFinCobertura", description = "Fecha fin de cobertura de la novedad")
   private Date fechaFinCobertura;
   @Schema(name = "tipoCot", description = "Tipo de identificación de trabajador")
   private BigDecimal tipoCot;
}
