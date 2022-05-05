package com.revature.models;

//This Class models the employees table in our database
public class User {

	//variables for the employee class - must match the employees table in the database
	//note the private variables, private coupled with getters and setters (see below) are how we achieve ENCAPSULATION
	private int user_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	//Every Employee in this application will have a role associated with it
	private Role role; //in other words, every EMPLOYEE has a ROLE

	
	//this class won't have any methods, we just need it to represent (aka MODEL) some data
	
	//boilerplate code below------------------------------
	//boilerplate code is any code that you'll probably write over and over again
	//most classes that we make objects of will have constructors, getters/setters, toString
	//so java makes this easy for us with the source tab 
	
	//remember all of this can be generated with the source tab
	
	//no args constuctor (source -> constructor from superclass)
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor (source -> constructor from fields)
	public User(int user_id, String username, String password, String first_name, String last_name, String email, Role role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
	}

	//We need an "all args minus id" constructor because the id is handled on the database side
	//when inserting data into a database, we should give objects with no id since the database gives each record an id
	public User(String username, String password, String first_name, String last_name, String email, Role role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
	}
	
	//the toString() method lets us actually print out our objects, since it would print a memory address otherwise
	//(source -> generate toString)
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ",username=" + username + ",password=" + password + ",first_name=" + first_name + ", last_name=" + last_name +",email=" + email
				+ ", role=" + role + "]";
	}


	//getters and setters allow you to access and change your private variables... ENCAPSULATION
	//(source -> generate getters and setters, make sure to check all the boxes)
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getusername() {
		return username;
	}
		
	public void setusername(String username) {
		this.username = username;
	}
	public String password() {
		return password;
	}
		
	public void setpassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	} 
	
}
