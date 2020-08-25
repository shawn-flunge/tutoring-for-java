package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	private String dbUrl;
	private String dbUser;
	private String dbPwd;
	
	String sql;
	
	public void Destructor() {
		try {
			rs.close();
			pstmt.close();
			con.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public UserDAO() {
		// TODO Auto-generated constructor stub
		dbUrl = "jdbc:mariadb://127.0.0.1:3306/tutoring";
		dbUser = "user_tutoring";
		dbPwd = "1111";
        
		try {
			con = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Boolean Login(String id, String pwd) {	
		sql = "select count(id) from user where id=? and pwd=?";
		
		try {		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs=pstmt.executeQuery();
			rs.next();
				
			if(rs.getString("count(id)").equals("0"))
				return false;
			else
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
}
