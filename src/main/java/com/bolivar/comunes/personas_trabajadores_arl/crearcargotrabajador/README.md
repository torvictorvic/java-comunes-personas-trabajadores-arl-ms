# Crear Cargo Trabajador

Micro-servicio que permite crear los cargos disponibles para la creación del trabajador.

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

Micro-servicio que permite crear los cargos disponibles para la creación del trabajador.
Esta operación consume el SP ARL_PCK_INGRSO_TRBJ_DPNDTES.Crea_Cargo ubicada en base de datos de Tronador.

---

## Detalle de Funcionalidades

#### POST/ /api/v1/cargos

Header obligatorios
| Header | Tipo | Descripción | Ejemplo
| ------------- | ------------- | ------------- | ------------- |
|               |               |               |               |

Notas:

##### REQUEST BODY
```
{
  "cargo": {
    "codigo": 0,
    "descripcion": "string"
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
    "cargo": {
      "codigo": 0,
      "descripcion": "string"
    }
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

---

## Proyectos relacionados

A continuación se detallan los módulos o funcionalidades que usan los servicios contenidos en este micro-servicio:


---
## Endpoints

- **DEV**
    - API Gateway: https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/trabajadores_arl/api/v1/cargos

- **TEST**
    - API Gateway: https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/trabajadores_arl/api/v1/cargos

- **PROD**
    - API Gateway: https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/trabajadores_arl/api/v1/cargos

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