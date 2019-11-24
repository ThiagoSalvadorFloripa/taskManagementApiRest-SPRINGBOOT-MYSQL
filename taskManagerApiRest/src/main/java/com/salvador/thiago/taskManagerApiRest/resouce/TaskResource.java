
package com.salvador.thiago.taskManagerApiRest.resouce;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salvador.thiago.taskManagerApiRest.domain.Task;
import com.salvador.thiago.taskManagerApiRest.dto.TaskDto;
import com.salvador.thiago.taskManagerApiRest.service.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Note:Class responsible for consuming and 
 * producing data via Http protocol
 * </p>
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@CrossOrigin(origins = "*")
@Api(value="REST API Task Management")
@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {
	
	@Autowired
	private TaskService service;
	
	
	/**
	   * <p>Method responsible for receiving of front a POST of 
	   * protocol HTTP with data type
	   * Json and send to next validation layer
	   * <p>
	   *  
	   * @param Object TaskDto
	   * @return ResponseEntity
	   */
	@ApiOperation(value="Save a task")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Valid TaskDto objDto) {
		Task obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/**
	   * <p>Method responsible for receiving of front a PUT of
	   *  protocol HTTP type data
	   *  Json and send to next validation layer
	   *  <p>
	   *  
	   * @param  TaskDto
	   * @param  id
	   * @return ResponseEntity
	   */
	@ApiOperation(value="Update a task")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update( @PathVariable("id") Long id, @RequestBody @Valid TaskDto objDto) {
		service.update(objDto, id);
		return ResponseEntity.noContent().build();
	}
	
	/**
	   * <p>Method responsible for receiving of front a DELETE of
	   *  protocol HTTP type
	   *  Json and send to next validation layer
	   *  <p>
	   *  
	   * @param  TaskDto
	   * @param  id
	   * @return ResponseEntity
	   */
	@ApiOperation(value="Delete a task")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	/**
	   * <p>Method responsible for receiving of front a GET of
	   *  protocol HTTP data type
	   *  Json and send to next validation layer<p>
	   *  
	   * @param  id
	   * @return ResponseEntity<TaskDto>
	   */
	@ApiOperation(value="Search for a task by ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TaskDto> findById(@PathVariable Long id){
		TaskDto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/**
	   * <p>Method responsible for receiving of front a GET of
	   *  protocol HTTP data type
	   *  Json and send to next validation layer<p>
	   *  
	   * @return ResponseEntity<List<TaskDto>> 
	   */
	@ApiOperation(value="Search all tasks")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TaskDto>> findAll(){
		List<TaskDto> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	}
	
	/**
	   * <p>Method responsible for receiving of front a GET type
	   *  Json and send to next validation layer<p>
	   * 
	   * @return ResponseEntity<Page<TaskDto>>
	   */
	@ApiOperation(value="Search paginated tasks")
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<TaskDto>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "current") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		Page<TaskDto> listDto = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(listDto);
	}
	
}
