package config;

import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ma.ensa.entities.Avoir;
import ma.ensa.entities.Client;
import ma.ensa.entities.Commande;
import ma.ensa.entities.LigneCommande;
import ma.ensa.entities.LigneCommandeId;
import ma.ensa.entities.Produit;


@Configuration
@ComponentScan("ma.ensa.dao,ma.ensa.service")
@EnableTransactionManagement
public class AppConfig {
		
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/ecommercedb02");
	    dataSource.setUsername("root");
	    dataSource.setPassword("");
	    return dataSource;
	}
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setHibernateProperties(getHibernateProperties());
        sessionFactory.setAnnotatedClasses(new Class[]{
        		Produit.class,
        		Commande.class,
        		LigneCommande.class,
        		LigneCommandeId.class,
        		Client.class,
        		Avoir.class
        		});
        return sessionFactory;
     }
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.hbm2ddl.auto","create");
	    properties.put("hibernate.show_sql","true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    return properties;
	}
	
	//@Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
	
}
