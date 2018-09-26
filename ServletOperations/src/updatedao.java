import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Operations.pojo;

public class updatedao {

public static void update(pojo user) {
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Sallauddin","super");
			PreparedStatement pstmt=conn.prepareStatement("update Details set Password=?,Email=?,Id=? where Username=?");
			pstmt.setString(4, user.getUsername());
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setInt(3, user.getId());
			int i=pstmt.executeUpdate();
			if(i==1){
				System.out.println("update success");
			}else{
				System.out.println("not success");
			}
			
			
			
			
		}catch(Exception e){
			
			System.out.println(e);
		}
		
		
}	
	
}
