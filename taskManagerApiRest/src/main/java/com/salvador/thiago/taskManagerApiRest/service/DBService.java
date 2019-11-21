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
		Task task0 = new Task(null,"title0", "description", true, new Date(),new Date(),new Date() );
		Task task1 = new Task(null,"title1", "description", true, new Date(),new Date(),new Date() );
		Task task2 = new Task(null,"title2", "description", true, new Date(),new Date(),new Date() );
		Task task3 = new Task(null,"title3", "description", true, new Date(),new Date(),new Date() );

		repository.saveAll(Arrays.asList(task0,task1,task2, task3));
		
		
		
		
		
	}
	

}
