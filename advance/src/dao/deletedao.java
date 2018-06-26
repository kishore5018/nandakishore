package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import userbean.userbean;

public class deletedao {
	public static void delete(userbean user) {
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nanda","nanda123");
	PreparedStatement pstmt1=conn.prepareStatement("delete from employee1 where username=?");
	pstmt1.setString(1, user.getUsername());
	int i=pstmt1.executeUpdate();
	if(i==1){
		System.out.println("Delete Success");
	}else{
		System.out.println("Delete Not Success");
	}
	
	

}catch(Exception e){
System.out.println(e); 

}
}
}