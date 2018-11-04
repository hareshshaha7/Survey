/**
 * 
 */
package com.haresh.usersurvey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.haresh.usersurvey.dao.UserDao;
import com.haresh.usersurvey.model.User;

/**
 * @author Haresh.Shaha
 *
 */
public class UserServiceImplementation implements UserService {

	@Autowired
	UserDao dao;
	
	/* (non-Javadoc)
	 * @see com.haresh.usersurvey.service.UserService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}
	
	

}
