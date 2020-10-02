[![CircleCI](https://circleci.com/gh/andresQD/Arep_lab03.svg?style=svg)](https://circleci.com/gh/andresQD/Arep_lab05)
# Taller de de modularización con virtualización e Introducción a Docker y a AWS
## Profesor 
### Ing Luis Daniel Benavides Navarro
## Presentado por 
### Andrés Felipe Quintero Duque

## Arquitectura de trabajo
Por medio de contenedores de docker se crearon las imagenes en las cuales almacena la aplicación y una base de datos no relacional mongodb, como se muestra en la imágen:

![arquitectura](https://user-images.githubusercontent.com/48091585/93956933-d868a300-fd18-11ea-8469-cfcb22943a78.png)

### Requisitos
Debe tener instalado:
* JDK 8
* Maven
* Docker
## Uso 
* En la página principal encontrará un servicio web que le permite escribir un nuevo mensaje y adicionalmente le muestra los ultimos 10 mensajes más recientes
 
![img1](https://user-images.githubusercontent.com/48091585/93956919-cf77d180-fd18-11ea-8519-56b8b400058a.png)

* Para añadir un nuevo mensaje debe escribir lo que desee en el campo de texto y dar click en el botón "Enviar mensaje"

![img2](https://user-images.githubusercontent.com/48091585/93956923-d272c200-fd18-11ea-9022-54accfb71bf9.png)

* Una vez le de en "Enviar mensaje", la lista de mensajes se actualizara le mostrará el mensaje más reciente

![img3](https://user-images.githubusercontent.com/48091585/93956930-d56db280-fd18-11ea-9645-a5b7534aa3d6.png)

* Se puede comprobar que los mensajes han sido almacenados en la base de datos

![img4](https://user-images.githubusercontent.com/48091585/93956932-d7377600-fd18-11ea-84cf-70a2826a2a3b.png)




