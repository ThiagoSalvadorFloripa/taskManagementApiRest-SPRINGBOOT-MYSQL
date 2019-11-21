/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salvador.thiago.taskManagerApiRest.domain.Task;
import com.salvador.thiago.taskManagerApiRest.repository.TaskRepository;

/**
 * @author thiagosalvador
 *
 */

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;

	public Task findById(Long id) {
		Optional<Task> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! id: "+ id + ", type" + Task.class.getName()));
				
	}

}
