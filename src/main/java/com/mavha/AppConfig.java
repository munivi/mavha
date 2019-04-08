package com.mavha;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class AppConfig {
	
	@Bean
	@Primary
	public DataSource dataSource() {
	    return DataSourceBuilder
	        .create()
	        .username("sa")
	        .password("sa")
	        .url("jdbc:hsqldb:file:db/testdb")
	        .driverClassName("org.hsqldb.jdbc.JDBCDriver")
	        .build();
	}
}
