package com.assignment.mailbox.dao;

import org.springframework.data.repository.CrudRepository;

import com.assignment.mailbox.model.Admin;
public interface AdminDao  extends CrudRepository<Admin, String>{

}
