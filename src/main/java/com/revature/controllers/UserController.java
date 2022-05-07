package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {
	
	UserService us = new UserService();

	public Handler getUsersHandler = (ctx) -> {

		
		if(ctx.req.getSession(true) != null) {
			
		ArrayList<User> users = us.getUsers();
		
		Gson gson = new Gson();
		
		String JSONUsers = gson.toJson(users);
		
		ctx.result(JSONUsers); 
		ctx.status(200); 
		
		} else { 
			ctx.status(400);
		}
		
	};
	
}
