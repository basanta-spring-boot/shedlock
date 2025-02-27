# shedlock

### Step 1: Add Dependencies
Add the necessary ShedLock dependencies to your pom.xml:
```
<!-- ShedLock Core -->
<dependency>
    <groupId>net.javacrumbs.shedlock</groupId>
    <artifactId>shedlock-spring</artifactId>
    <version>5.8.0</version>
</dependency>

<!-- ShedLock for JDBC (PostgreSQL, MySQL, etc.) -->
<dependency>
    <groupId>net.javacrumbs.shedlock</groupId>
    <artifactId>shedlock-provider-jdbc-template</artifactId>
    <version>5.8.0</version>
</dependency>

<!-- Spring Boot JDBC Starter (If not already included) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

### Step 2: Configure the ShedLock Table
Since ShedLock requires a database to store lock records, create the following table:
```
CREATE TABLE shedlock (
    name VARCHAR(64) PRIMARY KEY,
    lock_until TIMESTAMP NOT NULL,
    locked_at TIMESTAMP NOT NULL DEFAULT NOW(),
    locked_by VARCHAR(255) NOT NULL
);
```
### Run Multiple Instances Using Command Line
Use the -Dspring-boot.run.arguments option to specify different configurations for each instance.
```
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```
```
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8082"
```
