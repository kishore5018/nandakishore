package Tasks;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class driverClass {
	


		public static void main(String[] args ) throws Exception 
	    {
		
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Sallauddin","super");
			
		//	EmpDetails.fetchdata(con);
			EmpDetails.insertdata(con);
           
			
	    }

		
		

}
	
	
