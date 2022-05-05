package com.revature.daos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAOInterface {

	ArrayList<User> getUsers();
	
	User getUserById(int id) ;
	
	ArrayList<User> getUsersByRole(String title);
	
	void insertUser(User user, int role_id);
	
	void removeUser(int id);
	
	
	
	
	
}