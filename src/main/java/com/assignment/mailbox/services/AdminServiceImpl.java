package com.assignment.mailbox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.assignment.mailbox.dao.AdminDao;
import com.assignment.mailbox.dao.UserDao;
import com.assignment.mailbox.model.Admin;
import com.assignment.mailbox.model.User;

@Service
@Component
public class AdminServiceImpl  implements AdminService
{
     @Autowired
	private AdminDao adminDao;
     @Autowired
     private UserDao userdao;

	@Override
	public boolean login(Admin admin) {

             
	Optional<Admin>	 a =adminDao.findById(admin.getUsername());
	Admin ad = a.get();
	
	if(ad.getPassword().equals(admin.getPassword()))
	{
		return true;
	}
		
		return false;
	}

	public List<User> userList() {
		return userdao.findAll();

	}

	@Override
	public boolean activate(String username) {
		// TODO Auto-generated method stub
		User u=userdao.findByUsername(username);
		String s=u.getStatus();
		u.setStatus("yes");
		User u1=userdao.save(u);
		if(u1.getStatus().equals(s)) {
		return false;
	}
		return true;
		}

	@Override
	public boolean deactivate(String username) {
		User u=userdao.findByUsername(username);
		String s=u.getStatus();
		u.setStatus("no");
		User u1=userdao.save(u);
		if(u1.getStatus().equals(s)) {
		return false;
	}
		return true;
	}
	@Override
	public void delete(String username) {
		User u=userdao.findByUsername(username);
		userdao.delete(u);
		
			   
	}

}	


