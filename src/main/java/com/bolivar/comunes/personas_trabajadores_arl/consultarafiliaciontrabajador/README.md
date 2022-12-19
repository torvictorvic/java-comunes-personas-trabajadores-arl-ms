# Consultar Afiliación Trabajadores

Micro-servicio que permite consultar las afiliaciones vigentes del trabajador.

>  #aws #java #comunes #afiliacion
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

Micro-servicio que permite obtener las afiliaciones vigentes del trabajador.
Una entidad afiliacion-trabajador representa la relación de un trabajador con una empresa dependiente al tipo de cotizante. 

Esta operación consume el SP ARL_PCK_EXCLSION_TRBJ_DPNDTES.PROC_CONSULTAR ubicada en base de datos de Tronador.

---

## Detalle de Funcionalidades

#### GET/ /api/v1/empresas/afiliaciones

Header obligatorios
| Header | Tipo | Descripción | Ejemplo
| ------------- | ------------- | ------------- | ------------- |
|               |               |               |               |

Notas:

##### REQUEST
```
"request": {
	"method": "GET",
	"header": [
		{
			"key": "x-api-key",
			"value": "{{apiKey}}",
			"type": "default"
		}
	],
	"url": {
		"raw": "{{servidor}}/api/v1/empresas/afiliaciones?tipodocempresa=NT&numdocempresa=860036081&tipodoc=CC&numdoc=79625048&centrotrabajo=1&numpoliza=1000387288016&numsecpoliza=39744845698&codcia=2&codsecc=70&codprod=722&codusr=79625048&fecini=16/02/2022&fecfin=16/03/2022",
		"host": [
			"{{servidor}}"
		],
		"path": [
			"api",
			"v1",
			"empresas",
			"afiliaciones"
		],
		"query": [
			{
				"key": "tipodocempresa",
				"value": "NT"
			},
			{
				"key": "numdocempresa",
				"value": "860036081"
			},
			{
				"key": "tipodoc",
				"value": "CC"
			},
			{
				"key": "numdoc",
				"value": "79625048"
			},
			{
				"key": "centrotrabajo",
				"value": "1"
			},
			{
				"key": "numpoliza",
				"value": "1000387288016"
			},
			{
				"key": "numsecpoliza",
				"value": "39744845698"
			},
			{
				"key": "codcia",
				"value": "2"
			},
			{
				"key": "codsecc",
				"value": "70"
			},
			{
				"key": "codprod",
				"value": "722"
			},
			{
				"key": "codusr",
				"value": "79625048"
			},
			{
				"key": "fecini",
				"value": "16/02/2022"
			},
			{
				"key": "fecfin",
				"value": "16/03/2022"
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
    "errores": [
      {
        "idError": 0,
        "descError": "string",
        "tipoError": "string"
      }
    ]
  },
  "data": {
    "afiliaciones": [
      {
        "trabajadorTipoIdentificacion": {
          "codigo": "string",
          "valor": "string"
        },
        "trabajadorNumeroIdentificacion": 0,
        "descTrabajadorCentroTrabajo": {
          "codigo": "string",
          "valor": "string"
        },
        "trabajadorDescripcionCotizante": {
          "codigo": "string",
          "valor": "string"
        },
        "trabajadorFechaIngreso": "2022-04-01T15:29:43.035Z",
        "trabajadorFechaIniCobertura": "2022-04-01T15:29:43.035Z",
        "trabajadorFechaRetiro": "2022-04-01T15:29:43.035Z"
      }
    ]
  }
}
```


##### RESPONSE ERROR
```
{
  "cause": {
    "stackTrace": [
      {
        "classLoaderName": "string",
        "moduleName": "string",
        "moduleVersion": "string",
        "methodName": "string",
        "fileName": "string",
        "lineNumber": 0,
        "className": "string",
        "nativeMethod": true
      }
    ],
    "message": "string",
    "suppressed": [
      {
        "stackTrace": [
          {
            "classLoaderName": "string",
            "moduleName": "string",
            "moduleVersion": "string",
            "methodName": "string",
            "fileName": "string",
            "lineNumber": 0,
            "className": "string",
            "nativeMethod": true
          }
        ],
        "message": "string",
        "localizedMessage": "string"
      }
    ],
    "localizedMessage": "string"
  },
  "stackTrace": [
    {
      "classLoaderName": "string",
      "moduleName": "string",
      "moduleVersion": "string",
      "methodName": "string",
      "fileName": "string",
      "lineNumber": 0,
      "className": "string",
      "nativeMethod": true
    }
  ],
  "mensaje": "string",
  "codigo": "string",
  "categoria": "TECNICO",
  "errores": [
    {
      "codigo": "string",
      "componente": "string",
      "descripcion": "string"
    }
  ],
  "message": "string",
  "suppressed": [
    {
      "stackTrace": [
        {
          "classLoaderName": "string",
          "moduleName": "string",
          "moduleVersion": "string",
          "methodName": "string",
          "fileName": "string",
          "lineNumber": 0,
          "className": "string",
          "nativeMethod": true
        }
      ],
      "message": "string",
      "localizedMessage": "string"
    }
  ],
  "localizedMessage": "string"
}
```

---

## Proyectos relacionados

A continuación se detallan los módulos o funcionalidades que usan los servicios contenidos en este micro-servicio:


---
## Endpoints

- **DEV**
    - API Gateway: https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/trabajadores_arl/api/v1/empresas/afiliaciones

- **TEST**
    - API Gateway: https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/trabajadores_arl/api/v1/empresas/afiliaciones

- **PROD**
    - API Gateway: https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/trabajadores_arl/api/v1/empresas/afiliaciones

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
- Líder Técnico: Luisa Fernanda Leguizamon Bayona
- Arquitecto de TI: Miguel Angel Hernandez Zapata

---

## Licencia

![License](https://img.shields.io/badge/Licencia-Seguros%20Bolivar-green)
- Copyright 2022 ©