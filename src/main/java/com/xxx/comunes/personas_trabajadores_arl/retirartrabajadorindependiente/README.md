# Retirar Trabajador Independiente

Micro-servicio que permite realizar un retiro de un trabajador independiente.

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

Micro-servicio que permite realizar un retiro de un trabajador independiente.
Esta operación consume el procedimiento ARL_PCK_EXCLSION_TRBJ_DPNDTES.Prc_Excluir_Trab_Ind en la base de datos Tronador.

---

## Detalle de Funcionalidades

#### PUT/ /api/v1/independientes/estadosRetiros

Header obligatorios
| Header | Tipo | Descripción | Ejemplo
| ------------- | ------------- | ------------- | ------------- |
|               |               |               |               |

Notas:

##### REQUEST BODY
```
{
  "trabajador": {
    "fechaRetiroTrabajador": "2022-04-01T15:42:48.174Z",
    "fechaNovedad": "2022-04-01T15:42:48.174Z",
    "fechaIngreso": "2022-04-01T15:42:48.174Z",
    "numeroPoliza": 0,
    "centroTrabajo": 0,
    "numeroIdentificacion": 0,
    "tipoIdentificacion": "string",
    "departamentoLabora": "string",
    "municipioLabora": "string",
    "tipoCotizante": "string",
    "compania": 0,
    "seccion": 0,
    "producto": 0,
    "sistemaOrigen": 0,
    "sexo": "string",
    "aceptaCondiciones": "string",
    "numeroDocumentoEmpresa": 0,
    "tipoDocumentoEmpresa": "string",
    "usuarioTransaccion": "string"
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
    "resultado": {
      "trabajadorTipoIdentificacion": {
        "codigo": "string",
        "valor": "string"
      },
      "trabajadorNumeroIdentificacion": 0,
      "descTipoCotizante": {
        "codigo": "string",
        "valor": "string"
      },
      "descCentroTrabajo": {
        "codigo": "string",
        "valor": "string"
      },
      "trabajadorNovedadFechaRetiro": "2022-04-01T15:42:48.208Z",
      "fechaIngresoTrabajador": "2022-04-01T15:42:48.208Z",
      "fechaRetiroTrabajador": "2022-04-01T15:42:48.208Z"
    }
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
    - API Gateway: https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/trabajadores_arl/api/v1/independientes/estadosRetiros

- **TEST**
    - API Gateway: https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/trabajadores_arl/api/v1/independientes/estadosRetiros

- **PROD**
    - API Gateway: https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/trabajadores_arl/api/v1/independientes/estadosRetiros

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

- Equipo de Desarrollo: Andres Fernando Diaz Moreno
- Líder Técnico: Luisa Fernanda Leguizamon Bayona
- Arquitecto de TI: Miguel Angel Hernandez Zapata

---

## Licencia

![License](https://img.shields.io/badge/Licencia-Seguros%20Bolivar-green)
- Copyright 2022 ©