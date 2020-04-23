package com.assignment.mailbox.services;

import java.util.List;

import com.assignment.mailbox.model.Admin;
import com.assignment.mailbox.model.User;

public interface AdminService
{
	public boolean login(Admin admin);
	public List<User> userList();
	public boolean activate(String username);
	public boolean deactivate(String username);
	public void delete(String username);
}
