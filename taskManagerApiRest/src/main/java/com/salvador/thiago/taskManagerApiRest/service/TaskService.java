/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.salvador.thiago.taskManagerApiRest.domain.Task;
import com.salvador.thiago.taskManagerApiRest.repository.TaskRepository;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
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

	public List<Task> findAll() {
		return repository.findAll();
	}

	public Page<Task> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest =PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Task insert(Task obj) {
		obj.setId(null);
		try {
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Error trying to save, possible null values exist");
		}

	}

	public Task update(Task obj) {
		this.findById(obj.getId());
		return repository.save(obj);
	}

	public void deleteById(Long id) {
		this.findById(id);
		repository.deleteById(id);
	}

}
