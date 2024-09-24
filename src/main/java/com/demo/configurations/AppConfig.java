package com.demo.configurations;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class AppConfig {
	
	
	@Bean
	public DataSource dataSourceBean()
	{
		return new DriverManagerDataSource(
				"jdbc:mysql://localhost:3306/sampledb",  // spring jdbc URL
				"root",									// userName -- taking credentials
				"root");								// Password
	}
	
	
	
	@Bean
	public JdbcTemplate jdbcTemplateBean()
	{
		return new JdbcTemplate(dataSourceBean());   // it will take the datasourceBean as an input.
		//Thats why we need to create the Bean for datasource; (STEP 1)
	}
	
	@Bean
	public TransactionManager transactionManager()
	{
		return new DataSourceTransactionManager(dataSourceBean());
		
		// Inorder to get the TransactionManager bean , 
		// see the info by clicking ctrl+shift+t -- type PlatformTransactionManager
		//type ctrl+t , to view the classes which are implementing that interfaces.
		// Now, we can implement any of the classes, but for now, we chose the DataSourceTransactionManager
		// and it takes the DataSourceBean as an argument.
	}
	
	
	
	
	

}
