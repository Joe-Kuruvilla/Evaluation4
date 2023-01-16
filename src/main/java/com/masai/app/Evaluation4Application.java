package com.masai.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class Evaluation4Application {

	public static void main(String[] args) {
		SpringApplication.run(Evaluation4Application.class, args);
	}
	@Bean
	LocalValidatorFactoryBean validator(MessageSource ms) {
		LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean();
		lvfb.setValidationMessageSource(ms);
		return lvfb;
	}

}
