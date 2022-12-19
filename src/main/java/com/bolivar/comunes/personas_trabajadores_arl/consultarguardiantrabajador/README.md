# consultartrabajadoresguardian

Servicio para consultar empleados de guardian con parametros de fechas (desde / hasta), numero de documento, tipo de operación.

>  #aws #java #comunes #empresas #centrosTrabajo

---
## Tabla de Contenido

- [Descripción](#descripción)
- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Endpoints](#endpoints)
- [Autores](#autores)
- [Licencia](#licencia)
---

## Descripción

Servicio que permite retornar informacion de trabajadores de guardian de acuerdo a ciertos parametros: fechas desde - hasta, nro documento, operacion
Esta operación consume el procedimiento *Prc_Trabajadores_Arl_Guardian* del paquete *SIM_PCK_EXTRAC_INFOGUARDIAN* ubicado en la Base de datos de *TRONADOR*




---

## Detalle de Funcionalidades

#### GET/ /trabajadores_arl/api/v1/empresas/{fechas}/S/trabajador/{num_doc}/empresa/{operacion}


Headers obligatorios: x-api-key

Parámetros obligatorios: fechas, operacion


##### RESPONSE OK
```
{
    "dataHeader": {
        "codRespuesta": 0,
        "errores": []
    },
    "data": {
        "informacionCT": {
                "idEnvio": 2022071920220720,
                "tipoDocEmpresa": null,
                "numDocEmpresa": "830085844",
                "genero": "M",
                "tipDocEmpleado": "CC",
                "numDocEmpleado": "1023864348",
                "activo": null,
                "autorizado": 0,
                "lugarExp": null,
                "fechExp": null,
                "fechaNacimiento": "1986-08-09T05:00:00.000+00:00",
                "nombre": "DAVID ALEXANDER",
                "apellidos": "FONSECA PINZON",
                "tipContrato": "005",
                "profesion": null,
                "centroTrabajo": "SEDE PRINCIPAL",
                "codCargo": null,
                "ocupacion": null,
                "salarioIbc": 0,
                "eps": "014",
                "afp": "001",
                "arl": "bolivar",
                "pais": "68",
                "departamento": "242",
                "ciudad": "604",
                "rh": null,
                "nivelRiesgos": null,
                "centroCostos": null,
                "observacion": null,
                "direccion": "CL 34 #14 00 E",
                "contrato": "7263312",
                "fecIniContr": "2022-07-21T05:00:00.000+00:00",
                "fecFinContr": null,
                "mail": null
            }
    }
}
```

##### RESPONSE ERROR
Ejemplo mensaje de error:
```
{
    "dataHeader": {
        "codRespuesta": -1,
        "errores": [
            {
                "idError": 10210,
                "descError": "10210 No existen datos para la consulta",
                "tipoError": null
            }
        ]
    },
    "data": null
}

```

---
## Endpoints

- **DEV**
  - API Gateway: https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/trabajadores_arl/api/v1/empresas/2022071920220720/S/trabajador/900106575/empresa/nuevo

- **TEST**
  - API Gateway: https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/trabajadores_arl/api/v1/empresas/2022071920220720/S/trabajador/900106575/empresa/nuevo

- **PROD**
  - API Gateway: https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/trabajadores_arl/api/v1/empresas/2022071920220720/S/trabajador/900106575/empresa/nuevo

---



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

- Equipo de Desarrollo: Refactoring Portal ARL
    - Victor Manuel Suarez Torres (victor.suarez@insoftar.com)
- Lideres Técnicos :
    - Daniel Ruiz (daniel.ruiz@segurosbolivar.com)
- Arquitectos de TI:
    - Miguel Angel Hernández Zapata (miguel.hernandez@samtel.co)
---


## Licencia

![License](https://img.shields.io/badge/Licencia-Seguros%20Bolivar-green)
- Copyright 2022 ©