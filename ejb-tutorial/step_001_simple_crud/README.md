 
### Prerequisites
- Java 8
- maven 3
- glassfish 5.0
- mysql 8

## Setup

### mysql
Install mysql database, then execute following query.
    
    ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
    commit;
    
    CREATE SCHEMA `javaeetutorial` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
    
    CREATE TABLE user_info (
        id INT PRIMARY KEY,
        username VARCHAR(255) UNIQUE,
        passwd VARCHAR(255),
        email VARCHAR(255) UNIQUE
    );
    
    insert into user_info (id, username, passwd, email)
     values(1, 'samanalishiri', '123', 'samanalishiri@mail.com');
    insert into user_info (id, username, passwd, email) 
    values(2, 'admin', '123','admin@mail.com');
    insert into user_info (id, username, passwd, email) 
    values(3, 'user', '123','user@mail.com');
    commit;

### glassfish
Install glassfish 5.0.
- create domain with `asadmin create-domain domainname` command
- add mysql connector J in two solution:

    `1- asadmin add-library /path/to/mysql-connector-java<8.0.13>.jar`
    
     `2- add mysql-connector-java<8.0.13>.jar to glassfish5\glassfish\domains\domain-name\lib`    
- start glassfish with `asadmin start-domain domainname` command
- create connection pool

   ` You should set datasource class implementation to com.mysql.cj.jdbc.MysqlConnectionPoolDataSource.
    You can change implementation after create datasource`

- create jdbc resource with jndi-name: `jdbc/javaeetutorial`

### Build
`mvn clean install`

`deploy in glassfish`

### Test
`mvn clean test`

### Sonar
run `sonar-scanner` command in project root folder