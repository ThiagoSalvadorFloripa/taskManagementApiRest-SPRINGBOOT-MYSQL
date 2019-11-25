/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salvador.thiago.taskManagerApiRest.domain.Task;
import com.salvador.thiago.taskManagerApiRest.repository.TaskRepository;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Service
public class DBService {
	
	@Autowired
	private TaskRepository repository;
	
	
	public void instantiateDevDataBase() {
		Task task1 = new Task(null,"Do backend", "Backend created in spring boot", true, new Date(),null,null );
		Task task2 = new Task(null,"Do frontend", "Frontend created in React", true, new Date(),null,null );
		Task task3 = new Task(null,"Do documentation", "Documentation Swagger ", true, new Date(),null,null );

		repository.saveAll(Arrays.asList(task1,task2, task3));
		
		
		
		
		
	}
	

}
