 
### Prerequisites
- Java 8
- maven 3
- glassfish 5.0

## Setup

### mysql
Install mysql database, then execute following query.
    
    ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
    commit;
    
    CREATE SCHEMA `javaeetutorial` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
    
    CREATE TABLE user_info (
        id INT PRIMARY KEY,
        username VARCHAR(255) UNIQUE,
        passwd VARCHAR(255) UNIQUE,
        email VARCHAR(255) UNIQUE
    );
    commit;

### glassfish
Install glassfish 5.0.
- create domain with `asadmin create-domain domainname` command
- start glassfish with `asadmin start-domain domainname` command
- create connection pool

   ` You should set datasource class implementation to com.mysql.cj.jdbc.MysqlConnectionPoolDataSource.
    You can change implementation after create datasource`

- create jdbc resource with jndi-name: `jdbc/javaeetutorial`

### Build
`mvn clean install`

### Test
`mvn clean test`

### Sonar
run `sonar-scanner` command in project root folder