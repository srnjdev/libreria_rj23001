# Springboot Librería

## Descripción del proyecto

Esta aplicación **Spring Boot** gestiona una librería con entidades de `Libro` y `Autor`, usando **PostgreSQL** como base de datos. Al iniciar, crea automáticamente el esquema y las tablas definidas con JPA (`spring.jpa.hibernate.ddl-auto=create`).

## Requisitos previos

- Java 17 (o superior)  
- Docker y/o Maven Wrapper (`./mvnw`)  
- PostgreSQL funcionando en `localhost:5432`  


## Configuración de usuario y contraseña de PostgreSQL

Edita (o crea) `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/libreria_db
spring.datasource.username=<USUARIO_POSTGRES>
spring.datasource.password=<PASSWORD_POSTGRES>

spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```
Reemplaza **<USUARIO_POSTGRES>** y **<PASSWORD_POSTGRES>** por tus credenciales. Asegúrate de que la base libreria_db exista o usa el seeder automático.

## Creación de base de datos
Spring Boot creará la base `libreria_db` automáticamente. Si falla la creación automática, puedes hacerlo manualmente:
```bash
# Usando createdb (requiere rol válido)
createdb -h localhost -U <USUARIO_POSTGRES> libreria_db

# O con psql
psql -h localhost -U <USUARIO_POSTGRES> -c "CREATE DATABASE libreria_db;"
````

## Ejecutar proyecto

```bash
./mvnw spring-boot:run -DskipTests
```

## Endpoint disponibles

1. http://localhost:8080/api/autores
2. http://localhost:8080/api/libros



`Sergio Norberto Ramírez Juárez - RJ23001`