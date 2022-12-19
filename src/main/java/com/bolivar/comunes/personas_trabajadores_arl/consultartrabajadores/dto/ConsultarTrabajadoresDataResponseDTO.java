package com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto;

import java.util.List;

import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.dto.database.ArlTypConsltatrabajadoresCt;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ConsultarTrabajadoresDataResponseDTO")
public class ConsultarTrabajadoresDataResponseDTO {
	@Schema(name = "trabajadores", description = "Lista de trabajadores")
	private List<ArlTypConsltatrabajadoresCt> trabajadores;
	@Schema(name = "numeroPoliza", description = "Número de póliza de la empresa")
	private Long numeroPoliza;
	@Schema(name = "fechaPoliza", description = "Fecha de expedición de la primer póliza de la empresa (Con esta fecha se generan los certificados)")
	private String fechaPoliza;
	@Schema(name = "totalRegistros", description = "Número total de trabajadores (Solo se llena si la bandera soloCalcular está en true)")
	private Long totalRegistros;
}
