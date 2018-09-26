package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Operations.pojo;


public class insertdao {

	public static void insert(pojo user) {
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Sallauddin","super");
			PreparedStatement pstmt=conn.prepareStatement("insert into details(Username,Password,Email,Id) values(?,?,?,?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getId());
			int i=pstmt.executeUpdate();
			if(i==1){
				System.out.println("insert success");
			}else{
				System.out.println("not success");
			}
			
			
			
			
		}catch(Exception e){
			
			System.out.println(e);
		}
		
		
		
		
	}

}
