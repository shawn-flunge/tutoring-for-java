package exam;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	
	String driver = "org.mariadb.jdbc.Driver";
	
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	private String url;
	private String user;
	private String pwd;
	
	String sql;

	public DBConn() {
		// TODO Auto-generated constructor stub

		url = "jdbc:mariadb://127.0.0.1:3306/tutoring";
        user = "user_tutoring";
        pwd = "1111";
		
		try {
			//드라이버 로딩
			Class.forName(driver);
			
			//드라이버 연결
			con = DriverManager.getConnection(url,user,pwd);
			
			if(con == null) {
				System.out.println("실패");
			}
			else {
				System.out.println("성공");
			}		
				
			sql = "select * from ex1";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("col_pk")+ "\t" + 
									rs.getString(1) + "\t" + rs.getString(2));
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	
	

}
