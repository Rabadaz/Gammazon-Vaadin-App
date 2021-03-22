# Gammazon Wearhouse
Gammazon is a mini online Shop Vaadin-System. 
It is created to demonstrate the Decorator Pattern in a bigger Software Solution.

## The Decorator Pattern
It is used to implement the Filter Logic inside the Application.

## Technology
The application is using the following Tech-Stack:

* PostgreSQL
* JPA - Hibernate
* Spring Boot
* Vaadin

## Auth
For Auth this Application is using Spring-Boot Security with the Application Database as a Datasource.

There is a Permission-System implemented, currently there are 2 Permissions present:

### Permissions

|Permission|Description|
|----------|-----------|
|insights:view|enables the User to view the Insights Page|
|users:view|enables the User to view the Users Page|