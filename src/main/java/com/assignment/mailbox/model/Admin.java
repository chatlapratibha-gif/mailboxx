package com.assignment.mailbox.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="admin")
public class Admin {
     @Id
     @Generated("assigned")
     @NotEmpty(message = "User Name  should not empty")
	private String username;
     @Column
     @NotEmpty(message = "Password  should not empty")
     private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
     
     
	
}
