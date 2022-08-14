package net.myabc.spring.batch.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "firstDbEntityManagerFactory",
    transactionManagerRef = "firstDbTransactionManager",
    basePackages = ["org.path.to.firstDb.domain"]
)
@EnableTransactionManagement
public class DBConfigFirst {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.firstDb")
    fun firstDbDataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Primary
    @Bean(name = ["firstDbEntityManagerFactory"])
    fun firstDbEntityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("firstDbDataSource") dataSource: DataSource
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource)
            .packages(SomeEntity::class.java)
            .persistenceUnit("firstDb")
            // Following is the optional configuration for naming strategy
            .properties(
                singletonMap(
                    "hibernate.naming.physical-strategy",
                    "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl"
                )
            )
            .build()
    }

    @Primary
    @Bean(name = ["firstDbTransactionManager"])
    fun firstDbTransactionManager(
        @Qualifier("firstDbEntityManagerFactory") firstDbEntityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(firstDbEntityManagerFactory)
    }
}