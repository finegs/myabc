REM From (https://www.baeldung.com/java-apache-derby)
REM java -jar -Dij.protocol=jdbc:derby: -Dij.database=sample derbyrun.jar ij
REM %DERBY_HOME%/bin/dblook -d jdbc:derby:sample
REM $DERBY_HOME/bin/dblook -d jdbc:derby:sample -o sample.sql
REM $DERBY_HOME/bin/dblook -d jdbc:derby:sample -o sample.sql -z SCHEMA_NAME -t "table01"
REM java -jar $DERBY_HOME/lib/derbyrun.jar sysinfo
REM ij>connect 'jdbc:derby:databaseName;create=true;
REM ij>connect 'jdbc:derby:sample' user 'user1' password 'pass123';
REM ij>CREATE SCHEMA schema_name AUTHORIZATION userName;
REM ij>CREATE SCHEMA sample_authors;
REM ij>CREATE SCHEMA sample_authors AUTHORIZATION sample;
REM ij> DROP SCHEMA sample_authors RESTRICT;