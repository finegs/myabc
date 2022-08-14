package net.myabc.spring.batch.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyJDBCTemplate {

    @Bean
    public JdbcTemplate sourceJdbcTemplate(@Qualifier("extractorSourceDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate targetJdbcTemplate(@Qualifier("extractorTargetDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
