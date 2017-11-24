package com.tuneride.server.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.dialect.H2Dialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableTransactionManagement
//@ComponentScan(basePackages = "com.project.domain") //TODO adjust
public class DatabaseConfig {
	
	@Value("${spring.jpa.database}")
    private Database database;
	
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean(destroyMethod = "close", name = "dataSource")
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(DatabaseConfig databaseConfig) {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setDatabase(database);
        switch (database) {
            case H2:
                // https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html
                //hibernateJpaVendorAdapter.setGenerateDdl(true);
                hibernateJpaVendorAdapter.setShowSql(true);
                hibernateJpaVendorAdapter.setDatabasePlatform(H2Dialect.class.getCanonicalName());
                break;
            case MYSQL:
                hibernateJpaVendorAdapter.setGenerateDdl(false);
                //TODO
                //hibernateJpaVendorAdapter.setDatabasePlatform(FiSqlServerDialect.class.getCanonicalName());
                break;
            default:
                break;
        }
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("com.project.domain"); //TODO make configurable
        return lef;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setJpaDialect(new HibernateJpaDialect());
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

}
