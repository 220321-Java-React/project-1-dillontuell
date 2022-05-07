package com.revature.controllers;

import java.util.Collection;

import com.google.gson.Gson;
//import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {

	
	AuthService as = new AuthService();
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		/*LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		if(as.login(LDTO.getUsername(), LDTO.getPassword()) != null) {
			
			ctx.req.getSession(true);
			
			ctx.status(202); 
			
			String userJSON = gson.toJson(as.login(LDTO.getUsername(), LDTO.getPassword()));
			
			ctx.result(userJSON);
			
		} else {
			ctx.status(401);
			*/System.out.println("Uh Oh login failed");
		};
}

	
