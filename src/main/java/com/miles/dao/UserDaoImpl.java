package com.miles.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miles.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPerson(User pUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User pUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listUsers() {
        Session session = this.sessionFactory.openSession();  //.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<User> usersList = session.createQuery("from User").list();
        
        for(User p : usersList){
            System.out.println("Person List::"+p);
        }
		
        return usersList;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUserByString(String userSrchStr) {
		 Session session = this.sessionFactory.openSession();  //.getCurrentSession();
	        @SuppressWarnings("unchecked")
			List<User> usersList = session.createCriteria(User.class).add(Restrictions.ilike("username", "%"+userSrchStr+"%") ).list();
			
	        for(User p : usersList){
	            System.out.println("Person List::"+p);
	        }
			
	        return usersList;
	}

}
