package com.assignment.mailbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.assignment.mailbox.dao.UserDao;
import com.assignment.mailbox.model.User;
import com.assignment.mailbox.model.UserLogin;

@Service
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public int createUser(User user) {
		User u = userDao.findByUsername(user.getUsername());

		if (u == null) {
			User u1 = userDao.save(user);
			if (u1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
//0 aleady exists, 1 stored successfully , 2 some went wrong

		return 0;
	}

	@Override
	public int login(UserLogin userlogin) {
		 User u = userDao.findByUsername(userlogin.getUsername());
		 if(u==null)
		 {
		 	return 1;
		 }else if(u.getStatus().equals("no"))
		 {
		 	return 2;
		 }
		 else if(u.getPassword().equals(userlogin.getPassword()) && u.getStatus().equals("yes"))
		 {
		 	return 3;
		 }
		 else
		 {
		 return 4;
		 }

	}
         /*if(u!=null)
         {
         	return u.getPassword().equals(userlogin.getPassword());
         }
		
		return false;
	}
*/

	@Override
	public List<User> userList() {
		return userDao.findAll();

	}
	

}
