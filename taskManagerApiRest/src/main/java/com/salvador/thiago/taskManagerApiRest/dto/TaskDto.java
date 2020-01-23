/**
 * 
 */
package com.salvador.thiago.taskManagerApiRest.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com ----
 */

public class TaskDto implements Serializable {

	private static final long serialVersionUID = 2833818054900146733L;
	
	private Long id;
	@NotEmpty(message = "Title must not be null")
	private String title;
	@NotEmpty(message = "Description must not be null")
	private String description;
	private Boolean status;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,locale = "pt_BR")
	private Date dateCreated;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale = "pt_BR")
	private Date dateChange;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale = "pt_BR")
	private Date dateDeleted;
	
	public TaskDto() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateChange() {
		return dateChange;
	}

	public void setDateChange(Date dateChange) {
		this.dateChange = dateChange;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	
	
	
	
	
	
	

}
