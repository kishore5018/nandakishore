package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import userbean.userbean;

public class deletedao {

	public static void delete(userbean user) {
		// TODO Auto-generated method stub

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","srinu","srinu");
			PreparedStatement pstmt=conn.prepareStatement("Delete from employee where username=?");
			pstmt.setString(1, user.getUsername());
			
			int i=pstmt.executeUpdate();
			if(i==1){
				System.out.println("Delete success");
			}else{
				System.out.println("not success");
			}
			
			
			
			
		}catch(Exception e){
			
			System.out.println(e);
		}
		
		
		
		
	}



	}


