package com.assignment.mailbox.model;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {
    @SequenceGenerator(name = "userGenerator",initialValue = 2020,allocationSize = 1,sequenceName = "USER_SEQ")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userGenerator")
	private int UserId;
    @Column(unique =true)
    @NotEmpty(message = "User Name should not  be empty")
	private String username;
    @Column
    @NotBlank
	private String firstname;
    @Column
    private String lastname;
    @Column
	private String password;
    @Column(unique = true)
    @Email(message = "Invalid Email")
	private String  email;
    @Column
    @Pattern(regexp = "[6789][0-9]{9}",message = "Invalid Mobile")
	private String mobile;
    @Column
    private String status="no";
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", password=" + password + ", email=" + email + ", mobile=" + mobile + ", status=" + status
				+ "]";
	}
	
   
   
	
	
	
	
	
	
	

}
