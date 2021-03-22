# Gammazon Wearhouse

Gammazon is a mini online Shop Vaadin-System. 
It is created to demonstrate the Decorator Pattern in a bigger Software Solution.

## The Decorator Pattern
It is used to implement the Filter Logic inside the Application.
In this case every Type of Filter is represented by a Decorator. 
There is currently only one Component that can be decorated (FilterableList).

## How to start?

### Database
This Solution needs a Connection to an PostgreSQL Database.
In development a Docker Container was used to connect to this Database (in case anyone wonders why there are Credentials checked in).
To change the Database connection you have to edit the **application.propoerties** file. 

### Java
2. To start this Application it is required to have Java-15 and Maven installed.

If these Requirements are satisfied run:

    mvn spring-boot:run


## Technology
The application is using the following Tech-Stack:

* PostgreSQL
* JPA - Hibernate
* Spring Boot
* Vaadin

## Auth
For Auth this Application is using Spring-Boot Security with the Application Database as a Datasource.

**Note:** For demonstation Purposes the Passwords are saved as Plain-Text in the Database. 
This can easily be changed by using another Password encryptor

```java
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public static PasswordEncoder passwordEncoder() {
        //Just use another Encryptor here (eg: Bcrypt)
        return NoOpPasswordEncoder.getInstance();
    }
}
```


There is a Permission-System implemented, currently there are 2 Permissions present:

### Permissions

|Permission|Description|
|----------|-----------|
|insights:view|enables the User to view the Insights Page|
|users:view|enables the User to view the Users Page|