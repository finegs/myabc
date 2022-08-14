# spring-batch-example

```
DDL
{
 	CREATE TABLE IF NOT EXISTS person  (
        person_id BIGINT auto_increment NOT NULL PRIMARY KEY,
        first_name VARCHAR(40),
        last_name VARCHAR(40),
        email VARCHAR(100),
        age INT
    );   
}
````

```
Ref
{
    https://www.baeldung.com/spring-boot-configure-multiple-datasources
}
```

```
Multiple Data Source Ref
{
    https://stackoverflow.com/questions/30337582/spring-boot-configure-and-use-two-data-sources
}
```