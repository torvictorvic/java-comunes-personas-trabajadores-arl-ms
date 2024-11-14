# Historial Novedades Trabajadores

Micro-servicio que permite consultar historico de novedades del trabajador.

>  #aws #java #comunes #trabajador #tronador
---
## Tabla de Contenido

- [Descripción](#descripción)
- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Proyectos relacionados](#proyectos-relacionados)
- [Endpoints](#endpoints)
- [APikeys](#apikeys)
- [Autores](#autores)
- [Licencia](#licencia)
---

## Descripción

Micro-servicio que permite consultar historico de novedades del trabajador.
Esta operación consume el SP ARL_PCK_TRABAJADORES.PRC_CONSULTA_NOVEDADES_TRBJDR ubicada en base de datos de Tronador.

---

## Detalle de Funcionalidades

#### GET/ /api/v1/empresas/trabajadores

Header obligatorios

| Header    | Tipo | Descripción                                        | Ejemplo                                  |
| ---       | ---  | --- |------------------------------------------|
| x-api-key | string | Api key del dominio de personas-trabajadores-arl | prjhvnkUSQ8wvoWBYLERJ2Y7qLBhlCN3amqsQPFM |

Notas:

##### REQUEST BODY
```
"request": {
	"auth": {
		"type": "apikey",
		"apikey": [
			{
				"key": "value",
				"value": "prjhvnkUSQ8wvoWBYLERJ2Y7qLBhlCN3amqsQPFM",
				"type": "string"
			},
			{
				"key": "key",
				"value": "x-api-key",
				"type": "string"
			},
			{
				"key": "in",
				"value": "header",
				"type": "string"
			}
		]
	},
	"method": "GET",
	"header": [],
	"url": {
		"raw": "{{servidor}}gestion-afiliaciones/api/v1/trabajadores/historico/novedades?codUsr=40046226&numDocumentoEmpresa=860036081&numDocumentoTrabajador=1073520770&numPoliza=39744845698",
		"host": [
			"{{servidor}}gestion-afiliaciones"
		],
		"path": [
			"api",
			"v1",
			"trabajadores",
			"historico",
			"novedades"
		],
		"query": [
			{
				"key": "codUsr",
				"value": "40046226"
			},
			{
				"key": "numDocumentoEmpresa",
				"value": "860036081"
			},
			{
				"key": "numDocumentoTrabajador",
				"value": "1073520770"
			},
			{
				"key": "numPoliza",
				"value": "39744845698"
			}
		]
	}
}
```

##### RESPONSE OK
```
{
  "dataHeader": {
    "codRespuesta": 0,
    "errores": []
  },
  "data": [
    {
      "tipotransaccion": {
        "codigo": "ING",
        "valor": "INGRESO"
      },
      "horatransaccion": "15:44",
      "tipo_DOC_DESC": {
        "codigo": "CC",
        "valor": "CEDULA DE CIUDADANIA"
      },
      "desccentrotrabajotransaccion": {
        "codigo": "1",
        "valor": "1 - OFICINA PRINCIPAL"
      },
      "usuariotransaccioncodigo": "79625048",
      "fechaaplicacionnovedad": "2021-10-16T05:00:00.000+00:00",
      "fechatransaccion": "2021-10-15T05:00:00.000+00:00"
    }
  ]
}
```

##### RESPONSE ERROR
```
{
    "codigo": "ETBR01",
    "mensaje": "Error tecnico validando la estructura del mensaje de entrada",
    "descripcion": "Datos de Entrada Incorrectos",
    "categoria": "TECNICO",
    "path": "uri=/trabajadores_arl/api/v1/historicoNovedades/trabajadores",
    "errores": [
        {
            "descripcion": "Required request parameter 'numDocumentoEmpresa' for method parameter type String is not present"
        }
    ]
}
```

---

## Proyectos relacionados

A continuación se detallan los módulos o funcionalidades que usan los servicios contenidos en este micro-servicio:


---
## Endpoints

- **DEV**
    - API Gateway: https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/trabajadores_arl/api/v1/historicoNovedades/trabajadores

- **TEST**
    - API Gateway: https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/trabajadores_arl/api/v1/historicoNovedades/trabajadores

- **PROD**
    - API Gateway: https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/trabajadores_arl/api/v1/historicoNovedades/trabajadores

---
## APikeys

El x-api-key se debe enviar en el header de la petición

- **DEV**
    - x-api-key: prjhvnkUSQ8wvoWBYLERJ2Y7qLBhlCN3amqsQPFM

- **TEST**
    - x-api-key: 227mk71hd86xWa84ui0uQ4AAQhUfozs87NNSvG70

---
## Autores

El equipo involucrado en la implementación de estos componentes se detalla a continuación:

- Equipo de Desarrollo: Equipo desarrollo Refactoring Portal ARL
- Líder Técnico: Javier Steven Pérez Fernández
- Arquitecto de TI: Miguel Angel Hernandez Zapata

---

## Licencia

![License](https://img.shields.io/badge/Licencia-Seguros%20Bolivar-green)
- Copyright 2022 ©