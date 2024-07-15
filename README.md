# FinTrack
### Финансовое приложение с использованием MySQL и MongoDB
### Описание: 
#### Финансовое приложение для управления личными финансами, где пользователи могут отслеживать доходы, расходы и создавать бюджеты.

### Архитектура проекта

#### Микросервисы:
1. **User Service**: регистрация и управление пользователями.
2. **Transaction Service**: управление финансовыми транзакциями.
3. **Budget Service**: управление бюджетами и категориями расходов.
4. **eureka-server**: управление микросервисами по хосту http://localhost:8761/
#### Базы данных:
- **MySQL**: хранение финансовых транзакций и пользовательских данных.
- **MongoDB**: управление сессиями и кэширование.

### Основные технологии и инструменты
- **Java 11+**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Data MongoDB**
- **Spring Cloud**
- **Docker**
- **Eureka** (для сервис-дискавери)
- **Spring Cloud Gateway** (для API Gateway)
- **Spring Security** (для авторизации и аутентификации)
- **Docker Compose** (для управления контейнерами)

### Описание микросервисов

#### 1. User Service
**Основные функции:**
- Регистрация пользователей
- Аутентификация и авторизация
- Управление профилями пользователей

**Структура проекта:**
```plaintext
user-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.userservice/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       └── application.yml
├── Dockerfile
└── pom.xml
```

**Основные классы:**
- `UserController`: управление запросами пользователя.
- `User`: сущность пользователя.
- `UserRepository`: интерфейс для взаимодействия с базой данных.
- `UserService`: бизнес-логика для управления пользователями.

**application.yml:**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/userdb
    username: your-username
    password: your-password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
  instance:
    prefer-ip-address: true

server:
  port: 8081
```
#### 2. Transaction Service
**Основные функции:**
- Добавление и управление транзакциями
- Просмотр истории транзакций

**Структура проекта:**
```plaintext
transaction-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.transactionservice/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       └── application.yml
├── Dockerfile
└── pom.xml
```

**Основные классы:**
- `TransactionController`: управление запросами транзакций.
- `Transaction`: сущность транзакции.
- `TransactionRepository`: интерфейс для взаимодействия с базой данных.
- `TransactionService`: бизнес-логика для управления транзакциями.

**application.yml:**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/transactiondb
    username: your-username
    password: your-password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
  instance:
    prefer-ip-address: true

server:
  port: 8082
```

#### 3. Budget Service
**Основные функции:**
- Создание и управление бюджетами
- Классификация расходов по категориям

**Структура проекта:**
```plaintext
budget-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.budgetservice/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       └── application.yml
├── Dockerfile
└── pom.xml
```

**Основные классы:**
- `BudgetController`: управление запросами бюджетов.
- `Budget`: сущность бюджета.
- `BudgetRepository`: интерфейс для взаимодействия с базой данных.
- `BudgetService`: бизнес-логика для управления бюджетами.

**application.yml:**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/budgetdb
    username: your-username
    password: your-password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
  instance:
    prefer-ip-address: true

server:
  port: 8083
```