/**
 * 
 */
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
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TaskDto findById(Long id) {
		Task task = new Task();
		if (this.findByIdEntity(id) != null) {
			task = this.findByIdEntity(id);
		}
		TaskDto taskDto = modelMapper.map(task, TaskDto.class);
		return taskDto;
	}

	public List<TaskDto> findAll() {
		List<Task> lits = repository.findAll();
		List<TaskDto> listOfPostDTO = ObjectMapperUtils.mapAll(lits, TaskDto.class);
		return listOfPostDTO;
	}

	public Page<TaskDto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest =PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Task> tasks = repository.findAll(pageRequest);
		Page<TaskDto> dto = ObjectMapperUtils.mapAllPage(tasks, TaskDto.class);
		return dto;
	}

	public Task insert(TaskDto objDto) {
		Task task = modelMapper.map(objDto, Task.class);
		task.setDateCreated(new Date());
		task.setStatus(true);
		return repository.save(task);

	}

	public Task update(TaskDto objDto, Long id) {
		Task task = modelMapper.map(objDto, Task.class);
		task.setId(id);
		task.setDateChange(new Date());
		return repository.save(task);
	}

	public Task deleteById(TaskDto objDto, Long id) {
		Task task = modelMapper.map(objDto, Task.class);
		task.setDateDeleted(new Date());
		task.setStatus(false);
		return repository.save(task);
		
	}

	public Task findByIdEntity(Long id) {
		Optional<Task> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! id: "+ id + ", type" + Task.class.getName()));
	}
	
	public void converDate(TaskDto objDto) {
		Task task = (Task) modelMapper.typeMap(TaskDto.class,Task.class).addMappings(mp -> {
		    mp.skip(Task::setDateCreated );
		});
		
	}
	

}
