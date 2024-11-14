package com.xxxxxxxxxxxxx.comunes.personas_trabajadores_arl.commons.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.xxxxxxxxxxxxx.comunes.personas_trabajadores_arl.retirartrabajadordependiente.dto.TrabajadorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ActualizaRetiroTrabajadorRequest")
public class RetiroTrabajadorRequestDTO {
	@Valid
	@NotNull(message = "La información del trabajador no puede ser nula")
	@Schema(name = "trabajador", description = "Información necesaria para hacer el retiro del trabajador")
	TrabajadorDTO trabajador;
}
