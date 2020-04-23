package com.assignment.mailbox.services;

import java.util.List;

import com.assignment.mailbox.model.User;
import com.assignment.mailbox.model.UserLogin;

public interface UserService {
	public int createUser(User user);
	public int login(UserLogin userlogin);
	public List<User> userList();
}
