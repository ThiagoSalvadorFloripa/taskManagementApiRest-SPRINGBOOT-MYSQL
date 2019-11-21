/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salvador.thiago.taskManagerApiRest.domain.Task;
import com.salvador.thiago.taskManagerApiRest.service.TaskService;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@RestController
@RequestMapping(value = "/task")
public class TaskResource {
	
	@Autowired
	private TaskService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Task> findById(@PathVariable Long id){
		Task obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Task>> findAll(){
		List<Task> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	

}
