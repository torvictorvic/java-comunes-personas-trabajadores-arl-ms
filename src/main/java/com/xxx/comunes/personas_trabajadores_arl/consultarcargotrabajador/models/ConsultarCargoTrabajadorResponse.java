package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.models;

import com.xxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.DataHeaderDTO;
import com.xxxxxxxx.comunes.personas_trabajadores_arl.consultarcargotrabajador.dto.ConsultaListaCargoTrabajadorDataDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(name = "ConsultarCargoTrabajadorResponse")
public class ConsultarCargoTrabajadorResponse {
    @Schema(name = "dataHeader", description = "Cabecera de la respuesta")
    private DataHeaderDTO dataHeader;
    @Schema(name = "data", description = "Payload de la respuesta")
    private ConsultaListaCargoTrabajadorDataDTO data;
}
