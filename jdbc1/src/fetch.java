

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","srinu","srinu");
	PreparedStatement pst=cn.prepareStatement("select*from empdata");
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		System.out.println("username:"+rs.getString(1));
		System.out.println("password:"+rs.getString(4));
		System.out.println("email:"+rs.getString(2));
		System.out.println("id:"+rs.getInt(3));
		
	}
	
	
	
	
	
	
	
	
	
	
	
}catch(Exception e) {
	System.out.println(e);
}
	}

}
