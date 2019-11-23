/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author thiagosalvador
 *
 */
@Configuration
public class ApplicationConfiguration {
	
	@Bean
	  public ModelMapper modelMapper() {
	    ModelMapper mapper = new ModelMapper();

	    mapper.getConfiguration()
	        .setFieldMatchingEnabled(true)
	        .setMatchingStrategy(MatchingStrategies.STRICT);

	    return mapper;
	  }


}
