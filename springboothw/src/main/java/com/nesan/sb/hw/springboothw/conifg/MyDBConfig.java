package com.nesan.sb.hw.springboothw.conifg;



import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
//Note this file isnt needed for basic spring web
//Reason we put db.friver and all in properties file is because tommororw if we change it we can just directly change in properties file and then we dont need to recompile just need to restart the server
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MyDBConfig {
    @Value("${db.driver}")
    private String db_driver;

    @Value("${db.url}")
    private String db_url;

    @Value("${db.username}")
    private String db_username;

    @Value("${db.password}")
    private String db_password;

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${entitymanager.packagesToScan}")
    private String ENTITYMANAGER_PACKAGES_TO_SCAN;
    
    @Bean
    public DataSource datasource()
    {
       DriverManagerDataSource dataSource=new DriverManagerDataSource();
       dataSource.setDriverClassName(db_driver);
       dataSource.setUrl(db_url);
       dataSource.setUsername(db_username);
       dataSource.setPassword(db_password);
       return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        
        LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
        sessionFactory.setDataSource(datasource());
        sessionFactory.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
        Properties hibernateProperties=new Properties();
        hibernateProperties.put("hibernate.dialect",HIBERNATE_DIALECT);
        hibernateProperties.put("hibernate.show_sql",HIBERNATE_SHOW_SQL);//to print sql stuff for debugginh
        hibernateProperties.put("hibernate.enable_lazy_load_no_trans",true);
        hibernateProperties.put("hibernate.hbm2ddl.auto",HIBERNATE_HBM2DDL_AUTO);//set to update
        sessionFactory.setHibernateProperties(hibernateProperties);
        
        return sessionFactory;
    }

    @Bean//hibernate transaction manager ensures either you do something or you dont(commit and rollback)
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }



}
