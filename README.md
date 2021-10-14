# HW_ThirdPartTasks
## Task 12. Hibernate inheritance strategies
1. Create two projects:
  - In the first one use single table inheritance strategy from BillingDetails hierarchy
  - In the second one use join table inheritance strategy from BillingDetails hierarchy
2. Create repository that has method that returns all billing details for given buyer id
3. Create integrations tests for repository method.

## Task 13. Hibernate cache
1. Configure second-level cache for you project from home task #10-11
2. Enable caching for one entity from your domain model

### Solution
- Added cache for User entity
- Created integration test for User

## Task 14. Docker
run docker-compose up in the directory which contains docker-compose.yaml as result I will get fully-functional CRUD service (I can send appropriate request and entity will be created-read-updated-deleted in the database)

### Solution
1. Build 'DockerApp-0.0.1-SNAPSHOT.jar'
2. run docker-compose in project source folder
3. By default web-app has port :8080
4. Source path for CRUD operation is /sessions

## Task 15. Messaging
Реализовать паттерн Correlation Identifier - два участника отправитель и получатель:
Сообщение запроса содержит 2 числовых поля и уникальное поле-идентификатор (correlationId)
Отправитель сообщений должен отправить некоторое оговоренное количество сообщений в канал запросов не меньше 10, получателю (сохраняя из в локальной коллекции). Для имитации асинхронной обработки получатель не приступает к обработке сообщения немедленно, а сохраняет сообщения в произвольную коллекцию (отправитель хранит свои запросы).
После получения последнего сообщения получатель приступает к вычислениям, складывая значения двух числовых полей сообщения-запроса
Получатель отправляет сообщение-результат со значением арифметической операции в канал ответов.
Отправитель получает ответ и сравнивает вычисленное значение с сохраненным сообщением-запросом по correlationId
В случае несоответствия результата вывести ошибку.

## Task 17. MongoDB
Create project, that uses MongoDb contains 3 entities:
1. Customer (id, firstName, lastName, addresses, accounts)
2. Account (cardNumber, nameOnAccount, expirationDate)
3. Address (line1, line2, countryCode)

Using these entities create service, which will do these operations:
1. Create customer
2. Update customer
3. Find customer(s) by: id, firstName and lastName, address, cardNumber.
4. Find customer(s) with expired cards.
Write integration tests for this service using embedded MongoDb.
