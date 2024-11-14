# Crear Afiliación Trabajadores

Micro-servicio que permite realizar la afiliación de un trabajador.

>  #aws #java #comunes
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

Micro-servicio que permite la afiliación de un trabajador.
Esta operación consume el procedimiento ARL_PCK_TRABAJADORES.PROC_AFILIAR ubicado en la base de datos Tronador.

---

## Detalle de Funcionalidades

#### POST/ /api/v1/trabajadores/estadosAfiliacion

Header obligatorios
| Header | Tipo | Descripción | Ejemplo
| ------------- | ------------- | ------------- | ------------- |
|               |               |               |               |

Notas:

##### REQUEST BODY
```
{
  "datosTrabajador": {
    "grupocotizante": "string",
    "tipocotizante": "string",
    "tipocotizantedes": "string",
    "trbjdorsecnciatercero": 0,
    "trbjdortipoidentificacion": "string",
    "trbjdornumeroidentificacion": 0,
    "empresadptocodigo": 0,
    "empresaciudadcodigo": 0,
    "trabajadorcentrotrabajo": 0,
    "trbjdortipocontrato": 0,
    "trbjdordessexo": "string",
    "fechaingreso": "2022-04-01T15:23:28.303Z",
    "trbjdorcodigocargo": 0,
    "trbjdordesccargo": "string",
    "trbjdoringresomensual": 0,
    "trbjdoribc": 0,
    "trbjdorepscodigo": 0,
    "trbjdorepsdes": "string",
    "trbjdorafpcodigo": 0,
    "trbjdorafpdes": "string",
    "trbjdormcapensionado": "string",
    "trbjdorcolombianoext": "string",
    "trbjdorfechainiciocobertura": "2022-04-01T15:23:28.303Z",
    "trbjdorfechafincobertura": "2022-04-01T15:23:28.303Z",
    "trbjdorextranjero": "string",
    "usuarioconectado": "string",
    "trbjdorindcdoracptcioncontrato": "string",
    "trbjdorconsultable": "string",
    "trbjdortiponovedad": "string",
    "trbjdorfechanovedad": "2022-04-01T15:23:28.303Z",
    "trbjdorformapago": "string",
    "trbjdoringresototal": 0,
    "trbjdormcatransporte": "string",
    "trbjdormodalidad": 0,
    "localidad": "string",
    "zona": "string",
    "codigoJornada": 0,
    "descErrTercero": "string",
    "pinfo4": "string",
    "pinfo5": "string",
    "pinfo2": "string",
    "pinfo3": "string",
    "pinfo1": "string"
  },
  "tipoCotizante": {
    "trabajadorTipoCotizante": "string"
  },
  "datosProceso": {
    "p_MODULO": "string",
    "p_PROCESO": 0,
    "p_SUBPROCESO": 0,
    "p_COD_CIA": 0,
    "p_COD_SECC": 0,
    "p_COD_PRODUCTO": 0,
    "p_SUBPRODUCTO": 0,
    "p_COD_USR": "string",
    "p_AGENCIA_USR": 0,
    "p_ENTIDAD_COLOCADORA": 0,
    "p_CANAL": 0,
    "p_SISTEMA_ORIGEN": 0,
    "p_PAIS": 0,
    "p_SESSIONID": "string",
    "p_DIRECCIONIP": "string",
    "p_INFO1": "string",
    "p_INFO2": "string",
    "p_INFO3": "string",
    "p_INFO4": "string",
    "p_INFO5": "string"
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
    "respuesta": {
      "numerosecuenciapoliza": 0,
      "empresatipoidentificacion": {
        "codigo": "string",
        "valor": "string"
      },
      "empresanumeroidentificacion": 0,
      "trbjdorcentrotrabajo": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdortipoidentificacion": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdornumeroidentificacion": 0,
      "trbjdorfechanacimiento": "2022-04-01T15:23:28.363Z",
      "trbjdorsexo": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdorepsdescripcion": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdorafpdescripcion": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdorfchainiciocbrtracntrato": "2022-04-01T15:23:28.363Z",
      "trbjdorfchainiciocontrato": "2022-04-01T15:23:28.363Z",
      "trbjdorfchafincontrato": "2022-04-01T15:23:28.363Z",
      "trbjdoringresototal": 0,
      "trbjdoringresomensual": 0,
      "trbjdorcargodescripcion": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdortipocontrato": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdorformapago": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdormodalidad": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdorsuministratransporte": {
        "codigo": "string",
        "valor": "string"
      },
      "trbjdoribc": 0,
      "trbjdornombres": "string",
      "pinfo4": "string",
      "pinfo5": "string",
      "pinfo2": "string",
      "pinfo3": "string",
      "pinfo1": "string"
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
    - API Gateway: https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/trabajadores_arl/api/v1/trabajadores/estadosAfiliacion

- **TEST**
    - API Gateway: https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/trabajadores_arl/api/v1/trabajadores/estadosAfiliacion

- **PROD**
    - API Gateway: https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/trabajadores_arl/api/v1/trabajadores/estadosAfiliacion

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