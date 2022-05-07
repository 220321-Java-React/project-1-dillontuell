package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.controllers.AuthController;
import com.revature.controllers.UserController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) { 
			System.out.println("connection failed... :(");
			e.printStackTrace();
		}
		
		UserController uc = new UserController();
		
		AuthController ac = new AuthController();
		
		Javalin app = Javalin.create(
			
					config -> {
						config.enableCorsForAllOrigins(); 
					}
				).start(3000); 
		
		app.get("/users", uc.getUsersHandler);
		
		app.post("/login", ac.loginHandler);
		
	}
	
}
					