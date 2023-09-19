# springboot-backend
Simple CRUD application using SPRING BOOT.
Please note this project was run and hosted locally. 
(Use this as a template API)

Tools used:
- Java 17
- [Spring Boot](https://start.spring.io/)
- Spring Boot JPA (Hibernate)
- Lombok
- MySQL
- [IntelliJ Community](https://www.jetbrains.com/idea/download/#section=windows)
- Maven
- Tomcat
- [Postman](https://www.postman.com/downloads/)
- MySQL Workbench
---
## Endpoint URL's
- GET ALL EMPLOYEES         - GET:    http://localhost:8080/api/employees/
- GET EMPLOYEE BY ID        - GET:    http://localhost:8080/api/employees/{ID}
- CREATE NEW EMPLOYEE       - POST:   http://localhost:8080/api/employees/
- UPDATE EXISTING EMPLOYEE  - UPDATE: http://localhost:8080/api/employees/{ID}
- DELETE EXISTING EMPLOYEE  - DELETE: http://localhost:8080/api/employees/{ID}
---
## Create DB
Open a local instance of MySQL workbench and run the following script
"create database ems"

### create DB table
Ensure that the following code is present in your "application.properties" file
```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect 
spring.jpa.generate-ddl = true 
spring.jpa.hibernate.ddl-auto=update 
```
---
## Dependancies
- [pom.xml](https://github.com/Keane97/springboot-backend/blob/main/pom.xml)


---
## Project Architecture
*There is currently no accessible frontend, so Postman was used to access the endpoints made available*
![image](https://user-images.githubusercontent.com/34273900/159957857-ff2a4c6c-1238-45f2-9dc0-7fe07cddd24c.png)
