package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.User;

public class UserService {

	UserDAO eDAO = new UserDAO();

	public ArrayList<User> getUsers(){
		
		ArrayList<User> users = eDAO.getUsers();
		
		return users;
		
	}
	
}
