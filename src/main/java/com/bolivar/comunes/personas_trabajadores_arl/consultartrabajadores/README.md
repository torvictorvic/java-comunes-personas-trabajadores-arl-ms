# Consultar Trabajadores

Micro-servicio que permite obtener una lista de trabajadores o un conteo de trabajadores.

>  #aws #java #comunes #trabajadores #ARL
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

Micro-servicio que permite obtener la lista de trabajadores o un conteo.
Esta operación consume los SP ARL_PCK_CONSULTA_TRAB_PAG_OPT.Proc_Consultatrabajadores_Ordn y ARL_PCK_CONSULTA_TRAB_PAG_OPT.PROC_CONTARTRABAJADORES ubicados en base de datos de Tronador.

---

## Detalle de Funcionalidades

#### GET/ /api/v1/empresas/trabajadores

Header obligatorios  

| Header    | Tipo | Descripción                                        | Ejemplo                                  |
| ---       | ---  | --- |------------------------------------------|
| x-api-key | string | Api key del dominio de personas-trabajadores-arl | prjhvnkUSQ8wvoWBYLERJ2Y7qLBhlCN3amqsQPFM |

Notas:

##### REQUEST Lista de trabajadores
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
        "raw": "{{servidor}}trabajadores_arl/api/v1/empresas/trabajadores?fecIngresoDesde=2020-03-01&fecIngresoHasta=2020-03-31&centrosTrabajo=345,51,26,343,60,53,349,346,50,59,352,45,351,350,1,55,58&compania=2&seccion=70&producto=722&codUsr=79625048&tipoDocEmpresa=NT&numDocEmpresa=860036081&numPol=1000387288016&numSecuPol=39744845698&nivelSupervision=1&paginaInicio=1&paginaFin=2",
        "host": [
            "{{servidor}}trabajadores_arl"
        ],
        "path": [
            "api",
            "v1",
            "empresas",
            "trabajadores"
        ],
        "query": [
            {
                "key": "estado",
                "value": "RET",
                "disabled": true
            },
            {
                "key": "fecIngresoDesde",
                "value": "2020-03-01"
            },
            {
                "key": "fecIngresoHasta",
                "value": "2020-03-31"
            },
            {
                "key": "tipoCotizante",
                "value": "",
                "disabled": true
            },
            {
                "key": "tipoDocTrabajador",
                "value": "CC",
                "disabled": true
            },
            {
                "key": "numDocTrabajador",
                "value": "187230",
                "disabled": true
            },
            {
                "key": "centrosTrabajo",
                "value": "345,51,26,343,60,53,349,346,50,59,352,45,351,350,1,55,58"
            },
            {
                "key": "compania",
                "value": "2"
            },
            {
                "key": "seccion",
                "value": "70"
            },
            {
                "key": "producto",
                "value": "722"
            },
            {
                "key": "codUsr",
                "value": "79625048"
            },
            {
                "key": "tipoDocEmpresa",
                "value": "NT"
            },
            {
                "key": "numDocEmpresa",
                "value": "860036081"
            },
            {
                "key": "numPol",
                "value": "1000387288016"
            },
            {
                "key": "numSecuPol",
                "value": "39744845698"
            },
            {
                "key": "nivelSupervision",
                "value": "1"
            },
            {
                "key": "paginaInicio",
                "value": "1"
            },
            {
                "key": "paginaFin",
                "value": "2"
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
  "data": {
    "trabajadores": [
      {
        "ideNit": "CC",
        "nit": 187230,
        "fecIngreso": "2020-03-27T05:00:00.000+00:00",
        "fecBaja": "2020-04-08T05:00:00.000+00:00",
        "descCentrotrab": {
          "codigo": "343",
          "valor": "MONTAJE DE ESTRUCTURAS MECANICAS Y TUBERIAS IMPALA"
        },
        "descCargo": {
          "codigo": "52858",
          "valor": "781242"
        },
        "descEps": {
          "codigo": "1",
          "valor": "ALIANSALUD E.P.S"
        },
        "descAfp": {
          "codigo": "10",
          "valor": "COLFONDOS"
        },
        "descDependIndepen": {
          "codigo": "21",
          "valor": "ESTUDIANTES DE POSTGRADO EN SALUD DEC.190/1996"
        },
        "salario": 2000000,
        "claseRiesgo": "5",
        "tasaRiesgo": "6.96",
        "sexo": {
          "codigo": "M",
          "valor": "Masculino"
        },
        "fecNacimiento": "1953-01-22T05:00:00.000+00:00",
        "estado": "RETIRADO",
        "desCentrotrabCiudad": {
          "codigo": "27019",
          "valor": "BARRANCABERMEJA"
        },
        "coberturaExteriorFecInicio": "2020-03-27T05:00:00.000+00:00",
        "coberturaExteriorFecFin": "2020-04-08T05:00:00.000+00:00",
        "coberturaExteriorIndicator": null,
        "naturalesPrimerNombre": "VICENZO",
        "naturalesSegundoNombre": null,
        "naturalesPrimerApellido": "GUARINI",
        "naturalesSegundoApellido": null
      }
    ],
    "numeroPoliza": 1000387288016,
    "fechaPoliza": "01-01-2006",
    "totalRegistros": 33
  }
}
```

##### RESPONSE ERROR
```
{
  "idError": 0,
  "descError": "string",
  "tipoError": "string"
}
```
##### REQUEST Conteo de trabajadores
```
"request": {
    "method": "GET",
    "header": [
        {
            "key": "x-api-key",
            "value": "kjenaXRJDT9jY0fCB8pNo3753jrRPnH07wvad69K",
            "type": "text"
        }
    ],
    "url": {
        "raw": "{{servidor}}/api/v1/empresas/trabajadores?fecIngresoDesde=2021-01-01&fecIngresoHasta=2022-08-31&compania=2&seccion=70&producto=722&codUsr=79625048&tipoDocEmpresa=NT&numDocEmpresa=860050906&numPol=1000420657415&numSecuPol=29742026369&nivelSupervision=1&paginaInicio=0&paginaFin=10&soloCalcular=true",
        "host": [
            "{{servidor}}"
        ],
        "path": [
            "api",
            "v1",
            "empresas",
            "trabajadores"
        ],
        "query": [
            {
                "key": "fecIngresoDesde",
                "value": "2021-01-01"
            },
            {
                "key": "fecIngresoHasta",
                "value": "2022-08-31"
            },
            {
                "key": "tipoCotizante",
                "value": "1",
                "disabled": true
            },
            {
                "key": "tipoDocTrabajador",
                "value": "CC",
                "disabled": true
            },
            {
                "key": "numDocTrabajador",
                "value": "1073520770",
                "disabled": true
            },
            {
                "key": "centrosTrabajo",
                "value": "345,51,26,343,60,53,349,346,50,59,352,45,351,350,1,55,58",
                "disabled": true
            },
            {
                "key": "compania",
                "value": "2"
            },
            {
                "key": "seccion",
                "value": "70"
            },
            {
                "key": "producto",
                "value": "722"
            },
            {
                "key": "codUsr",
                "value": "79625048"
            },
            {
                "key": "tipoDocEmpresa",
                "value": "NT"
            },
            {
                "key": "numDocEmpresa",
                "value": "860050906"
            },
            {
                "key": "numPol",
                "value": "1000420657415"
            },
            {
                "key": "numSecuPol",
                "value": "29742026369"
            },
            {
                "key": "nivelSupervision",
                "value": "1"
            },
            {
                "key": "paginaInicio",
                "value": "0"
            },
            {
                "key": "paginaFin",
                "value": "10"
            },
            {
                "key": "soloCalcular",
                "value": "true"
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
    "data": {
        "trabajadores": null,
        "numeroPoliza": 1000420657415,
        "fechaPoliza": null,
        "totalRegistros": 37
    }
}
```
##### RESPONSE ERROR
```
{
    "codigo": "ETBR01",
    "mensaje": "Error tecnico validando la estructura del mensaje de entrada",
    "descripcion": "Datos de Entrada Incorrectos",
    "categoria": "TECNICO",
    "path": "uri=/trabajadores_arl/api/v1/empresas/trabajadores",
    "errores": [
        {
            "descripcion": "Required request parameter 'codUsr' for method parameter type String is not present"
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
    - API Gateway: https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/trabajadores_arl/api/v1/empresas/trabajadores_arl

- **TEST**
    - API Gateway: https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/trabajadores_arl/api/v1/empresas/trabajadores_arl

- **PROD**
    - API Gateway: https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/trabajadores_arl/api/v1/empresas/trabajadores_arl

---
## Api keys

El x-api-key se debe enviar en el header de la petición

- **DEV**
    - x-api-key: prjhvnkUSQ8wvoWBYLERJ2Y7qLBhlCN3amqsQPFM

- **TEST**
    - x-api-key: 227mk71hd86xWa84ui0uQ4AAQhUfozs87NNSvG70

---
## Autores

El equipo involucrado en la implementación de estos componentes se detalla a continuación:

- Equipo de Desarrollo: Javier Steven Pérez Fernández, Diego Mauricio Duque
- Líder Técnico: Javier Steven Pérez Fernández, Luisa Fernanda Leguizamon Bayona
- Arquitecto de TI: Miguel Angel Hernandez Zapata

---

## Licencia

![License](https://img.shields.io/badge/Licencia-Seguros%20Bolivar-green)
- Copyright 2022 ©