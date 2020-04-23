package com.assignment.mailbox.dao;



import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.assignment.mailbox.model.User;


public interface UserDao extends CrudRepository<User, Integer> 
{
	public List<User>  findAll();
	public User findByUsername(String username); 
		
	
}
