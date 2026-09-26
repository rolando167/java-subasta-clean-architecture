# ⚡ FlashBids Engine - Backend de Subastas en Tiempo Real

Sistema backend transaccional de alto rendimiento diseñado para gestionar subastas de cuenta regresiva ultrarrápida, garantizando consistencia en transacciones monetarias y concurrencia bajo presión.

🏛️ Arquitectura del Proyecto (Clean Architecture)
El proyecto está estructurado modularmente para desacoplar la lógica de negocio de los frameworks externos:

domain: Modelos de negocio puros, excepciones y contratos (interfaces de repositorios). Sin dependencias de Spring Boot ni bases de datos.

application: Casos de uso (reglas de negocio de la aplicación como registrar usuario, crear subasta, realizar puja).

infrastructure: Controladores REST, entidades y adaptadores de JPA/Hibernate, configuración de seguridad (JWT) y adaptadores externos (Redis, Kafka).

🛠️ Tecnologías y Stack
Lenguaje: Java 21

Framework: Spring Boot 3.2.5

Gestor de Dependencias: Maven

Base de Datos: PostgreSQL 16 & Spring Data JPA

Caché y Concurrencia: Redis (en memoria para ranking temporal de pujas)

Seguridad: Spring Security & JWT (JSON Web Tokens)

Mensajería Asíncrona: Apache Kafka

Documentación API: Swagger / OpenAPI

Testing: JUnit & Mockito

🚀 Hoja de Ruta de Desarrollo (Fases)
[x] Fase 1: El Núcleo, los Datos y CRUD Básico de Usuarios (Completado)

[ ] Fase 2: Concurrencia, Artículos y Lógica de Subastas

[ ] Fase 3: Seguridad con Spring Security, Roles (USER/ADMIN) y JWT

[ ] Fase 4: Exposición de APIs, Documentación Swagger y Generación de Ficheros (PDF/CSV)

[ ] Fase 5: Pruebas Exhaustivas (JUnit/Mockito) y Eventos con Kafka

⚙️ Configuración y Ejecución Local
Clonar el repositorio:

Bash
git clone [https://github.com/tu-usuario/app-subastas.git](https://github.com/tu-usuario/app-subastas.git)
cd app-subastas
Configurar las credenciales:
Asegúrate de configurar tu archivo src/main/resources/application.properties con los accesos a tu base de datos PostgreSQL y Redis locales.

Compilar y ejecutar el proyecto:

Bash
mvn clean spring-boot:run
Probar los Endpoints:
La aplicación correrá por defecto en http://localhost:8080. Puedes probar el registro y listado de usuarios mediante herramientas como Postman o curl.