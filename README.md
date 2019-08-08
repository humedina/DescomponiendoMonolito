# DescomponiendoMonolito

_La finalidad del presente proyecto es realizar el trabajo de separación de un servicio monolito y como resultado obtener microservicios capaces de realizar la misma lógica de negocio y obtener los mismos resultados que el servicio original._

_Los microservicios realizarán las tareas de ALta, Baja, Consulta y Eliminación (CRUD) en la información de un empleado y su equipo de trabajo (equipo de cómputo); por lo que los microservicios se llamarán **Employee** y **Workstation**. Cada microservicios tiene su base de datos H2 embebida y se puede acceder a ella con la ruta http://localhost:{puerto}/employee/h2 o http://localhost:{puerto}/workstation/h2_

## Comenzando 🚀
_1.- Clonar el repositorio de GitHub para tener acceso a los proyectos involucrados: https://github.com/humedina/DescomponiendoMonolito.git_

_2.- Importar proyectos (practica8-Employee y practica8-Workstation)._

_2.1.- Abrir su IDE de preferencia (Se recomienda STS3)._

_2.2.- Dar click en File > Import > Maven > Existing Maven Projects > Next > Browse > {directorio_desacarga}/Eureka-RibbonApi-and-LoadBalancedRestTemplate- > Select All > Finish._


### Pre-requisitos 📋

_Antes de iniciar, necesitas:_

```
* Tener instalado Java 8
* Tener instalado Maven
```

### Instalación 🔧

_Para la ejecución o instalación de los proyectos, será necesario seguir el siguiente listado de instrucciones:_


_El primer paso consiste en actualizar las dependencias Maven en cada uno de los proyectos._

_El tercer paso es compilar el primer proyecto y para esto es necesario ejecutar el siguiente comando en la ubicación en la que se encuentra el fichero **pom.xml**_

```
mvn clean package
```
_El segundo paso es ejectar como proyecto Spring Boot App cada uno de los proyectos._

_**Nota:** Existe dependencia entre ambos y si uno llegará a faltar no se podrá corroborar su funcionamiento._

## Ejecutando las pruebas ⚙️

_Para ejecutar pruebas bastará con ejecutar el servicio de regitro de un empleado (**Employee**) a través de un cliente REST y con la siguiente URi _**http://{ip}:{puerto}/v1/employees**_ al enviar un JSON con el formato requerido, como a continuación se ejemplifica:

```
{
    "id": 3,
    "firstName": "Luis",
    "lastName": "Guzman",
    "employeeNumber": "00003",
    "workstation": [{
            "id": 3,
            "vendor": "Mac",
            "model": "iMac Pro 25 Retina",
            "facilitiesSerialNumber": "00103"
        }]
}
```

el microservicio ejecutara internamente la llamada a el Microservicio de **Workstations** y las registrará._

_Por otro lado habrá validaciones que s epodrán probar como por ejemplo no registrar dos veces la misma Workstation a un empleado o registrar elimiar un empleado que tenga asociada una workstation, etc. (Se recomienda probar diferentes escenarios.)_


_**Nota:** Hacer uso de la relación de los verbos Http con las operaciones CRUD para su ejecución._

## Autores ✒️

* **Humberto Medina Hernández** - *Desarrollo* - [humedina](https://github.com/humedina)




---
😊
