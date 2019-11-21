/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.configEnvironment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService db;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDataBase() {
		if(!"create".equals(strategy)) {
			return false;
		}
		
		db.instantiateDevDataBase();
		return  true;
	}
	

}
