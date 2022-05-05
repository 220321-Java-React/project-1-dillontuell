package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Role;

public interface RoleDAOInterface {

	ArrayList<Role> getRoles();
	Role getRoleById(int id);
	
}