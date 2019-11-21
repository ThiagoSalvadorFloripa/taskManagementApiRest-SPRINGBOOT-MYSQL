package com.salvador.thiago.taskManagerApiRest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Entity
public class Task implements Serializable {
	
	private static final long serialVersionUID = 4393975235067312189L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "{title.not.blank}")
	private String title;
	@NotEmpty(message = "{description.not.blank}")
	private String description;
	
	private Boolean status;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dateCreated;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dateChange;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dateDeleted;
	
	public Task() {
	}

	public Task(Long id) {
		this.id = id;
	}

	public Task(Long id, String title, String description, Boolean status, Date dateCreated, Date dateChange,
			Date dateDeleted) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.dateCreated = dateCreated;
		this.dateChange = dateChange;
		this.dateDeleted = dateDeleted;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
