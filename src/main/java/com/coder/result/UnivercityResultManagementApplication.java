package com.coder.result;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@SpringBootApplication
public class UnivercityResultManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnivercityResultManagementApplication.class, args);
	}

	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {
		return new  CommonsMultipartResolver();
		
	}
}
