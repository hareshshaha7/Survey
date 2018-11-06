/**
 * 
 */
package com.haresh.usersurvey.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.haresh.usersurvey.model.User;

/**
 * @author Haresh.Shaha
 *
 */
public class UserDaoImplementation implements UserDao {

	@Autowired
	JdbcTemplate template;
	
	private final String SQL_GET_ALL_USERS = "Select * from [User]";
	
	/* (non-Javadoc)
	 * @see com.haresh.usersurvey.dao.UserDao#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> listUsers = template.query(SQL_GET_ALL_USERS, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException
			{
				// TODO Auto-generated method stub
				User user = new User();
				user.setUserId(resultSet.getInt("UserId"));
				user.setFirstName(resultSet.getString("FirstName"));
				user.setLastName(resultSet.getString("LastName"));
				user.setDisplayName(resultSet.getString("DisplayName"));
				user.setEmail(resultSet.getString("Email"));
				
				System.out.println(user);
				return user;
			}
			
		});
		
		return listUsers;
	}
	
	

}
