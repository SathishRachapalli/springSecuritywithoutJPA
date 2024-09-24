package com.demo.TransactionalDemo.springTransactionDemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.configurations.AppConfig;
import com.demo.serviceLayer.serviceClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ConfigurableApplicationContext container=new AnnotationConfigApplicationContext(AppConfig.class);
    	//since its a standalone application (not a web based application), we are using this application Container
    	
    	//this container needs to be closed, it can be done by the following.
    	
    	container.registerShutdownHook();
    	
    	
    	serviceClass serviceClassBean = container.getBean(serviceClass.class);
    	
    	serviceClassBean.saveEmployeeInfo();
    	
    	container.close();
    	
    	
    }
}
