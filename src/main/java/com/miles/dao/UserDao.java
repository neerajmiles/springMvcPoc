package com.miles.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.miles.entity.User;

public interface UserDao {
	
	public void addPerson(User pUser);
	
    public void updateUser(User pUser);
    
    public List<User> listUsers();
    
    public List<User> getUserByString(String userSrchStr);
    
    public User getUserById(int id);
    
    public void removeUser(int id);

}
