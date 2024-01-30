## Процедура запуска автотестов

### 1. Подготовка к запуску тестов
Для реализации автотестов необходимо провести установку программ IntelliJ Idea, Docker.
Проект открываем в IntelliJ Idea.

### 2. Запуск контейнеров c MySQL, с PostgreSQL,с эмулятором банковских сервисов
В файлах  `docker-compose.yml`,`Dockerfile` описаны настройки для сборки образа и запуска контейнеров.
Сборка и запуск контейнеров осуществляется командой в терминале: `docker-compose up --build`.


### 3. Запуск сервиса

Запуск сервиса с поддержкой БД осуществляется одним из следующих способов:

#### 3.1 Запуск сервиса с MySQL

В файле `application.properties` должна быть указана следующая настройка: 

`spring.datasource.url=jdbc:mysql://localhost:3306/app`.

В файле `build.gradle`  указываем настройки:

`test {
systemProperty 'db.url', System.getProperty('db.url','jdbc:mysql://localhost:3306/app')
}`

В командной строке для запуска сервиса вводим в терминале команду: `java -jar ./artifacts/aqa-shop.jar -P:jdbc.url=jdbc:mysql://localhost:3306/app  -port=8080`.


Если БД была развернута на удаленном сервере, то указываем в команде запуска сервиса и в настройках `application.properties` вместо `localhost` адрес сервера.

#### 3.2 Запуск сервиса с PostgreSQL

В файле `application.properties` должна быть указана следующая настройка: 

`spring.datasource.url=jdbc:postgresql://localhost:5432/app`.

В файле `build.gradle`  указываем настройки:

`test {
systemProperty 'db.url', System.getProperty('db.url','jdbc:postgresql://localhost:5432/app')
}`

В командной строке для запуска сервиса вводим в терминале команду:  `java -jar ./artifacts/aqa-shop.jar -P:jdbc.url=jdbc:postgresql://localhost:5432/app  -port=8080`.


Если БД была развернута на удаленном сервере, то указываем в команде запуска сервиса и в настройках `application.properties` вместо `localhost` адрес сервера.


### 4 Запуск автотестов

Автотесты запускаются в терминале командной строкой: `./gradlew clean test`.

