package TASK1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PROG1 {
	

	public static void main(String args[])

 {
	
try {
	{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
				Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aravind","aravind");
		
			//PROG2.arvind(c);
			PROG2.arvind1(c);
				
			}
	
} catch (Exception e) {
	System.out.println(e);
}
	

	
}

}

