package operations;

import java.sql.Connection;
import java.sql.DriverManager;

public class main {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Admin","#admin");
		
      
    // update.updateData(cn);
       //ResultPortal.details(cn);
       Approval.Approve(cn);

	}

}
