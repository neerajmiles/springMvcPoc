package com.miles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miles.command.UserSearchCommand;
import com.miles.dao.UserDao;
import com.miles.entity.User;

@Service
public class UserSearchService {
	
	@Autowired
	private UserDao userDaoImpl;

	public List<User> getUsers() {				
		return userDaoImpl.listUsers();
	}
}
