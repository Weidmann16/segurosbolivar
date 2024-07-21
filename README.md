# Servicio Rick and Morty

Este repositorio contiene el código para el servicio Rick and Morty, el cual puede ser desplegado utilizando Docker Compose.

## Instrucciones de Despliegue

### 1. Clonar el Repositorio

Clona este repositorio en tu máquina local usando Git:

```bash
git clone https://github.com/Weidmann16/segurosbolivar.git
cd segurosbolivar
```
### 2. Construir la Imagen Docker

```bash
docker build -t rickandmorty-service:1.0 .
```

### 3. Ejecutar Docker Compose
```bash
docker-compose up -d
```

### 4. Acceder al Servicio
```bash
 http://localhost:8080
```

### Documentacion API
``` bash
https://documenter.getpostman.com/view/9471522/2sA3kUH2mB#70ec6eff-1099-4433-b9ee-148c13f98c32
```
