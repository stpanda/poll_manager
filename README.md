# poll_manager


Cклонировать проект и развернуть локально. Необходимо поменять в application.yml 
datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    
сделать mvn clean
сделать mvn compile

Для получения списка опросов с пагинацией, фильтрами и сортировкой отправить через любой REST клиент запрос следующего вида http://localhost:5010/?size=10&page=0&sort=endDate%2Casc&startDate=2019-11-11

