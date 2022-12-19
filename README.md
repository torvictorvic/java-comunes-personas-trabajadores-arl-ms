# comunes-personas-trabajadores-arl-ms

Micro-servicio para personas-trabajadores.
Expone una API relacionada con el dominio ***Personas Trabajadores ARL*** de Seguros Bolívar.

>  #aws #rest #java #arl #personas-trabajadores

---
## Tabla de Contenido
- [Descripción](#descripción)
- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Arquitectura](#arquitectura)
- [Construido con](#construido-con)
- [Desarrollo](#desarrollo)
- [Seguridad](#seguridad)
- [Endpoints](#endpoints)
- [Licencia](#licencia)
---
## Descripción

Agrupación de operaciones relacionadas con el dominio de negocio ***Personas Trabajadores ARL***

Las operaciones de este repositorio consumen procedimientos almacenados en la base de datos TRONADOR y los
exponen en una API REST. 

## Detalle de Funcionalidades

Las siguientes son las funcionalidades presentes en este repositorio:

- [crearafiliaciontrabajadores](src/main/java/com/bolivar/comunes/personas_trabajadores_arl/crearafiliaciontrabajadores/README.md)
- [consultarAfiliacionTrabajador](src/main/java/com/bolivar/comunes/personas_trabajadores_arl/consultarafiliaciontrabajador/README.md)
- [consultarCargoTrabajador](src/main/java/com/bolivar/comunes/personas_trabajadores_arl/consultarcargotrabajador/README.md)
- [consultartrabajadores](src/main/java/com/bolivar/comunes/personas_trabajadores_arl/consultartrabajadores/README.md)
- [crearCargoTrabajador](src/main/java/com/bolivar/comunes/personas_trabajadores_arl/crearcargotrabajador/README.md)
- [historialnovedadestrabajadores](src/main/java/com/bolivar/comunes/personas_trabajadores_arl/retirartrabajadordependiente/README.md)
- [retirarTrabajadorDependiente](src/main/java/com/bolivar/comunes/personas_trabajadores_arl/historialnovedadestrabajadores/README.md)
- [retirarTrabajadorIndependiente](src/main/java/com/bolivar/comunes/personas_trabajadores_arl/retirartrabajadorindependiente/README.md)
- [consultarguardiantrabajador](src/main/java/com/bolivar/comunes/personas_trabajadores_arl/consultarguardiantrabajador/README.md)

## Arquitectura
Descripción de la arquitectura

## Construido con

El código se encuentra implementado con Java 11 y Gradle 6.9.1 usando las siguientes librerías:

- Lombok - Para simplificar la creación de los medios de acceso a datos de un objeto
- MyBatis - Conexión con base de datos Oracle y ejecución de procedimiento almacenados
- Google Guava - Utilidades básicas.
- ojdc8 - Soporte para conexión con base de datos Oracle
- AWS SDK V2 - Para la conexión al parameter store y conexión con base de datos Dynamo.
- OkHttp - Cliente Http
- Retrofit - Para consumo de micro servicios y mapeo de respuestas a objetos Java
- Log4j - Para escribir mensajes de registro

## Desarrollo
1. Instale Java 11 y un IDE de desarrollo como Eclipse o IntelliJ.
2. Clone este repositorio.
3. Permita la construcción del proyecto con gradle.
4. Inicialice el proyecto
5. Abra http://localhost/personas/swagger-ui/index.html para visualizar la lista de apis

Para ejecutar las pruebas unitarias:
1. Configure sonar-project.properties.
2. Corra el Sonar en local.
3. Ejecute el proyecto desde test en gradle.


## Seguridad

Consideraciones a tener en cuenta con respecto a temas de seguridad de la información

---

## Endpoints

- **DEV**
    - API Gateway: https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/trabajadores_arl

- **STAGE**
    - API Gateway: https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/trabajadores_arl

- **PROD**
    - API Gateway: https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/trabajadores_arl


---

## Licencia

![License](https://img.shields.io/badge/Licencia-Seguros%20Bolivar-green)
- Copyright 2022 ©
