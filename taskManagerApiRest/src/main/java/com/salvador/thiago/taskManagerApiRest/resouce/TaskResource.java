/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.resouce;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */
@CrossOrigin(origins = "*")
@Api(value="REST API Task Management")
@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {
	
	@Autowired
	private TaskService service;
	
	@ApiOperation(value="Salva uma tarefa")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Valid TaskDto objDto) {
		Task obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value="Atualiza uma tarefa")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid TaskDto objDto, @PathVariable Long id) {
		service.update(objDto, id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Deleta uma tarefa")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody TaskDto objDto, @PathVariable Long id){
		service.deleteById(objDto, id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Busca uma tarefa por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TaskDto> findById(@PathVariable Long id){
		TaskDto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Busca todas tarefas")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TaskDto>> findAll(){
		List<TaskDto> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value="Busca tarefas paginadas")
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
