package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class UserDAO implements UserDAOInterface{

	RoleDAO rDAO = new RoleDAO();
	
	public ArrayList<User> getUsers(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from users;";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						null 
						);
				
				int roleFK = rs.getInt("role_id_fk");
				
				Role r = rDAO.getRoleById(roleFK);
				
				u.setRole(r);
			
				userList.add(u);
			}
			
			return userList;
			
		} catch (SQLException u) {
			System.out.println("Something went wrong selecting all users!");
			u.printStackTrace();
		}
		
		return null;
		
	}
	
	public ArrayList<User> getUsersByRole(String title) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from users inner join roles "
					+ "on role_id = role_id_fk where role_title = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, title);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						null
						);
				
				int roleFK = rs.getInt("role_id_fk");
				
				Role r = rDAO.getRoleById(roleFK);
				
				u.setRole(r);
				
				userList.add(u);
			}
			
			return userList;
			
		} catch (SQLException u) {
			System.out.println("Something went wrong selecting users by ID");
			u.printStackTrace();
		}
		
		return null;
	}


	
	public void insertUser(User user, int role_id) {
	
		try(Connection conn = ConnectionUtil.getConnection()){
		
		String sql = "insert into users (username, password, first_name, last_name, email, role_id_fk)"
				+ "values (?, ?, ?);";
				
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getFirst_name());
		ps.setString(2, user.getLast_name());
		ps.setInt(3, role_id); 
		ps.executeUpdate();
		
		System.out.println("User " + user.getFirst_name() + " added. Welcome to Dunder Mifflin!");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong inserting User!");
			e.printStackTrace();
		}
		
	} 


	
	public void removeUser(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete from user where user_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			System.out.println("Good bye user #" + id);
			
		} catch (SQLException u) {
			System.out.println("There must be a mistake");
			u.printStackTrace();
		}
		
	}
	
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
	
	

