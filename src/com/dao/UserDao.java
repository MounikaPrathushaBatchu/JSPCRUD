package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.User;

public class UserDao {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	String status="";
	
	public UserDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl", "training", "training");
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	public String save(User u) {
		
		String sql = "insert into registeruser(id,name,password,email,gender,state) values (?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, u.getId());
			pst.setString(2, u.getName());
			pst.setString(3, u.getPassword());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getGender());
			pst.setString(6, u.getState());
			
			pst.executeUpdate();
			status = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
