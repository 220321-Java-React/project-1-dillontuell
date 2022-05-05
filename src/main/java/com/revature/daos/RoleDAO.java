package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class RoleDAO implements RoleDAOInterface{

	
	public ArrayList<Role> getRoles(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from roles;";
			
			Statement s = conn.createStatement(); 
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Role> roleList = new ArrayList<>();
		
			while(rs.next()) {
				
				Role role = new Role(
										
						rs.getInt("role_id"),
						rs.getString("role_title")
						);
				
				roleList.add(role);
			}
			
			return roleList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong contacting the database");
			e.printStackTrace(); 
		}
		
		return null; 
		
	}

	
	
	
	public Role getRoleById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from roles where role_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
		
			
			while(rs.next()) {
				
			return new Role(
					rs.getInt("role_id"),
					rs.getString("role_title")
					);
				
			}	
		
			
		} catch (SQLException e) {
			System.out.println("Something went wrong fetching this data!!");
			e.printStackTrace();
		}
		
		return null;
	}

	{
	
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//write out our SQL UPDATE command
			String sql = "update roles s where role_title = ?";
			
			//create our PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(title);
			
			ps.executeUpdate();
			
			System.out.println(title);
			
		} catch (SQLException e) {
			System.out.println("Couldn't update :(");
			e.printStackTrace();
		}
		
	}
	
}
