package com.mavha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.mavha.controller.TodoController;

//@ComponentScan(basePackageClasses = TodoController.class) 
@SpringBootApplication
public class ExamenApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(ExamenApplication.class);
	    }
}
