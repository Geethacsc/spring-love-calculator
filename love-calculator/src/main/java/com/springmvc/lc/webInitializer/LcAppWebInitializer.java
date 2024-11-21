package com.springmvc.lc.webInitializer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.springmvc.lc.config.ConfigApp;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

//Approach - I --> for java based web.xml
public class LcAppWebInitializer //implements WebApplicationInitializer 
{

	//@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		/**
		 * for xml based config file
		 * XmlWebApplicationContext webApplicationContext=new XmlWebApplicationContext();
		 * webApplicationContext.setConfigLocation("classpath:application-config.xml");
		 */		 
		 
		AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(ConfigApp.class);
		
		DispatcherServlet dispatcherServlet=new DispatcherServlet(webApplicationContext);
		
		ServletRegistration.Dynamic customServlet=servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		
		
		customServlet.setLoadOnStartup(1);
		customServlet.addMapping("/mywebsite.com/*");
		
		
	}

}
