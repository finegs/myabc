# myabc

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).


### Derby Client for Embedded
jdbc:derby:[subsubprotocol:][databaseName][;attribute=value]

### Derby Client JDBC URL for client/server mode
jdbc:derby://server[:port]/databaseName[;attribute=value]

String urlConnection = "jdbc:derby:baeldung;create=true";

### Use Apache Derby in Embedded mode
String urlConnection = "jdbc:derby:baeldung;create=true";
Connection con = DriverManager.getConnection(urlConnection);
Statement statement = con.createStatement();
String sql = "CREATE TABLE authors (id INT PRIMARY KEY,first_name VARCHAR(255),last_name VARCHAR(255))";
statement.execute(sql);
sql = "INSERT INTO authors VALUES (1, 'arash','ariani')";
statement.execute(sql);

### Use Apache Derby in client/server mode
java -jar $DERBY_HOME/lib/derbyrun.jar server start

### JDBC API to connect to an apache derby server on localhost
String urlConnection = "jdbc:derby://localhost:1527/baeldung";
   try (Connection con = DriverManager.getConnection(urlConnection)) {
       Statement statement = con.createStatement();
       String sql = "SELECT * FROM authors";
       ResultSet result = statement.executeQuery(sql);
         while (result.next()) {
           // We can print or use ResultSet here
         }
   } catch (SQLException ex) {
       ex.printStackTrace();
 }

### Derby Configuration for Maven 
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.derby</groupId>
    <artifactId>derbyclient</artifactId>
    <version>10.13.1.1</version>
</dependency>

### Derby on SpringBoot (application.properties)
spring.datasource.url=jdbc:derby://localhost:1527/baeldung 
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.DerbyTenSevenDialect 
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=org.apache.derby.jdbc.ClientDriver

### Java on VSCode
https://jhleeeme.github.io/java-and-maven-uses-in-vscode/

### RestAPI with apache derby on SpringBoot
https://mnaufalazwar.medium.com/java-spring-boot-making-crud-operation-using-spring-data-jpa-4d9252a87270