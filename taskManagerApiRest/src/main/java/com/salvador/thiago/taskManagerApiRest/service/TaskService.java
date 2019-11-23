
package com.salvador.thiago.taskManagerApiRest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.salvador.thiago.taskManagerApiRest.domain.Task;
import com.salvador.thiago.taskManagerApiRest.dto.TaskDto;
import com.salvador.thiago.taskManagerApiRest.repository.TaskRepository;
import com.salvador.thiago.taskManagerApiRest.util.ObjectMapperUtils;

/**
* <p>Note:Class responsible for application business and 
* send to next data persistence layer
* </p>
* 
* @author Thiago Salvador - thiago.salvadorpower@gmail.com
*/

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	   * <p> Method responsible for fetching a task by id by
	   * and sending and validating data received from the
	   * persistence layer.
	   * 
	   * Maps one object to another using modelMapper
	   * <p>
	   *  
	   * @param Long id
	   * @return TaskDto
	   */
	public TaskDto findById(Long id) {
		Task task = new Task();
		if (this.findByIdEntity(id) != null) {
			task = this.findByIdEntity(id);
		}
		TaskDto taskDto = modelMapper.map(task, TaskDto.class);
		return taskDto;
	}
	
	/**
	   * <p> Method responsible for fetching all tasks and 
	   * sending and validating data received from the 
	   * persistence layer.
	   * 
	   * Maps one object to another using modelMapper
	   * <p>
	   * 
	   * @return List<TaskDto>
	   */
	public List<TaskDto> findAll() {
		List<Task> lits = repository.findAll();
		List<TaskDto> listOfPostDTO = ObjectMapperUtils.mapAll(lits, TaskDto.class);
		return listOfPostDTO;
	}

	/**
	   * <p> Method responsible for paginating all tasks and 
	   * sending and validating data received from the 
	   * persistence layer.
	   * 
	   * Maps one object to another using modelMapper
	   * <p>
	   *  
	   * @param Integer page, Integer linesPerPage, String orderBy, String direction
	   * @return Page<TaskDto>
	   */
	public Page<TaskDto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest =PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Task> tasks = repository.findAll(pageRequest);
		Page<TaskDto> dto = ObjectMapperUtils.mapAllPage(tasks, TaskDto.class);
		return dto;
	}
	
	/**
	   * <p> Responsible method to insert a task and 
	   * send and validate data received from 
	   * persistence layer.
	   * 
	   * Maps one object to another using modelMapper
	   * <p>
	   * 
	   * @param TaskDto
	   * @return Task
	   */
	public Task insert(TaskDto objDto) {
		Task task = modelMapper.map(objDto, Task.class);
		task.setDateCreated(new Date());
		task.setStatus(true);
		return repository.save(task);

	}
	
	/**
	   * <p> Responsible method to update a task and 
	   * send and validate data received from 
	   * persistence layer.
	   * 
	   * Maps one object to another using modelMapper
	   * <p>
	   * 
	   * @param TaskDto, Long id
	   * @return Task
	   */
	public Task update(TaskDto objDto, Long id) {
		Task task = modelMapper.map(objDto, Task.class);
		task.setId(id);
		task.setDateChange(new Date());
		return repository.save(task);
	}
	
	/**
	   * <p> Responsible method to delete a task by id
	   * send and validate data received from 
	   * persistence layer.
	   * 
	   * Maps one object to another using modelMapper
	   * <p>
	   * 
	   * @param TaskDto, Long id
	   * @return Task
	   */
	public Task deleteById(TaskDto objDto, Long id) {
		Task task = modelMapper.map(objDto, Task.class);
		task.setDateDeleted(new Date());
		task.setStatus(false);
		return repository.save(task);
		
	}
	
	/**
	   * <p> Responsible method to validatio Exception <p>
	   * 
	   * @param Long id
	   * @return Task
	   */
	public Task findByIdEntity(Long id) {
		Optional<Task> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! id: "+ id + ", type" + Task.class.getName()));
	}

}
