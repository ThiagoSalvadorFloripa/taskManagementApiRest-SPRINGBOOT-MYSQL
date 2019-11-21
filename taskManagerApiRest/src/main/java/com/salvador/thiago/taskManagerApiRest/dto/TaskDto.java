/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.dto;

import java.io.Serializable;

import com.salvador.thiago.taskManagerApiRest.domain.Task;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */
public class TaskDto implements Serializable {

	private static final long serialVersionUID = 2833818054900146733L;
	
	private String title;
	private String description;
	private Boolean status;
	private String dateCreated;
	private String dateChange;
	private String dateDeleted;
	
	public TaskDto() {
		
	}
	
	public TaskDto( Task task) {
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.status = task.getStatus();
		this.dateCreated = task.getDateCreated().toString();
		this.dateChange = task.getDateChange().toString();
		this.dateDeleted = task.getDateDeleted().toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateChange() {
		return dateChange;
	}

	public void setDateChange(String dateChange) {
		this.dateChange = dateChange;
	}

	public String getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(String dateDeleted) {
		this.dateDeleted = dateDeleted;
	}
	
	
	
	
	
	

}
