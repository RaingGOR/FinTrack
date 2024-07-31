# FinTrack

___

### Описание проекта:

#### Финансовое приложение для управления личными финансами, где пользователи могут отслеживать доходы, расходы и создавать бюджеты. Приложение написано на Maven с использованием Java 21, микросервисной архитектуры и фреймворка Spring boot 3.3. Так же в проекте использованы база данных MySQL, Vaadin, Spring Security, Eureka, Flyaway, Lombok, Spring Cloud, WebFlux, LoadBalancer и многие другие технологии.

___

### Архитектура проекта

#### Микросервисы:

1. **_Eureka-Server_** - регистрация и поиск микросервисов | Базовый порт:   http://localhost:8761/
2. **_Client-Service_** - фронтэнд часть написанная на **Java**+**Vaadin** | Базовый порт: http://localhost:8083/
3. **_Transaction-Service_** - управление транзакциями | Базовый порт: http://localhost:8082/
4. **_User-Service_** - управление пользователями | Базовый порт: http://localhost:8081/
5. `IN FUTURE`

#### Базы данных:

- **MySQL**: в каждом микросервисе собственная база данных
- **FlyAway**: дополнительный инструмент для управление базой данных в каждом микросервисе

### Основные технологии и инструменты

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Data WebFlux**
- **Spring Cloud**
- **Docker**
- **Eureka**
- **Spring Cloud Gateway**
- **Spring Security**
- **Docker Compose**
- **Lombok**
- **MySQL**
- **Spring Boot Validation**
- **LoadBalancer**
- **Vaadin**

