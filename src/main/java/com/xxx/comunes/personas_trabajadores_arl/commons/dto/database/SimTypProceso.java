package com.xxxxxxxxxxxxx.comunes.personas_trabajadores_arl.commons.dto.database;

import com.xxxxxxxxxxxxx.mybatis.util.core.annotation.BolivarObject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BolivarObject(objectName = "SIM_TYP_PROCESO")
@Schema(name = "SimTypProceso")
public class SimTypProceso {
	@Schema(name = "p_MODULO", description = "Modulo desde el cual se hace el llamado a la operacion")
	private String p_MODULO;
	@Schema(name = "p_PROCESO", description = "Identificador del proceso")
	private Integer p_PROCESO;
	@Schema(name = "p_SUBPROCESO", description = "Identificador del subproceso")
	private Integer p_SUBPROCESO;
	@Schema(name = "p_COD_CIA", description = "Código de la compañía")
	private Integer p_COD_CIA;
	@Schema(name = "p_COD_SECC", description = "Código de la sección")
	private Integer p_COD_SECC;
	@Schema(name = "p_COD_PRODUCTO", description = "Código del producto")
	private Integer p_COD_PRODUCTO;
	@Schema(name = "p_SUBPRODUCTO", description = "Código del subproducto")
	private Integer p_SUBPRODUCTO;
	@Schema(name = "p_COD_USR", description = "Identificacion del usuario conectado")
	private String p_COD_USR;
	@Schema(name = "p_AGENCIA_USR", description = "Agencia del usuario conectado")
	private Integer p_AGENCIA_USR;
	@Schema(name = "p_ENTIDAD_COLOCADORA", description = "Identificacion de la entidad colocadora")
	private Integer p_ENTIDAD_COLOCADORA;
	@Schema(name = "p_CANAL", description = "Canal de ejecución del proceso")
	private Integer p_CANAL;
	@Schema(name = "p_SISTEMA_ORIGEN", description = "Identificación del sistema de origen del llamado a la operación")
	private Integer p_SISTEMA_ORIGEN;
	@Schema(name = "p_PAIS", description = "Pais")
	private Integer p_PAIS;
	@Schema(name = "p_SESSIONID", description = "Identificación de la sesion")
	private String p_SESSIONID;
	@Schema(name = "p_DIRECCIONIP", description = "Direccion ip del usuario conectado")
	private String p_DIRECCIONIP;
	@Schema(name = "p_INFO1", description = "Campo comodin usado para el tipo de documento de la empresa")
	private String p_INFO1;
	@Schema(name = "p_INFO2", description = "Campo comodin usado para el número de documento de la empresa")
	private String p_INFO2;
	@Schema(name = "p_INFO3", description = "Campo comodin usado para el número de la póliza")
	private String p_INFO3;
	@Schema(name = "p_INFO4", description = "Campo comodin usado para el número de secuencia de la póliza")
	private String p_INFO4;
	@Schema(name = "p_INFO5", description = "Campo comodin")
	private String p_INFO5;
}
