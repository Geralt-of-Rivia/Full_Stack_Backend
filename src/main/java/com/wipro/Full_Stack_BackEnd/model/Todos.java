package com.wipro.Full_Stack_BackEnd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Todos {
	@Id
	@Column
	private long id;
	@Column
	private String username;
	@Column
	private String description;
	@Column
	private Date targetdate;
	@Column
	private boolean isDone;
	public Todos() {
		super();
	}
	public Todos(long id, String username, String description, Date targetdate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetdate = targetdate;
		this.isDone = isDone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetdate() {
		return targetdate;
	}
	public void setTargetdate(Date targetdate) {
		this.targetdate = targetdate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Todos other = (Todos) obj;
		if (id != other.id)
			return false;
		return true;
	} 

}
