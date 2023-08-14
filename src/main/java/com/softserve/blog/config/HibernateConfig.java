package com.softserve.blog.config;

import com.softserve.blog.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
@ComponentScan("com.softserve.blog")
public class HibernateConfig {

    private final Environment environment;

    @Autowired
    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSourceBean());
        sessionFactory.setPackagesToScan(new String[] {"com.softserve.blog"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSourceBean() {
        DriverManagerDataSource basicDataSource = new DriverManagerDataSource();
        basicDataSource.setDriverClassName(environment.getRequiredProperty("hibernate.driver_class"));
        basicDataSource.setUrl(environment.getRequiredProperty("hibernate.connection.url"));
        basicDataSource.setUsername(environment.getRequiredProperty("hibernate.connection.username"));
        basicDataSource.setPassword(environment.getRequiredProperty("hibernate.connection.password"));

        return basicDataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return  transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(org.hibernate.cfg.Environment.DIALECT, environment.getRequiredProperty("hibernate.dialect"));
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, environment.getRequiredProperty("hibernate.show_sql"));
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put(org.hibernate.cfg.Environment.CURRENT_SESSION_CONTEXT_CLASS, environment.getRequiredProperty("hibernate.current_session_context_class"));
        properties.put(org.hibernate.cfg.Environment.DRIVER, environment.getRequiredProperty("hibernate.driver_class"));
        properties.put(org.hibernate.cfg.Environment.URL, environment.getRequiredProperty("hibernate.connection.url"));
        properties.put(org.hibernate.cfg.Environment.USER, environment.getRequiredProperty("hibernate.connection.username"));
        properties.put(org.hibernate.cfg.Environment.PASS, environment.getRequiredProperty("hibernate.connection.password"));

        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.setProperties(properties);

        return properties;
    }
}
