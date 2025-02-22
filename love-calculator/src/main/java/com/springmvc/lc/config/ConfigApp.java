package com.springmvc.lc.config;

import java.util.Properties;

import javax.imageio.spi.RegisterableService;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springmvc.lc.converter.MobileConverter;
import com.springmvc.lc.formatter.MobileFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.springmvc.lc")
public class ConfigApp implements WebMvcConfigurer {// WebMvcConfigurer calls the formatter class

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean("messageSource") // loads the properties files - spring automatically fetches bean named
							// "messageSource"
	public MessageSource myMessageSource() {
		System.out.println("Inside messageSource");
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("messages");
		return resource;
	}

	@Bean("validator") // used to set user set codes properties value to fetch in messages.properties
	public LocalValidatorFactoryBean myValidator() {
		System.out.println("Inside validator");
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(myMessageSource());
		return localValidatorFactoryBean;
	}

	@Override
	public void addFormatters(FormatterRegistry register) {
		System.out.println("Inside Formatter initialiaze");

		// string to Mobile object using Formatter
		// register.addFormatter(new MobileFormatter());

		// string to Mobile object using Converter
		register.addConverter(new MobileConverter());
	}

	@Override
	public Validator getValidator() {
		System.out.println("inside webMVC getValidator");
		return myValidator();
	}

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setUsername("geetha553jg@gmail.com");
		mailSender.setPassword("bvcx tczj kxxw dzrd");
		mailSender.setPort(587);

		 Properties mailProperties = new Properties();
//		mailProperties.put("mail.transport.protocol", "smtp");
//		mailProperties.put("mail.smtp.auth", "true");
//		mailProperties.put("mail.smtp.starttls.enable", "true");
//		mailProperties.put("mail.debug", "true");

		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		mailSender.setJavaMailProperties(mailProperties);
		return mailSender;
	}

}
