package net.myabc.spring.batch.config;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.myabc.spring.batch.entity.Person;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackageClasses = Person.class,
  entityManagerFactoryRef = "extractorSourceEntityManagerFactory",
  transactionManagerRef = "extractorSourceTransactionManager"
)
public class ExtractorSourceJpaConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean extractorSourceEntityManagerFactory(
      @Qualifier("extractorSourceDataSource") DataSource dataSource,
      EntityManagerFactoryBuilder builder) {
        return builder
          .dataSource(dataSource)
          //.dataSource(extractorSourceDataSource())
          .packages(Person.class)
          .build();
    }

    @Bean
    public PlatformTransactionManager extractorSourceTransactionManager(
      @Qualifier("extractorSourceEntityManagerFactory") LocalContainerEntityManagerFactoryBean extractorSourceEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(extractorSourceEntityManagerFactory.getObject()));
    }

}